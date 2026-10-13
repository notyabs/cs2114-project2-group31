package application;

/**
 * Represents a song with a title, artist, genre, and duration in seconds.
 */

public class Song {

    private final String title;
    private final String artist;
    private final String genre;
    private final int lengthSeconds;


/**
     * Creates a song.
     *
     * @param title the song title; must not be null or blank
     * @param artist the artist name; must not be null or blank
     * @param genre the genre; null is stored as an empty string
     * @param lengthSeconds the duration in whole seconds; must be positive
     * @throws IllegalArgumentException if title or artist is null or blank,
     *     or lengthSeconds is not positive
     */
    public Song(String title, String artist, String genre, int lengthSeconds) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.lengthSeconds = lengthSeconds;

        if (title == null) {
            throw new IllegalArgumentException("Song title cannot be empty.");
        }
        if (artist == null) {
            throw new IllegalArgumentException("Artist cannot be empty.");
        }
        if (lengthSeconds <= 0) {
            throw new IllegalArgumentException("Song length must be positive.");
        }
    }

    /**
     * @return title the title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return artist the artist of the song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * @return genre the genre of the song
     */
    public String getGenre() {
        return genre;
    }

    /** 
     * @return the duration in whole seconds 
    */
    public int getLengthSeconds() {
        return lengthSeconds;
    }

    /** 
     * @return condensed song information with duration as minutes:seconds 
    */
    @Override
    public String toString() {
        int minutes = lengthSeconds / 60;
        int seconds = lengthSeconds % 60;
        return title + " - " + artist + " (" + minutes + ":"
            + (seconds < 10 ? "0" : "") + seconds + ")";
    }

}
