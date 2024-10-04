package com.example.demo.commands;

import java.util.List;
import com.example.demo.repositories.MusicPlayer;

public class DeletePlaylistCommand implements ICommand {

    @Override
    public void execute(List<String> tokens) {
        String playlistName = tokens.get(1);

        boolean result = MusicPlayer.getInstance().deletePlaylist(playlistName);

        if (result) {
            System.out.println("Playlist " + playlistName + " is deleted!");
        } else {
            System.out.println("Failed to delete playlist.");
        }
    }
}