package Proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SongServiceProxy implements SongService {
    private final SongService songService;
    private final HashMap<Integer, Song> cacheID;
    private final HashMap<String, List<Song>> cacheTitle;
    private final HashMap<String, List<Song>> cacheAlbum;

    public SongServiceProxy() {
        this.songService = new SongServiceObject();
        this.cacheID = new HashMap<>();
        this.cacheTitle = new HashMap<>();
        this.cacheAlbum = new HashMap<>();
    }

    public void addSong(Song song){
        songService.addSong(song);
    }

    @Override
    public Song searchById(Integer songID) {

        Song song = cacheID.get(songID);

        if (song == null) {
            song = songService.searchById(songID);
            List<Song> titleList = songService.searchByTitle(song.getTitle());
            List<Song> albumList = songService.searchByAlbum(song.getAlbum());
            cacheID.put(songID, song);
            cacheTitle.put(song.getTitle(), titleList);
            cacheAlbum.put(song.getAlbum(), albumList);
        }

        System.out.println("Retrieving song metadata from cache for songID: " + songID);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> songs = cacheTitle.get(title);

        if (songs == null) {
            songs = songService.searchByTitle(title);
            cacheTitle.put(title, songs);
        }

        System.out.println("Retrieving song(s) metadata from cache by title: " + title);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {

        List<Song> songs = cacheAlbum.get(album);

        if (songs == null) {
            songs = songService.searchByAlbum(album);
            cacheAlbum.put(album, songs);
        }

        System.out.println("Retrieving song(s) metadata from cache by album: " + album);
        return songs;
    }
}
