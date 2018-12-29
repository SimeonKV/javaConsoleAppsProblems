package array;

import java.util.Scanner;

public class manupulateArray {
    public static void main(String[] args){
        //Console app that has three commands - reverse, distinct and replace
        //the reverse command - rverses the array
        // the distinct command - deletes the non-unique elements in the array
        //the replace command - replaces the element with a new one on the chosen index by the user.

        Scanner scanner = new Scanner(System.in);
        String[] arrayOfWords = scanner.nextLine().split(" ");
        int numberOfCommands =  Integer.parseInt(scanner.nextLine());

        while(numberOfCommands > 0){
            String[] cmds = scanner.nextLine().split(" ");

            if(cmds[0].equals("Reverse")){
                arrayOfWords = reverseArray(arrayOfWords);
            }else if(cmds[0].equals("Distinct")){
                arrayOfWords = deleteNonUniqueElements(arrayOfWords);
            }else if(cmds[0].equals("Replace")){
                int index = Integer.parseInt(cmds[1]);
                String replacementWord = cmds[2];
                arrayOfWords = replaceWithNewWords(arrayOfWords,index,replacementWord);
            }

            numberOfCommands --;
        }

        for (int i = 0; i < arrayOfWords.length ; i++) {
            if(i == 0){
                System.out.print(arrayOfWords[i]);
            }else{
                System.out.print(", " + arrayOfWords[i]);
            }
        }


    }

    private static String[] replaceWithNewWords(String[] arrayOfWords, int index, String replacementWord) {

        for (int i = 0; i < arrayOfWords.length ; i++) {
            if(i == index){
                arrayOfWords[i] = replacementWord;
            }
        }

        return arrayOfWords;
    }

    private static String[] deleteNonUniqueElements(String[] arrayOfWords) {
      int count = 0;
        for (int i = 0; i < arrayOfWords.length ; i++) {
            String iSymbol = arrayOfWords[i];
            for (int j = i + 1; j < arrayOfWords.length; j++) {
                String jSymbol = arrayOfWords[j];
                if (iSymbol.equals(jSymbol) && !jSymbol.equals("-1")) {
                    count++;
                    arrayOfWords[j] = "-1";
                }
            }
        }

            String[] arrayOfUniqueElements = new String[arrayOfWords.length - count];
            int addingElements = 0;
            for (String output : arrayOfWords){
                if(!output.equals("-1")){
                    arrayOfUniqueElements[addingElements++] = output;
                }
            }


        return arrayOfUniqueElements ;
    }

    private static String[] reverseArray(String[] arrayOfWords) {
        String[] reversedArray = new String[arrayOfWords.length];
        for (int i = arrayOfWords.length - 1; i >= 0  ; i--) {
            reversedArray[i] = arrayOfWords[arrayOfWords.length - 1 - i];
        }

        return reversedArray;
    }
}
