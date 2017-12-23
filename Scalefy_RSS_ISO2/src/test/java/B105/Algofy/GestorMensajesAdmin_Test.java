package B105.Algofy;

import dominio.GestorMensajes_Admin;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Usuario;

public class GestorMensajesAdmin_Test {

    // Usuarios alamacenados
    private int[] cancionesAdquiridas1;
    private int[] cancionesAdquiridas2;
    private int[] listasReproduccion1;
    private Queue<String> mensajes;
    private Usuario usuario1;
    private Usuario usuario2;

    // Atributos para este gestor
    private LinkedList<Usuario> lu;
    private GestorMensajes_Admin gma;

    @Before
    public void setUp() throws Exception {

        // Usuarios alamacenados
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

        // Atributos para este gestor
        lu = new LinkedList();
        lu.add(usuario1);
        lu.add(usuario2);
        gma = new GestorMensajes_Admin(lu);

    }

    @Test
    public void testEnviarMensaje() {

        assertFalse(gma.enviarMensaje(0, ""));
        assertTrue(gma.enviarMensaje(0,"Mensaje"));
        assertFalse(gma.enviarMensaje(-1, null));
        assertFalse(gma.enviarMensaje(4, "Mensaje"));

    }

}
