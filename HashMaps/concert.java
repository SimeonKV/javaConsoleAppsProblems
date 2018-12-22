package techExam;

import java.util.*;

import static java.lang.Integer.compare;

public class concert {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        Map<String,LinkedHashSet<String>> banndAndMembers = new HashMap<>();
        Map<String,Integer> bandAndTime = new HashMap<>();
        int totalTime = 0;

        String line = scanner.nextLine();
        while(!line.equals("start of concert")){
            String[] input = line.split(";\\s|,\\s");

            if(line.contains("Add")){
                String band = input[1];
                if(!banndAndMembers.containsKey(band)){
                    banndAndMembers.put(band,new LinkedHashSet<>());
                }

                    for (int i = 2; i < input.length ; i++) {
                        banndAndMembers.get(band).add(input[i]);
                }
            }if(line.contains("Play")){
                String band = input[1];
                int hours = Integer.parseInt(input[2]);
                totalTime += hours;
                if(!bandAndTime.containsKey(band)){
                    bandAndTime.put(band,hours);
                }else {

                    bandAndTime.put(band, hours + bandAndTime.get(band));
                }


            }

            line = scanner.nextLine();
        }

        String lastCommand = scanner.nextLine();


        System.out.println(String.format("Total time: %d",totalTime));
       bandAndTime.entrySet().stream().sorted(
               (a,b) ->{
                  return Integer.compare(b.getValue(),a.getValue());
               }
       ).forEach(e -> System.out.println(String.format("%s -> %d",e.getKey(),e.getValue())));

       for(Map.Entry<String,LinkedHashSet<String>> iteratedOver : banndAndMembers.entrySet()){
            if(lastCommand.equals(iteratedOver.getKey())){
                System.out.println(iteratedOver.getKey());
                iteratedOver.getValue().stream().forEach(e -> System.out.println(String.format("=> %s",e)));

            }

        }
    }
}
