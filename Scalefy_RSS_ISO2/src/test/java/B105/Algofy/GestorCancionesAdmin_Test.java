package B105.Algofy;

import dominio.GestorCanciones_Admin;
import java.util.LinkedList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Cancion;

public class GestorCancionesAdmin_Test {
    
    private Cancion cancion1;
    private Cancion cancion2;
    
    @Before
    public void setUp() throws Exception {
        
        cancion1 = new Cancion(0, "Entre la espada y la pared", "Fito y fitipaldis", 
                1, "Rock", 4.52);
        cancion2 = new Cancion(1, "Lo que sobra de mi", "Fito y fitipaldis", 1, 
                "Rock", 3.40);

    }
    
    @Test
    public void testGestorCancionesAdmin() {
        
        LinkedList<Cancion> listaCanciones = new LinkedList();
        LinkedList<Cancion> listaCancionesRetornadas;
        
        listaCanciones.add(cancion1);
        GestorCanciones_Admin
        
        gca = new GestorCanciones_Admin(listaCanciones);
        assertTrue(gca.añadirCancion(cancion2));
        assertFalse(gca.añadirCancion(cancion1));
        assertFalse(gca.añadirCancion(null));
        
        listaCancionesRetornadas = gca.buscarCancion("espada");
        for (int i = 0; i < listaCancionesRetornadas.size(); i++) {
            assertEquals(listaCancionesRetornadas.get(i), listaCanciones.get(i));
        }

        listaCancionesRetornadas = gca.buscarCancion("");
        for (int i = 0; i < listaCancionesRetornadas.size(); i++) {
            assertEquals(listaCancionesRetornadas.get(i), listaCanciones.get(i));
        }
        
        assertTrue(gca.modificarCancion(0, cancion2));
        assertFalse(gca.modificarCancion(0, cancion1));
        assertFalse(gca.modificarCancion(0, null));
        
        assertTrue(gca.eliminarCancion(1));
        assertFalse(gca.eliminarCancion(2));
        
    }
}
