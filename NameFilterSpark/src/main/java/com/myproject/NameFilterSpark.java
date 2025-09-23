package com.myproject;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;


public class NameFilterSpark {
    public static void main(String[] args) {
        // Set Hadoop security property before any Spark/Hadoop classes are loaded
        System.setProperty("hadoop.security.authentication", "Simple");
        // ...existing code...
        SparkConf conf = new SparkConf().setAppName("NameFilterSpark").setMaster("local[*]");
        try (JavaSparkContext sc = new JavaSparkContext(conf)) {
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
        }
    }
}
