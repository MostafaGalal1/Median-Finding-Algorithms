package org.example;

import java.util.Random;

import Algorithms.RandomizedDivideAndConquer;
import Algorithms.DeterministicLinearTimeSelection;
import Algorithms.NaiveSorting;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        for (int j = 0; j < 10; j++) {
            Integer[] A = new Integer[1000000];

            for (int i = 0; i < A.length; i++) {
                A[i] = random.nextInt(1000000);
            }
            RandomizedDivideAndConquer<Integer> randomizedDivideAndConquer = new RandomizedDivideAndConquer<>(A);
            DeterministicLinearTimeSelection<Integer> deterministicLinearTimeSelection = new DeterministicLinearTimeSelection<>(A);
            NaiveSorting<Integer> naiveSorting = new NaiveSorting<>(A);

            System.out.print(randomizedDivideAndConquer.getMedian());
            System.out.print(' ');

            System.out.print(deterministicLinearTimeSelection.getMedian());
            System.out.print(' ');

            System.out.println(naiveSorting.getMedian());
        }
    }
}



