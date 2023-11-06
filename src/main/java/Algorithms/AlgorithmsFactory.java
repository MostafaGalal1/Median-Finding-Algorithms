package Algorithms;

public class AlgorithmsFactory <T extends Comparable<T>> {

    public MedianFindingAlgorithm getAlgorithm (Algorithms algorithm, int[] A){
        return switch (algorithm) {
            case Randomized -> new RandomizedDivideAndConquer(A);
            case Deterministic -> new DeterministicLinearTimeSelection(A);
            case Naive -> new NaiveSorting(A);
        };
    }
}
