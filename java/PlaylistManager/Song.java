public abstract class Song implements Playable {
    
    private int songId;
    private String title;
    private String artist;
    private double duration;
    public Song(int songId, String title, String artist, double duration){
        this.songId = songId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
public int getSongId() {
    return songId;
}
public String getTitle() {
    return title;
}

public String getArtist() {
    return artist;
}

public double getDuration() {
    return duration;
}
public void setSongId(int songId){
    this.songId = songId;
}
public void setTitle(String title) {
    this.title = title;
}

public void setArtist(String artist) {
    this.artist = artist;
}

public void setDuration(double duration) {
    this.duration = duration;
}
public abstract void play();
}