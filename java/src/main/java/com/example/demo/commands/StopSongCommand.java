package com.example.demo.commands;

import java.util.List;
import com.example.demo.repositories.MusicPlayer;

public class StopSongCommand implements ICommand {

    @Override
    public void execute(List<String> tokens) {
        MusicPlayer.getInstance().stopSong();
    }
}