package Algorithms;

import java.util.Arrays;

public class NaiveSorting extends MedianFindingAlgorithm {
    public NaiveSorting(int[] A) {
        super(A);
    }

    private void sort(){
        Arrays.sort(A);
    }

    @Override
    public int getMedian(){
        sort();
        return A[(A.length-1)/2];
    }
}
