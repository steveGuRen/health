package com.health.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.SequenceFile.Reader;
import org.apache.hadoop.io.Text;
import org.apache.mahout.common.Pair;
import org.apache.mahout.fpm.pfpgrowth.convertors.string.TopKStringPatterns;

public class ConfidenceCalculation {
	static DecimalFormat df_support = new DecimalFormat("######0.00000"); 
	static DecimalFormat df_confidence = new DecimalFormat("######0.000");
    public static Map<String, Long> readFrequency(Configuration configuration, String fileName) throws Exception {
        FileSystem fs = FileSystem.get(configuration);
        Reader frequencyReader = new SequenceFile.Reader(fs,
                new Path(fileName), configuration);
        Map<String, Long> frequency = new HashMap<String, Long>();
        Text key = new Text();
        LongWritable value = new LongWritable();
        while(frequencyReader.next(key, value)) {
            frequency.put(key.toString(), value.get());
        }
        return frequency;
    }
 
 /**
  * @param configuration 
  * @param fileName 包含每个item的频繁项的序列文件
  * @param transactionCount  事务总数
  * @param frequency 每个item出现的次数的list
  * @param minSupport 支持度
  * @param minConfidence 置信度
  */
    public static void readFrequentPatterns(
            Configuration configuration,
            String fileName,
            long transactionCount,
            Map<String, Long> frequency,
            double minSupport, double minConfidence) throws Exception {
        FileSystem fs = FileSystem.get(configuration);
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:/data/frquentout41316.txt",true));
        BufferedWriter bw = new BufferedWriter(osw);
 
        Reader frequentPatternsReader = new SequenceFile.Reader(fs,
                new Path(fileName), configuration);
        Text key = new Text();
        TopKStringPatterns value = new TopKStringPatterns();
        
        while(frequentPatternsReader.next(key, value)) {
            List<Pair<List<String>, Long>> patterns = value.getPatterns();//条件模式基
            Long keycount = frequency.get(key.toString());
            for(Pair<List<String>, Long> pair: patterns) {
                List<String> itemList = pair.getFirst();//模式基
                Long occurrence = pair.getSecond();//模式基的次数
                if(itemList.size() > 1){
                	itemList.remove(key.toString());
                	double support = (double)occurrence / transactionCount;
                    double confidence = (double)occurrence / keycount;
                    if ((support > minSupport
                            && confidence > minConfidence)){
	                    String str = itemList.toString();
	                    String s = key+";"+str.substring(str.indexOf("[")+1, str.lastIndexOf("]"))+";"+df_support.format(support)+";"+df_confidence.format(confidence)+";undirected"+"\n";
	                    bw.write(new String(s.getBytes("UTF-8")));
	                    System.out.printf(
	                            "%s;%s;%.5f;%.3f\n",
	                            key,
	                            str.substring(str.indexOf("[")+1, str.lastIndexOf("]")),
	                            support,
	                            confidence);
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        frequentPatternsReader.close();
        
    }
 
    public static void main(String args[]) throws Exception {
 
    	OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("d:/data/listout41316.txt",true));
        BufferedWriter bw = new BufferedWriter(osw);
        long transactionCount = 2181896;//事务总数
        String frequencyFilename = "d:/data/fList41117.seq";//
        String frequentPatternsFilename = "d:/data/frequent41117.seq";
        double minSupport = 0.000045;//支持度
        double minConfidence = 0.7;//置信度
        
 
 
        Configuration configuration = new Configuration();
        //读取频繁一项集，key为一项集元素，value是对应出现次数
        Map<String, Long> frequency = readFrequency(configuration, frequencyFilename);
        Iterator<Map.Entry<String, Long>> it = frequency.entrySet().iterator();
        while (it.hasNext()) {
             Map.Entry<String, Long> entry = it.next();
             String s = entry.getKey()+";"+entry.getKey()+";"+entry.getValue()+"\n";
             bw.write(new String(s.getBytes("UTF-8")));
        }
        bw.flush();
        bw.close();
        
        //计算关联规则项
        readFrequentPatterns(configuration, frequentPatternsFilename,
                transactionCount, frequency, minSupport, minConfidence);
 
    }
}