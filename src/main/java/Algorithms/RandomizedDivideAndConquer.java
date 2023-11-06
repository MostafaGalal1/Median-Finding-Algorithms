package Algorithms;

import java.util.Random;

public class RandomizedDivideAndConquer<T extends Comparable<T>> extends MedianFindingAlgorithm<T> {
    private final Random random;
    public RandomizedDivideAndConquer(T[] A) {
        super(A);
        this.random = new Random();
    }

    private void swap(int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int partition(int p, int r){
        T x = A[r];
        int i = p-1;

        for (int j = p; j < r; j++){
            if (A[j].compareTo(x) < 1){
                i++;
                swap(i, j);
            }
        }

        swap(i+1, r);
        return i+1;
    }

    private int randomizedPartition(int p, int r){
        int i = random.nextInt(r - p + 1) + p;
        swap(i, r);

        return partition(p, r);
    }
    private T randomizedSelect(int p, int r, int i) {
        if (p == r) {
            return A[p];
        }

        int q = randomizedPartition(p, r);
        int k = q - p + 1;

        if (i == k) {
            return A[q];
        } else if (i < k) {
            return randomizedSelect(p, q - 1, i);
        } else {
            return randomizedSelect(q + 1, r, i - k);
        }
    }

    @Override
    public T getMedian(){
        return randomizedSelect(0, A.length-1, (A.length-1)/2);
    }
}
