
package application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the Song class.
 */
public class SongTest {

    private Song song;

    /**
     * Creates a song before each test.
     */
    @BeforeEach
    public void setUp() {
        song = new Song(" Title ", " Artist ", " Pop ", 185);
    }

    /**
     * Tests the constructor.
     */
    @Test
    public void constructorTest() {
        assertEquals("Title", song.getTitle());
        assertEquals("Artist", song.getArtist());
        assertEquals("Pop", song.getGenre());
        assertEquals(185, song.getLengthSeconds());
    }

    /**
     * Tests invalid constructor inputs.
     */
    @Test
    public void invalidConstructorTest() {
        assertThrows(IllegalArgumentException.class,
            () -> new Song(null, "Artist", "Pop", 185));

        assertThrows(IllegalArgumentException.class,
            () -> new Song("", "Artist", "Pop", 185));

        assertThrows(IllegalArgumentException.class,
            () -> new Song("   ", "Artist", "Pop", 185));

        assertThrows(IllegalArgumentException.class,
            () -> new Song("Title", null, "Pop", 185));

        assertThrows(IllegalArgumentException.class,
            () -> new Song("Title", "", "Pop", 185));

        assertThrows(IllegalArgumentException.class,
            () -> new Song("Title", "   ", "Pop", 185));

        assertThrows(IllegalArgumentException.class,
            () -> new Song("Title", "Artist", "Pop", 0));

        assertThrows(IllegalArgumentException.class,
            () -> new Song("Title", "Artist", "Pop", -5));
    }

    /**
     * Tests getTitle().
     */
    @Test
    public void getTitleTest() {
        assertEquals("Title", song.getTitle());

        Song other = new Song(" A ", "Artist", "Pop", 1);
        assertEquals("A", other.getTitle());
    }

    /**
     * Tests getArtist().
     */
    @Test
    public void getArtistTest() {
        assertEquals("Artist", song.getArtist());

        Song other = new Song("Title", " A ", "Pop", 1);
        assertEquals("A", other.getArtist());
    }

    /**
     * Tests getGenre().
     */
    @Test
    public void getGenreTest() {
        assertEquals("Pop", song.getGenre());

        Song noGenre = new Song("Title", "Artist", null, 185);
        assertEquals("", noGenre.getGenre());

        Song blankGenre = new Song("Title", "Artist", "  ", 185);
        assertEquals("", blankGenre.getGenre());
    }

    /**
     * Tests getLengthSeconds().
     */
    @Test
    public void getLengthSecondsTest() {
        assertEquals(185, song.getLengthSeconds());

        Song shortSong = new Song("Title", "Artist", "Pop", 1);
        assertEquals(1, shortSong.getLengthSeconds());

        Song longSong = new Song("Title", "Artist", "Pop",
            Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE,
            longSong.getLengthSeconds());
    }

    /**
     * Tests equals().
     */
    @Test
    public void equalsTest() {
        Song same = new Song("Title", "Artist", "Rock", 200);
        Song differentTitle =
            new Song("Other", "Artist", "Pop", 185);
        Song differentArtist =
            new Song("Title", "Other", "Pop", 185);

        assertTrue(song.equals(song));
        assertEquals(song, same);
        assertEquals(same, song);

        assertNotEquals(song, differentTitle);
        assertNotEquals(song, differentArtist);
        assertNotEquals(song, null);
        assertNotEquals(song, "Not a Song");
    }

    /**
     * Tests hashCode().
     */
    @Test
    public void hashCodeTest() {
        Song same = new Song("Title", "Artist", "Rock", 200);

        assertEquals(song.hashCode(), same.hashCode());
    }

    /**
     * Tests toString().
     */
    @Test
    public void toStringTest() {
        assertEquals("Title - Artist (3:05)",
            song.toString());

        Song oneSecond = new Song(
            "Title", "Artist", null, 1);
        assertEquals("Title - Artist (0:01)",
            oneSecond.toString());

        Song oneMinute = new Song(
            "Title", "Artist", "Pop", 60);
        assertEquals("Title - Artist (1:00)",
            oneMinute.toString());

        Song tenMinutes = new Song(
            "Title", "Artist", "Pop", 605);
        assertEquals("Title - Artist (10:05)",
            tenMinutes.toString());
    }
}
