package com.performance.arithmetic;

import org.openjdk.jmh.annotations.*;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, warmups = 1)
@Warmup(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@State(Scope.Benchmark)
public class MathBenchmark {
    @Benchmark
    public double squareRootBenchmark() {
        return Math.sqrt(Math.random());
    }
    @Benchmark
    public double sinBenchmark() {
        return Math.sin(Math.random());
    }
}