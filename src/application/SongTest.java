package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SongTest {

    private Song song;

    @BeforeEach
    public void setUp() {
        song = new Song(" Title ", " Artist ", " Pop ", 185);
    }

    /**
     * Tests song constructor
     */
    @Test
    public void constructorTest() {
        assertEquals("Title", song.getTitle());
        assertEquals("Artist", song.getArtist());
        assertEquals("Pop", song.getGenre());
        assertEquals(185, song.getLengthSeconds());
    }

    /**
     * Tests getTitle()
     */
    @Test
    public void getTitleTest() {
        assertEquals("Title", song.getTitle());
        assertEquals("A", new Song(" A ", "Artist", "Pop", 1).getTitle());
    }

    /**
     * Tests getArtist()
     */
    @Test
    public void getArtistTest() {
        assertEquals("Artist", song.getArtist());
        assertEquals("A", new Song("Title", " A ", "Pop", 1).getArtist());
    }

    /**
     * Tests getGenre()
     */
    @Test
    public void getGenreTest() {
        assertEquals("Pop", song.getGenre());
        assertEquals("", new Song("Title", "Artist", null, 185).getGenre());
        assertEquals("", new Song("Title", "Artist", "  ", 185).getGenre());
    }

    /**
     * Tests getLengthSeconds()
     */
    @Test
    public void getLengthSecondsTest() {
        assertEquals(185, song.getLengthSeconds());
        assertEquals(1, new Song("Title", "Artist", "Pop", 1).getLengthSeconds());
        assertEquals(Integer.MAX_VALUE,
            new Song("Title", "Artist", "Pop", Integer.MAX_VALUE).getLengthSeconds());
    }

    /**
     * Tests toString()
     */
    @Test
    public void toStringTest() {
        assertEquals("Title - Artist (3:05)",
            song.toString());
        assertEquals("Title - Artist (0:01)",
            new Song("Title", "Artist", null, 1).toString());
        assertEquals("Title - Artist (1:00)",
            new Song("Title", "Artist", "Pop", 60).toString());
    }

}
