package com.ivan.jmh.collections.map;

import gnu.trove.map.hash.TLongObjectHashMap;
import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 10)
@Fork(value = 1)
@Measurement(iterations = 10)
public class MapAdditionTest {

    private static final int COLLECTION_SIZE = 1_000_000;

//    Benchmark                             Mode  Cnt   Score  Error  Units
//    MapAdditionTest.hashMap              thrpt   10  4,604 ± 0,931  ops/s
//    MapAdditionTest.linkedHashMap        thrpt   10  3,732 ± 0,564  ops/s
//    MapAdditionTest.treeMap              thrpt   10  1,225 ± 0,191  ops/s
//    MapAdditionTest.synchronizedHashMap  thrpt   10  3,869 ± 0,511  ops/s
//    MapAdditionTest.concurrentHashMap    thrpt   10  2,487 ± 0,374  ops/s
//    MapAdditionTest.tLongObjectHashMap   thrpt   10  3,749 ± 0,229  ops/s

    @Benchmark
    public Map<Long, String> hashMap() {
        Map<Long, String> map = new HashMap<>();

        for (long i = 0; i < COLLECTION_SIZE; i++) {
            map.put(i, String.valueOf(i));
        }

        return map;
    }

    @Benchmark
    public Map<Long, String> linkedHashMap() {
        Map<Long, String> map = new LinkedHashMap<>();

        for (long i = 0; i < COLLECTION_SIZE; i++) {
            map.put(i, String.valueOf(i));
        }

        return map;
    }

    @Benchmark
    public Map<Long, String> treeMap() {
        Map<Long, String> map = new TreeMap<>();

        for (long i = 0; i < COLLECTION_SIZE; i++) {
            map.put(i, String.valueOf(i));
        }

        return map;
    }

    @Benchmark
    public TLongObjectHashMap<String> tLongObjectHashMap() {
        TLongObjectHashMap<String> map = new TLongObjectHashMap<>();

        for (long i = 0; i < COLLECTION_SIZE; i++) {
            map.put(i, String.valueOf(i));
        }

        return map;
    }

    @Benchmark
    public Map<Long, String> synchronizedHashMap() {
        Map<Long, String> map = new HashMap<>();
        map = Collections.synchronizedMap(map);

        for (long i = 0; i < COLLECTION_SIZE; i++) {
            map.put(i, String.valueOf(i));
        }

        return map;
    }

    @Benchmark
    public Map<Long, String> concurrentHashMap() {
        ConcurrentHashMap<Long, String> map = new ConcurrentHashMap<>();

        for (long i = 0; i < COLLECTION_SIZE; i++) {
            map.put(i, String.valueOf(i));
        }

        return map;
    }

}
