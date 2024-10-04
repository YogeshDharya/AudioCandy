package com.example.demo.repositories;

import com.example.demo.commands.AddSongCommand;
import com.example.demo.commands.AddSongToPlaylistCommand;
import com.example.demo.commands.CommandRegistory;
import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.DeletePlaylistCommand;
import com.example.demo.commands.DeleteSongFromPlaylistCommand;
import com.example.demo.commands.ListSongsCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;

public class AppRepository {

    private final CommandRegistory commandRegistry = new CommandRegistory();

    public CommandRegistory getCommandInvoker(){
        commandRegistry.registerCommand("ADD_SONG", new AddSongCommand());
        commandRegistry.registerCommand("PLAY_SONG", new PlaySongCommand());
        commandRegistry.registerCommand("NEXT_SONG", new NextSongCommand());
        commandRegistry.registerCommand("PREVIOUS_SONG", new PreviousSongCommand());
        commandRegistry.registerCommand("STOP_SONG", new StopSongCommand());
        commandRegistry.registerCommand("LIST_SONGS", new ListSongsCommand());
        commandRegistry.registerCommand("CREATE_PLAYLIST", new CreatePlaylistCommand());
        commandRegistry.registerCommand("LOAD_PLAYLIST", new LoadPlaylistCommand());
        commandRegistry.registerCommand("DELETE_PLAYLIST", new DeletePlaylistCommand());
        commandRegistry.registerCommand("ADD_SONG_TO_PLAYLIST", new AddSongToPlaylistCommand());
        commandRegistry.registerCommand("DELETE_SONG_FROM_PLAYLIST", new DeleteSongFromPlaylistCommand());
  
        return commandRegistry;
    }
}
