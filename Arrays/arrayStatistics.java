package array;

import java.util.Arrays;
import java.util.Scanner;

public class arrStats {
    public static void main(String[] args) {
        //Algorithm for finding the max/min value and the average and total sum of an array of integer number.
        //Алгоритъм за намиране на макс/мин стойност и на средната и общата стойност на елементите на масив от интежери.

        Scanner scanner = new Scanner(System.in);
        int[] arrayOfIntNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int minNumber = findTheMinNumber(arrayOfIntNumbers);
        int maxNumber = findTheMaxNumber(arrayOfIntNumbers);
        int totalSum = sum(arrayOfIntNumbers);
        double averageValue = (totalSum * 1.0) / arrayOfIntNumbers.length;
        System.out.println(String.format("Min = %d%nMax = %d%nSum = %d%nAverage = %.1f%n",
                minNumber,maxNumber,totalSum,averageValue));


    }

    private static int sum(int[] arrayOfIntNumbers) {
        int totalSum = 0;

        for (int i = 0; i < arrayOfIntNumbers.length ; i++) {
            totalSum += arrayOfIntNumbers[i];
        }

        return totalSum;
    }

    private static int findTheMaxNumber(int[] arrayOfIntNumbers) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arrayOfIntNumbers.length; i++) {
            if (maxValue < arrayOfIntNumbers[i]) {
                maxValue = arrayOfIntNumbers[i];
            }
        }

        return maxValue;
    }

    private static int findTheMinNumber(int[] arrayOfIntNumbers) {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < arrayOfIntNumbers.length; i++) {
            if (minValue > arrayOfIntNumbers[i]) {
                minValue = arrayOfIntNumbers[i];
            }
        }

        return minValue;
    }
}
