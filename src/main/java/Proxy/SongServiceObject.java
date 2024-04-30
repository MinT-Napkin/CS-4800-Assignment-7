package Proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SongServiceObject implements SongService {

    private HashMap<Integer, Song> songStorageID = new HashMap<>();
    private HashMap<String, List<Song>> songStorageTitle= new HashMap<>();
    private HashMap<String, List<Song>> songStorageAlbum= new HashMap<>();

    @Override
    public void addSong(Song song) {

        if(!songStorageID.containsKey(song.getSongID()))
        {
            songStorageID.put(song.getSongID(), song);

            if(!songStorageTitle.containsKey(song.getTitle())) {
                List<Song> titleSongList = new ArrayList<>();
                titleSongList.add(song);
                songStorageTitle.put(song.getTitle(), titleSongList);
            } else {
                List<Song> list = songStorageTitle.get(song.getTitle());
                list.add(song);
                songStorageTitle.put(song.getTitle(), list);
            }

            if(!songStorageAlbum.containsKey(song.getAlbum()))
            {
                List<Song> albumSongList = new ArrayList<>();
                albumSongList.add(song);
                songStorageAlbum.put(song.getAlbum(), albumSongList);
            } else {
                List<Song> list = songStorageAlbum.get(song.getAlbum());
                list.add(song);
                songStorageAlbum.put(song.getAlbum(), list);
            }
        }
        else
        {
            System.out.println("Song already exists in database.");
        }
    }

    @Override
    public Song searchById(Integer songID) {
        delay();

        Song song = songStorageID.get(songID);
        if (song == null) {
            System.out.println("Song of ID, " + songID + ", was not found");
            return null;
        }

        songStorageID.containsKey(songID);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        delay();

        List<Song> song = songStorageTitle.get(title);
        if (song == null) {
            System.out.println("Song of title, "+ title + ", was not found");
            return null;
        }

        songStorageTitle.containsKey(title);
        return song;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        delay();

        List<Song> song = songStorageAlbum.get(album);
        if (song == null) {
            System.out.println("Song of title, "+ album + ", was not found");
            return null;
        }

        songStorageAlbum.containsKey(album);
        return song;
    }

    public void setSongStorageID(HashMap<Integer, Song> songStorageID) {
        this.songStorageID = songStorageID;
    }

    public void setSongStorageTitle(HashMap<String, List<Song>> songStorageTitle) {
        this.songStorageTitle = songStorageTitle;
    }

    public void setSongStorageAlbum(HashMap<String, List<Song>> songStorageAlbum) {
        this.songStorageAlbum = songStorageAlbum;
    }

    private void delay()
    {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
    }
}
