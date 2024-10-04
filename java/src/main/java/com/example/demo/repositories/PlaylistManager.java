package com.example.demo.repositories;

import java.util.HashMap;
import java.util.Map;
import com.example.demo.entities.Playlist;

public class PlaylistManager {

    private Map<String, Playlist> playlists;
    private int autoincrement;

    public PlaylistManager() {
        playlists = new HashMap<>();
        autoincrement = 1;
    }

    public void addPlaylist(Playlist playlist) {
        playlist.setId(String.valueOf(autoincrement++));
        playlists.put(playlist.getName() ,playlist);
    }

    public boolean removePlaylist(Playlist playlist) {
        return playlists.remove(playlist.getName()) != null;
    }

    public Playlist getPlaylistByName(String name) {
        // return playlists.stream()
        //         .filter(playlist -> playlist.getName().equals(name))
        //         .findFirst()
        //         .orElse(null);
        return playlists.get(name);
    }
}