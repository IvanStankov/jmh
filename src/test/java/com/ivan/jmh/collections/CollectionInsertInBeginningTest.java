package com.ivan.jmh.collections;

import gnu.trove.list.TIntList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.list.linked.TIntLinkedList;
import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class CollectionInsertInBeginningTest {

    public static final int COLLECTION_SIZE = 25_000;

//    Benchmark                                        Mode  Cnt     Score    Error  Units
//    CollectionInsertInBeginningTest.arrayList       thrpt   10     5,064 ±  0,019  ops/s
//    CollectionInsertInBeginningTest.linkedList      thrpt   10  1305,162 ± 13,003  ops/s
//    CollectionInsertInBeginningTest.tIntArrayList   thrpt   10     5,217 ±  0,020  ops/s
//    CollectionInsertInBeginningTest.tIntLinkedList  thrpt   10  2687,024 ± 38,178  ops/s

    @Benchmark
    public List arrayList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            list.add(0, i);
        }

        return list;
    }

    @Benchmark
    public List linkedList() {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            list.add(0, i);
        }

        return list;
    }

    @Benchmark
    public TIntList tIntArrayList() {
        TIntList list = new TIntArrayList();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            list.insert(0, i);
        }

        return list;
    }

    @Benchmark
    public TIntList tIntLinkedList() {
        TIntList list = new TIntLinkedList();

        list.add(0);
        for (int i = 1; i < COLLECTION_SIZE; i++) {
            list.insert(0, i);
        }

        return list;
    }
}
