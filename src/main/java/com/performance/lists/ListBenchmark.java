package com.performance.lists;

import org.openjdk.jmh.annotations.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, warmups = 1)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class ListBenchmark {
    private List<Integer> arrayList;
    private List<Integer> linkedList;
    @Setup
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        for (int i = 0; i < 1000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
    }
    @Benchmark
    public int arrayListIteration() {
        int sum = 0;
        for (int num : arrayList) {
            sum += num;
        }
        return sum;
    }
    @Benchmark
    public int linkedListIteration() {
        int sum = 0;
        for (int num : linkedList) {
            sum += num;
        }
        return sum;
    }
}