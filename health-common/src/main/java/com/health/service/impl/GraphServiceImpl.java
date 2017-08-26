package com.health.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.dao.BaseDaoI;
import com.health.model.ThGraphTemp;
import com.health.model.ThHistoryMedical;
import com.health.model.ThQuotaRecord;
import com.health.service.GraphService;
import com.health.service.ThGraphTempService;
import com.health.utils.SimilarityAnalyzeUtil;


@Service
public class GraphServiceImpl implements GraphService {

	@Autowired
	BaseDaoI<ThHistoryMedical> graphMedicalDao;

	@Autowired
	BaseDaoI<ThQuotaRecord> userInfoDao;
	
	@Autowired
	ThGraphTempService ThGraphTempService;
	
	
	@Transactional	
	@Override
	public Map<String, Object> delAll() {
		// TODO Auto-generated method stub
		String sql = "truncate table th_graph_temp";
		graphMedicalDao.executeSql(sql);
		Map<String, Object> result = new HashMap<>();
		return result;
	}

	@Override
	public Map<String, Object> getItems(ThHistoryMedical item) {
		// String sql = "select distinct historyType, title, item from
		// th_history_medical where userId = :userId";
		String sql = "select distinct item from th_history_medical where userId = :userId";
		Map<String, Object> param = new HashMap<>();
		param.put("userId", item.getUserId());
		List<Map<String, Object>> types = graphMedicalDao.getInfoListBySql(sql, param);

		List<String> items = new ArrayList<>();
		for (int i = 0; i < types.size(); i++) {
			items.add((String) types.get(i).get("item"));
		}
		Map<String, Object> param1 = new HashMap<>();
		StringBuffer str = new StringBuffer("select count(*) as score, userId from th_history_medical");
		str.append(" where 1=1 ");
		str.append(" and userId != :userId ");
		str.append(" and item in (:items) ");
		str.append(" group by userId ");
		str.append(" limit 0, 5");
		param1.put("items", items);
		param1.put("userId", item.getUserId());
		List<Map<String, Object>> users = graphMedicalDao.getInfoListBySql(str.toString(), param1);
		Map<String, Object> result = new HashMap<>();
		result.put("users", users);
		return result;
	}

	@Transactional
	@Override
	public Map<String, Object> getStarGraph(ThHistoryMedical item) {
		Map<String, Object> result = getItems(item);
		List<Map<String, Object>> users = (List<Map<String, Object>>) result.get("users");
		Map<String, Object> resultRes = new HashMap<>();
		Map<String, Object> nodes = new HashMap<>();
		Map<String, Object> lines = new HashMap<>();
		Map<String, Object> areas = new HashMap<>();

		resultRes.put("title", "title");
		resultRes.put("nodes", nodes);
		DecimalFormat format = new DecimalFormat("#0");
		String at = format.format(360 / (users.size()));
		Double a = new Double(at);
		for (int i = 0; i <= users.size(); i++) {
			if(i == users.size()) {
				Map<String, Object> node = new HashMap<>();
				node.put("name", item.getUserId());
				node.put("left", 200); // 圆心x
				node.put("top", 200); // 圆心y
				node.put("type", "end");
				node.put("width", 26);
				node.put("height", 24);
				node.put("alt", true);
				nodes.put("gf_node_" + item.getUserId(), node);
				continue;
			}
			Map<String, Object> node = new HashMap<>();
			Map<String, Object> map = users.get(i);
			node.put("name", map.get("userId"));
			node.put("left", new Integer(format.format(200 + 200 * Math.cos(Math.toRadians((i) * a)))) ); // x = i * 100
			node.put("top", new Integer(format.format(200 + 200 * Math.sin(Math.toRadians( (i) * a))))); // y = x + 100
			node.put("type", "end");
			node.put("width", 26);
			node.put("height", 24);
			node.put("alt", true);
			nodes.put("gf_node_" + map.get("userId"), node);
			
			Map<String, Object> line = new HashMap<>();
			line.put("type", "sl");
			line.put("from", "gf_node_" + item.getUserId());
			line.put("to", "gf_node_" + users.get(i).get("userId"));
			line.put("name", "");
			line.put("score", users.get(i).get("score"));
			lines.put("gf_line_" + map.get("userId"), line);
		}
		resultRes.put("lines", lines);
		resultRes.put("areas", areas);
		resultRes.put("initNum", users.size() + 1);
		return resultRes;
	}

	@Transactional
	public Map<String, Object> getByWeight(ThQuotaRecord user) {
		Map<String, Object> map = new HashMap<>();
		String sqlWeight = "SELECT avg(value) as weightavg FROM health.th_quota_record where "
				+ " quotaName = '体重' "
				+ " and userId = :userId "
				+ " group by userId";
		Map<String, Object> params = new HashMap<>();
		params.put("userId", user.getUserId());
		
		List<Map<String, Object>> myInfo = userInfoDao.getInfoListBySql(sqlWeight, params);
		if(myInfo.size() > 0) {
			Double myBmi = (Double) myInfo.get(0).get("weightavg");
			//定义标准
			Double min = myBmi - 5;
			Double max = myBmi + 5;
			String sql = "select t.userId "
					+ " from (SELECT avg(value) as weightavg, userId FROM health.th_quota_record where quotaName = '体重' group by userId) t "
					+ " where t.weightavg >:min and t.weightavg <:max "
					;
			Map<String, Object> params1 = new HashMap<>();
			params1.put("min", min);
			params1.put("max", max);
			List<Map<String, Object>> weightResult = userInfoDao.getInfoListBySql(sql, params1);
			map.put("result", weightResult);
			
		}
		return map;
	}	
	
	@Transactional
	@Override
	public Map<String, Object> getGroups(ThQuotaRecord item) {
		// TODO Auto-generated method stub
		Map<String, Object> map1 = new HashMap<>();
		String sqlMyInfo = "select t.userId, t.quotaName, t.weightavg, t.weightmin, t.weightmax "
				+ "from (SELECT avg(NULLIF(value ,0)) as weightavg, min(NULLIF(value ,0)) as weightmin, max(NULLIF(value ,0)) as weightmax, userId, quotaName FROM health.th_quota_record"
				+ " where quotaName != '尿检' and value is not null and userId = :userId "
				+ "group by userId, quotaName) t "
				+ "";
		map1.put("userId", item.getUserId());
		List<Map<String, Object>> myinfos = userInfoDao.getInfoListBySql(sqlMyInfo, map1);
		Map<String, Map<String, Object>> myinfo = new HashMap<>();
		for(Map<String, Object> info : myinfos) {
			Map<String, Object> tem = new HashMap<>();
			tem.put("min", info.get("weightmin"));
			tem.put("avg", info.get("weightavg"));
			tem.put("max", info.get("weightmax"));
			myinfo.put((String) info.get("quotaName"), tem);
		}
		
		Map<String, Object> map = new HashMap<>();
		String sql = "select t.userId, t.quotaName, t.weightavg, t.weightmin, t.weightmax "
				+ "from (SELECT avg(NULLIF(value ,0)) as weightavg, min(NULLIF(value ,0)) as weightmin, max(NULLIF(value ,0)) as weightmax, userId, quotaName FROM health.th_quota_record where quotaName != '尿检' and value is not null group by userId, quotaName) t "
				+ "";
		List<Map<String, Object>> infos = userInfoDao.getInfoListBySql(sql);
		Map<String, Double> notSortedMap = new HashMap<>();
		
		for(Map<String, Object> info : infos) {
			Double score = notSortedMap.get(info.get("userId"));
			if(score == null) {
				notSortedMap.put((String)info.get("userId"), 0D);
				score = notSortedMap.get(info.get("userId"));
			}
			
			String quotaName = (String)info.get("quotaName");
			switch (quotaName) {
			case "体温":
				Map<String, Object> tem = myinfo.get("体温");
				score = score + Math.abs((Double) tem.get("min") - (Double) info.get("weightmin"));
				score = score + Math.abs((Double) tem.get("avg") - (Double) info.get("weightavg"));
				score = score + Math.abs((Double) tem.get("max") - (Double) info.get("weightmax"));
				break;
			case "体重":
				Map<String, Object> tem1 = myinfo.get("体重");
				score = score + Math.abs((Double) tem1.get("min") - (Double) info.get("weightmin"));
				score = score + Math.abs((Double) tem1.get("avg") - (Double) info.get("weightavg"));
				score = score + Math.abs((Double) tem1.get("max") - (Double) info.get("weightmax"));
				break;
			case "心率":
				Map<String, Object> tem2 = myinfo.get("心率");
				score = score + Math.abs((Double) tem2.get("min") - (Double) info.get("weightmin"));
				score = score + Math.abs((Double) tem2.get("avg") - (Double) info.get("weightavg"));
				score = score + Math.abs((Double) tem2.get("max") - (Double) info.get("weightmax"));
				break;
			case "脂肪率":
				Map<String, Object> tem3 = myinfo.get("脂肪率");
				score = score + Math.abs((Double) tem3.get("min") - (Double) info.get("weightmin"));
				score = score + Math.abs((Double) tem3.get("avg") - (Double) info.get("weightavg"));
				score = score + Math.abs((Double) tem3.get("max") - (Double) info.get("weightmax"));
				break;
			case "血压":
				Map<String, Object> tem4 = myinfo.get("血压");
				score = score + Math.abs((Double) tem4.get("min") - (Double) info.get("weightmin"));
				score = score + Math.abs((Double) tem4.get("avg") - (Double) info.get("weightavg"));
				score = score + Math.abs((Double) tem4.get("max") - (Double) info.get("weightmax"));
				break;
			case "血氧":
				Map<String, Object> tem5 = myinfo.get("血氧");
				score = score + Math.abs((Double) tem5.get("min") - (Double) info.get("weightmin"));
				score = score + Math.abs((Double) tem5.get("avg") - (Double) info.get("weightavg"));
				score = score + Math.abs((Double) tem5.get("max") - (Double) info.get("weightmax"));
				break;
			case "血糖":
				Map<String, Object> tem6 = myinfo.get("血糖");
				score = score + Math.abs((Double) tem6.get("min") - (Double) info.get("weightmin"));
				score = score + Math.abs((Double) tem6.get("avg") - (Double) info.get("weightavg"));
				score = score + Math.abs((Double) tem6.get("max") - (Double) info.get("weightmax"));
				break;
			default:
				break;
			}
			notSortedMap.put((String)info.get("userId"), score);
		}
		
		List<Map.Entry<String, Double>> notSortedList = new ArrayList<Map.Entry<String, Double>>(notSortedMap.entrySet());
		Collections.sort(notSortedList, new Comparator<Map.Entry<String, Double>>() {

			@Override
			public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
				// TODO Auto-generated method stub
				if(o1.getValue() > o2.getValue()) {
					return 1;
				} else if(o1.getValue() < o2.getValue()) {
					return -1;
				} else {
					return 0;					
				}
			}
		});
		List<Map.Entry<String, Double>> list = notSortedList.subList(0, 9);
		
		Map<String, Object> result = new HashMap<>();
		result.put("userList", list);
		return result;
	}
	
	@Transactional
	public Map<String, Object> getAVGs() {
		Date startTime = null;
		Date endTime = null;
		String selectMinDateSql = "select min(createTime) as minDate from th_quota_record t";
		String selectMaxDateSql = "select max(createTime) as maxDate from th_quota_record t";
		String sqlWeight = "SELECT avg(value),userId FROM th_quota_record t where t.createTime >= :currentTime and t.createTime <= :currentTime";
		List<Map<String, Object>> minDateResult = userInfoDao.getInfoListBySql(selectMinDateSql);
		List<Map<String, Object>> maxDateResult = userInfoDao.getInfoListBySql(selectMaxDateSql);
		Date minDate = (Date) minDateResult.get(0).get("minDate");
		Date maxDate = (Date) maxDateResult.get(0).get("maxDate");
		String sqlUsers = "select distinct userId from th_quota_record t where userId is not null";
		/**
		 * 查找所有用户的平均值和方差
		 */
		String sqlStdAndAvg = "SELECT avg(value) as avgall, min(value) as minall, max(value) as maxall, std(value) as std, quotaName FROM th_quota_record t "
				+ " where t.createTime > :startTime and t.createTime < :endTime  and quotaName != '尿检' "
				+ "group by quotaName";
		/**
		 * 查找所有用户的指标平均值
		 */
		String sql = "SELECT avg(value) as avgvalue,min(value) as minall, max(value) as maxall, userId, quotaName FROM health.th_quota_record t "
				+ " where t.createTime > :startTime and t.createTime < :endTime  and quotaName != '尿检' "
				+ " group by userId, quotaName ";
		/**
		 * 查找单一用户的指标平均值
		 */
		String sqlSingle = "SELECT avg(value) as avgvalue,min(value) as minall, max(value) as maxall, userId, quotaName FROM health.th_quota_record t "
				+ " where t.createTime > :startTime and t.createTime < :endTime  and quotaName != '尿检' "
				+ "and t.userId = :userId"
				+ " group by userId, quotaName ";
		
		List<Map<String, Object>> users = userInfoDao.getInfoListBySql(sqlUsers);
		Long sevenDate = 7*24*60*60*1000L;
		Date current = maxDate;
		// TODO 遍历users、时间
		for(Map<String, Object> user : users) {
			Date currentI = new Date(current.getTime());
			Map<String, Object> paramsSingle = new HashMap<>();
			paramsSingle.put("startTime", new Date(current.getTime() - sevenDate));
			paramsSingle.put("endTime", new Date(current.getTime()));
			paramsSingle.put("userId", user.get("userId"));
			List<Map<String, Object>> queryResult = userInfoDao.getInfoListBySql(sqlSingle, paramsSingle);
			paramsSingle.remove("userId");
			List<Map<String, Object>> queryAvgallAndStd = userInfoDao.getInfoListBySql(sqlStdAndAvg, paramsSingle);
			
			while(currentI.getTime() >= minDate.getTime() && currentI.getTime() <= maxDate.getTime()) {
				Map<String, Object> params = new HashMap<>();
				params.put("startTime", new Date(current.getTime() - sevenDate));
				params.put("endTime", new Date(current.getTime()));
				List<Map<String, Object>> usersAndDatas =  userInfoDao.getInfoListBySql(sql, params);
				// TODO 分析度算法,输入参(userInfo, usersAndDatas)
				if(queryResult.size() > 0) {
					Map<String, Object> resultMap = SimilarityAnalyzeUtil.calculateSimilarity(queryResult, usersAndDatas, queryAvgallAndStd);
					List<Map.Entry<String, Object>> notSortedList = new ArrayList<Map.Entry<String, Object>>(resultMap.entrySet());
					//先排序，再分组
					Collections.sort(notSortedList, new Comparator<Map.Entry<String, Object>>() {
						@Override
						public int compare(Entry<String, Object> o1, Entry<String, Object> o2) {
							// 从大到小排序
							if((Double)o1.getValue() > (Double)o2.getValue()) {
								return -1;
							} else if((Double)o1.getValue() < (Double)o2.getValue()) {
								return 1;
							} else {
								return 0;					
							}
						}
					});
					Map<String, List<Map<String, Object>>> groupResult = new HashMap<>();
					// TODO 跟某个用户（当前遍历的user）的相似的用户数据save(currentI)
					int saveSize = 8;
					for(int i = 0; i <= saveSize - 1; i++ ) {
						add(notSortedList.get(i), currentI, sevenDate, (String) user.get("userId"));
					}
					
					System.out.println(groupResult);
					
				}
				currentI = new Date(currentI.getTime() - sevenDate);
			}
			
			
		}
			
		Map<String, Object> result = new HashMap<>();
		return result;
	}
	
	private void add(Map.Entry<String, Object> i, Date current, Long sevenDate, String source) {
		ThGraphTemp itemTemp = new ThGraphTemp();
		itemTemp.setCreateTime(new Date());
		itemTemp.setUpdateTime(new Date());
		itemTemp.setCompareStartTime(new Date(current.getTime() - sevenDate));
		itemTemp.setCompareEndTime(new Date(current.getTime()));
		itemTemp.setDiff((Double)i.getValue());
		itemTemp.setSource(source);
		itemTemp.setTarget(i.getKey());
		itemTemp.setQuotaName("综合");
		ThGraphTempService.saveThGraphTemp(itemTemp);
	}
}
