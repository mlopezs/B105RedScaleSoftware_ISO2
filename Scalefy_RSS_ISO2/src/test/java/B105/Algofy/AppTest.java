package B105.Algofy;

import dominio.GestorAlbumes_Admin;
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
        cancionesAlbum1[0] = 1;
        cancionesAlbum1[1] = 2;
        cancionesAlbum1[2] = 3;

        cancionesAlbum2 = new int[3];
        cancionesAlbum2[0] = 4;
        cancionesAlbum2[1] = 5;
        cancionesAlbum2[2] = 6;

        album1 = new Album(1, "Huyendo conmigo de mi", cancionesAlbum1);
        album2 = new Album(1, "Bad Bunny Hits", cancionesAlbum2);

        cancion1 = new Cancion(1, "Entre la espada y la pared", "Fito y fitipaldis", 1, "Rock", 4.52);
        cancion2 = new Cancion(2, "Lo que sobra de mi", "Fito y fitipaldis", 1, "Rock", 3.40);
        cancion3 = new Cancion(3, "Pajaros disecados", "Fito y fitipaldis", 1, "Rock", 4.19);

        cancion4 = new Cancion(4, "Sensualidad", "Bad Bunny", 1, "KK", 2.22);
        cancion5 = new Cancion(5, "Chambeo", "Bad Bunny", 1, "KK", 5.23);
        cancion6 = new Cancion(6, "Tu no metes cabra", "Bad Bunny", 1, "Mega KK", 3.19);

        cancionesAdquiridas1 = new int[2];
        cancionesAdquiridas1[0] = 2;
        cancionesAdquiridas1[1] = 4;

        cancionesAdquiridas2 = new int[2];
        cancionesAdquiridas1[0] = 2;
        cancionesAdquiridas1[1] = 4;

        listasReproduccion1 = new int[2];
        listasReproduccion1[0] = 1;
        listasReproduccion1[1] = 2;

        mensajes = new PriorityQueue<String>();
        usuario1 = new Usuario(1, "Moises", "Rodriguez Monje", "moisror57", "123", cancionesAdquiridas1, listasReproduccion1, 999, mensajes);
        usuario2 = new Usuario(1, "Ricardo", "Perez del Castillo", "ricper23", "123", cancionesAdquiridas2, listasReproduccion1, 999, mensajes);

        cancionesLista1 = new int[3];
        cancionesLista1[0] = 1;
        cancionesLista1[1] = 2;
        cancionesLista1[2] = 3;

        cancionesLista2 = new int[3];
        cancionesLista1[0] = 4;
        cancionesLista1[1] = 5;
        cancionesLista1[2] = 6;

        lista1 = new ListaReproduccion(1, "Best lista de reproduccion", 1, cancionesLista1);
        lista2 = new ListaReproduccion(2, "Worst lista de reproduccion", 1, cancionesLista2);
    }

    @Test
    public void testGestorAlbumesAdmin() {
        GestorAlbumes_Admin gaa = new GestorAlbumes_Admin();
        assertTrue(gaa.añadirAlbum(album1));
    }

}
