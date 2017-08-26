package com.health.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.health.manager.RedisObjectCmd;
import com.health.model.ThOrganization;
import com.health.model.ThQuota;
import com.health.model.ThQuotaRecord;
import com.health.model.ThUser;
import com.health.model.ThUserAddress;
import com.health.model.ThUserInfo;
import com.health.service.ThQuotaRecordService;
import com.health.service.ThQuotaService;
import com.health.utils.Bean2MapUtil;
import com.health.utils.PageHelper;
import com.health.utils.QuotaResultCalculation;
import com.health.utils.ResponseConstant;
import com.health.utils.Return2AndriodFormat;
import com.health.utils.SerializableBufferedImage;
import com.health.utils.chart.SbBitmapEncoder;
import com.health.utils.chart.SbChart;
import com.health.utils.chart.SbChartBuilder;
import com.health.utils.chart.SbBitmapEncoder.BitmapFormat;

@RestController
@RequestMapping("/")
public class ThQuotaController {
	
	private static Logger log = LoggerFactory.getLogger(ThQuotaController.class);
	
	@Autowired
	ThQuotaRecordService quotaRecordService;
	@Autowired
	ThQuotaService quotaService;
	@Autowired
	RedisObjectCmd ocmd;
	
	@RequestMapping("/quota/list")
	public String getQuotaList(ThQuota quota,PageHelper ph) {
		List<Map<String, Object>> quotalist = new ArrayList<Map<String, Object>>();
		quotalist = quotaService.getQuotaNameList(quota);
		JSONObject jo = new JSONObject();
		jo.put("quotalist", quotalist);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/quota/add")
	public String addQuota(ThQuota quota) {
		Integer id = null;
		id = (Integer) quotaService.add(quota);
		JSONObject jo = new JSONObject();
		jo.put("id", id);
		if(id == null){
			log.error("添加指标失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_ERROR,"失败", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		}
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/quota/update")
	public String updateQuota(ThQuota quota) {
		Integer id = null;
		id = (Integer) quotaService.updateById(quota);
		JSONObject jo = new JSONObject();
		jo.put("id", id);
		if(id == null || id == 0){
			log.error("修改指标失败");
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_ERROR,"失败", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		}
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/quotarecord/add")
	public String addQuotaRecord(HttpServletRequest request,ThUser user) {
		JSONObject jo = new JSONObject();
		String situationString = request.getParameter("situation");
		Integer situation = 0;
		if(StringUtils.isNotBlank(situationString)){
			situation = Integer.valueOf(situationString);
		}
		String recordList = request.getParameter("recordList");
		List<ThQuotaRecord> list = new ArrayList<ThQuotaRecord>();
		if(StringUtils.isNotBlank(recordList)){
			list = JSON.parseObject(recordList, new TypeReference<List<ThQuotaRecord>>(){});
		} 
		Integer count = 0;
		Integer recordCount = 1;
		List<ThQuotaRecord> recordMaxCount = quotaRecordService.getQuotaRecordMaxCount(new ThQuotaRecord());
		if(recordMaxCount.size() != 0){
			recordCount = recordMaxCount.get(0).getCount() + 1;
		}
		String result = "";
		for(ThQuotaRecord q:list){
			Integer id = null;
			if(q.getQuotaType() != 0){
				result = QuotaResultCalculation.getResult(user.getUserAge(), user.getGender(), situation, q.getQuotaType(), q.getSecondQuotaName(), q.getValue(),q.getResult());
				q.setResult(result);
			}
			if(situation == 1){
				q.setSecondQuotaName("空腹");
			}
			if(situation == 2){
				q.setSecondQuotaName("餐后2小时");
			}
			q.setCount(recordCount);
			q.setUserId(user.getUserId());
			q.setUserAge(user.getUserAge());
			q.setUserName(user.getUserName());
			q.setGender(user.getGender());
			id = (Integer) quotaRecordService.add(q);
			if(id != null && id != 0){
				count++;
			}
		}
		if(count == 0){
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_ERROR, "失败", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		}
		jo.put("count", count);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/quotarecord/list")
	public String getQuotaRecordList(ThQuotaRecord quotarecord,ThUser user,ThUserInfo userinfo,ThUserAddress useraddress,ThQuota quota,ThOrganization organization,PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		Map<String, Object> userMap = new HashMap<String, Object>();
		Map<String, Object> userinfoMap = new HashMap<String, Object>();
		Map<String, Object> useraddressMap = new HashMap<String, Object>();
		Map<String, Object> quotaMap = new HashMap<String, Object>();
		Map<String, Object> organizationMap = new HashMap<String, Object>();
		//合并
		quotarecord.setStatus(1);
		whereMap = Bean2MapUtil.transBean2Map(quotarecord);
		userMap = Bean2MapUtil.transBean2Map(user);
		userinfoMap = Bean2MapUtil.transBean2Map(userinfo);
		useraddressMap = Bean2MapUtil.transBean2Map(useraddress);
		quotaMap = Bean2MapUtil.transBean2Map(quota);
		organizationMap = Bean2MapUtil.transBean2Map(organization);
		whereMap.putAll(userMap);
		whereMap.putAll(userinfoMap);
		whereMap.putAll(useraddressMap);
		whereMap.putAll(quotaMap);
		whereMap.putAll(organizationMap);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		/*------------------------------------------------------------------------------------------------------------------*/
		String key =  "/quotarecord/list" + quotarecord.toString() + user.toString() + userinfo.toString() + useraddress.toString() + quota.toString() + organization.toString() + ph.toString();
		JSONObject jo = new JSONObject();
		long seconds = 24*60*60;
		Map<String, Object> result = null;
		if((result = (Map<String, Object>) ocmd.get(key)) != null) {
			jo.put("list", result.get("list"));
			jo.put("count", result.get("count"));
			return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		} else {
			//缓存失效
			log.info(key + ":缓存失效");
			synchronized (this) {
				if((result = (Map<String, Object>) ocmd.get(key)) == null) {
					List<Map<String, Object>> list1 = quotaRecordService.getQuotaRecordAndQuotaList(whereMap, ph);
					Long count1 = quotaRecordService.getCountOfQuotaRecordAndQuotaList(whereMap);
					result = new HashMap<>();
					result.put("list", list1);
					result.put("count", count1);
					ocmd.set(key, result, seconds);
					jo.put("list", list1);
					jo.put("count", count1);
					return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
				} else {
					jo.put("list", result.get("list"));
					jo.put("count", result.get("count"));
					return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
				}
			}
		}
		
		/*------------------------------------------------------------------------------------------------------------------*/
		
//		list = quotaRecordService.getQuotaRecordAndQuotaList(whereMap, ph);
//		Long count = quotaRecordService.getCountOfQuotaRecordAndQuotaList(whereMap);
//		jo.put("list", list);
//		jo.put("count", count);
//		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	//不加缓存
	@RequestMapping("/quotarecord/list2")
	public String getQuotaRecordList2(ThQuotaRecord quotarecord,ThUser user,ThUserInfo userinfo,ThUserAddress useraddress,ThQuota quota,ThOrganization organization,PageHelper ph) {
		Map<String, Object> whereMap = new HashMap<String, Object>();
		Map<String, Object> userMap = new HashMap<String, Object>();
		Map<String, Object> userinfoMap = new HashMap<String, Object>();
		Map<String, Object> useraddressMap = new HashMap<String, Object>();
		Map<String, Object> quotaMap = new HashMap<String, Object>();
		Map<String, Object> organizationMap = new HashMap<String, Object>();
		//合并
		quotarecord.setStatus(1);
		whereMap = Bean2MapUtil.transBean2Map(quotarecord);
		userMap = Bean2MapUtil.transBean2Map(user);
		userinfoMap = Bean2MapUtil.transBean2Map(userinfo);
		useraddressMap = Bean2MapUtil.transBean2Map(useraddress);
		quotaMap = Bean2MapUtil.transBean2Map(quota);
		organizationMap = Bean2MapUtil.transBean2Map(organization);
		whereMap.putAll(userMap);
		whereMap.putAll(userinfoMap);
		whereMap.putAll(useraddressMap);
		whereMap.putAll(quotaMap);
		whereMap.putAll(organizationMap);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		JSONObject jo = new JSONObject();
		list = quotaRecordService.getQuotaRecordAndQuotaList(whereMap, ph);
		Long count = quotaRecordService.getCountOfQuotaRecordAndQuotaList(whereMap);
		jo.put("list", list);
		jo.put("count", count);
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
	
	@RequestMapping("/getImage/get")
	public void getImage(HttpServletRequest request, HttpServletResponse response, ThQuotaRecord quotarecord) {
		quotarecord.setStatus(1);
		Map<String, Object> whereMap = new HashMap<String, Object>();
		whereMap = Bean2MapUtil.transBean2Map(quotarecord);
		String key =  "/getImage/get" + quotarecord.toString();
		SerializableBufferedImage thumbnailOut = null;
		BufferedImage image = null;
		long seconds = 24*60*60;
		if((thumbnailOut = (SerializableBufferedImage) ocmd.get(key)) != null) {
			try {
				OutputStream os = response.getOutputStream();
				ImageIO.write(thumbnailOut.getImage(), "png", os);
				os.flush();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		} else {
			//缓存失效
			log.info(key + ":缓存失效");
			synchronized (this) {
				if((thumbnailOut = (SerializableBufferedImage) ocmd.get(key)) != null) {
					try {
						OutputStream os = response.getOutputStream();
						ImageIO.write(thumbnailOut.getImage(), "png", os);
						os.flush();
						os.close();
					} catch (Exception e) {
						e.printStackTrace();
						return;
					}
				} else {
					SbChart chart = new SbChartBuilder().width(800).height(600).build();
					chart.setXAxisTitle("X");
					chart.setYAxisTitle("Y");
					// Customize Chart
					chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Scatter);
					chart.getStyler().setChartTitleVisible(false);
					chart.getStyler().setLegendPosition(LegendPosition.InsideSW);
					chart.getStyler().setMarkerSize(16);
					chart.getStyler().setChartBackgroundColor(new Color(222, 222, 222));
					// Series
					List<Double> xData = new LinkedList<Double>();
					List<Double> yData = new LinkedList<Double>();
					//add data
					PageHelper ph = new PageHelper();
//					ph.setPage(1);
//					ph.setRows(10);
					List<Map<String, Object>> list1 = quotaRecordService.getQuotaRecordAndQuotaList(whereMap, ph);
					for(Map<String, Object> map : list1) {
						xData.add(new Double(((Integer)map.get("userAge")).toString()));
						yData.add((Double)map.get("value"));
					}
					String seriesStr = "分析";
					switch (quotarecord.getQuotaType()) {
					case 0:
						seriesStr = "体重";
						break;
					case 1:
						seriesStr = "体温";
						break;
					case 2:
						seriesStr = "血压";
						break;
					case 3:
						seriesStr = "血氧";
						break;
					case 4:
						seriesStr = "血糖";
						break;
					case 5:
						seriesStr = "心率";
						break;
					case 6:
						seriesStr = "脂肪率";
						break;
					case 7:
						seriesStr = "尿检";
						break;
					default:
						break;
					}
					chart.addSeries(seriesStr, xData, yData);
					try {
						image = SbBitmapEncoder.bitmapWithDPI(chart, BitmapFormat.PNG, 300);		
						ocmd.set(key, new SerializableBufferedImage(image), seconds);
						try {
							OutputStream os = response.getOutputStream();
							ImageIO.write(image, "png", os);
							os.flush();
							os.close();
						} catch (Exception e) {
							e.printStackTrace();
							return;
						}
					} catch (Exception e) {
						e.printStackTrace();
						return;
					}
				}
			}
		}
		
	}
	
	
	@RequestMapping("/quotastatistical/list")
	public String getQuotaStatisticalList(HttpServletRequest request,ThQuotaRecord quotarecord,ThUser user,ThUserInfo userinfo,ThUserAddress useraddress) {
		
		JSONObject jo = new JSONObject();
		String StatisticType = "0";
		if(request.getParameter("StatisticType") != null){
			StatisticType = request.getParameter("StatisticType");
		}
		String fields = request.getParameter("fieldList");
		String categorys = request.getParameter("categoryList");
		List<String> fieldList = new ArrayList<String>();
		List<String> categoryList = new ArrayList<String>();
		if(StringUtils.isNotBlank(fields)) {
			fieldList = JSON.parseObject(fields, new TypeReference<List<String>>(){});
		}
		if(StringUtils.isNotBlank(categorys)) {
			categoryList = JSON.parseObject(categorys, new TypeReference<List<String>>(){});
		}
		
		Map<String, Object> whereMap = new HashMap<String, Object>();
		Map<String, Object> userMap = new HashMap<String, Object>();
		Map<String, Object> userinfoMap = new HashMap<String, Object>();
		Map<String, Object> useraddressMap = new HashMap<String, Object>();
		//合并
		quotarecord.setStatus(1);
		whereMap = Bean2MapUtil.transBean2Map(quotarecord);
		userMap = Bean2MapUtil.transBean2Map(user);
		userinfoMap = Bean2MapUtil.transBean2Map(userinfo);
		useraddressMap = Bean2MapUtil.transBean2Map(useraddress);
		whereMap.putAll(userMap);
		whereMap.putAll(userinfoMap);
		whereMap.putAll(useraddressMap);
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> nationList = new ArrayList<Map<String, Object>>();
		
		/*-----------------------------------------------------------------------------------------------------------------*/
		long seconds = 24*60*60;
		if(request.getParameter("quotaType") != null && request.getParameter("StatisticType") != null) {
			String key = "/quotastatistical/list#" + request.getParameter("quotaType") + request.getParameter("StatisticType") + (request.getParameter("secondQuotaName") == null ? "" : request.getParameter("secondQuotaName"));
			Map<String, Object> result = null;
			if((result = (Map<String, Object>) ocmd.get(key)) != null) {
				jo.put("list", result.get("list"));
				if(StatisticType.equals("1")){
					jo.put("nationList", result.get("nationList"));
				}
				return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
			} else {
				log.info(key + ":缓存失效");
				synchronized (this) {
					if((result = (Map<String, Object>) ocmd.get(key)) == null) {
						result = new HashMap<>();
						list = quotaRecordService.getQuotaRecordStatisticalAnalysis(whereMap,StatisticType,fieldList,categoryList);
						if(StatisticType.equals("1")){
							nationList = quotaRecordService.getNationList(whereMap);
							jo.put("nationList", nationList);
							result.put("nationList", nationList);
						}
						result.put("list", list);
						jo.put("list", list);
						ocmd.set(key, result, seconds);
						return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
					} else {
						jo.put("list", result.get("list"));
						if(StatisticType.equals("1")){
							jo.put("nationList", result.get("nationList"));
						}
						return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
					}
				}
			}
//			if(ocmd.get(key2) != null) {
//				 list = (List<Map<String, Object>>) ocmd.get(key2);
//				 jo.put("list", list);
//				 if(StatisticType.equals("1")){
//					 if(ocmd.get(key3) != null) {
//						 nationList = (List<Map<String, Object>>) ocmd.get(key3);
//						 jo.put("nationList", nationList);						 
//					 } else {  //缓存失效
//						 log.info(key3 + ":缓存失效");
//						 synchronized (this) {
//							 nationList = quotaRecordService.getNationList(whereMap);
//							 ocmd.set(key3, nationList, seconds);
//						}
//					 }
//				 } 
//			} else {//没有缓存，直接更新
//				 log.info(key2 + ":缓存失效");
//				 synchronized (this) {
//					 list = quotaRecordService.getQuotaRecordStatisticalAnalysis(whereMap,StatisticType,fieldList,categoryList);	
//					 ocmd.set(key2, list, seconds);
//				 }
//				 jo.put("list", list);
//				 if(StatisticType.equals("1")){
//					 if(ocmd.get(key3) != null) {
//						 nationList = (List<Map<String, Object>>) ocmd.get(key3);
//						 jo.put("nationList", nationList);						 
//					 } else {  //缓存失效
//						 log.info(key3 + ":缓存失效");
//						 synchronized (this) {
//							 nationList = quotaRecordService.getNationList(whereMap);
//							 ocmd.set(key3, nationList, seconds);
//						}
//					 }
//				 } 
//			}
		} else {
			//直接查询
			list = quotaRecordService.getQuotaRecordStatisticalAnalysis(whereMap,StatisticType,fieldList,categoryList);
			if(StatisticType.equals("1")){
				nationList = quotaRecordService.getNationList(whereMap);
				jo.put("nationList", nationList);
			}
			jo.put("list", list);
		}
		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
		/*-----------------------------------------------------------------------------------------------------------------*/
		
		
//		list = quotaRecordService.getQuotaRecordStatisticalAnalysis(whereMap,StatisticType,fieldList,categoryList);
//		if(StatisticType.equals("1")){
//			nationList = quotaRecordService.getNationList(whereMap);
//			jo.put("nationList", nationList);
//		}
//		jo.put("list", list);
//		return JSONObject.toJSONString(Return2AndriodFormat.getResult(ResponseConstant.STATUS_OK, "成功", jo),SerializerFeature.WriteMapNullValue,SerializerFeature.WriteDateUseDateFormat);
	}
}
