package B105.Algofy;

import dominio.GestorListasReproduccion;
import java.util.LinkedList;
import java.util.Queue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Cancion;
import persistencia.ListaReproduccion;
import persistencia.Usuario;

public class GestorListasReproduccion_Test {
    
    private Cancion cancion1;
    private Cancion cancion2;
    private Cancion cancion3;

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
    
    @Before
    public void setUp() throws Exception {
        
        cancion1 = new Cancion(0, "Entre la espada y la pared", "Fito y fitipaldis", 
                1, "Rock", 4.52);
        cancion2 = new Cancion(1, "Lo que sobra de mi", "Fito y fitipaldis", 1, 
                "Rock", 3.40);
        cancion3 = new Cancion(2, "Pajaros disecados", "Fito y fitipaldis", 1, 
                "Rock", 4.19);
        
        cancionesAdquiridas1 = new int[2];
        cancionesAdquiridas1[0] = 1;
        cancionesAdquiridas1[1] = 3;

        cancionesAdquiridas2 = new int[2];
        cancionesAdquiridas1[0] = 1;
        cancionesAdquiridas1[1] = 0;

        listasReproduccion1 = new int[2];
        listasReproduccion1[0] = 0;
        listasReproduccion1[1] = 1;

        usuario1 = new Usuario(0, "Moises", "Rodriguez Monje", "moisror57", 
                "123", cancionesAdquiridas1, listasReproduccion1, 999, mensajes);
        usuario2 = new Usuario(1, "Ricardo", "Perez del Castillo", "ricper23", 
                "456", cancionesAdquiridas2, listasReproduccion1, 999, mensajes);

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
}