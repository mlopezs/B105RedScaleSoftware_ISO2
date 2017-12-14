package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import persistencia.Cancion;
import persistencia.ListaReproduccion;
import persistencia.Usuario;

/**
 * @version 1.1
 */
public class GestorListasReproduccion {

    // Simulacion BBDD
    private final LinkedList<ListaReproduccion> bbdd_ListasReproduccion;
    private final LinkedList<Usuario> bbdd_Usuarios;
    private final LinkedList<Cancion> bbdd_Canciones;

    /**
     * Constructor.
     *
     * @param bbdd_ListasReproduccion
     * @param bbdd_Usuarios
     * @param bbdd_Canciones
     */
    public GestorListasReproduccion(LinkedList<ListaReproduccion> bbdd_ListasReproduccion, LinkedList<Usuario> bbdd_Usuarios, LinkedList<Cancion> bbdd_Canciones) {
        this.bbdd_ListasReproduccion = bbdd_ListasReproduccion;
        this.bbdd_Usuarios = bbdd_Usuarios;
        this.bbdd_Canciones = bbdd_Canciones;
    }

    /**
     *
     * @param idLista
     * @param idUsuario
     * @param nombreLista
     * @param canciones
     * @return
     */
    public boolean crearLR(int idLista, int idUsuario, String nombreLista, int[] canciones) {
        Iterator<Usuario> itu = bbdd_Usuarios.iterator();
        boolean flag = false;
        while (itu.hasNext()) {
            if (idUsuario == itu.next().getIdUsuario()) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Usuario no encontrado");
            return false;
        }
        for (int a : canciones) {
            if (a < 0) {
                System.out.println("La cancion no es válida.");
                return false;
            }
        }
        if (idLista < 0 || nombreLista == null || nombreLista.equals("")) {
            System.out.println("El id o nombre de la lista no son correctos");
            return false;
        }
        ListaReproduccion lr = new ListaReproduccion(idLista, nombreLista, idUsuario, canciones);
        bbdd_ListasReproduccion.add(lr);
        System.out.println("Lista \"" + nombreLista + "\" añadida con éxito.");
        return true;
    }

    /**
     *
     * @param idListaReproduccion
     * @return
     */
    public boolean borrarLR(int idListaReproduccion) {
        Iterator<ListaReproduccion> it = bbdd_ListasReproduccion.iterator();
        while (it.hasNext()) {
            ListaReproduccion l = it.next();
            if (idListaReproduccion == l.getId()) {
                bbdd_ListasReproduccion.remove(l);
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
        Iterator<ListaReproduccion> it = bbdd_ListasReproduccion.iterator();
        while (it.hasNext()) {
            ListaReproduccion l = it.next();
            if (idListaReproduccion == l.getId()) {
                String old = l.getNombre();
                System.out.println("Cambiar \"" + old + "\" a:");
                Scanner sc = new Scanner(System.in);
                String nuevo = "<LeidoPorTeclado>";//sc.next();
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
        boolean flag = false;
        Iterator<Cancion> it = bbdd_Canciones.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == idCancion) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("La cancion no existe.");
            return false;
        }
        Iterator<ListaReproduccion> it2 = bbdd_ListasReproduccion.iterator();
        while (it2.hasNext()) {
            ListaReproduccion l = it2.next();
            if (idLR == l.getId()) {
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
        boolean flag = false;
        Iterator<Cancion> it = bbdd_Canciones.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == idCancion) {
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("La cancion no existe.");
            return false;
        }
        Iterator<ListaReproduccion> it2 = bbdd_ListasReproduccion.iterator();
        while (it2.hasNext()) {
            ListaReproduccion l = it2.next();
            if (idLR == l.getId()) {
                l.setCanciones(separar(l.getCanciones(), idCancion));
                System.out.println("La canción ha sido retirada de la lista.");
                return true;
            }
        }
        System.out.println("La canción no pudo retirarse de la lista de reproducción");
        return false;
    }

    /**
     * Introduce en el vector 'canciones' el elemento 'idCancion'.
     *
     * @param canciones
     * @param c
     * @return
     */
    private int[] juntar(int[] canciones, int idCancion) {
        int[] nuevo = new int[canciones.length + 1];
        System.arraycopy(canciones, 0, nuevo, 0, canciones.length);
        nuevo[nuevo.length - 1] = idCancion;
        return nuevo;
    }

    /**
     * Elimina del vector 'canciones' el elemento 'idCancion'.
     *
     * @param canciones
     * @param idCancion
     * @return
     */
    private int[] separar(int[] canciones, int idCancion) {
        int[] nuevo = new int[canciones.length - 1];
        int n = 0;
        for (int i = 0; i < canciones.length; i++) {
            if (canciones[i] != idCancion) {
                nuevo[n] = canciones[i];
            }
        }
        return nuevo;
    }

}
