package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.*;

/**
 * @version 1.3
 */
public class GestorCanciones_Admin {

    private LinkedList<Cancion> bbdd_Canciones;

    /**
     *
     * @param cancion
     * @return
     */
    public boolean añadirCancion(Cancion cancion) {
        Iterator<Cancion> it = bbdd_Canciones.iterator();
        while (it.hasNext()) {
            if (it.next().getId() == cancion.getId()) {
                System.out.println("ERROR. La cancion ya existe.");
                return false;
            }
        }

        bbdd_Canciones.add(cancion);
        System.out.println("Canción agregada con exito.");
        return true;
    }

    /**
     *
     * @param patron
     * @return
     */
    public LinkedList<Cancion> buscarCancion(String patron) {
        
        Iterator<Cancion> it = bbdd_Canciones.iterator();

        LinkedList<Cancion> coincidencias = new LinkedList();

        while (it.hasNext()) {
            Cancion cancion = it.next();
            if (cancion.getArtista().contains(patron) || cancion.getNombre().contains(patron)) {
                coincidencias.add(cancion);
            }
        }

        Iterator<Cancion> itc = coincidencias.iterator();

        if (coincidencias.size() > 0) {
            System.out.println("Coincidencias encontradas: \n");
        }        
        while (itc.hasNext()) {
            System.out.println(itc.next().toString());
        }

        return coincidencias;
    }

    /**
     *
     * @param idCancionVieja
     * @param cancionNueva
     * @return
     */
    public boolean modificarCancion(int idCancionVieja, Cancion cancionNueva) {
        boolean modificacion = true;

        try {
            bbdd_Canciones.remove(idCancionVieja);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR. La canción no existe");
            modificacion = false;
        }
        if (modificacion == true && idCancionVieja < bbdd_Canciones.size()) {
            bbdd_Canciones.add(idCancionVieja, cancionNueva);
        }

        return modificacion;
    }

    /**
     *
     * @param idCancion
     * @return
     */
    public boolean eliminarCancion(int idCancion) {
        boolean eliminacion = true;

        try {
            bbdd_Canciones.remove(idCancion);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR. La canción no existe en la base de datos");
            eliminacion = false;
        }

        if (eliminacion == true) {
            System.out.println("Eliminación exitosa.");
        }

        return eliminacion;
    }
}
