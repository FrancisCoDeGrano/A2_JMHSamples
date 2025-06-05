package com.performance.arithmetic;

import org.openjdk.jmh.annotations.*;

public class MyBenchmark {

    @Benchmark
    public int testMethod() {
        int a = 1;
        int b = 2;
        return a + b;
    }
}