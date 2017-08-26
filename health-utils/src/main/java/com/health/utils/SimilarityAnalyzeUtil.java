package com.health.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SimilarityAnalyzeUtil {
	//待检测用户所有指标在最近时间段内的均值
	private static List<Map<String, Object>> userInfos;
	//除待检测用户外所有样本的所有指标在指定时间段内的均值
	private static List<Map<String, Object>> usersAndDatas;
	//各指标的均值和标准差
	private static List<Map<String, Object>> mQuotasAvgAndStd;
	
	public static Map<String, Object> calculateSimilarity(List<Map<String, Object>> infos,
	                                                            List<Map<String, Object>> usersAndData,
	                                                            List<Map<String, Object>> quotasAvgAndStd){
		userInfos = infos;
		usersAndDatas = usersAndData;
		mQuotasAvgAndStd = quotasAvgAndStd;
		List<Map<String, Object>> resultMaps = new ArrayList<Map<String, Object>>();
		Map<String,Map<String, Object>> quotasAvgAndStdMap = new HashMap<String,Map<String, Object>>();
		Map<String, Object> sortedResultMap = new HashMap<>();
		try {
			for (Map<String,Object> param : mQuotasAvgAndStd){
				switch ((String)param.get("quotaName")){
				case "体温":
					quotasAvgAndStdMap.put("体温", param);
					break;
				case "体重":
					quotasAvgAndStdMap.put("体重", param);
					break;
				case "心率":
					quotasAvgAndStdMap.put("心率", param);
					break;
				case "脂肪率":
					quotasAvgAndStdMap.put("脂肪率", param);
					break;
				case "血压":
					quotasAvgAndStdMap.put("血压", param);
					break;
				case "血氧":
					quotasAvgAndStdMap.put("血氧", param);
					break;
				case "血糖":
					quotasAvgAndStdMap.put("血糖", param);
					break;
				default:
					break;
				}
			}
			for(Map<String, Object> mapUser : userInfos){
				for(Map<String, Object> mapSample : usersAndDatas){
					Map<String, Object> tempMap = new HashMap<>();
					switch ((String)mapUser.get("quotaName")){
					case "体温":
						if (((String)mapSample.get("quotaName")).equals("体温")){
							tempMap.put("quotaName", "体温");
							tempMap.put("userId", mapSample.get("userId"));
							double distance = Math.abs(normalize((double)mapUser.get("avgvalue"),
									                            (double)quotasAvgAndStdMap.get("体温").get("minall"),
									                            (double)quotasAvgAndStdMap.get("体温").get("maxall")) 
									                - normalize((double)mapSample.get("avgvalue"),
											                    (double)quotasAvgAndStdMap.get("体温").get("minall"),
				                                                (double)quotasAvgAndStdMap.get("体温").get("maxall")));
							tempMap.put("diff", filterDiff(distance,0.2));
							
						}
						break;
					case "体重":
						if (((String)mapSample.get("quotaName")).equals("体重")){
							tempMap.put("quotaName", "体重");
							tempMap.put("userId", mapSample.get("userId"));
							double distance = Math.abs(normalize((double)mapUser.get("avgvalue"),
		                                                        (double)quotasAvgAndStdMap.get("体重").get("minall"),
		                                                        (double)quotasAvgAndStdMap.get("体重").get("maxall")) 
		                                            - normalize((double)mapSample.get("avgvalue"),
				                                                (double)quotasAvgAndStdMap.get("体重").get("minall"),
                                                                (double)quotasAvgAndStdMap.get("体重").get("maxall")));
							tempMap.put("diff", filterDiff(distance,0.2));
						}
						break;
					case "心率":
						if (((String)mapSample.get("quotaName")).equals("心率")){
							tempMap.put("quotaName", "心率");
							tempMap.put("userId", mapSample.get("userId"));
							double distance = Math.abs(normalize((double)mapUser.get("avgvalue"),
		                                                        (double)quotasAvgAndStdMap.get("心率").get("minall"),
		                                                        (double)quotasAvgAndStdMap.get("心率").get("maxall")) 
		                                            - normalize((double)mapSample.get("avgvalue"),
				                                                (double)quotasAvgAndStdMap.get("心率").get("minall"),
                                                                (double)quotasAvgAndStdMap.get("心率").get("maxall")));
							tempMap.put("diff", filterDiff(distance,0.2));
						}
						break;
					case "脂肪率":
						if (((String)mapSample.get("quotaName")).equals("脂肪率")){
							tempMap.put("quotaName", "脂肪率");
							tempMap.put("userId", mapSample.get("userId"));
							double distance = Math.abs(normalize((double)mapUser.get("avgvalue"),
		                                                        (double)quotasAvgAndStdMap.get("脂肪率").get("minall"),
		                                                        (double)quotasAvgAndStdMap.get("脂肪率").get("maxall")) 
		                                            - normalize((double)mapSample.get("avgvalue"),
				                                                (double)quotasAvgAndStdMap.get("脂肪率").get("minall"),
                                                                (double)quotasAvgAndStdMap.get("脂肪率").get("maxall")));
							tempMap.put("diff", filterDiff(distance,0.2));
						}
						break;
					case "血压":
						if (((String)mapSample.get("quotaName")).equals("血压")){
							tempMap.put("quotaName", "血压");
							tempMap.put("userId", mapSample.get("userId"));
							double distance = Math.abs(normalize((double)mapUser.get("avgvalue"),
		                                                        (double)quotasAvgAndStdMap.get("血压").get("minall"),
		                                                        (double)quotasAvgAndStdMap.get("血压").get("maxall")) 
		                                            - normalize((double)mapSample.get("avgvalue"),
				                                                (double)quotasAvgAndStdMap.get("血压").get("minall"),
                                                                (double)quotasAvgAndStdMap.get("血压").get("maxall")));
							tempMap.put("diff", filterDiff(distance,0.2));
						}
						break;
					case "血氧":
						if (((String)mapSample.get("quotaName")).equals("血氧")){
							tempMap.put("quotaName", "血氧");
							tempMap.put("userId", mapSample.get("userId"));
							double distance = Math.abs(normalize((double)mapUser.get("avgvalue"),
		                                                        (double)quotasAvgAndStdMap.get("血氧").get("minall"),
		                                                        (double)quotasAvgAndStdMap.get("血氧").get("maxall")) 
		                                            - normalize((double)mapSample.get("avgvalue"),
				                                                (double)quotasAvgAndStdMap.get("血氧").get("minall"),
                                                                (double)quotasAvgAndStdMap.get("血氧").get("maxall")));
							tempMap.put("diff", filterDiff(distance,0.2));
						}
						break;
					case "血糖":
						if (((String)mapSample.get("quotaName")).equals("血糖")){
							tempMap.put("quotaName", "血糖");
							tempMap.put("userId", mapSample.get("userId"));
							double distance = Math.abs(normalize((double)mapUser.get("avgvalue"),
		                                                        (double)quotasAvgAndStdMap.get("血糖").get("minall"),
		                                                        (double)quotasAvgAndStdMap.get("血糖").get("maxall")) 
		                                            - normalize((double)mapSample.get("avgvalue"),
				                                                (double)quotasAvgAndStdMap.get("血糖").get("minall"),
                                                                (double)quotasAvgAndStdMap.get("血糖").get("maxall")));
							tempMap.put("diff", filterDiff(distance,0.2));
						}
						break;
					default:
					    break;		
					}
					if (tempMap.size() != 0){
						resultMaps.add(tempMap);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("SimilarityAnalyzeError: " + e );
		}
		sortedResultMap = sortSimilarity(resultMaps);
		return sortedResultMap;
	}
	
	//归一化
	private static double normalize(double x,double min, double max){
		double result = 0;
		if (min < max && x >= min && x <= max){
			result = (x - min)/(max - min);
		} else {
			System.out.println("normalizeError: 参数值不正确");
		}
		
		return result;
	}
	
	//设置阈值
	private static double filterDiff (double diff,double threshold){
		double result;
		if ((diff - threshold) < 0){
			result = 1 - diff;
		} else {
			result = 0;
		}
		return result;
	}
	
	//整理各项指标的相似度，得到与每个用户的总相似度
	private static Map<String,Object> sortSimilarity(List<Map<String,Object>> originList){
		Map<String,Object> similarityMap = new HashMap<>();
		try {
			for (Map<String, Object> map:originList){
				if (similarityMap.containsKey((String)map.get("userId"))){
					double tempSimilar = (double)similarityMap.get(map.get("userId")) + (double) map.get("diff")/7;
					similarityMap.put((String)map.get("userId"),tempSimilar);
				} else {
					similarityMap.put((String)map.get("userId"), (double) map.get("diff")/7);
				}
			}
		} catch (Exception e){
			System.out.println("sortSimilarity: 统计相似度错误");
		}
		return similarityMap;
	}
}
