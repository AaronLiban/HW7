package org.example.Proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceImpl implements SongService {
    private Map<Integer, Song> songDatabase = new HashMap<>();

    public void addSong(Song song) {
        songDatabase.put(songDatabase.size()+1, song);
    }
    @Override
    public Song searchById(Integer songID) {
        simulateDelay();
        return songDatabase.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateDelay();
        List<Song> songList = new ArrayList<>();
        for(Map.Entry<Integer, Song> songs : songDatabase.entrySet()) {
            if (title.equals(songs.getValue().getTitle())) {
                songList.add(songs.getValue());
            }
        }
        return songList;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateDelay();
        List<Song> songList = new ArrayList<>();
        for(Map.Entry<Integer, Song> songs : songDatabase.entrySet()) {
            if (album.equals(songs.getValue().getAlbum())) {
                songList.add(songs.getValue());
            }
        }
        return songList;
    }
    private void simulateDelay() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
    }
}
