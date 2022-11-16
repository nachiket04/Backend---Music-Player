import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;

    private ArrayList<Song> album;

    Album(String name, String artist){
        this.name = name;
        this.artist = artist;
        album = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public boolean findSong(String name){
        for(Song s: album){
            if(s.getName().equalsIgnoreCase(name)){
                return true;
            }
        }
        return false;
    }

    boolean addSong(String name, double duration){
        if(findSong(name)){
            System.out.println("Song Already Present...");
            return false;
        }
        this.album.add(new Song(name, duration));
        return true;
    }

    boolean addToPlaylist(String name, LinkedList<Song> playList){
        for(Song s: album){
            if(s.getName().equalsIgnoreCase(name)){
                playList.add(s);
                System.out.println("Song " + s.getName() +" added Successfully..!");
                return true;
            }
        }
        return false;
    }

    boolean addToPlayList(int track_no, LinkedList<Song> playList){
        int idx = track_no -1;
        if(idx >=0 && idx < album.size()){
            playList.add(album.get(idx));
            System.out.println("Song " + album.get(idx).getName() +" added Successfully..!");
            return true;
        }
        return false;
    }
}
