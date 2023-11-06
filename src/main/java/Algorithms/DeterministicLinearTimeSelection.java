package Algorithms;

public class DeterministicLinearTimeSelection<T extends Comparable<T>> extends MedianFindingAlgorithm<T> {
    public DeterministicLinearTimeSelection(T[] A) {
        super(A);
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

    private int partitionAround(int p, int r, T x){
        for (int j = p; j <= r; j++){
            if (A[j].compareTo(x) == 0) {
                swap(j, r);
                break;
            }
        }

        return partition(p, r);
    }

    private void minMax(int i, int j, int p, int g){
        int mini = p;
        int maxi = p;

        for (int l = i+1; l <= j; l+=2) {
            if (A[p+l*g].compareTo(A[p+(l+1)*g]) < 0) {
                if (A[p+l*g].compareTo(A[mini]) < 0)
                    mini = p+l*g;
                if (A[p+(l+1)*g].compareTo(A[maxi]) > 0)
                    maxi = p+(l+1)*g;
            } else {
                if (A[p+(l+1)*g].compareTo(A[mini]) < 0)
                    mini = p+(l+1)*g;
                if (A[p+l*g].compareTo(A[maxi]) > 0)
                    maxi = p+l*g;
            }
        }

        swap(mini, p+i*g);
        swap(maxi, p+j*g);
    }

    private T select(int p, int r, int i){
        while ((r - p + 1)%5 != 0){
            for (int j = p; j <= r; j++){
                if (A[j].compareTo(A[p]) < 1){
                    swap(p, j);
                }
            }

            if (i == 1)
                return A[p];

            p++;
            i--;
        }

        int g = (r-p+1)/5;
        for (int j = p; j < p+g-1; j++){
            minMax(0, 4, j, g);
            minMax(1, 3, j, g);
        }

        T x = select(p+2*g, p+3*g-1, (g+1)/2);
        int q = partitionAround(p, r, x);
        int k = q - p + 1;

        if (i == k)
            return A[q];
        if (i < k)
            return select(p, q-1, i);
        else
            return select(q+1, r, i-k);
    }

    private T get_ith_static_order(int i){
        return select(0, A.length-1, i);
    }

    @Override
    public T getMedian(){
        return get_ith_static_order((A.length+1)/2);
    }
}
