package B105.Algofy;

import dominio.GestorLogin;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Usuario;

public class GestorLogin_Test {

    private int[] cancionesAdquiridas1;
    private int[] cancionesAdquiridas2;
    private int[] listasReproduccion1;
    private Queue<String> mensajes;
    private Usuario usuario1;
    private Usuario usuario2;
    
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
        assertFalse(gl.autenticar(usuario1.getNombreUsuario(), "Algo".toCharArray()));

    }
    
}
