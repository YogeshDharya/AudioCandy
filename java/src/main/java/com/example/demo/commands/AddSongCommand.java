package com.example.demo.commands;

import java.util.List;
import com.example.demo.repositories.MusicPlayer;
import com.example.demo.entities.Song;

public class AddSongCommand implements ICommand {

    @Override
    public void execute(List<String> tokens) {
        String name = tokens.get(1).trim();
        String artist = tokens.get(2).trim();
        String album = tokens.get(3).trim();
        String genre = tokens.get(4).trim();

        Song song = new Song(name, artist, album, genre);
        MusicPlayer.getInstance().addSong(song);
        System.out.println(song);
    }
}