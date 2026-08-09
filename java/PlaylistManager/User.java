public class User {

    private int userId;
    private String name;
    private Playlist playlist;

    public User(int userId, String name) {

        this.userId = userId;
        this.name = name;
        this.playlist = new Playlist();

    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

}