package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import persistencia.Cancion;
import persistencia.ListaReproduccion;

/**
 * @version 1.1
 */
public class GestorListasReproduccion {
    
    // Simulacion BBDD
    private final LinkedList<Cancion> bbdd_Canciones;
    private final LinkedList<ListaReproduccion> bbdd_Listas;
    
    // Simulacion datos de entrada
    private ListaReproduccion lr;
    private final int idLista;
    private final int idUsuario;
    private final String nombreLista;
    private final int[] canciones;

    /**
     * Constructor para testing.
     * @param idLista
     * @param idUsuario
     * @param nombreLista
     * @param canciones 
     */
    public GestorListasReproduccion(int idLista, int idUsuario, String nombreLista, 
            int[] canciones) {
        this.bbdd_Listas = new LinkedList();
        this.bbdd_Canciones = new LinkedList();
        this.idLista = idLista;
        this.idUsuario = idUsuario;
        this.nombreLista = nombreLista;
        this.canciones = canciones;
    }

    /**
     *
     * @return
     */
    public int crearLR() {
        lr = new ListaReproduccion(idLista, nombreLista, idUsuario, canciones);
        bbdd_Listas.add(lr);
        return idLista;
    }

    /**
     *
     * @param idListaReproduccion
     * @return
     */
    public boolean borrarLR(int idListaReproduccion) {
        Iterator<ListaReproduccion> it = bbdd_Listas.iterator();
        while(it.hasNext()){
            ListaReproduccion l = it.next();
            if(idListaReproduccion == l.getId()){
                bbdd_Listas.remove(l);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param idListaReproduccion
     * @return
     */
    public boolean modificarLR(int idListaReproduccion) {
        Iterator<ListaReproduccion> it = bbdd_Listas.iterator();
        while(it.hasNext()){
            ListaReproduccion l = it.next();
            if(idListaReproduccion == l.getId()){
                System.out.println("Cambiar \"" + nombreLista + "\" a:");
                Scanner sc = new Scanner(System.in);
                String nuevoNombre = sc.next();
                l.setNombre(nuevoNombre);
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param idCancion
     * @param idLR
     * @return
     */
    public boolean añadirCancion(int idCancion, int idLR) {
                
        Iterator<ListaReproduccion> it2 = bbdd_Listas.iterator();
        while(it2.hasNext()){
            ListaReproduccion l = it2.next();
            if(idLR == l.getId()){
                l.setCanciones(juntar(l.getCanciones(), idCancion));
                return true;
            }
        }
        
        return false;
    }

    /**
     *
     * @param idCancion
     * @param idLR
     * @return
     */
    public boolean eliminarCancion(int idCancion, int idLR) {
       
        Iterator<ListaReproduccion> it = bbdd_Listas.iterator();
        while(it.hasNext()){
            ListaReproduccion l = it.next();
            if(idLR == l.getId()){
                l.setCanciones(separar(l.getCanciones(),idCancion));                
            }
        }
        
        return false;
    }

    /**
     * Introduce en el vector 'canciones' el elemento 'idCancion'.
     * @param canciones
     * @param c
     * @return 
     */
    private int[] juntar(int[] canciones, int idCancion) {
        int[] nuevo = new int[canciones.length+1];
        System.arraycopy(canciones, 0, nuevo, 0, canciones.length);
        nuevo[nuevo.length-1] = idCancion;
        return nuevo;
    }

    /**
     * Elimina del vector 'canciones' el elemento 'idCancion'.
     * @param canciones
     * @param idCancion
     * @return 
     */
    private int[] separar(int[] canciones, int idCancion) {
        int[] nuevo = new int[canciones.length-1];
        int n = 0;
        for(int i = 0; i < canciones.length; i++){
            if(canciones[i] != idCancion){
                nuevo[n] = canciones[i];
            }
        }
        return nuevo;
    }

}
