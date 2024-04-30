package Proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SongServiceObjectTest {

    private SongService songService;

    @BeforeEach
    public void setUp() {
        songService = new SongServiceObject();
    }

    @Test
    public void testAddSong() {
        Song song = new Song("SongTitle", "Artist", "Album", 180);
        songService.addSong(song);

        assertNotNull(songService.searchById(song.getSongID()));
        assertNotNull(songService.searchByTitle("SongTitle"));
        assertNotNull(songService.searchByAlbum("Album"));
    }

    @Test
    public void testSearchById() {
        Song song = new Song("SongTitle", "Artist", "Album", 180);
        songService.addSong(song);

        assertEquals(song, songService.searchById(song.getSongID()));
    }

    @Test
    public void testSearchByTitle() {
        Song song = new Song("SongTitle", "Artist", "Album", 180);
        songService.addSong(song);

        List<Song> songs = songService.searchByTitle("SongTitle");
        assertNotNull(songs);
        assertEquals(1, songs.size());
        assertEquals(song, songs.get(0));
    }

    @Test
    public void testSearchByAlbum() {
        Song song = new Song("SongTitle", "Artist", "Album", 180);
        songService.addSong(song);

        List<Song> songs = songService.searchByAlbum("Album");
        assertNotNull(songs);
        assertEquals(1, songs.size());
        assertEquals(song, songs.get(0));
    }
}
