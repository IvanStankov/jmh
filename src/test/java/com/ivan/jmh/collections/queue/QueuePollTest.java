package com.ivan.jmh.collections.queue;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class QueuePollTest {

    private Queue<Integer> arrayDeque;
    private Queue<Integer> linkedList;

    //Benchmark                  Mode  Cnt     Score    Error  Units
    //QueuePollTest.arrayDeque  thrpt   10  2548,506 ± 47,587  ops/s
    //QueuePollTest.linkedList  thrpt   10  1546,397 ± 28,091  ops/s

    @Setup(Level.Invocation)
    public void setup() {
        this.arrayDeque = this.populate(new ArrayDeque<>());
        this.linkedList = this.populate(new LinkedList<>());
    }

    @Benchmark
    public void arrayDeque(final Blackhole blackhole) {
        this.traverse(this.arrayDeque, blackhole);
    }

    @Benchmark
    public void linkedList(final Blackhole blackhole) {
        this.traverse(this.linkedList, blackhole);    }

    private Queue<Integer> populate(final Queue<Integer> queue) {
        IntStream.range(0, 100_000)
                .forEach(queue::add);
        return queue;
    }

    private void traverse(final Queue<Integer> queue, final Blackhole blackhole) {
        Integer i;
        while ((i = queue.poll()) != null) {
            blackhole.consume(i);
        }
    }

}
