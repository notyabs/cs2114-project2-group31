
package application;

import java.util.Objects;

/**
 * Represents a song with a title, artist, genre, and duration in seconds.
 */
public class Song
{

    private final String title;
    private final String artist;
    private final String genre;
    private final int lengthSeconds;

    /**
     * Creates a new Song.
     *
     * @param title
     *            the song title
     * @param artist
     *            the artist name
     * @param genre
     *            the song genre
     * @param lengthSeconds
     *            the duration in seconds
     * @throws IllegalArgumentException
     *             for invalid inputs
     */
    public Song(String title, String artist, String genre, int lengthSeconds)
    {

        if (title == null || title.trim().isEmpty())
        {
            throw new IllegalArgumentException("Song title cannot be empty.");
        }

        if (artist == null || artist.trim().isEmpty())
        {
            throw new IllegalArgumentException("Artist cannot be empty.");
        }

        if (lengthSeconds <= 0)
        {
            throw new IllegalArgumentException("Song length must be positive.");
        }

        this.title = title.trim();
        this.artist = artist.trim();
        this.genre = genre == null ? "" : genre.trim();
        this.lengthSeconds = lengthSeconds;
    }


    /**
     * Returns the song title.
     *
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }


    /**
     * Returns the artist.
     *
     * @return the artist name
     */
    public String getArtist()
    {
        return artist;
    }


    /**
     * Returns the genre.
     *
     * @return the genre
     */
    public String getGenre()
    {
        return genre;
    }


    /**
     * Returns the song duration.
     *
     * @return duration in seconds
     */
    public int getLengthSeconds()
    {
        return lengthSeconds;
    }


    /**
     * Compares songs using title and artist.
     *
     * @param other
     *            the object being compared
     * @return true if title and artist match
     */
    @Override
    public boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }

        if (!(other instanceof Song))
        {
            return false;
        }

        Song otherSong = (Song)other;

        return title.equals(otherSong.title) && artist.equals(otherSong.artist);
    }


    /**
     * Generates a hash code using title and artist.
     *
     * @return the hash code
     */
    @Override
    public int hashCode()
    {
        return Objects.hash(title, artist);
    }


    /**
     * Returns formatted song information.
     *
     * @return title, artist, and duration
     */
    @Override
    public String toString() {
        int minutes = lengthSeconds / 60;
        int seconds = lengthSeconds % 60;
        if (seconds < 10) {
            return title + " - " + artist + " ("
                + minutes + ":0" + seconds + ")";
        }
        return title + " - " + artist + " ("
            + minutes + ":" + seconds + ")";
    }
}
