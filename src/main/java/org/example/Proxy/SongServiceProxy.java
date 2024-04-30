package org.example.Proxy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private Map<Integer, Song> songCache = new HashMap<>();
    private SongService songService;

    public SongServiceProxy(SongService songService) {
        this.songService = songService;
    }

    @Override
    public Song searchById(Integer songID) {
        if(!songCache.containsKey(songID)) {
            Song song = songService.searchById(songID);
            songCache.put(songID, song);
        }
        return songCache.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return songService.searchByTitle(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        return songService.searchByAlbum(album);
    }
}
