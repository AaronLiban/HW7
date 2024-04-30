import org.example.Proxy.Song;
import org.example.Proxy.SongService;
import org.example.Proxy.SongServiceImpl;
import org.example.Proxy.SongServiceProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProxyTest {
    SongServiceImpl s = new SongServiceImpl();
    SongService proxySongService = new SongServiceProxy(s);

    @Test
    public void testSearchById() {
        Song expected = new Song("Love Affair", "Haruno", "25", 200);
        s.addSong(expected);
        Song actual = proxySongService.searchById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchByTitle() {
        Song expected = new Song("Love Affair", "Haruno", "25", 200);
        s.addSong(expected);
        Song actual = proxySongService.searchByTitle("Love Affair").get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSearchByAlbum() {
        Song expected = new Song("Love Affair", "Haruno", "25", 200);
        s.addSong(expected);
        Song actual = proxySongService.searchByAlbum("25").get(0);
        assertEquals(expected, actual);
    }

}
