package playlistManager;

public class Song {
    private String songTitle;
    private String artist;
    private double duration;

    public Song(String songTitle, String artist, double duration){
        this.songTitle = songTitle;
        this.artist = artist;
        this.duration = duration;
    }

    public String getSongTitle(){
        return this.songTitle;
    }

    public String getArtist(){
        return this.artist;
    }

    public double getDuration(){
        return this.duration;
    }
}
