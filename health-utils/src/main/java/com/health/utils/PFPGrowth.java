package com.health.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.common.Pair;
import org.apache.mahout.common.iterator.FileLineIterable;
import org.apache.mahout.common.iterator.StringRecordIterator;
import org.apache.mahout.fpm.pfpgrowth.convertors.ContextStatusUpdater;
import org.apache.mahout.fpm.pfpgrowth.convertors.SequenceFileOutputCollector;
import org.apache.mahout.fpm.pfpgrowth.convertors.string.StringOutputConverter;
import org.apache.mahout.fpm.pfpgrowth.convertors.string.TopKStringPatterns;
import org.apache.mahout.fpm.pfpgrowth.fpgrowth.FPGrowth;


public class PFPGrowth {
 
    public static void main(String[] args) throws IOException { 
        
        Set<String> features = new HashSet<String>();
        String input = "d:/data/diagnosis.txt";
//        minSupport，最小支持度，默认3
        int minSupport = 3;
//        maxHeapSize，最大项集，默认50
        int maxHeapSize = 50;//top-k
//        数据分割符
        String pattern = " \"[ ,\\t]*[,|\\t][ ,\\t]*\" ";        
        Charset encoding = Charset.forName("UTF-8");
        FPGrowth<String> fp = new FPGrowth<String>();
        String output = "d:/data/diagnosis2.txt";
        Path path = new Path(output);
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(conf);
         
        SequenceFile.Writer writer = new SequenceFile.Writer(fs, conf, path, Text.class, TopKStringPatterns.class);

        fp.generateTopKFrequentPatterns(
                new StringRecordIterator(new FileLineIterable(new File(input), encoding, false), pattern),
                fp.generateFList(
                    new StringRecordIterator(new FileLineIterable(new File(input), encoding, false), pattern),
                    minSupport),
                minSupport,
                maxHeapSize,
                features,
                new StringOutputConverter(new SequenceFileOutputCollector<Text,TopKStringPatterns>(writer)),
                new ContextStatusUpdater(null));
        writer.close();
        
//        List<Pair<String,TopKStringPatterns>> frequentPatterns = FPGrowth.readFrequentPattern(fs, conf, path);
        List<Pair<String,TopKStringPatterns>> frequentPatterns = FPGrowth.readFrequentPattern(conf, path);
        for (Pair<String,TopKStringPatterns> entry : frequentPatterns) {
            System.out.print(entry.getFirst()+"-"); // the frequent patterns meet minSupport
            System.out.println(entry.getSecond()); // the frequent patterns meet minSupport and support
        }
        System.out.print("\nthe end! ");
    }

}