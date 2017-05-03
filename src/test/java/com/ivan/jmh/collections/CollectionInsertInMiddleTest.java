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
public class CollectionInsertInMiddleTest {

    private static final int COLLECTION_SIZE = 25_000;

//    Benchmark                                     Mode  Cnt   Score   Error  Units
//    CollectionInsertInMiddleTest.arrayList       thrpt   10  10,477 ± 0,022  ops/s
//    CollectionInsertInMiddleTest.linkedList      thrpt   10   0,941 ± 0,008  ops/s
//    CollectionInsertInMiddleTest.tIntArrayList   thrpt   10  10,725 ± 0,057  ops/s
//    CollectionInsertInMiddleTest.tIntLinkedList  thrpt   10   1,286 ± 0,075  ops/s

    @Benchmark
    public List arrayList() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            int position = this.computePosition(i);
            list.add(position, i);
        }

        return list;
    }

    @Benchmark
    public List linkedList() {
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            int position = this.computePosition(i);
            list.add(position, i);
        }

        return list;
    }

    @Benchmark
    public TIntList tIntArrayList() {
        TIntList list = new TIntArrayList();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            int position = this.computePosition(i);
            list.insert(position, i);
        }

        return list;
    }

    @Benchmark
    public TIntList tIntLinkedList() {
        TIntList list = new TIntLinkedList();

        list.add(0);
        for (int i = 1; i < COLLECTION_SIZE; i++) {
            int position = this.computePosition(i);
            list.insert(position, i);
        }

        return list;
    }

    private int computePosition(int i) {
        return Math.round(i / 2);
    }

}
