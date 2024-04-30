package org.example.Proxy;

public class ProxyDriver {
    public static void main(String[] args) {
        SongServiceImpl s = new SongServiceImpl();
        SongService proxySongService = new SongServiceProxy(s);
        s.addSong(new Song("Love Affair", "Haruno", "25", 200));
        s.addSong(new Song("Love Affair", "UMI", "Love Language", 190));
        s.addSong(new Song("Tablet", "TOOBOE", "Stupid dog", 201));
        s.addSong(new Song("Eden", "Mitsukiyo", "Wonderland", 199));
        s.addSong(new Song("Utopia", "Mitsukiyo", "Wonderland", 106));
        System.out.println(proxySongService.searchById(3));
        System.out.println(proxySongService.searchByTitle("Love Affair"));
        System.out.println(proxySongService.searchByAlbum("Wonderland"));
    }
}
