package com.ivan.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class StreamParallelismTest {

    public static final int CONSUME_RANGE = 10;

    private IntStream stream;

    @Setup(Level.Invocation)
    public void setup() {
        stream = IntStream.range(1, 10_000);
    }

    @Benchmark
    public int sequentialStream() {
        return stream
                .peek(i -> Blackhole.consumeCPU(CONSUME_RANGE))
                .sum();
    }

    @Benchmark
    public int parallelStream_Standard() {
        return stream
                .parallel()
                .peek(i -> Blackhole.consumeCPU(CONSUME_RANGE))
                .sum();
    }

    @Benchmark
    public int parallelStream_2Threads() {
        ForkJoinTask<Integer> submit = new ForkJoinPool(2).submit(() -> stream
                .parallel()
                .peek(i -> Blackhole.consumeCPU(CONSUME_RANGE))
                .sum());

        return submit.join();
    }

    @Benchmark
    public int parallelStream_6Threads() {
        ForkJoinTask<Integer> submit = new ForkJoinPool(6).submit(() -> stream
                .parallel()
                .peek(i -> Blackhole.consumeCPU(CONSUME_RANGE))
                .sum());

        return submit.join();
    }

}
