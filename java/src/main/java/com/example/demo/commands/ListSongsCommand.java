package com.example.demo.commands;

import java.util.List;
import com.example.demo.repositories.MusicPlayer;
import com.example.demo.entities.Song;

public class ListSongsCommand implements ICommand {

    @Override
    public void execute(List<String> tokens) {
        List<Song> songs = MusicPlayer.getInstance().getAllSongs();
        System.out.println(songs);
    }
}
