package Proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongServiceProxyTest {

    private SongService songServiceProxy;

    @BeforeEach
    public void setUp() {
        songServiceProxy = new SongServiceProxy();
    }

    @Test
    public void testSearchById() {
        Song song = new Song("SongTitle", "Artist", "Album", 180);
        songServiceProxy.addSong(song);

        assertEquals(song, songServiceProxy.searchById(song.getSongID()));
    }

    @Test
    public void testSearchByTitle() {
        Song song = new Song("SongTitle", "Artist", "Album", 180);
        songServiceProxy.addSong(song);

        assertEquals(song, songServiceProxy.searchByTitle("SongTitle").get(0));
    }

    @Test
    public void testSearchByAlbum() {
        Song song = new Song("SongTitle", "Artist", "Album", 180);
        songServiceProxy.addSong(song);

        assertEquals(song, songServiceProxy.searchByAlbum("Album").get(0));
    }
}

