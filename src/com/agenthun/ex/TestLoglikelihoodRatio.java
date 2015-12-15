package com.agenthun.ex;

/**
 * Created by agenthun on 15/12/15.
 */
public class TestLoglikelihoodRatio {
    private double loglikelihoodRatio(int eventBothAAndBTimes, int eventOnlyBTimes,
                                      int eventOnlyATimes, int eventNeitherANorBTimes) {
        double rowEntropy, columnEntropy, matrixEntropy;
        double logLikelihoodRatio;
        rowEntropy = countInformationentropy(eventBothAAndBTimes, eventOnlyBTimes)
                + countInformationentropy(eventOnlyATimes, eventNeitherANorBTimes);
        columnEntropy = countInformationentropy(eventBothAAndBTimes, eventOnlyATimes)
                + countInformationentropy(eventOnlyBTimes, eventNeitherANorBTimes);
        matrixEntropy = countInformationentropy(eventBothAAndBTimes, eventOnlyBTimes, eventOnlyATimes, eventNeitherANorBTimes);
        logLikelihoodRatio = 2 * (matrixEntropy - rowEntropy - columnEntropy);
        return logLikelihoodRatio;
    }

    private double countInformationentropy(int... args) {
        if (args.length == 0) return Double.MAX_VALUE;
        double informationentropy = 0;
        for (int arg : args) {
            if (arg == 0) continue;
            informationentropy += arg * Math.log(arg);
        }
        return -informationentropy;
    }

    public static void main(String[] args) {
        int eventBothAAndBTimes = 20;
        int eventOnlyBTimes = 2;
        int eventOnlyATimes = 9;
        int eventNeitherANorBTimes = 1;
        System.out.print("eventBothAAndBTimes = " + eventBothAAndBTimes);
        System.out.println(", eventOnlyBTimes = " + eventOnlyBTimes);
        System.out.print("eventOnlyATimes = " + eventOnlyATimes);
        System.out.println(", eventNeitherANorBTimes = " + eventNeitherANorBTimes);

        double loglikelihoodRatio = new TestLoglikelihoodRatio().loglikelihoodRatio(eventBothAAndBTimes, eventOnlyBTimes,
                eventOnlyATimes, eventNeitherANorBTimes);
        System.out.println("loglikelihoodRatio = " + loglikelihoodRatio);
    }
}
