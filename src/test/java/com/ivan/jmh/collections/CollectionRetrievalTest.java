package com.ivan.jmh.collections;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.linked.TIntLinkedList;
import gnu.trove.set.hash.TIntHashSet;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class CollectionRetrievalTest {

    public static final int COLLECTION_SIZE = 25_000;

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private TIntArrayList tIntArrayList;
    private TIntLinkedList tIntLinkedList;
    private HashSet<Integer> hashSet;
    private LinkedHashSet<Integer> linkedHashSet;
    private TIntHashSet tIntHashSet;

//    Benchmark                                       Mode  Cnt     Score    Error  Units
//    CollectionRetrievalTest.arrayList              thrpt   10  1608,387 ± 49,216  ops/s
//    CollectionRetrievalTest.tIntArrayList          thrpt   10  1939,055 ±  6,411  ops/s
//    CollectionRetrievalTest.linkedList             thrpt   10     0,840 ±  0,004  ops/s
//    CollectionRetrievalTest.tIntLinkedList         thrpt   10     0,830 ±  0,005  ops/s
//    CollectionRetrievalTest.hashSetIterator        thrpt   10   878,249 ± 18,873  ops/s
//    CollectionRetrievalTest.linkedHashSetIterator  thrpt   10  1059,862 ±  5,092  ops/s
//    CollectionRetrievalTest.tIntHashSetIterator    thrpt   10  1442,059 ± 24,158  ops/s

    @Setup(Level.Trial)
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        tIntArrayList = new TIntArrayList();
        tIntLinkedList = new TIntLinkedList();
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        tIntHashSet = new TIntHashSet();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
            tIntArrayList.add(i);
            tIntLinkedList.add(i);
            hashSet.add(i);
            linkedHashSet.add(i);
            tIntHashSet.add(i);
        }
    }

    @Benchmark
    public void arrayList(Blackhole bh) {
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            Integer elem = arrayList.get(i);
            bh.consume(elem);
        }
    }

    @Benchmark
    public void linkedList(Blackhole bh) {
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            Integer elem = linkedList.get(i);
            bh.consume(elem);
        }
    }

    @Benchmark
    public void tIntArrayList(Blackhole bh) {
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            Integer elem = tIntArrayList.get(i);
            bh.consume(elem);
        }
    }

    @Benchmark
    public void tIntLinkedList(Blackhole bh) {
        for (int i = 0; i < COLLECTION_SIZE; i++) {
            Integer elem = tIntLinkedList.get(i);
            bh.consume(elem);
        }
    }

    @Benchmark
    public void hashSetIterator(Blackhole bh) {
        for (Integer elem : hashSet) {
            bh.consume(elem);
        }
    }

    @Benchmark
    public void linkedHashSetIterator(Blackhole bh) {
        for (Integer elem : linkedHashSet) {
            bh.consume(elem);
        }
    }

    @Benchmark
    public void tIntHashSetIterator(Blackhole bh) {
        TIntIterator iterator = tIntHashSet.iterator();
        while (iterator.hasNext()) {
            int elem = iterator.next();
            bh.consume(elem);
        }
    }

}
