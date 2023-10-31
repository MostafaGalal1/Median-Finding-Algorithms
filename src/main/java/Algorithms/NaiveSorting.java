package Algorithms;

import java.util.Arrays;

public class NaiveSorting<T extends Comparable<T>> extends MedianFindingAlgorithm<T> {
    public NaiveSorting(T[] A) {
        super(A);
    }

    private void sort(){
        Arrays.sort(A);
    }

    @Override
    public T getMedian(){
        sort();
        return A[(A.length-1)/2];
    }
}
