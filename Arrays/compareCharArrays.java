package array;

import java.util.Scanner;

public class compareCharArrays {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        boolean isTrue = true;



        int smallerLenght = Math.min(firstArr.length,secondArr.length);

        for (int i = 0; i < smallerLenght; i++) {
            String firstArrChar = firstArr[i];
            String secondArrChar = secondArr[i];
           if(firstArrChar.compareTo(secondArrChar) <= 0){
               if(firstArr.length > smallerLenght){
                   isTrue = false;
               }

           }else{
               isTrue = false;
           }

        }

        if(isTrue){
            printFirst(firstArr);
            System.out.println();
            printSecond(secondArr);
            System.out.println();
        }else{
            printSecond(secondArr);
            System.out.println();
            printSecond(firstArr);
            System.out.println();
        }


    }

    private static void printSecond(String[] secondArr) {
        for(String second : secondArr){
            System.out.print(second);
        }
    }

    private static void printFirst(String[] firstArr) {
        for(String first : firstArr){
            System.out.print(first);
        }
    }
}
