package org.example;

import java.util.Random;

import Algorithms.RandomizedDivideAndConquer;
import Algorithms.DeterministicLinearTimeSelection;
import Algorithms.NaiveSorting;


public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        for (int j = 0; j < 50; j++) {
            int[] A = new int[1000000];

            for (int i = 0; i < A.length; i++) {
                A[i] = random.nextInt(1000000);
            }
            RandomizedDivideAndConquer randomizedDivideAndConquer = new RandomizedDivideAndConquer(A);
            DeterministicLinearTimeSelection deterministicLinearTimeSelection = new DeterministicLinearTimeSelection(A);
            NaiveSorting naiveSorting = new NaiveSorting(A);

            System.out.print(randomizedDivideAndConquer.getMedian());
            System.out.print(' ');

            System.out.print(deterministicLinearTimeSelection.getMedian());
            System.out.print(' ');

            System.out.println(naiveSorting.getMedian());
        }
    }
}



