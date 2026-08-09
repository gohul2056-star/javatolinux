import java.util.ArrayList;

public class Playlist {

    private ArrayList<Song> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

// Add a song to the playlist

    public void addSong(Song song) {
        songs.add(song);
        System.out.println("Song added successfully!");
    }

// Display all songs in the playlist

    public void displaySongs() {

        if (songs.isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        }

        System.out.println("\n===== PLAYLIST =====");

        for (Song song : songs) {

            System.out.println(
                "ID: " + song.getSongId() +
                ", Title: " + song.getTitle() +
                ", Artist: " + song.getArtist() +
                ", Duration: " + song.getDuration() + " seconds"
            );
        }
    }

// Remove a song from the playlist by its ID

    public void removeSong(int songId){

        for (int i = 0; i < songs.size(); i++){
            Song song = songs.get(i);
            if(song.getSongId() == songId){
                songs.remove(i);
                System.out.println("Song removed successfully!");
                return;
            }
        }
        System.out.println("Song not found!");

    }

// Search for a song

    public Song searchSong(int songId) throws SongNotFoundException {

    for (Song song : songs) {

        if (song.getSongId() == songId) {
            return song;
        }
    }

    throw new SongNotFoundException(
        "Song with ID " + songId + " was not found."
    );
}



    public Song searchSong(String title) {

    for (Song song : songs) {

        if (song.getTitle().equalsIgnoreCase(title)) {
            return song;
        }
    }

    return null;
    }

    public void updateSong(int songId, String newTitle, String newArtist, double newDuration) {

    try {

        Song song = searchSong(songId);

        song.setTitle(newTitle);
        song.setArtist(newArtist);
        song.setDuration(newDuration);

        System.out.println("Song updated successfully!");

    } catch (SongNotFoundException e) {

        System.out.println(e.getMessage());

        }

    } 

// Play a song by its ID

    public void playSong(int songId) {

    try {

        Song song = searchSong(songId);

        song.play();

    } catch (SongNotFoundException e) {

        System.out.println(e.getMessage());

    }
}

}