package B105.Algofy;

import dominio.GestorAlbumes_Admin;
import dominio.GestorCanciones_Admin;
import dominio.GestorReproduccion;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import persistencia.Album;
import persistencia.Cancion;
import persistencia.ListaReproduccion;
import persistencia.Usuario;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private int[] cancionesAlbum1;
    private int[] cancionesAlbum2;
    private Album album1;
    private Album album2;

    private Cancion cancion1;
    private Cancion cancion2;
    private Cancion cancion3;

    private Cancion cancion4;
    private Cancion cancion5;
    private Cancion cancion6;

    private int[] cancionesAdquiridas1;
    private int[] cancionesAdquiridas2;
    private int[] listasReproduccion1;
    private Queue<String> mensajes;
    private Usuario usuario1;
    private Usuario usuario2;

    private int[] cancionesLista1;
    private int[] cancionesLista2;
    private ListaReproduccion lista1;
    private ListaReproduccion lista2;

    /**
     *
     * @throws Exception
     */
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

        cancion1 = new Cancion(0, "Entre la espada y la pared", "Fito y fitipaldis", 1, "Rock", 4.52);
        cancion2 = new Cancion(1, "Lo que sobra de mi", "Fito y fitipaldis", 1, "Rock", 3.40);
        cancion3 = new Cancion(2, "Pajaros disecados", "Fito y fitipaldis", 1, "Rock", 4.19);

        cancion4 = new Cancion(3, "Sensualidad", "Bad Bunny", 1, "KK", 2.22);
        cancion5 = new Cancion(4, "Chambeo", "Bad Bunny", 1, "KK", 5.23);
        cancion6 = new Cancion(5, "Tu no metes cabra", "Bad Bunny", 1, "Mega KK", 3.19);

        cancionesAdquiridas1 = new int[2];
        cancionesAdquiridas1[0] = 1;
        cancionesAdquiridas1[1] = 3;

        cancionesAdquiridas2 = new int[2];
        cancionesAdquiridas1[0] = 1;
        cancionesAdquiridas1[1] = 0;

        listasReproduccion1 = new int[2];
        listasReproduccion1[0] = 0;
        listasReproduccion1[1] = 1;

        mensajes = new PriorityQueue<String>();
        usuario1 = new Usuario(0, "Moises", "Rodriguez Monje", "moisror57", "123", cancionesAdquiridas1, listasReproduccion1, 999, mensajes);
        usuario2 = new Usuario(1, "Ricardo", "Perez del Castillo", "ricper23", "123", cancionesAdquiridas2, listasReproduccion1, 999, mensajes);

        cancionesLista1 = new int[3];
        cancionesLista1[0] = 0;
        cancionesLista1[1] = 1;
        cancionesLista1[2] = 2;

        cancionesLista2 = new int[3];
        cancionesLista1[0] = 3;
        cancionesLista1[1] = 4;
        cancionesLista1[2] = 5;

        lista1 = new ListaReproduccion(0, "Best lista de reproduccion", 1, cancionesLista1);
        lista2 = new ListaReproduccion(1, "Worst lista de reproduccion", 1, cancionesLista2);
    }

    @Test
    public void testGestorAlbumesAdmin() {
        LinkedList<Album> listaAlbumesTest = new LinkedList();
        listaAlbumesTest.add(album2);
        GestorAlbumes_Admin gaa = new GestorAlbumes_Admin(listaAlbumesTest);

        assertTrue(gaa.añadirAlbum(album1));
        assertFalse(gaa.añadirAlbum(album2));

        assertTrue(gaa.eliminarAlbum(album1.getId()));
        assertFalse(gaa.eliminarAlbum(album1.getId()));
    }

    @Test
    public void testGestorCancionesAdmin() {
        LinkedList<Cancion> listaCanciones = new LinkedList();
        LinkedList<Cancion> listaCancionesRetornadas = new LinkedList();
        listaCanciones.add(cancion1);

        GestorCanciones_Admin gca = new GestorCanciones_Admin(listaCanciones);
        assertTrue(gca.añadirCancion(cancion2));
        assertFalse(gca.añadirCancion(cancion1));

        listaCancionesRetornadas = gca.buscarCancion("espada");
        
        for(int i = 0; i < listaCancionesRetornadas.size(); i++){
            assertEquals(listaCancionesRetornadas.get(i),listaCanciones.get(i));
        }
                
        assertTrue(gca.modificarCancion(cancion1.getId(), cancion2));
        assertFalse(gca.modificarCancion(12,cancion1));
        
        

    }

    @Test
    public void testGestorReproduccion(){
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
        assertTrue(gr.reproducirAlbum(0));
        assertFalse(gr.reproducirAlbum(9));
        assertTrue(gr.reproducirListaReproduccion(0));
        assertFalse(gr.reproducirListaReproduccion(5));
    }
    
}
