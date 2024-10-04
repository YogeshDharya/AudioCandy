package com.example.demo.commands;

import java.util.List;
import com.example.demo.repositories.MusicPlayer;

public class NextSongCommand implements ICommand {

    @Override
    public void execute(List<String> tokens) {
        MusicPlayer.getInstance().nextSong();
    }
}