package B105.Algofy;

import dominio.GestorUsuarios;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Usuario;

public class GestorUsuarios_Test {

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
}
