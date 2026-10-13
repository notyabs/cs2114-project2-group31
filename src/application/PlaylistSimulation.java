package application;

import java.util.Scanner;

/**
 * An interactive driver class to simulate the Playlist and Song functionality
 * using console input.
 */
public class PlaylistSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist myPlaylist = new Playlist("My Interactive Playlist");

        // Pre-populate with a few songs for immediate testing
        myPlaylist.addSong(new Song("Bohemian Rhapsody", "Queen", "Rock", 354));
        myPlaylist.addSong(new Song("Nights", "Frank Ocean", "R&B", 307));
        myPlaylist.addSong(new Song("Hotel California", "Eagles", "Rock", 390));

        boolean running = true;

        System.out.println("Welcome to the Playlist Simulation!");

        while (running) {
            displayPlaylist(myPlaylist);

            System.out.println("\nSelect an action:");
            System.out.println("1. Add a song");
            System.out.println("2. Remove a song (by position)");
            System.out.println("3. Move a song (change its position)");
            System.out.println("4. Swap two songs");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1":
                        System.out.print("Enter song title: ");
                        String title = scanner.nextLine().trim();
                        System.out.print("Enter artist: ");
                        String artist = scanner.nextLine().trim();
                        System.out.print("Enter genre: ");
                        String genre = scanner.nextLine().trim();
                        System.out.print("Enter length in seconds: ");
                        int length = Integer.parseInt(scanner.nextLine().trim());
                        
                        myPlaylist.addSong(new Song(title, artist, genre, length));
                        System.out.println(">> Added \"" + title + "\" to the playlist.");
                        break;

                    case "2":
                        System.out.print("Enter the position of the song to remove: ");
                        int removePos = Integer.parseInt(scanner.nextLine().trim());
                        
                        // Convert 1-based user input to 0-based index
                        Song songToRemove = myPlaylist.getSong(removePos - 1);
                        myPlaylist.removeSong(songToRemove);
                        System.out.println(">> Removed \"" + songToRemove.getTitle() + "\".");
                        break;

                    case "3":
                        System.out.print("Enter the current position of the song: ");
                        int currentPos = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter the new position to move it to: ");
                        int newPos = Integer.parseInt(scanner.nextLine().trim());
                        
                        myPlaylist.moveSong(currentPos - 1, newPos - 1);
                        System.out.println(">> Moved song from position " + currentPos + " to " + newPos + ".");
                        break;

                    case "4":
                        System.out.print("Enter the position of the first song: ");
                        int pos1 = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter the position of the second song: ");
                        int pos2 = Integer.parseInt(scanner.nextLine().trim());
                        
                        myPlaylist.swapSongs(pos1 - 1, pos2 - 1);
                        System.out.println(">> Swapped songs at positions " + pos1 + " and " + pos2 + ".");
                        break;

                    case "5":
                        running = false;
                        System.out.println("Exiting simulation. Goodbye!");
                        break;

                    default:
                        System.out.println(">> Invalid choice. Please enter a number from 1 to 5.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(">> Error: Invalid position. Please enter a position that currently exists in the playlist.");
            } catch (IllegalArgumentException e) {
                System.out.println(">> Error: Invalid input format. Please ensure lengths and positions are valid numbers.");
            }
        }
        
        scanner.close();
    }

    /**
     * Helper method to print the current state of the playlist.
     */
    private static void displayPlaylist(Playlist playlist) {
        System.out.println("\n-------------------------------------------------");
        System.out.println("PLAYLIST: " + playlist.getName());
        System.out.println("Total Songs: " + playlist.getSongCount() + " | Total Length: " + playlist.getTotalLength() + " seconds");
        System.out.println("-------------------------------------------------");
        
        if (playlist.isEmpty()) {
            System.out.println("  (Playlist is empty)");
        } else {
            for (int i = 0; i < playlist.getSongCount(); i++) {
                Song s = playlist.getSong(i);
                // Displays as [1] Title - Artist (Length)
                System.out.println("  [" + (i + 1) + "] " + s.getTitle() + " - " + s.getArtist() + " (" + s.getLengthSeconds() + "s)");
            }
        }
        System.out.println("-------------------------------------------------");
    }
}