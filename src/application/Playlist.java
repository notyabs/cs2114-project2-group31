package application;

/**
 * Represents a playlist containing a chain of songs.
 */
public class Playlist {
    private String name;
    private LinkedChain<Song> songs;

    /**
     * Creates a new, empty Playlist.
     * 
     * @param name The name of the playlist.
     * @throws IllegalArgumentException if the name is null or empty.
     */
    public Playlist(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Playlist name cannot be empty.");
        }
        this.name = name;
        this.songs = new LinkedChain<>();
    }

    public String getName() {
        return name;
    }

    /**
     * Adds a song to the end of the playlist.
     * 
     * @param song The song to add.
     * @return true if added successfully.
     * @throws IllegalArgumentException if the song is null.
     */
    public boolean addSong(Song song) {
        if (song == null) {
            throw new IllegalArgumentException("Cannot add a null song to the playlist.");
        }
        return songs.addToEnd(song);
    }

    public boolean removeSong(Song song) {
        return songs.remove(song);
    }

    public boolean containsSong(Song song) {
        return songs.contains(song);
    }

    public Song getSong(int index) {
        return songs.get(index);
    }

    public int getSongCount() {
        return songs.size();
    }

    /**
     * Calculates the total length of the playlist in seconds.
     * 
     * @return The total runtime of all songs combined.
     */
    public int getTotalLength() {
        int size = songs.size();
        if (size == 0) {
            return 0;
        }

        // LinkedChain.toArray requires an initialized array of the correct type and size
        Song[] songArray = songs.toArray(new Song[size]);
        int totalSeconds = 0;
        
        for (Song s : songArray) {
            totalSeconds += s.getLengthSeconds();
        }
        
        return totalSeconds;
    }

    public boolean isEmpty() {
        return songs.isEmpty();
    }

    public void clear() {
        songs.clear();
    }

    /**
     * STRETCH GOAL: Edits the order of the playlist by moving a song from one position to another,
     * shifting the remaining songs up or down accordingly.
     * 
     * @param currentIndex The current zero-based position of the song.
     * @param newIndex The new zero-based position to move the song to.
     * @throws IndexOutOfBoundsException if either index is invalid.
     */
    public void moveSong(int currentIndex, int newIndex) {
        int size = songs.size();
        if (currentIndex < 0 || currentIndex >= size || newIndex < 0 || newIndex >= size) {
            throw new IndexOutOfBoundsException("Invalid position within the playlist.");
        }
        if (currentIndex == newIndex) {
            return; 
        }

        Song[] songArray = songs.toArray(new Song[size]);
        Song songToMove = songArray[currentIndex];

        // Shift elements to make room for the insertion
        if (currentIndex < newIndex) {
            for (int i = currentIndex; i < newIndex; i++) {
                songArray[i] = songArray[i + 1];
            }
        } else {
            for (int i = currentIndex; i > newIndex; i--) {
                songArray[i] = songArray[i - 1];
            }
        }
        songArray[newIndex] = songToMove;

        // Rebuild the LinkedChain in the new order
        songs.clear();
        for (Song s : songArray) {
            songs.addToEnd(s);
        }
    }

    /**
     * STRETCH GOAL: Edits the order of the playlist by directly swapping two songs 
     * at the specified positions.
     * 
     * @param index1 The zero-based position of the first song.
     * @param index2 The zero-based position of the second song.
     * @throws IndexOutOfBoundsException if either index is invalid.
     */
    public void swapSongs(int index1, int index2) {
        int size = songs.size();
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException("Invalid position within the playlist.");
        }
        if (index1 == index2) {
            return;
        }

        Song[] songArray = songs.toArray(new Song[size]);
        
        // Swap
        Song temp = songArray[index1];
        songArray[index1] = songArray[index2];
        songArray[index2] = temp;

        // Rebuild the LinkedChain in the new order
        songs.clear();
        for (Song s : songArray) {
            songs.addToEnd(s);
        }
    }
}