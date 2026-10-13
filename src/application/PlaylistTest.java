package application;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class PlaylistTest{
    
    private Playlist playlist;
    private Song a;
    private Song b;
    private Song c;

    @BeforeEach
    public void setUp() {
        playlist = new Playlist("Favorites");
        a = new Song("app", "app artist", "pop", 120);
        b = new Song("bat", "bat artist", "rap", 180);
        c = new Song("game", "game artist", "rock", 240);
    
    }

    /**
     * Adds three songs to a playlist
     */
    private void addThree() {
        playlist.addSong(a);
        playlist.addSong(b);
        playlist.addSong(c);
    }

    /**
     * Tests Playlist constructor
     */
    @Test
    public void constructorTest() {
        assertEquals("Favorites", playlist.getName());
        assertTrue(playlist.isEmpty());
        assertEquals(0, playlist.getSongCount());
        assertEquals(0, playlist.getTotalLength());
    }

    /**
     * Tests getName()
     */
    @Test
    public void getNameTest() {
        {
            addThree();
            assertEquals("Favorites", playlist.getName());
        }
    }

    /**
     * Tests addSong()
     */
    @Test
    public void addSongTest() {
        assertTrue(playlist.addSong(a));
        assertTrue(playlist.addSong(b));
        assertEquals(2, playlist.getSongCount());
        try {
            playlist.addSong(null);
            fail("Adding null should throw IllegalArgumentException.");
        }
        catch (IllegalArgumentException exception) {
            assertEquals("Cannot add a null song to the playlist.", exception.getMessage());
        }
    }

    /**
     * Tests removeSong()
     */
    @Test
    public void removeSongTest(){
        addThree();
        assertTrue(playlist.removeSong(b));
        assertTrue(playlist.removeSong(a));
    }

    /**
    * Tests removeSong() when playlist is empty/null 
    */
    @Test
    public void removeSongTest2(){
        setUp();
        assertFalse(playlist.removeSong(a));
    }

    /**
     * Tests containSong()
     */
    @Test
    public void containsSongTest() {
        setUp();
        playlist.addSong(a);
        assertTrue(playlist.containsSong(a));
        playlist.removeSong(a);
        assertFalse(playlist.containsSong(a));
    }

    /**
     * Tests getSong()
     */
    @Test
    public void getSongTest(){
        addThree();
        assertEquals(a, playlist.getSong(0));
        
    }

    /**
     * Tests getSong() when index is invalid
     */
    @Test
    public void getSongTest2(){
        try {
            playlist.getSong(-1);
            fail("A negative index should throw an exception.");
        }
        catch (IndexOutOfBoundsException exception) {
            assertNotNull(exception);
        }
    }

    /**
     * Tests getTotalLength()
     */
    @Test
    public void totalLegthTest(){
        addThree();
        assertEquals(540, playlist.getTotalLength());
    }
    /**
     * Tests getTotalLength() when playlist is empty
     */
    @Test 
    public void totalLengthTest2(){
        assertEquals(0, playlist.getTotalLength());
    }

    /**
     * Tests isEmpty()
     */
    @Test 
    public void isEmptyTest(){
        assertTrue(playlist.isEmpty());
        addThree();
        assertFalse(playlist.isEmpty());

    }
    /**
     * Tests clear()
     */
    @Test 
    public void clearTest(){
        addThree();
        playlist.clear();
        assertTrue(playlist.isEmpty());
        playlist.clear();
    }
    
    /**
     * Tests moveSong()
     */
    @Test 
    public void moveSongTest(){
        addThree();
        playlist.moveSong(0,2);
        assertEquals(a, playlist.getSong(2));
    }

    /**
     * Tests moveSong() on empty playlist
     */
    @Test
    void moveSongTest2() {
        assertTrue(playlist.isEmpty());

        try {
            playlist.moveSong(0, 0);
            fail("Moving a song in an empty playlist should throw an exception.");
        }
        catch (IndexOutOfBoundsException exception) {
            assertNotNull(exception);
        }
        assertTrue(playlist.isEmpty());
    }  
    
    /**
     * Tests swapSongs()
     */
    @Test
    public void swapSongsTest(){
        addThree();
        playlist.swapSongs(0, 2);
        assertEquals(a, playlist.getSong(2));
        assertEquals(c, playlist.getSong(0));

    }
    /**
     * Tests swapSongs() on empty playlist
     */
    @Test
    public void swapSongsTest2() {
        try {
            playlist.swapSongs(0, 0);
            fail("Swapping songs in an empty playlist should throw an exception.");
        }
        catch (IndexOutOfBoundsException exception) {
            assertNotNull(exception);
        }
        assertTrue(playlist.isEmpty());
    }


}
