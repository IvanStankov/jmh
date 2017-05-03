package com.ivan.jmh.collections;

import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.linked.TIntLinkedList;
import gnu.trove.set.TIntSet;
import gnu.trove.set.hash.TIntHashSet;
import org.openjdk.jmh.annotations.*;

import java.util.*;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class CollectionAdditionTest {

    private static final int COLLECTION_SIZE = 1_000_000;

//    Benchmark                               Mode  Cnt   Score    Error  Units
//    CollectionAdditionTest.arrayList       thrpt   10  41,953 ±  2,089  ops/s
//    CollectionAdditionTest.linkedList      thrpt   10  35,973 ± 10,118  ops/s
//    CollectionAdditionTest.tIntArrayList   thrpt   10  98,480 ±  2,697  ops/s
//    CollectionAdditionTest.tIntLinkedList  thrpt   10  71,861 ±  4,538  ops/s
//    CollectionAdditionTest.hashSet         thrpt   10  12,113 ±  1,032  ops/s
//    CollectionAdditionTest.linkedHashSet   thrpt   10   9,319 ±  0,559  ops/s
//    CollectionAdditionTest.treeSet         thrpt   10   2,537 ±  0,160  ops/s
//    CollectionAdditionTest.tIntHashSet     thrpt   10   8,895 ±  0,063  ops/s

    @Benchmark
    public List arrayList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            list.add(i);
        }

        return list;
    }

    @Benchmark
    public List linkedList() {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            list.add(i);
        }

        return list;
    }

    @Benchmark
    public TIntList tIntArrayList() {
        TIntList list = new TIntArrayList();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            list.add(i);
        }

        return list;
    }

    @Benchmark
    public TIntList tIntLinkedList() {
        TIntList list = new TIntLinkedList();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            list.add(i);
        }

        return list;
    }

    @Benchmark
    public Set hashSet() {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            set.add(i);
        }

        return set;
    }

    @Benchmark
    public Set linkedHashSet() {
        Set<Integer> set = new LinkedHashSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            set.add(i);
        }

        return set;
    }

    @Benchmark
    public Set treeSet() {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            set.add(i);
        }

        return set;
    }

    @Benchmark
    public TIntSet tIntHashSet() {
        TIntSet set = new TIntHashSet();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            set.add(i);
        }

        return set;
    }

}
