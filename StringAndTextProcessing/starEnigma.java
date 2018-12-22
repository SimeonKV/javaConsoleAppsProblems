package stringAndTextProcessing;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class starEnigma {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numberOfLines = Integer.parseInt(scanner.nextLine());


        List<String> decryptedLine = new ArrayList<>();
        while(numberOfLines > 0){
            String line = scanner.nextLine();
            int count = 0;
            String decripting = "";
            for (int i = 0; i < line.length(); i++) {
                char symbol = Character.toLowerCase(line.charAt(i));
                if (symbol == 's' || symbol == 't'
                        || symbol == 'a' || symbol == 'r') {
                    count++;
                }
            }
                for (int j = 0; j < line.length() ; j++) {
                    int singleChar = (int)line.charAt(j) - count;
                    decripting += (char)singleChar;
                }
                decryptedLine.add(decripting);

            numberOfLines--;

        }

        String regEx = "[^@\\-!:>]*\\@(?<name>[A-Za-z]+)[^@\\-!:>]*\\:(?<population>\\d+)[^@\\-!:>]*\\!(?<type>[AD])\\![^@\\-!:>]*\\-\\>(?<scount>\\d+)[^@\\-!:>]*";


        int countAttack = 0;
        int countDestr = 0;
        TreeSet<String> namesAttack = new TreeSet<>();
        TreeSet<String> namesDestroyd = new TreeSet<>();
        for(String output : decryptedLine){
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(output);
            while (matcher.find()){
                if(matcher.group("type").equals("A")){
                    countAttack++;
                    namesAttack.add(matcher.group("name"));
                }else if(matcher.group("type").equals("D")){
                    countDestr++;
                    namesDestroyd.add(matcher.group("name"));
                }

            }
        }

        System.out.println(String.format("Attacked planets: %d",countAttack));;
        namesAttack.forEach(e -> System.out.println("-> " + e));
        System.out.println(String.format("Destroyed planets: %d",countDestr));
        namesDestroyd.forEach(e -> System.out.println("-> " + e));


    }
}
