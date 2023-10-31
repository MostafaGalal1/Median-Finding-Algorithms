package Algorithms;

public class AlgorithmsFactory <T extends Comparable<T>> {

    public MedianFindingAlgorithm<T> getAlgorithm (Algorithms algorithm, T[] A){
        return switch (algorithm) {
            case Randomized -> new RandomizedDivideAndConquer<>(A);
            case Deterministic -> new DeterministicLinearTimeSelection<>(A);
            case Naive -> new NaiveSorting<>(A);
        };
    }
}
