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

    public static final int COLLECTION_SIZE = 3_000_000;

//    Benchmark                               Mode  Cnt   Score   Error  Units
//    CollectionAdditionTest.arrayList       thrpt   10  28,590 ± 2,154  ops/s
//    CollectionAdditionTest.linkedList      thrpt   10  17,387 ± 6,950  ops/s
//    CollectionAdditionTest.tIntArrayList   thrpt   10  58,763 ± 2,267  ops/s
//    CollectionAdditionTest.tIntLinkedList  thrpt   10  47,148 ± 5,443  ops/s
//    CollectionAdditionTest.hashSet         thrpt   10   9,320 ± 1,178  ops/s
//    CollectionAdditionTest.linkedHashSet   thrpt   10   6,652 ± 1,206  ops/s
//    CollectionAdditionTest.tIntHashSet     thrpt   10   7,405 ± 0,069  ops/s

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
    public TIntSet tIntHashSet() {
        TIntSet set = new TIntHashSet();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            set.add(i);
        }

        return set;
    }

}
