package Algorithms;

public class DeterministicLinearTimeSelection extends MedianFindingAlgorithm {
    public DeterministicLinearTimeSelection(int[] A) {
        super(A);
    }

    private void swap(int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int partition(int p, int r){
        int x = A[r];
        int i = p-1;

        for (int j = p; j < r; j++){
            if (A[j] <= x){
                i++;
                swap(i, j);
            }
        }

        swap(i+1, r);
        return i+1;
    }

    private int partitionAround(int p, int r, int x){
        for (int j = p; j <= r; j++){
            if (A[j] == x) {
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
            if (A[p+l*g] < A[p+(l+1)*g]) {
                if (A[p+l*g] < A[mini])
                    mini = p+l*g;
                if (A[p+(l+1)*g] > A[maxi])
                    maxi = p+(l+1)*g;
            } else {
                if (A[p+(l+1)*g] < A[mini])
                    mini = p+(l+1)*g;
                if (A[p+l*g] > A[maxi])
                    maxi = p+l*g;
            }
        }

        swap(mini, p+i*g);
        swap(maxi, p+j*g);
    }

    private int select(int p, int r, int i){
        while ((r - p + 1)%5 != 0){
            for (int j = p; j <= r; j++){
                if (A[j] <= A[p]){
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

        int x = select(p+2*g, p+3*g-1, (g+1)/2);
        int q = partitionAround(p, r, x);
        int k = q - p + 1;

        if (i == k)
            return A[q];
        if (i < k)
            return select(p, q-1, i);
        else
            return select(q+1, r, i-k);
    }

    private int get_ith_static_order(int i){
        return select(0, A.length-1, i);
    }

    @Override
    public int getMedian(){
        return get_ith_static_order((A.length+1)/2);
    }
}
