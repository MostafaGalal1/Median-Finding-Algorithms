package Algorithms;

import java.util.Random;

public class RandomizedDivideAndConquer<T extends Comparable<T>> extends MedianFindingAlgorithm<T> {
    private final Random random;
    public RandomizedDivideAndConquer(T[] A) {
        super(A);
        this.random = new Random();
    }

    private int partition(int p, int r){
        T x = A[r];
        int i = p-1;

        for (int j = p; j < r; j++){
            if (A[j].compareTo(x) < 1){
                i++;
                T temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        T temp = A[i+1];
        A[i+1] = A[r];
        A[r] = temp;
        return i+1;
    }

    private int randomizedPartition(int p, int r){
        int i = random.nextInt(r - p + 1) + p;
        T temp = A[i];
        A[i] = A[r];
        A[r] = temp;

        return partition(p, r);
    }
    private void randomizedQuickSort(int p, int r) {
        if (p < r) {
            int q = randomizedPartition(p, r);
            randomizedQuickSort(p, q - 1);
            randomizedQuickSort(q + 1, r);
        }
    }

    @Override
    public T getMedian(){
        randomizedQuickSort(0, A.length-1);
        return A[(A.length-1)/2];
    }
}
