package com.ivan.jmh.collections;

import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.linked.TIntLinkedList;
import gnu.trove.set.hash.TIntHashSet;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class CollectionRemovalTest {

    private static final int COLLECTION_SIZE = 25_000;

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private TIntArrayList tIntArrayList;
    private TIntLinkedList tIntLinkedList;
    private HashSet<Integer> hashSet;
    private LinkedHashSet<Integer> linkedHashSet;
    private TreeSet<Integer> treeSet;
    private TIntHashSet tIntHashSet;

//    Benchmark                              Mode  Cnt     Score     Error  Units
//    CollectionRemovalTest.arrayList       thrpt   10  3927,111 ±  57,230  ops/s
//    CollectionRemovalTest.linkedList      thrpt   10  4360,926 ± 121,257  ops/s
//    CollectionRemovalTest.tIntArrayList   thrpt   10  3899,559 ±  64,079  ops/s
//    CollectionRemovalTest.tIntLinkedList  thrpt   10  4490,124 ±  50,396  ops/s
//    CollectionRemovalTest.hashSet         thrpt   10  2455,101 ±  14,791  ops/s
//    CollectionRemovalTest.linkedHashSet   thrpt   10  2468,913 ±  14,034  ops/s
//    CollectionRemovalTest.treeSet         thrpt   10  3267,110 ±  26,093  ops/s
//    CollectionRemovalTest.tIntHashSet     thrpt   10   997,116 ±  10,324  ops/s

    @Setup(Level.Trial)
    public void setup() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        tIntArrayList = new TIntArrayList();
        tIntLinkedList = new TIntLinkedList();
        hashSet = new HashSet<>();
        linkedHashSet = new LinkedHashSet<>();
        treeSet = new TreeSet<>();
        tIntHashSet = new TIntHashSet();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
            tIntArrayList.add(i);
            tIntLinkedList.add(i);
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
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
    public void treeSet(Blackhole bh) {
        for (Integer i = 0; i < COLLECTION_SIZE; i++) {
            treeSet.remove(i);
        }
    }

    @Benchmark
    public void tIntHashSet(Blackhole bh) {
        for (Integer i = 0; i < COLLECTION_SIZE; i++) {
            tIntHashSet.remove(i);
        }
    }

}
