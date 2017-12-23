package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.Cancion;

/**
 * @version 1.3
 */
public class GestorCanciones_Admin {

    private final LinkedList<Cancion> bbdd_Canciones;

    /**
     *
     * @param bbddCanciones
     */
    public GestorCanciones_Admin(LinkedList<Cancion> bbddCanciones) {
        this.bbdd_Canciones = bbddCanciones;
    }

    /**
     *
     * @param cancion
     * @return
     */
    public boolean añadirCancion(Cancion cancion) {
        Iterator<Cancion> itBbddCanciones = bbdd_Canciones.iterator();
        while (itBbddCanciones.hasNext()) {
            try {
                if (itBbddCanciones.next().getId() == cancion.getId()) {
                    System.out.println("ERROR. La cancion ya existe.");
                    return false;
                }
            } catch (NullPointerException e) {
                System.out.println("ERROR, cancion nula");
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

        Iterator<Cancion> itCanciones = bbdd_Canciones.iterator();

        LinkedList<Cancion> coincidencias = new LinkedList();

        if (patron == null) {

            System.out.println("ERROR, patron nulo");
            return coincidencias;

        }

        while (itCanciones.hasNext()) {
            Cancion cancion = itCanciones.next();
            if (cancion.getArtista().contains(patron)
                    || cancion.getNombre().contains(patron)) {
                coincidencias.add(cancion);
            }
        }

        Iterator<Cancion> itCoincidencias = coincidencias.iterator();

        if (coincidencias.size() > 0) {
            System.out.println("Coincidencias encontradas: \n");
        }
        while (itCoincidencias.hasNext()) {
            System.out.println(itCoincidencias.next().toString());
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
        Cancion auxCancion;

        Iterator<Cancion> itCanciones = bbdd_Canciones.iterator();
        int lugarCancion;

        while (itCanciones.hasNext()) {
            auxCancion = itCanciones.next();

            if (cancionNueva == null) {
                modificacion = false;
                return modificacion;
            }

            if (auxCancion.getId() == idCancionVieja) {
                lugarCancion = bbdd_Canciones.indexOf(auxCancion);
                bbdd_Canciones.remove(lugarCancion);
                bbdd_Canciones.add(lugarCancion, cancionNueva);
                modificacion = true;
                break;
            } else {
                modificacion = false;
            }

        }

        return modificacion;
    }

    /**
     *
     * @param idEliminacion
     * @return
     */
    public boolean eliminarCancion(int idEliminacion) {
        boolean eliminacion = false;

        Cancion auxCancion;

        Iterator<Cancion> itCanciones;
        itCanciones = bbdd_Canciones.iterator();

        int lugarCancion;
        while (itCanciones.hasNext()) {
            auxCancion = itCanciones.next();
            System.out.println(auxCancion.getId() + " -> "
                    + auxCancion.getNombre());
            if (auxCancion.getId() == idEliminacion) {
                lugarCancion = bbdd_Canciones.indexOf(auxCancion);
                bbdd_Canciones.remove(lugarCancion);
                eliminacion = true;
                break;
            }

        }

        return eliminacion;
    }
}
