package B105.Algofy;

import dominio.GestorCanciones_Admin;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import persistencia.Cancion;

public class GestorCancionesAdmin_Test {
    
    
    // Canciones
    private Cancion cancion1;
    private Cancion cancion3;

    // Recursos necesarios de testing
     private List<Cancion> listaCancionesRecibidas;
     private List<Cancion> listaCancionesRecibidas2;
    
    // Atributos para el gestor
    private LinkedList<Cancion> listaCancionesGestor;
    private GestorCanciones_Admin gca;
    
    // Listas test de busqueda
    private LinkedList<Cancion> listaCancionesEsperadas;
    private LinkedList<Cancion> listaCancionesEsperadas1;

    @Before
    public void setUp() throws Exception {
        
        cancion1 = new Cancion(0, "Entre la espada y la pared", "Fito y fitipaldis", 
                1, "Rock", 4.52);
        
        cancion3 = new Cancion(2, "Pajaros disecados", "Fito y fitipaldis", 1, 
                "Rock", 4.19);

       listaCancionesGestor = new LinkedList<Cancion>();
       listaCancionesGestor.add(cancion1);
       
       listaCancionesEsperadas = new LinkedList();
       
       gca = new GestorCanciones_Admin(listaCancionesGestor);
       
        listaCancionesEsperadas = new LinkedList<Cancion>();
        listaCancionesEsperadas.add(cancion1);
        
        listaCancionesEsperadas1 = new LinkedList<Cancion>();
        listaCancionesEsperadas1.add(cancion1);
                    
    }
    
    @Test
    public void testAñadirCancion(){
        
        assertTrue(gca.añadirCancion(cancion3));
        assertFalse(gca.añadirCancion(cancion1));
        assertFalse(gca.añadirCancion(null));
        
    }
    
    @Test
    public void testBuscarCancion(){
        
        listaCancionesRecibidas = gca.buscarCancion("espada");
        listaCancionesRecibidas2 = gca.buscarCancion("");

        for(int i = 0; i < listaCancionesRecibidas.size(); i++){
            assertEquals(listaCancionesEsperadas.get(i), listaCancionesRecibidas.get(i));
        }
        
        
        for(int i = 0; i < listaCancionesRecibidas.size(); i++){
            assertEquals(listaCancionesEsperadas1.get(i), listaCancionesRecibidas2.get(i));
        }
        
        
        assertTrue(gca.buscarCancion(null).isEmpty());
        
    }
    
    @Test
    public void testModificarCancion(){
        
        assertTrue(gca.modificarCancion(0, cancion3));
        assertFalse(gca.modificarCancion(-1, cancion1));
        assertFalse(gca.modificarCancion(2, null));
         
    } 
    
    @Test
    public void testEliminarCancion(){
        
        assertTrue(gca.eliminarCancion(0));
        assertFalse(gca.eliminarCancion(80));
        assertFalse(gca.eliminarCancion(-1));
        
    } 

}
