package com.health.utils;

import java.util.Map;

/**
 * 将检测的数据通过指标标准进行计算
 * @author qinzhaohong
 *
 */
public class QuotaResultCalculation {
	
	/**
	 * @param value
	 * @return
	 */
	public static String getResult(Integer age,Integer gender,Integer situation,Integer quotaType,String secordQuotaName,Object value,String resultIn) {
		String result = "";
		//0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检
		if(quotaType == 0){
			return getBMI((double)value);
		}
		if(quotaType == 1){
			return getTemperature((double)value);
		}
		if(quotaType == 2){
			if(secordQuotaName.equals("收缩压")){
				return getSystolicPressure(Double.parseDouble(value.toString()));
			}
			if(secordQuotaName.equals("舒张压")){
				return getDiastolicPressure(Double.parseDouble(value.toString()));
				
			}
		}
		if(quotaType == 3){
			return getBloodOxygen((double)value);
		}
		if(quotaType == 4){
			return getBloodSugar(situation,(double)value);
		}
		if(quotaType == 5){
			double valueResult = (double) value;
			return getHeartRate((int) valueResult);
		}
		if(quotaType == 6){
			return getBFR(age,gender,(double)value);
		}
		if(quotaType == 7){
			if(secordQuotaName.equals("尿白细胞")){
				return getULEU((double)value);
			}else if(secordQuotaName.equals("尿胆原")){
				return getURO((double)value);
			}else if(secordQuotaName.equals("尿比重")){
				return getSG((double)value);
			}else if(secordQuotaName.equals("尿酸碱度")){
				return getPH((double)value);
			}else if(secordQuotaName.equals("尿肌酐")){
				return getUMI(gender,(double)value);
			}else{
				return (String) resultIn;
			}			
		}
		
		return result;
	}
	/**
	 * 体重指数 =体重（公斤） 除以 身高（米）的平方 kg/m2
	 * @param BMI
	 * @return
	 */
	public static String getBMI(double BMI) {
		String result = "";
		if(BMI < 18){
			result = "偏瘦";
		}else if(BMI >= 18 && BMI < 25){
			result = "正常体重";
		}else if(BMI >= 25 && BMI < 30){
			result = "超重";
		}else if(BMI >= 30 && BMI < 35){
			result = "轻度肥胖";
		}else if(BMI >= 35 && BMI < 40){
			result = "中度肥胖";
		}else if(BMI >= 40){
			result = "重度肥胖";
		}	
		
		return result;
	}
	
	/**
	 * 心率
	 * @param value
	 * @return
	 */
	public static String getHeartRate(int value) {
		String result = "";
		if(value < 40){
			result = "房室传导阻带";
		}else if(value >= 40 && value < 60){
			result = "窦性心动过缓";
		}else if(value >= 60 && value < 100){
			result = "正常";
		}else if(value >= 100 && value < 160){
			result = "窦性心动过速";
		}else if(value >= 160 && value < 200){
			result = "阵发性心动过速";
		}
		return result;
	}
	
	/**
	 * 收缩压
	 * @param value
	 * @return
	 */
	public static String getSystolicPressure(double value) {
		String result = "";
		if(value < 90){
			result = "偏低";
		}else if(value >= 90 && value < 140){
			result = "正常";
		}else if(value >= 140){
			result = "偏高";
		}
		return result;
	}
	
	/**
	 * 舒张压
	 * @param value
	 * @return
	 */
	public static String getDiastolicPressure(double value) {
		String result = "";
		if(value < 60){
			result = "偏低";
		}else if(value >= 60 && value < 90){
			result = "正常";
		}else if(value >= 90){
			result = "偏高";
		}
		return result;
	}
	
	/**
	 * 脉搏
	 * @param count
	 * @return
	 */
	public static String getPulse(int count) {
		String result = "";
		if(count < 60){
			result = "偏低";
		}else if(count >= 60 && count < 100){
			result = "正常";
		}else if(count >= 100){
			result = "偏高";
		}
		return result;
	}
	
	/**
	 * 温度
	 * @param value
	 * @return
	 */
	public static String getTemperature(double value) {
		String result = "";
		if(value < 36.0){
			result = "异常";
		}else if(value >= 36.0 && value < 37.4){
			result = "正常";
		}else if(value >= 37.4 && value < 38.1){
			result = "低热";
		}else if(value >= 38.1 && value < 39.1){
			result = "中等热度";
		}else if(value >= 39.1 && value < 41.1){
			result = "高热";
		}else if(value >= 41.1){
			result = "超高热";
		}
		return result;
	}
	/**
	 * 血糖
	 * @param situation 
	 * @param value
	 * @return
	 */
	public static String getBloodSugar(int situation,double value){
		String result = "";
		//空腹
		if(situation == 1){
			if(value <= 7.0){
				if(value >= 4.4 && value <= 6.1){
					result = "最佳";
				}else{
					result = "良好";
				}
			}else if(value > 7.0){
				result = "差";
			}
		}
		//餐后2小时
		if(situation == 2){
			if(value <= 10.0){
				if(value >= 4.4 && value <= 8.0){
					result = "最佳";
				}else{
					result = "良好";
				}
			}else if(value > 10.0){
				result = "差";
			}
		}
		return result;
	}
	
	/**
	 * 血氧
	 * @param value
	 * @return
	 */
	public static String getBloodOxygen(double value){
		String result = "";
		if(value < 0.70){
			result = "异常";
		}else if(value >= 0.7 && value < 0.90){
			result = "低氧血证";
		}else if(value >= 0.90 && value < 0.94){
			result = "供氧不足";
		}else if(value >= 0.94 && value <= 1){
			result = "供氧不足";
		}else if(value > 1){
			result = "异常";
		}
		return result;
	}
		
	/**
	 * 尿白细胞
	 * @param value
	 * @return
	 */
	public static String getULEU(double value){
		String result = "";
		if(value < 5){
			result = "正常";
		}else if(value >= 5){
			result = "偏高";
		}
		return result;
	}
	
	/**
	 * 尿胆原
	 * @param value
	 * @return
	 */
	public static String getURO(double value){
		String result = "";
		if(value < 16){
			result = "正常";
		}else if(value >= 16){
			result = "偏高";
		}
		return result;
	}
	
	/**
	 * 尿比重
	 * @param value
	 * @return
	 */
	public static String getSG(double value){
		String result = "";
		if(value < 1.015){
			result = "偏低";
		}else if(value >= 1.015 && value < 1.025){
			result = "正常";
		}else if(value >= 1.025){
			result = "偏高";
		}
		return result;
	}
	
	/**
	 * 尿酸碱度
	 * @param value
	 * @return
	 */
	public static String getPH(double value){
		String result = "";
		if(value < 4.6){
			result = "偏低";
		}else if(value >= 4.6 && value < 8.0){
			result = "正常";
		}else if(value >= 8.0){
			result = "偏高";
		}
		return result;
	}
	
	/**
	 * 尿肌酐
	 * @param gender
	 * @param value
	 * @return
	 */
	public static String getUMI(int gender, double value){
		String result = "";
		//男
		if(gender == 0){
			if(value < 8.4){
				result = "偏低";
			}else if(value >= 8.4 && value < 13.25){
				result = "正常";
			}else if(value >= 13.25){
				result = "偏高";
			}
		}
		//女
		if(gender == 1){
			if(value < 7){
				result = "偏低";
			}else if(value >= 7 && value < 18){
				result = "正常";
			}else if(value >= 18){
				result = "偏高";
			}
		}
		return result;
	}
	
	/**
	 * 体脂 % = 1.2*BMI +0.23*年龄-5.4-10.8*性别（男为1，女为0）
	 * @param age
	 * @param gender
	 * @param BMI
	 * @return
	 */
	public static String getBFR(int age,int gender, double BMI){
		String result = "";
		int gd = (gender + 1) % 2;
		double BFR = 1.2*BMI + 0.23*age - 5.4 - 10.8*gd;
		//男
		if(gender == 0){
			if(age < 30){
				if(BFR < 13){
					result = "偏瘦";
				}else if(BFR >= 13 && BFR < 20){
					result = "标准";
				}else if(BFR >= 20 && BFR < 25){
					result = "微胖";
				}else if(BFR >= 25){
					result = "肥胖";
				}
			}
			if(age >= 30){
				if(BFR < 16){
					result = "偏瘦";
				}else if(BFR >= 16 && BFR < 23){
					result = "标准";
				}else if(BFR >= 23 && BFR < 25){
					result = "微胖";
				}else if(BFR >= 25){
					result = "肥胖";
				}
			}
		}
		//女
		if(gender == 1){
			if(age < 30){
				if(BFR < 16){
					result = "偏瘦";
				}else if(BFR >= 16 && BFR < 24){
					result = "标准";
				}else if(BFR >= 24 && BFR < 30){
					result = "微胖";
				}else if(BFR >= 30){
					result = "肥胖";
				}
			}
			if(age >= 30){
				if(BFR < 19){
					result = "偏瘦";
				}else if(BFR >= 19 && BFR < 27){
					result = "标准";
				}else if(BFR >= 27 && BFR < 30){
					result = "微胖";
				}else if(BFR >= 30){
					result = "肥胖";
				}
			}
		}
		return result;
	}
	
}
