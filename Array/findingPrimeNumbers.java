package array;

import java.util.Scanner;

public class findingPrimeNumbers {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        String primeNumbers = "";

        for (int i = 1; i <= number ; i++) {
            int count = 0;

            for (int j = 1; j <= i ; j++) {
                if (i % j == 0) {
                    count++;
                }
            }

            if(count <= 2 && i != 1){
                primeNumbers += i + " ";
            }
        }

        String[] arrayOfPrimeNumbers = primeNumbers.split(" ");

        for(String output : arrayOfPrimeNumbers){
            System.out.print(output + " ");
        }

    }
}
