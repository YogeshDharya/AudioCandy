package com.example.demo.commands;

import java.util.List;
import com.example.demo.repositories.MusicPlayer;

public class AddSongToPlaylistCommand implements ICommand {

    @Override
    public void execute(List<String> tokens) {
        String playlistName = tokens.get(1);
        String songId = tokens.get(2);

        boolean result = MusicPlayer.getInstance().addSongToPlaylist(playlistName, songId);

        if (result) {
            System.out.println("Playlist " + playlistName + " is revised with " +
                    MusicPlayer.getInstance().getPlaylist(playlistName).getSongs());
        } else {
            System.out.println("Failed to add song to playlist.");
        }
    }
}
