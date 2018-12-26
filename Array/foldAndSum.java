package array;

import java.util.Arrays;
import java.util.Scanner;

public class foldAndSum {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        String[] firstArray = new String[array.length/2];
        String[] secondArray = new String[array.length/2];
        int[] sumArray = new int[firstArray.length];

        for (int i = 0; i < firstArray.length ; i++) {
            firstArray[i] = array[i];
        }

        for (int i = 0; i < secondArray.length ; i++) {
            String a =  array[array.length - 1 - i];
            secondArray[i] = array[array.length - 1 - i];
        }


        for (int i = 0; i < firstArray.length / 2 ; i++) {
            int a = Integer.parseInt(firstArray[firstArray.length / 2 - 1 - i]);
            int b = Integer.parseInt(firstArray[firstArray.length/2 + i]);
            sumArray[i] = a + b;

        }

        for (int i = 0; i < secondArray.length/2 ; i++) {
           int a = Integer.parseInt(secondArray[secondArray.length- 1 - i]);
           int b = Integer.parseInt(secondArray[i]);
           sumArray[secondArray.length/2 + i] = a + b;
        }

        for(int sum : sumArray){
            System.out.print(sum + " ");
        }



    }
}
