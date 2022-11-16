import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Main {

    static LinkedList <Song> playList;
    static ListIterator <Song> itr;
    static boolean forward;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Song s1 = new Song("Kesariya", 4.20);
        Album ArjitSingh = new Album("Top Arijit", "Arijit Singh");
        ArjitSingh.addSong("Kesariya", 4.20);
        ArjitSingh.findSong("Kesariya");
        ArjitSingh.addSong("Kalank", 3.30);
        ArjitSingh.addSong("Tera Fitoor", 4.20);
        Album NehaKakkar = new Album("Best of Neha Kakkar", "Neha Kakkar");
        NehaKakkar.addSong("Kata laga", 3.15);
        playList = new LinkedList<>();
        itr = playList.listIterator();
        ArjitSingh.addToPlaylist("Kesariya", playList);
        ArjitSingh.addToPlaylist("Tera Fitoor", playList);
        ArjitSingh.addToPlayList(2, playList);
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
                    break;
                case 2:
                    printPlayList(playList);
                    itr = playList.listIterator();
                    break;
                case 3:
                    itr = playList.listIterator();
                    play(playList);
                    break;
                case 4:
                    playNext(playList);
                    break;
                case 5:
                    playPrev(playList);
                    break;
                case 6:
                    repeat(playList);
                    break;
                case 7:
                    delete(playList);
                    break;
            }
        }

    }

    public static void printPlayList(LinkedList <Song> playList){
        ListIterator <Song> itr = playList.listIterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    public static void showMenu(){
        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Show the list of all Songs in the playlist");
        System.out.println("3. Start Playing song");
        System.out.println("4. Play next song");
        System.out.println("5. Play previous Song");
        System.out.println("6. Repeat the song");
        System.out.println("7. Delete the song");

    }

    public static boolean play(LinkedList <Song> playList){
        if(!itr.hasNext()){
            System.out.println("PlayList is Empty..!");
            return false;
        }
        System.out.println("Now playing " + itr.next());
        forward = true;
        return true;
    }

    public static boolean playNext(LinkedList <Song> playList){
        if(!forward){
            if(itr.hasNext())
            itr.next();
        }
        if(!itr.hasNext()){
            System.out.println("End of the PlayList.." + "\n" + "Nothing to play.. :(");
            return false;
        }
        System.out.println("Now playing " + itr.next());
        forward = true;
        return true;
    }

    public static boolean playPrev(LinkedList <Song> playList){
        if(forward){
            if(itr.hasPrevious())
            itr.previous();
        }
        if(!itr.hasPrevious()){
            System.out.println("End of the PlayList.." + "\n" + "Nothing to play.. :(");
            return false;
        }
        System.out.println("Now playing " + itr.previous());
        forward = false;
        return true;
    }

    public static boolean repeat(LinkedList <Song> playList){
        if(forward){
            itr.previous();
            System.out.println("playing " + itr.next() + " Again");
        }
        else {
            itr.next();
            System.out.println("playing " + itr.previous() + " Again");
        }
        return true;
    }

    public static boolean delete(LinkedList<Song> playList){
        itr.remove();
        System.out.println("Song has been removed");
        return true;
    }
}

