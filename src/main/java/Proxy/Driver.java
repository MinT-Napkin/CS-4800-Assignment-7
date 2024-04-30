package Proxy;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        SongService songService = new SongServiceProxy();

        Song newSong1 = new Song("Library Stroll", "Nightmargin", "Oneshot", 240);
        Song newSong2 = new Song("Happy Days", "Darer", "Dawn to Dusk", 120);
        Song newSong3 = new Song("Lovely Tree Friends", "Darer", "Dawn to Dusk", 240);
        Song newSong4 = new Song("Library Stroll", "Darer", "Oneshot Copycat", 120);
        Song newSong5 = new Song("Hyper!", "Hyper Potions", "Nonexistant", 240);
        songService.addSong(newSong1);
        songService.addSong(newSong2);
        songService.addSong(newSong3);
        songService.addSong(newSong4);
        songService.addSong(newSong5);

        Song retrievedSong1 = songService.searchById(newSong1.getSongID());
        Song retrievedSong2 = songService.searchById(newSong2.getSongID());
        Song retrievedSong3 = songService.searchById(newSong3.getSongID());
        Song retrievedSong4 = songService.searchById(newSong4.getSongID());
        Song retrievedSong5 = songService.searchById(newSong5.getSongID());

        System.out.println("Retrieved song: " + retrievedSong1.getSongID());
        System.out.println("Retrieved song: " + retrievedSong2.getSongID());
        System.out.println("Retrieved song: " + retrievedSong3.getSongID());
        System.out.println("Retrieved song: " + retrievedSong4.getSongID());
        System.out.println("Retrieved song: " + retrievedSong5.getSongID());

        //retrieve by id again
        retrievedSong1 = songService.searchById(newSong1.getSongID());
        retrievedSong2 = songService.searchById(newSong2.getSongID());
        retrievedSong3 = songService.searchById(newSong3.getSongID());
        retrievedSong4 = songService.searchById(newSong4.getSongID());
        retrievedSong5 = songService.searchById(newSong5.getSongID());

        System.out.println("Retrieved song: " + retrievedSong1.getSongID());
        System.out.println("Retrieved song: " + retrievedSong2.getSongID());
        System.out.println("Retrieved song: " + retrievedSong3.getSongID());
        System.out.println("Retrieved song: " + retrievedSong4.getSongID());
        System.out.println("Retrieved song: " + retrievedSong5.getSongID());

        //retrieve by title
        List<Song> retrievedSongList1 = songService.searchByTitle(newSong1.getTitle());
        List<Song> retrievedSongList2 = songService.searchByTitle(newSong2.getTitle());
        List<Song> retrievedSongList3 = songService.searchByTitle(newSong3.getTitle());
        List<Song> retrievedSongList4 = songService.searchByTitle(newSong4.getTitle());
        List<Song> retrievedSongList5 = songService.searchByTitle(newSong5.getTitle());

        System.out.println("Songs retrieved by title:");
        printSongList(retrievedSongList1);
        printSongList(retrievedSongList2);
        printSongList(retrievedSongList3);
        printSongList(retrievedSongList4);
        printSongList(retrievedSongList5);

        //retrieve by album
        retrievedSongList1 = songService.searchByAlbum(newSong1.getAlbum());
        retrievedSongList2 = songService.searchByAlbum(newSong2.getAlbum());
        retrievedSongList3 = songService.searchByAlbum(newSong3.getAlbum());
        retrievedSongList4 = songService.searchByAlbum(newSong4.getAlbum());
        retrievedSongList5 = songService.searchByAlbum(newSong5.getAlbum());

        System.out.println("Songs retrieved by title:");
        printSongList(retrievedSongList1);
        printSongList(retrievedSongList2);
        printSongList(retrievedSongList3);
        printSongList(retrievedSongList4);
        printSongList(retrievedSongList5);
    }

    private static void printSongList(List<Song> songs) {
        for (Song song : songs) {
            System.out.println("Song ID: " + song.getSongID());
            System.out.println("Title: " + song.getTitle());
            System.out.println("Artist: " + song.getArtist());
            System.out.println("Album: " + song.getAlbum());
            System.out.println("Duration: " + song.getDuration());
            System.out.println("-----------------------------");
        }
    }
}
