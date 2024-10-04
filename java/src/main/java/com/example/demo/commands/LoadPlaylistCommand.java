package com.example.demo.commands;

import java.util.List;
import com.example.demo.repositories.MusicPlayer;

public class LoadPlaylistCommand implements ICommand {

    @Override
    public void execute(List<String> tokens) {
        String playlistName = tokens.get(1);

        boolean result = MusicPlayer.getInstance().loadPlaylist(playlistName);

        if (result) {
            System.out.println("Playlist " + playlistName + " is loaded!");
        } else {
            System.out.println("Failed to load playlist.");
        }
    }
}