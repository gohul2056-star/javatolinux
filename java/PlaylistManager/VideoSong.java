public class VideoSong extends Song{
    public VideoSong(int songId, String title, String artist, double duration){
        super(songId, title, artist, duration);
    }
    @Override 
    public void play(){
        System.out.println("Now Playing Video: " + getTitle() + " by " + getArtist());
    }
}