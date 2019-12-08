package arrays;

import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if(n == 0){
            System.out.println(0);
        }else {
            long[] fibArr = new long[n];
            for (int i = 0; i < fibArr.length; i++) {
                if (i < 2) {
                    fibArr[i] = 1;
                } else {
                    fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
                }
            }
            System.out.println(fibArr[fibArr.length - 1]);
        }
    }
}
