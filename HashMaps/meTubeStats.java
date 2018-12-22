package assosiativeArrays;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class meTubeStats {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        HashMap<String,Integer> artistByViews = new HashMap<>();
        HashMap<String,Integer> artistByLikes = new HashMap<>();


        while(!text.equals("stats time")){

            if(text.contains("like:") && text.startsWith("l")){
              String[] artistAndLikes = text.split("\\:");
              if(!artistByLikes.containsKey(artistAndLikes[1])){
                  artistByLikes.put(artistAndLikes[1],1);
              }else{
                  artistByLikes.put(artistAndLikes[1],artistByLikes.get(artistAndLikes[1]) + 1);
              }
            }else if(text.contains("dislike:" ) && !text.startsWith("l")){
                String[] artistAndLikes = text.split("\\:");
                String dislikes = artistAndLikes[0];
                String artist = artistAndLikes[1];
                if(!artistByLikes.containsKey(artist)){
                    artistByLikes.put(artist, - 1);
                }else{
                    artistByLikes.put(artist,artistByLikes.get(artist) - 1);
                }
            } else {
                String[] views = text.split("-");
                String artist = views[0];
                int viewsCount = Integer.parseInt(views[1]);
                if(!artistByViews.containsKey(artist)){
                    artistByViews.put(artist,viewsCount);
                }else{
                    artistByViews.put(artist,artistByViews.get(artist) + viewsCount);
                }

            }

            text = scanner.nextLine();
        }

        String cmd = scanner.nextLine();

        if(cmd.equals("by likes")){
            artistByLikes.entrySet().stream().sorted((a,b) -> Integer.compare(b.getValue(),a.getValue())).forEach(
                    e -> {
                        if(e.getValue() != null) {
                            System.out.println(String.format("%s - %d views - %d likes", e.getKey(), artistByViews.get(e.getKey()), e.getValue()));
                        }else{
                            System.out.println(String.format("%s - %d views - 0 likes", e.getKey(), artistByViews.get(e.getKey())));
                        }
                    });
        }else if(cmd.equals("by views")){
            artistByViews.entrySet().stream().sorted((a,b) -> Integer.compare(b.getValue(),a.getValue()))
                    .forEach( e -> {
                        if (artistByLikes.get(e.getKey()) != null) {
                            System.out.println(String.format("%s - %d views - %d likes", e.getKey(), e.getValue(), artistByLikes.get(e.getKey())));
                        }else{
                            System.out.println(String.format("%s - %d views - 0 likes", e.getKey(), e.getValue()));
                        }
                    } );
        }

    }
}
