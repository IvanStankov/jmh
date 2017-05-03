package com.ivan.jmh.collections.map;

import gnu.trove.map.hash.TLongObjectHashMap;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(1)
@Measurement(iterations = 10)
public class MapRetrievalTest {

    private static final int COLLECTION_SIZE = 25_000;

    private HashMap<Long, String> hashMap;
    private LinkedHashMap<Long, String> linkedHashMap;
    private TreeMap<Long, String> treeMap;
    private ConcurrentHashMap<Long, String> concurrentHashMap;
    private Map<Long, String> synchronizedHashMap;
    private TLongObjectHashMap<String> tLongObjectHashMap;

//    Benchmark                              Mode  Cnt    Score    Error  Units
//    MapRetrievalTest.hashMap              thrpt   10  731,712 ±  6,728  ops/s
//    MapRetrievalTest.linkedHashMap        thrpt   10  773,652 ±  9,948  ops/s
//    MapRetrievalTest.treeMap              thrpt   10  248,594 ±  4,492  ops/s
//    MapRetrievalTest.concurrentHashMap    thrpt   10  727,879 ± 10,511  ops/s
//    MapRetrievalTest.synchronizedHashMap  thrpt   10  403,038 ± 19,848  ops/s
//    MapRetrievalTest.tLongObjectHashMap   thrpt   10  513,576 ±  4,144  ops/s

    @Setup(Level.Trial)
    public void setup() {
        hashMap = new HashMap<>();
        linkedHashMap = new LinkedHashMap<>();
        treeMap = new TreeMap<>();
        concurrentHashMap = new ConcurrentHashMap<>();
        synchronizedHashMap = new HashMap<>();
        tLongObjectHashMap = new TLongObjectHashMap<>();

        for (long i = 0; i < COLLECTION_SIZE; i++) {
            hashMap.put(i, String.valueOf(i));
            linkedHashMap.put(i, String.valueOf(i));
            treeMap.put(i, String.valueOf(i));
            concurrentHashMap.put(i, String.valueOf(i));
            synchronizedHashMap.put(i, String.valueOf(i));
            tLongObjectHashMap.put(i, String.valueOf(i));
        }

        synchronizedHashMap = Collections.synchronizedMap(synchronizedHashMap);
    }

    @Benchmark
    public void hashMap(Blackhole bh) {
        for (long i = 0; i < COLLECTION_SIZE; i++) {
            String s = hashMap.get(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void linkedHashMap(Blackhole bh) {
        for (long i = 0; i < COLLECTION_SIZE; i++) {
            String s = linkedHashMap.get(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void treeMap(Blackhole bh) {
        for (long i = 0; i < COLLECTION_SIZE; i++) {
            String s = treeMap.get(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void tLongObjectHashMap(Blackhole bh) {
        for (long i = 0; i < COLLECTION_SIZE; i++) {
            String s = tLongObjectHashMap.get(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void synchronizedHashMap(Blackhole bh) {
        for (long i = 0; i < COLLECTION_SIZE; i++) {
            String s = synchronizedHashMap.get(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void concurrentHashMap(Blackhole bh) {
        for (long i = 0; i < COLLECTION_SIZE; i++) {
            String s = concurrentHashMap.get(i);
            bh.consume(s);
        }
    }

}
