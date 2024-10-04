package com.example.demo.commands;

import java.util.List;
import com.example.demo.repositories.MusicPlayer;
import com.example.demo.entities.Playlist;

public class CreatePlaylistCommand implements ICommand {

    @Override
    public void execute(List<String> tokens) {
        String playlistName = tokens.get(1);
        List<String> songIds = tokens.subList(2, tokens.size());

        Playlist playlist = MusicPlayer.getInstance().createPlaylist(playlistName, songIds);
        System.out.println(playlist);
    }
}
