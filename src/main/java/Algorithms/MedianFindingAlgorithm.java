package Algorithms;

public abstract class MedianFindingAlgorithm<T extends Comparable<T>> {
    protected final T[] A;

    public MedianFindingAlgorithm(T[] A){
        this.A = A.clone();
    }

    public abstract T getMedian();
}
