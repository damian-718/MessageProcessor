package com.myproject;

import org.apache.spark.api.java.*;
import org.apache.spark.SparkConf;
import java.util.Arrays;
import java.util.List;


public class NameFilterSpark {
    public static void main(String[] args) {

        // 1. Spark setup (local with all cores)
        SparkConf conf = new SparkConf().setAppName("NameFilterSpark").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);

        // 2. Input data
        List<String> names = Arrays.asList("Tom", "Jerry", "Amy", "Christopher", "Max", "John");

        // 3. Parallelize the list (Spark distributes it)
        JavaRDD<String> namesRDD = sc.parallelize(names);

        // 4. Filter + transform
        JavaRDD<String> processed = namesRDD
                .filter(name -> name.length() > 3)
                .map(String::toUpperCase);

        // 5. Collect results back and print
        processed.collect().forEach(System.out::println);

        sc.close();
    }
}
