package com.ivan.jmh.collections;

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
public class CollectionRemovalTest {

    public static final int COLLECTION_SIZE = 25_000;

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private TIntArrayList tIntArrayList;
    private TIntLinkedList tIntLinkedList;
    private HashSet<Integer> hashSet;
    private LinkedHashSet<Integer> linkedHashSet;
    private TIntHashSet tIntHashSet;

//    Benchmark                              Mode  Cnt     Score    Error  Units
//    CollectionRemovalTest.arrayList       thrpt   10  3969,495 ± 80,777  ops/s
//    CollectionRemovalTest.linkedList      thrpt   10  4476,851 ± 65,729  ops/s
//    CollectionRemovalTest.tIntArrayList   thrpt   10  3902,786 ± 22,512  ops/s
//    CollectionRemovalTest.tIntLinkedList  thrpt   10  4487,632 ± 24,603  ops/s
//    CollectionRemovalTest.hashSet         thrpt   10  2503,527 ± 16,420  ops/s
//    CollectionRemovalTest.linkedHashSet   thrpt   10  2499,842 ± 17,137  ops/s
//    CollectionRemovalTest.tIntHashSet     thrpt   10  1007,783 ±  7,195  ops/s

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
        for (Integer i = 0; i < COLLECTION_SIZE; i++) {
            arrayList.remove(i);
        }
    }

    @Benchmark
    public void linkedList(Blackhole bh) {
        for (Integer i = 0; i < COLLECTION_SIZE; i++) {
            linkedList.remove(i);
        }
    }

    @Benchmark
    public void tIntArrayList(Blackhole bh) {
        for (Integer i = 0; i < COLLECTION_SIZE; i++) {
            tIntArrayList.remove(i);
        }
    }

    @Benchmark
    public void tIntLinkedList(Blackhole bh) {
        for (Integer i = 0; i < COLLECTION_SIZE; i++) {
            tIntLinkedList.remove(i);
        }
    }

    @Benchmark
    public void hashSet(Blackhole bh) {
        for (Integer i = 0; i < COLLECTION_SIZE; i++) {
            hashSet.remove(i);
        }
    }

    @Benchmark
    public void linkedHashSet(Blackhole bh) {
        for (Integer i = 0; i < COLLECTION_SIZE; i++) {
            linkedHashSet.remove(i);
        }
    }

    @Benchmark
    public void tIntHashSet(Blackhole bh) {
        for (Integer i = 0; i < COLLECTION_SIZE; i++) {
            tIntHashSet.remove(i);
        }
    }

}
