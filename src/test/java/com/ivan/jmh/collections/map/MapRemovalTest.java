package com.ivan.jmh.collections.map;

import gnu.trove.map.hash.TLongObjectHashMap;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(value = 1)
@Measurement(iterations = 10)
public class MapRemovalTest {

    private static final int COLLECTION_SIZE = 25_000;

    private HashMap<Long, String> hashMap;
    private LinkedHashMap<Long, String> linkedHashMap;
    private TreeMap<Long, String> treeMap;
    private ConcurrentHashMap<Long, String> concurrentHashMap;
    private Map<Long, String> synchronizedHashMap;
    private TLongObjectHashMap<String> tLongObjectHashMap;

//    Benchmark                            Mode  Cnt     Score    Error  Units
//    MapRemovalTest.hashMap              thrpt   10  1317,882 ± 40,804  ops/s
//    MapRemovalTest.linkedHashMap        thrpt   10  1265,977 ± 36,549  ops/s
//    MapRemovalTest.treeMap              thrpt   10  1650,573 ± 74,480  ops/s
//    MapRemovalTest.tLongObjectHashMap   thrpt   10   913,247 ±  5,582  ops/s
//    MapRemovalTest.concurrentHashMap    thrpt   10  1179,907 ± 12,048  ops/s
//    MapRemovalTest.synchronizedHashMap  thrpt   10   674,731 ± 20,214  ops/s

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
        for (Long i = 0L; i < COLLECTION_SIZE; i++) {
            String s = hashMap.remove(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void linkedHashMap(Blackhole bh) {
        for (Long i = 0L; i < COLLECTION_SIZE; i++) {
            String s = linkedHashMap.remove(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void treeMap(Blackhole bh) {
        for (Long i = 0L; i < COLLECTION_SIZE; i++) {
            String s = treeMap.remove(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void tLongObjectHashMap(Blackhole bh) {
        for (long i = 0; i < COLLECTION_SIZE; i++) {
            String s = tLongObjectHashMap.remove(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void synchronizedHashMap(Blackhole bh) {
        for (Long i = 0L; i < COLLECTION_SIZE; i++) {
            String s = synchronizedHashMap.remove(i);
            bh.consume(s);
        }
    }

    @Benchmark
    public void concurrentHashMap(Blackhole bh) {
        for (Long i = 0L; i < COLLECTION_SIZE; i++) {
            String s = concurrentHashMap.remove(i);
            bh.consume(s);
        }
    }
}
