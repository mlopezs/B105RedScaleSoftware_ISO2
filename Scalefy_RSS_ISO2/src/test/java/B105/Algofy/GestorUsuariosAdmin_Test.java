package B105.Algofy;

import dominio.GestorUsuarios_Admin;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Usuario;

public class GestorUsuariosAdmin_Test {

    // ALMACENADO EN BBDD
    private int[] cancionesAdquiridas1;
    private int[] cancionesAdquiridas2;
    private int[] listasReproduccion1;
    private Queue<String> mensajes;
    private Usuario usuario1;
    private Usuario usuario2;
    
    // Atributos para el gestor
    private LinkedList<Usuario> lu;
    private Usuario ufid, ufap, ufidn, ua;
    private GestorUsuarios_Admin gua;
    
    @Before
    public void setUp() throws Exception {
        
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
        usuario1 = new Usuario(0, "Moises", "Rodriguez Monje", "moisror57", 
                "123", cancionesAdquiridas1, listasReproduccion1, 999, mensajes);
        usuario2 = new Usuario(1, "Ricardo", "Perez del Castillo", "ricper23", 
                "456", cancionesAdquiridas2, listasReproduccion1, 999, mensajes);
        
        lu = new LinkedList();
        lu.add(usuario1);
        lu.add(usuario2);
        ufid = new Usuario(0, "Moises", "Naidia", "moisror57", "123",
                cancionesAdquiridas1, listasReproduccion1, 999, mensajes);
        ufap = usuario1 = new Usuario(3, "Moises", "Rodriguez Monje",
                "moisror57", "123", cancionesAdquiridas1, listasReproduccion1, 
                999, mensajes);
        ufidn = new Usuario(-9, "Fallo", "Castillo", "acfsfd", "htsbh",
                cancionesAdquiridas1, listasReproduccion1, 999, mensajes);
        ua = new Usuario(5, "Acierto", "Jimenez", "acjim", "98h",
                cancionesAdquiridas1, listasReproduccion1, 999, mensajes);
        gua = new GestorUsuarios_Admin(lu);
        
    }
    
    @Test
    public void testAñadirUsuario() {
        assertFalse(gua.añadirUsuario(ufid));
        assertFalse(gua.añadirUsuario(ufap));
        assertFalse(gua.añadirUsuario(ufidn));
        assertTrue(gua.añadirUsuario(ua));
        
    }
    
    @Test
    public void testEliminarUsuario() {
        
        assertFalse(gua.eliminarUsuario(-9));
        assertTrue(gua.eliminarUsuario(1));
        
    }
    
}
