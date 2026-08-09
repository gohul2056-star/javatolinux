public class AudioSong extends Song{
    public AudioSong(int songId, String title, String artist, double duration){
        super(songId, title, artist, duration);
    }
    @Override 
    public void play(){
        System.out.println("Now Playing Audio: " + getTitle() + " by " + getArtist());
    }
}