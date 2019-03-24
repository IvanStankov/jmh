package com.ivan.jmh.collections.queue;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class QueueAdditionTest {

    private Queue<Integer> arrayDeque;
    private Queue<Integer> linkedList;

    //Benchmark                      Mode  Cnt     Score    Error  Units
    //QueueAdditionTest.arrayDeck   thrpt   10  1955,492 ± 13,151  ops/s
    //QueueAdditionTest.linkedList  thrpt   10  1403,889 ± 61,692  ops/s

    @Setup(Level.Invocation)
    public void setup() {
        this.arrayDeque = new ArrayDeque<>();
        this.linkedList = new LinkedList<>();
    }

    @Benchmark
    public Queue<Integer> arrayDeck() {
        this.loop(this.arrayDeque::add);
        return this.arrayDeque;
    }

    @Benchmark
    public Queue<Integer> linkedList() {
        this.loop(this.linkedList::add);
        return this.linkedList;
    }

    private void loop(final Consumer<Integer> addToQueue) {
        IntStream.range(0, 100_000)
                .forEach(addToQueue::accept);
    }

}
