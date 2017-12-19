package B105.Algofy;

import dominio.GestorCompras;
import java.util.LinkedList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Album;
import persistencia.Cancion;

public class GestorCompras_Test {
    
    private int[] cancionesAlbum1;
    private int[] cancionesAlbum2;
    private Album album1;
    private Album album2;

    private Cancion cancion1;
    private Cancion cancion2;    
    
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

        cancion1 = new Cancion(0, "Entre la espada y la pared", "Fito y fitipaldis", 
                1, "Rock", 4.52);
        cancion2 = new Cancion(1, "Lo que sobra de mi", "Fito y fitipaldis", 1, 
                "Rock", 3.40);
        
    }
    
    @Test
    public void testGestorCompras(){
        
        LinkedList<Cancion> bdCanciones = new LinkedList();
        LinkedList<Album> bdAlbumes = new LinkedList();
        LinkedList<Cancion> cancionesAdquiridas = new LinkedList();
        LinkedList<Album> albumesAdquiridos = new LinkedList();
        
        cancionesAdquiridas.add(cancion1);
        albumesAdquiridos.add(album1);
        
        bdCanciones.add(cancion2);
        bdAlbumes.add(album2);
        
        GestorCompras gc = new GestorCompras(bdCanciones, bdAlbumes, 
                cancionesAdquiridas, albumesAdquiridos);
        
        assertFalse(gc.adquirirCancion(0));
        assertTrue(gc.adquirirCancion(1));
        assertFalse(gc.adquirirCancion(-1));
        
        assertFalse(gc.adquirirAlbum(0));
        assertTrue(gc.adquirirAlbum(1));
        assertFalse(gc.adquirirAlbum(-1));
        
    }
    
}
