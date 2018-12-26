package array;

import java.util.Scanner;

public class maxSequenceOfEqualElements {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int maxSequence = 0;
        String digit = "";
        int count = 1;

        for (int i = 0; i < array.length - 1 ; i++) {
            String iNumber = array[i];
            String nextNumber = array[i + 1];
            if(iNumber.equals(nextNumber)){
             count++;
         }else{
                count = 1;
            }

         if(maxSequence < count){
             maxSequence = count;
             digit = array[i];
         }

        }

        for (int i = 0; i < maxSequence ; i++) {
            System.out.print(digit + " ");
        }


    }
}
