package com.performance.concatenation;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, warmups = 1)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class StringConcatenationBenchmark {
    private String str1 = "Hello";
    private String str2 = "World";
    @Benchmark
    public String concatenateWithPlus() {
        return str1 + str2;
    }
    @Benchmark
    public String concatenateWithStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append(str1);
        sb.append(str2);
        return sb.toString();
    }
}