package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import persistencia.ListaReproduccion;

/**
 * @version 1.1
 */
public class GestorListasReproduccion {
    
    // Simulacion BBDD
    private final LinkedList<ListaReproduccion> bbdd_Listas = new LinkedList();

    /**
     * 
     * @param idLista
     * @param idUsuario
     * @param nombreLista
     * @param canciones
     * @return 
     */
    public int crearLR(int idLista, int idUsuario, String nombreLista, int[] canciones) {
        ListaReproduccion lr = new ListaReproduccion(idLista, nombreLista, idUsuario, canciones);
        bbdd_Listas.add(lr);
        System.out.println("Lista \"" + lr.getNombre() + "\" añadida con éxito.");
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
                System.out.println("Lista \"" + l.getNombre() + "\" eliminada con éxito.");
                return true;
            }
        }
        System.out.println("La lista de reproducción no ha podido ser eliminada");
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
                String old = l.getNombre();
                System.out.println("Cambiar \"" + old + "\" a:");
                Scanner sc = new Scanner(System.in);
                String nuevo = sc.next();
                l.setNombre(nuevo);
                System.out.println("El nombre de la lista \"" + old + "\" "
                        + "se ha cambiado a \"" + nuevo + "\".");
                return true;
            }
        }
        System.out.println("El nombre de la lista se ha cambiado con éxito.");
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
                System.out.println("La cancion se ha añadido con éxito a la lista de reproducción.");
                return true;
            }
        }
        System.out.println("La canción no pudo ser añadida a la lista de reproducción.");
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
                System.out.println("La canción ha sido retirada de la lista.");
                return true;
            }
        }
        System.out.println("La canción no pudo retirarse de la lista de reproducción");
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
