```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        User user = new User(1, "Gohul");
        Playlist playlist = user.getPlaylist();

        System.out.println("Welcome, " + user.getName());

        while (true) {

            System.out.println("\n===== PLAYLIST MANAGER =====");
            System.out.println("1. Add Song");
            System.out.println("2. Display Playlist");
            System.out.println("3. Search Song");
            System.out.println("4. Update Song");
            System.out.println("5. Remove Song");
            System.out.println("6. Play Song");
            System.out.println("7. Exit");

            int choice;

            try {

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

            } catch (InputMismatchException e) {

                System.out.println("Please enter a number!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {

                // =========================
                // 1. ADD SONG
                // =========================
                case 1:

                    System.out.print("Enter Song ID: ");
                    int songId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter Song Title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter Artist: ");
                    String artist = scanner.nextLine();

                    System.out.print("Enter Duration (seconds): ");
                    double duration = scanner.nextDouble();

                    System.out.print(
                        "Enter Song Type (1 = Audio, 2 = Video): "
                    );
                    int type = scanner.nextInt();

                    Song song;

                    if (type == 1) {

                        song = new AudioSong(
                            songId,
                            title,
                            artist,
                            duration
                        );

                    } else if (type == 2) {

                        song = new VideoSong(
                            songId,
                            title,
                            artist,
                            duration
                        );

                    } else {

                        System.out.println("Invalid song type!");
                        break;
                    }

                    playlist.addSong(song);

                    break;

                // =========================
                // 2. DISPLAY PLAYLIST
                // =========================
                case 2:

                    playlist.displaySongs();

                    break;

                // =========================
                // 3. SEARCH SONG
                // =========================
                case 3:

                    System.out.println("\n===== SEARCH SONG =====");
                    System.out.println("1. Search by ID");
                    System.out.println("2. Search by Title");

                    System.out.print("Enter your choice: ");
                    int searchChoice = scanner.nextInt();

                    scanner.nextLine();

                    if (searchChoice == 1) {

                        System.out.print("Enter Song ID: ");
                        int searchId = scanner.nextInt();

                        try {

                            Song foundSong = playlist.searchSong(searchId);

                            System.out.println("\nSong Found!");
                            System.out.println(
                                "ID: " + foundSong.getSongId()
                            );
                            System.out.println(
                                "Title: " + foundSong.getTitle()
                            );
                            System.out.println(
                                "Artist: " + foundSong.getArtist()
                            );
                            System.out.println(
                                "Duration: "
                                + foundSong.getDuration()
                                + " seconds"
                            );

                        } catch (SongNotFoundException e) {

                            System.out.println(e.getMessage());
                        }

                    } else if (searchChoice == 2) {

                        System.out.print("Enter Song Title: ");
                        String searchTitle = scanner.nextLine();

                        Song foundSong = playlist.searchSong(searchTitle);

                        if (foundSong != null) {

                            System.out.println("\nSong Found!");
                            System.out.println(
                                "ID: " + foundSong.getSongId()
                            );
                            System.out.println(
                                "Title: " + foundSong.getTitle()
                            );
                            System.out.println(
                                "Artist: " + foundSong.getArtist()
                            );
                            System.out.println(
                                "Duration: "
                                + foundSong.getDuration()
                                + " seconds"
                            );

                        } else {

                            System.out.println("Song not found!");
                        }

                    } else {

                        System.out.println("Invalid search choice!");
                    }

                    break;

                // =========================
                // 4. UPDATE SONG
                // =========================
                case 4:

                    System.out.println("\n===== UPDATE SONG =====");

                    System.out.print("Enter Song ID to update: ");
                    int updateId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter New Artist: ");
                    String newArtist = scanner.nextLine();

                    System.out.print("Enter New Duration (seconds): ");
                    double newDuration = scanner.nextDouble();

                    playlist.updateSong(
                        updateId,
                        newTitle,
                        newArtist,
                        newDuration
                    );

                    break;

                // =========================
                // 5. REMOVE SONG
                // =========================
                case 5:

                    System.out.println("\n===== REMOVE SONG =====");

                    System.out.print("Enter Song ID to remove: ");
                    int removeId = scanner.nextInt();

                    playlist.removeSong(removeId);

                    break;

                // =========================
                // 6. PLAY SONG
                // =========================
                case 6:

                    System.out.print("Enter Song ID to play: ");
                    int playId = scanner.nextInt();

                    playlist.playSong(playId);

                    break;

                // =========================
                // 7. EXIT
                // =========================
                case 7:

                    System.out.println(
                        "Thank you for using Playlist Manager!"
                    );

                    scanner.close();
                    return;

                // =========================
                // INVALID CHOICE
                // =========================
                default:

                    System.out.println("Invalid choice!");
            }
        }
    }
}
```
