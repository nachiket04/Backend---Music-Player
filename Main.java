import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Song s1 = new Song("Kesariya", 4.20);
        Album ArjitSingh = new Album("Top Arijit", "Arijit Singh");
        ArjitSingh.addSong("Kesariya", 4.20);
        ArjitSingh.findSong("Kesariya");
        Album NehaKakkar = new Album("Best of Neha Kakkar", "Neha Kakkar");
        NehaKakkar.addSong("Kata laga", 3.15);
        LinkedList <Song> playList = new LinkedList<>();
        ArjitSingh.addToPlaylist("Kesariya", playList);
        NehaKakkar.addToPlaylist("kata Laga", playList);
//        printPlayList(playList);
        showMenu();
        while(true){
            int op1 = sc.nextInt();
            switch(op1){
                case 0:
                    System.out.println("Thank you for Using our Music Player");
                    return;
                case 1:
                    showMenu();
                case 2:
                    printPlayList(playList);
            }
        }

    }

    public static void printPlayList(LinkedList <Song> playList){
        ListIterator <Song> itr = playList.listIterator();
        while(itr.hasNext()){
            System.out.println("Now Playing " + itr.next());
        }
    }

    public static void showMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all Songs in the playlist");
        System.out.println("3. Play next song");
        System.out.println("4. Play previous Song");
        System.out.println("5. Repeat the song");
        System.out.println("6. Delete the song");

    }
}

