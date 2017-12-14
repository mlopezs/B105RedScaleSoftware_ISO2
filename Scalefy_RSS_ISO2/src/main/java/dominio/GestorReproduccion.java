package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.Album;
import persistencia.Cancion;
import persistencia.ListaReproduccion;

/**
 * @version 1.1
 */
public class GestorReproduccion {

    private final LinkedList<Cancion> bbdd_Canciones;
    private final LinkedList<Album> bbdd_Albumes;
    private final LinkedList<ListaReproduccion> bbdd_ListasReproduccion;

    /**
     * Constructor.
     * @param bbdd_Canciones
     * @param bbdd_Albumes
     * @param bbdd_ListasReproduccion 
     */
    public GestorReproduccion(LinkedList<Cancion> bbdd_Canciones, LinkedList<Album> bbdd_Albumes, 
            LinkedList<ListaReproduccion> bbdd_ListasReproduccion) {
        this.bbdd_Canciones = bbdd_Canciones;
        this.bbdd_Albumes = bbdd_Albumes;
        this.bbdd_ListasReproduccion = bbdd_ListasReproduccion;
    }    
    
    /**
     * 
     * @param idCancion
     * @return 
     */
    public boolean reproducirCancion(int idCancion) {
        Iterator<Cancion> it = bbdd_Canciones.iterator();
        while (it.hasNext()) {
            Cancion c = it.next();
            if (c.getId() == idCancion) {
                System.out.println("Reproduciendo canción \"" + c.getNombre()
                        + "\" de \"" + c.getArtista() + "\".");
                return true;
            }
        }
        System.out.println("La canción no existe.");
        return false;
    }

    /**
     * 
     * @param idAlbum
     * @return 
     */
    public boolean reproducirAlbum(int idAlbum) {
        Iterator<Album> it = bbdd_Albumes.iterator();
        while (it.hasNext()) {
            Album a = it.next();
            if (a.getId() == idAlbum) {
                System.out.println("Reproduciendo álbum \"" + a.getNombre() + "\".");
                return true;
            }
        }
        System.out.println("El álbum no existe.");
        return false;
    }

    /**
     * 
     * @param idListaReproduccion
     * @return 
     */
    public boolean reproducirListaReproduccion(int idListaReproduccion) {
        Iterator<ListaReproduccion> it = bbdd_ListasReproduccion.iterator();
        while (it.hasNext()) {
            ListaReproduccion lr = it.next();
            if (lr.getId() == idListaReproduccion) {
                System.out.println("Reproduciendo lista de reproducción \"" + 
                        lr.getNombre() + "\".");
                return true;
            }
        }
        System.out.println("La lista de reproduccion no existe.");
        return false;
    }

}
