package B105.Algofy;

import dominio.GestorReproduccion;
import java.util.LinkedList;
import java.util.PriorityQueue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Album;
import persistencia.Cancion;
import persistencia.ListaReproduccion;
import persistencia.Usuario;

public class GestorReproduccion_Test {
    
    private int[] cancionesAlbum1;
    private int[] cancionesAlbum2;
    private Album album1;
    private Album album2;

    private Cancion cancion1;
    private Cancion cancion2;
    private Cancion cancion3;
    
    private int[] cancionesLista1;
    private int[] cancionesLista2;
    private ListaReproduccion lista1;
    private ListaReproduccion lista2;
    
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
        cancion3 = new Cancion(2, "Pajaros disecados", "Fito y fitipaldis", 1, 
                "Rock", 4.19);
        
        cancionesLista1 = new int[3];
        cancionesLista1[0] = 0;
        cancionesLista1[1] = 1;
        cancionesLista1[2] = 2;

        cancionesLista2 = new int[3];
        cancionesLista1[0] = 3;
        cancionesLista1[1] = 4;
        cancionesLista1[2] = 5;

        lista1 = new ListaReproduccion(0, "Best lista de reproduccion", 1, 
                cancionesLista1);
        lista2 = new ListaReproduccion(1, "Worst lista de reproduccion", 1, 
                cancionesLista2);
        
    }
    
    @Test
    public void testGestorReproduccion() {

        LinkedList<Cancion> lc = new LinkedList();
        lc.add(cancion1);
        lc.add(cancion2);
        LinkedList<Album> la = new LinkedList();
        la.add(album1);
        la.add(album2);
        LinkedList<ListaReproduccion> llr = new LinkedList();
        llr.add(lista1);
        llr.add(lista2);

        GestorReproduccion gr = new GestorReproduccion(lc, la, llr);

        assertTrue(gr.reproducirCancion(0));
        assertFalse(gr.reproducirCancion(4));
        assertFalse(gr.reproducirCancion(-3));

        assertTrue(gr.reproducirAlbum(0));
        assertFalse(gr.reproducirAlbum(9));
        assertFalse(gr.reproducirAlbum(-3));

        assertTrue(gr.reproducirListaReproduccion(0));
        assertFalse(gr.reproducirListaReproduccion(5));
        assertFalse(gr.reproducirListaReproduccion(-3));
    }
}
