package Algorithms;

public abstract class MedianFindingAlgorithm {
    protected final int[] A;

    public MedianFindingAlgorithm(int[] A){
        this.A = A.clone();
    }

    public abstract int getMedian();
}
