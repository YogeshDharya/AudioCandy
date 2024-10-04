package com.example.demo.repositories;  
  
//import java.util.ArrayList;  
import java.util.List;  
import com.example.demo.entities.Playlist;  
import com.example.demo.entities.Song;  
  
public class MusicPlayer {  
  
    private static MusicPlayer instance;  
    private PlaylistManager playlistManager;  
    private SongManager songManager;  
    private Playlist currentPlaylist;  
    private boolean currentlyPlayingSongs; 
     private int currentSongIndex; 
   
    private MusicPlayer() {  
        playlistManager = new PlaylistManager();  
        songManager = new SongManager(); 
         currentPlaylist = null; 
         currentlyPlayingSongs = false; 
         currentSongIndex = -1; 
     }
 
    public static MusicPlayer getInstance() {
        if (instance == null) {
            instance = new MusicPlayer();
        }
        return instance;
    }

    public List<Song> getAllSongs() {
        return songManager.getAllSongs();
    }

    public void addSong(Song song) {
        songManager.addSong(song);
    }

    public Playlist getPlaylist(String playlistName) {
        return playlistManager.getPlaylistByName(playlistName);
    }

    public Playlist createPlaylist(String name, List<String> songIds) {
        Playlist playlist = new Playlist(name);
        for (String songId : songIds) {
            Song song = songManager.getSongById(songId);
            if (song != null) {
                playlist.addSong(song);
            }
        }
        playlistManager.addPlaylist(playlist);
        return playlist;
    }

    public boolean addSongToPlaylist(String playlistName, String songId) {
        Playlist playlist = playlistManager.getPlaylistByName(playlistName);
        if (playlist != null) {
            Song song = songManager.getSongById(songId);
            if (song != null) {
                if (playlist.addSong(song)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteSongFromPlaylist(String playlistName, String songId) {
        Playlist playlist = playlistManager.getPlaylistByName(playlistName);
        if (playlist != null) {
            Song song = songManager.getSongById(songId);
            if (song != null) {
                if (playlist.removeSong(song)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deletePlaylist(String name) {
        Playlist playlist = playlistManager.getPlaylistByName(name);
        if (playlist != null) {
            return playlistManager.removePlaylist(playlist);
        }
        return false;
    }

    public boolean loadPlaylist(String name) {
        Playlist playlist = playlistManager.getPlaylistByName(name);
        if (playlist != null) {
            currentPlaylist = playlist;
            currentSongIndex = 0;
            return true;
        }
        return false;
    }

    public void playSong() {
        if (currentPlaylist != null && currentPlaylist.getSongs().size() > 0) {
            Song currentSong = currentPlaylist.getSongs().get(currentSongIndex);
            if (currentlyPlayingSongs) {
                System.out.println("Song [id=" + currentSong.getId() + "] is paused!");
            } else {
                System.out.println("Song [id=" + currentSong.getId() + "] is playing!");
            }
            currentlyPlayingSongs = !currentlyPlayingSongs;
        } else {
            System.out.println("No song is currently playing.");
        }
    }

    public void nextSong() {
        if (currentPlaylist != null && currentPlaylist.getSongs().size() > 1) {
            currentSongIndex = (currentSongIndex + 1) % currentPlaylist.getSongs().size();
            System.out.println("Song [id="
                    + currentPlaylist.getSongs().get(currentSongIndex).getId() + "] is playing!");
        }
    }

    public void previousSong() {
        if (currentPlaylist != null && currentPlaylist.getSongs().size() > 1) {
            currentSongIndex = (currentSongIndex - 1 + currentPlaylist.getSongs().size())
                    % currentPlaylist.getSongs().size();
            System.out.println("Song [id="
                    + currentPlaylist.getSongs().get(currentSongIndex).getId() + "] is playing!");
        }
    }

    public void stopSong() {
        if (currentPlaylist != null && currentPlaylist.getSongs().size() > 0) {
            System.out.println("Song [id="
                    + currentPlaylist.getSongs().get(currentSongIndex).getId() + "] is stopped!");
            currentSongIndex = -1;
        } else {
            System.out.println("No song is currently playing.");
        }
    }
}
