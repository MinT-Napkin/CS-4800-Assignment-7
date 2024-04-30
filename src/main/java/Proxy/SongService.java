package Proxy;

import java.util.List;
public interface SongService {
    void addSong(Song song);
    Song searchById(Integer songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}
