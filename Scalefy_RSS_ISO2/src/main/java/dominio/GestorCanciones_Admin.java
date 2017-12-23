package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.*;

/**
 * @version 1.3
 */
public class GestorCanciones_Admin {

    private final LinkedList<Cancion> bbdd_Canciones;

    public GestorCanciones_Admin(LinkedList<Cancion> bbddCanciones) {
        this.bbdd_Canciones = bbddCanciones;
    }

    /**
     *
     * @param cancion
     * @return
     */
    public boolean añadirCancion(Cancion cancion) {
        Iterator<Cancion> iteradorBbddCanciones = bbdd_Canciones.iterator();
        while (iteradorBbddCanciones.hasNext()) {
            try {
                if (iteradorBbddCanciones.next().getId() == cancion.getId()) {
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
        
        Iterator<Cancion> iteradorCanciones = bbdd_Canciones.iterator();

        LinkedList<Cancion> coincidencias = new LinkedList();
        
        if(patron == null){
            
            System.out.println("ERROR, patron nulo");
            return coincidencias;
        
        }

        while (iteradorCanciones.hasNext()) {
            Cancion cancion = iteradorCanciones.next();
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
        Cancion auxiliarSustitucion/* = null*/;

        Iterator<Cancion> cancionesBaseDeDatos = bbdd_Canciones.iterator();
        int lugarCancion/* = 0*/;

        while (cancionesBaseDeDatos.hasNext()) {
            auxiliarSustitucion = cancionesBaseDeDatos.next();
            
                if (cancionNueva == null) {
                    modificacion = false;
                    return modificacion;
                }

            if (auxiliarSustitucion.getId() == idCancionVieja) {
                lugarCancion = bbdd_Canciones.indexOf(auxiliarSustitucion);
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
     * @param idCancionEliminada
     * @return 
     */
    public boolean eliminarCancion(int idCancionEliminada) {
        boolean eliminacion = false;
        
        Cancion auxiliarSustitucion;

        Iterator<Cancion> cancionesBaseDeDatos;
        cancionesBaseDeDatos = bbdd_Canciones.iterator();
        
        int lugarCancion/* = 0*/;
        while (cancionesBaseDeDatos.hasNext()) {
            System.out.println("ADIOS");
            auxiliarSustitucion = cancionesBaseDeDatos.next();
            System.out.println(auxiliarSustitucion.getId()+" -> "+auxiliarSustitucion.getNombre());
                if (auxiliarSustitucion.getId() == idCancionEliminada) {
                    lugarCancion = bbdd_Canciones.indexOf(auxiliarSustitucion);
                    bbdd_Canciones.remove(lugarCancion);
                    eliminacion = true;
                    break;
                }

        }

        if (eliminacion == true) {
            System.out.println("Eliminación exitosa.");
        }

        return eliminacion;
    }
}
