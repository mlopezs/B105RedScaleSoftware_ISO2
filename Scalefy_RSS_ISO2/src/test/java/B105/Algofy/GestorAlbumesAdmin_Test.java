package B105.Algofy;

import dominio.GestorAlbumes_Admin;
import java.util.LinkedList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Album;

public class GestorAlbumesAdmin_Test {
    
    private int[] cancionesAlbum1;
    private int[] cancionesAlbum2;
    private Album album1;
    private Album album2;
    
    @Before
    public void setUp() throws Exception {
        
        cancionesAlbum1 = new int[3];
        cancionesAlbum1[0] = 0;
        cancionesAlbum1[1] = 1;
        cancionesAlbum1[2] = 2;

        cancionesAlbum2 = new int[3];
        cancionesAlbum2[0] = 3;
        cancionesAlbum2[1] = 4;
        cancionesAlbum2[2] = 5;

        album1 = new Album(0, "Huyendo conmigo de mi", cancionesAlbum1);
        album2 = new Album(1, "Bad Bunny Hits", cancionesAlbum2);
        
    }
    
    @Test
    public void testGestorAlbumesAdmin() {
        
        LinkedList<Album> listaAlbumesTest = new LinkedList();
        listaAlbumesTest.add(album2);
        GestorAlbumes_Admin gaa = new GestorAlbumes_Admin(listaAlbumesTest);

        assertTrue(gaa.añadirAlbum(album1));
        assertFalse(gaa.añadirAlbum(album2));
        assertFalse(gaa.añadirAlbum(null));
        
        assertTrue(gaa.eliminarAlbum(album1.getId()));
        assertFalse(gaa.eliminarAlbum(album1.getId()));
        assertFalse(gaa.eliminarAlbum(-12));
        
    }
    
}