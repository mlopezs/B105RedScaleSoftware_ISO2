package B105.Algofy;

import dominio.GestorAlbumes_Admin;
import dominio.GestorCanciones_Admin;
import dominio.GestorCompras;
import dominio.GestorListasReproduccion;
import dominio.GestorLogin;
import dominio.GestorMensajes_Admin;
import dominio.GestorReproduccion;
import dominio.GestorUsuarios;
import dominio.GestorUsuarios_Admin;
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
        usuario2 = new Usuario(1, "Ricardo", "Perez del Castillo", "ricper23", "456", cancionesAdquiridas2, listasReproduccion1, 999, mensajes);

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
        LinkedList<Cancion> listaCancionesRetornadas;

        listaCanciones.add(cancion1);
        GestorCanciones_Admin gca = new GestorCanciones_Admin(listaCanciones);
        assertTrue(gca.añadirCancion(cancion2));
        assertFalse(gca.añadirCancion(cancion1));

        listaCancionesRetornadas = gca.buscarCancion("espada");
        for (int i = 0; i < listaCancionesRetornadas.size(); i++) {
            assertEquals(listaCancionesRetornadas.get(i), listaCanciones.get(i));
        }

        listaCancionesRetornadas = gca.buscarCancion("");
        for (int i = 0; i < listaCancionesRetornadas.size(); i++) {
            assertEquals(listaCancionesRetornadas.get(i), listaCanciones.get(i));
        }

        assertTrue(gca.modificarCancion(cancion1.getId(), cancion2));
        assertFalse(gca.modificarCancion(12, cancion1));

        assertTrue(gca.eliminarCancion(cancion1.getId()));
        assertFalse(gca.eliminarCancion(cancion2.getId()));

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

    @Test
    public void testGestorListasReproduccion() {

        LinkedList<Cancion> lc = new LinkedList();
        lc.add(cancion1);
        lc.add(cancion2);
        lc.add(cancion3);
        LinkedList<Usuario> lu = new LinkedList();
        lu.add(usuario1);
        lu.add(usuario2);
        LinkedList<ListaReproduccion> llr = new LinkedList();
        llr.add(lista1);
        llr.add(lista2);
        int[] cs = {0, 1, 2};
        int[] csf = {1, -1};

        GestorListasReproduccion glr = new GestorListasReproduccion(llr, lu, lc);

        assertFalse(glr.crearLR(0, 4, "FallaUsuario", cs));
        assertFalse(glr.crearLR(0, 0, "FallaCancion", csf));
        assertFalse(glr.crearLR(0, 1, "", cs));
        assertTrue(glr.crearLR(0, 0, "Acierto", cs));

        assertFalse(glr.borrarLR(-9));
        assertTrue(glr.borrarLR(0));

        assertFalse(glr.modificarLR(5, "NuevoNombre"));
        assertFalse(glr.modificarLR(1, ""));
        assertTrue(glr.modificarLR(0, "NuevoNombre"));

        assertFalse(glr.añadirCancion(10, 0));
        assertFalse(glr.añadirCancion(1, 84));
        assertTrue(glr.añadirCancion(0, 0));

        assertFalse(glr.eliminarCancion(10, 0));
        assertFalse(glr.eliminarCancion(1, 84));
        assertTrue(glr.eliminarCancion(0, 0));

    }

    @Test
    public void testGestorMensajesAdmin() {

        LinkedList<Usuario> lu = new LinkedList();
        lu.add(usuario1);
        lu.add(usuario2);

        GestorMensajes_Admin gma = new GestorMensajes_Admin(lu);

        assertFalse(gma.enviarMensaje(0, null));
        assertFalse(gma.enviarMensaje(5, "Mensaje"));
        assertTrue(gma.enviarMensaje(1, "Mensaje"));

    }

    @Test
    public void testGesstorUsuariosAdmin() {

        LinkedList<Usuario> lu = new LinkedList();
        lu.add(usuario1);
        lu.add(usuario2);

        Usuario ufid = new Usuario(0, "Moises", "Naidia", "moisror57", "123",
                cancionesAdquiridas1, listasReproduccion1, 999, mensajes);
        Usuario ufap = usuario1 = new Usuario(3, "Moises", "Rodriguez Monje",
                "moisror57", "123", cancionesAdquiridas1, listasReproduccion1, 999, mensajes);
        Usuario ua = new Usuario(5, "Acierto", "Jimenez", "acjim", "98h",
                cancionesAdquiridas1, listasReproduccion1, 999, mensajes);

        GestorUsuarios_Admin gua = new GestorUsuarios_Admin(lu);

        assertFalse(gua.añadirUsuario(ufid));
        assertFalse(gua.añadirUsuario(ufap));
        assertTrue(gua.añadirUsuario(ua));

        assertFalse(gua.eliminarUsuario(-9));
        assertTrue(gua.eliminarUsuario(1));
    }

    @Test
    public void testGestorLogin() {

        LinkedList<Usuario> lu = new LinkedList();
        lu.add(usuario1);

        GestorLogin gl = new GestorLogin(lu);

        assertTrue(gl.autenticar(usuario1.getNombreUsuario(),
                usuario1.getContraseña().toCharArray()));
        assertFalse(gl.autenticar(usuario1.getNombreUsuario(),
                usuario2.getContraseña().toCharArray()));
        assertFalse(gl.autenticar("NoExisto", usuario1.getContraseña().toCharArray()));

    }

    @Test
    public void testGestorUsuarios() {

        LinkedList<Usuario> usu = new LinkedList();
        usu.add(usuario1);

        GestorUsuarios gu = new GestorUsuarios(usu);

        Usuario ufap = new Usuario(3, "Moises", "Rodriguez Monje",
                "moisror57", "123", cancionesAdquiridas1, listasReproduccion1, 999, mensajes);

        assertTrue(gu.anadirUsuario(usuario2));
        assertFalse(gu.anadirUsuario(usuario1));
        assertFalse(gu.anadirUsuario(ufap));
        assertFalse(gu.anadirUsuario(null));
        
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
        
        GestorCompras gc = new GestorCompras(bdCanciones, bdAlbumes, cancionesAdquiridas, 
                albumesAdquiridos);
        
        assertFalse(gc.adquirirCancion(0));
        assertTrue(gc.adquirirCancion(1));
        assertFalse(gc.adquirirCancion(-1));
        
        assertFalse(gc.adquirirAlbum(0));
        assertTrue(gc.adquirirAlbum(1));
        assertFalse(gc.adquirirAlbum(-1));
        
    }
}
