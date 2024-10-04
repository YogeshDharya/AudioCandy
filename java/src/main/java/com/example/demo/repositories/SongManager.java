package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.demo.entities.Song;

public class SongManager {

    private Map<Integer, Song> allSongs;
    private int autoincrement;
    // private List<Song> allSongs;

    public SongManager() {
        allSongs = new HashMap<>();
        autoincrement = 1;
    }

    public void addSong(Song song) {

        song.setId(String.valueOf(autoincrement));
        allSongs.put(autoincrement, song);
        autoincrement++;
    }

    public Song getSongById(String songId) {
        // return allSongs.stream().filter(song -> song.getId().equals(songId)).findFirst()
        //         .orElse(null);
        return allSongs.get(Integer.parseInt(songId));
    }

    public List<Song> getAllSongs() {
        return new ArrayList<>(allSongs.values());

    }
}
