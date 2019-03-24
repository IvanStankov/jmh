package com.ivan.jmh.algorithms;

import com.ivan.newtechnologies.algorithms.sort.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.ArrayList;
import java.util.List;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 5)
@Fork(1)
@Measurement(iterations = 10)
public class SortAlgorithmsTest {

    private List<Integer> originalList;
    private List<Integer> target;

    private SortAlgorithm bubbleSort;
    private SortAlgorithm selectionSort;
    private SortAlgorithm insertionSort;
    private SortAlgorithm quickSortPivotIsLast;
    private SortAlgorithm quickSortPivotIsMiddle;
    private SortAlgorithm mergeSort;

    @Setup(Level.Iteration)
    public void setup() {
        this.originalList = ListGenerator.generate(2000);
        this.bubbleSort = new BubbleSort();
        this.selectionSort = new SelectionSort();
        this.insertionSort = new InsertionSort();
        this.quickSortPivotIsLast = new QuickSortPivotIsLast();
        this.quickSortPivotIsMiddle = new QuickSortPivotIsMiddle();
        this.mergeSort = new MergeSort();
    }

    @Setup(Level.Invocation)
    public void setup2() {
        this.target = new ArrayList<>(this.originalList);
    }

    @Benchmark
    public void bubbleSort(final Blackhole blackhole) {
        this.bubbleSort.sort(this.target);
        blackhole.consume(this.target);
    }

    @Benchmark
    public void selectionSort(final Blackhole blackhole) {
        this.selectionSort.sort(this.target);
        blackhole.consume(this.target);
    }

    @Benchmark
    public void insertionSort(final Blackhole blackhole) {
        this.insertionSort.sort(this.target);
        blackhole.consume(this.target);
    }

    @Benchmark
    public void quickSortPivotIsLastSort(final Blackhole blackhole) {
        this.quickSortPivotIsLast.sort(this.target);
        blackhole.consume(this.target);
    }

    @Benchmark
    public void quickSortPivotIsMiddleSort(final Blackhole blackhole) {
        this.quickSortPivotIsMiddle.sort(this.target);
        blackhole.consume(this.target);
    }

    @Benchmark
    public void mergeSort(final Blackhole blackhole) {
        this.mergeSort.sort(this.target);
        blackhole.consume(this.target);
    }

}
