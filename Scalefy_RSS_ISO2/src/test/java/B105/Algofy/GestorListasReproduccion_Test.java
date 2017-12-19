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
    
    // Canciones alamacenadas
    private Cancion cancion1;
    private Cancion cancion2;
    private Cancion cancion3;
    
    // Usuarios almacenados
    private int[] cancionesAdquiridas1;
    private int[] cancionesAdquiridas2;
    private int[] listasReproduccion1;
    private Queue<String> mensajes;    
    private Usuario usuario1;
    private Usuario usuario2;

    // Listas de Reproduccion alamacenadas
    private int[] cancionesLista1;
    private int[] cancionesLista2;
    private ListaReproduccion lista1;
    private ListaReproduccion lista2;
    
    // Atributos para este gestor
    private LinkedList<Cancion> lc;
    private LinkedList<Usuario> lu;
    private LinkedList<ListaReproduccion> llr;
    int[] cs = {0, 1, 2};
    int[] csf = {1, -1};       
    private GestorListasReproduccion glr;
    
    @Before
    public void setUp() throws Exception {
        
        // Canciones almacenadas
        cancion1 = new Cancion(0, "Entre la espada y la pared", "Fito y fitipaldis", 
                1, "Rock", 4.52);
        cancion2 = new Cancion(1, "Lo que sobra de mi", "Fito y fitipaldis", 1, 
                "Rock", 3.40);
        cancion3 = new Cancion(2, "Pajaros disecados", "Fito y fitipaldis", 1, 
                "Rock", 4.19);
        
        // Usuarios almacenados
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
        
        // Listas de Reproduccion alamacenadas
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
        
        // Atributos para este gestor
        lc = new LinkedList();
        lc.add(cancion1);
        lc.add(cancion2);
        lc.add(cancion3);
        lu = new LinkedList();
        lu.add(usuario1);
        lu.add(usuario2);
        llr = new LinkedList();
        llr.add(lista1);
        llr.add(lista2);
        
        glr = new GestorListasReproduccion(llr, lu, lc);
        
    }
    
    @Test
    public void testCrearLR() {

        assertFalse(glr.crearLR(0, 4, "ListaNueva", cs));
        assertFalse(glr.crearLR(7, 0, "ListaNueva", cs));
        assertFalse(glr.crearLR(0, 0, "ListaNueva", csf));
        assertFalse(glr.crearLR(-6, 0, "ListaNueva", cs));
        assertFalse(glr.crearLR(0, -6, "ListaNueva", cs));
        assertFalse(glr.crearLR(0, 1, "", cs));
        assertFalse(glr.crearLR(0, 1, null, cs));
        assertTrue(glr.crearLR(0, 0, "ListaNueva", cs));
        
    }
    
    @Test
    public void testBorrarLR() {

        assertFalse(glr.borrarLR(-9));
        assertFalse(glr.borrarLR(9));
        assertTrue(glr.borrarLR(0));
        
    }
    
    @Test
    public void testModificarLR() {

        assertFalse(glr.modificarLR(5, "NuevoNombre"));
        assertFalse(glr.modificarLR(1, ""));
        assertTrue(glr.modificarLR(0, "NuevoNombre"));

    }
    
    @Test
    public void testAñadirCancion() {

        assertFalse(glr.añadirCancion(10, 0));
        assertFalse(glr.añadirCancion(1, 84));
        assertFalse(glr.añadirCancion(-2, 0));
        assertFalse(glr.añadirCancion(0, -4));
        assertTrue(glr.añadirCancion(0, 0));

    }
    
    @Test
    public void testEliminarCancion() {

        assertFalse(glr.eliminarCancion(10, 0));
        assertFalse(glr.eliminarCancion(1, 84));
        assertTrue(glr.eliminarCancion(0, 0));

    }
    
}
