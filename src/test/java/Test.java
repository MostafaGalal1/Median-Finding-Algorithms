import Algorithms.Algorithms;
import Algorithms.AlgorithmsFactory;
import Algorithms.MedianFindingAlgorithm;

import java.util.Random;


public class Test {
    private Random random;
    private AlgorithmsFactory algorithmsFactory;

    public int[] generateArray(int size){
        int[] A = new int[size];
        for (int i = 0; i < size; i++){
            int RANGE_MAX = (int) 1e9;
            int RANGE_MIN = (int) -1e9;
            int val = random.nextInt(RANGE_MAX - RANGE_MIN + 1) + RANGE_MIN;
            A[i] = val;
        }

        return A;
    }

    public double algorithmTest(Algorithms algoType, int[] A){
        MedianFindingAlgorithm algorithm = algorithmsFactory.getAlgorithm(algoType, A);
        double averageRunningTime = 0;

        int runsCount = 10;
        for (int i = 0; i < runsCount; i++) {
            long startTime, finishTime, runningTime;
            startTime = System.nanoTime();
            algorithm.getMedian();
            finishTime = System.nanoTime();
            runningTime = finishTime - startTime;
            averageRunningTime += runningTime;
        }

        averageRunningTime /= runsCount * 1000000;
        return averageRunningTime;
    }

    public void printRunningTime(String algorithm, long time){
        System.out.println("Average running time for " + algorithm + " algorithm is: " + time + " ms.");
    }

    public void printHeader(){
        System.out.printf("%-15s %-15s %-15s%n", "Randomized", "Deterministic", "Naive");
    }

    public void printResult(double randomized, double deterministic, double naive){
        System.out.printf("%-15s %-15s %-15s%n", randomized, deterministic, naive);
    }

    public void driver() {
        random = new Random();
        algorithmsFactory = new AlgorithmsFactory();
        printHeader();
        for (int i = 2; i < 8; i++) {
            int[] A = generateArray((int)Math.pow(10, 7));
            double randomized = algorithmTest(Algorithms.Randomized, A);
            double deterministic = algorithmTest(Algorithms.Deterministic, A);
            double naive = algorithmTest(Algorithms.Naive, A);
            printResult(randomized, deterministic, naive);
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.driver();
    }
}
