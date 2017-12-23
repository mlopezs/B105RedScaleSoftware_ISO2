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
    private final LinkedList<ListaReproduccion> bbdd_ListasReprod;

    /**
     * Constructor.
     *
     * @param bbddCanciones
     * @param bbddAlbumes
     * @param bbddListasReprod
     */
    public GestorReproduccion(LinkedList<Cancion> bbddCanciones,
            LinkedList<Album> bbddAlbumes,
            LinkedList<ListaReproduccion> bbddListasReprod) {
        this.bbdd_Canciones = bbddCanciones;
        this.bbdd_Albumes = bbddAlbumes;
        this.bbdd_ListasReprod = bbddListasReprod;
    }

    /**
     *
     * @param idCancion
     * @return
     */
    public boolean reproducirCancion(int idCancion) {
        Iterator<Cancion> itCanciones = bbdd_Canciones.iterator();
        while (itCanciones.hasNext()) {
            Cancion auxCancion = itCanciones.next();
            if (auxCancion.getId() == idCancion) {
                System.out.println("Reproduciendo canción \""
                        + auxCancion.getNombre() + "\" de \""
                        + auxCancion.getArtista() + "\".");
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
        Iterator<Album> itAlbumes = bbdd_Albumes.iterator();
        while (itAlbumes.hasNext()) {
            Album auxAlbum = itAlbumes.next();
            if (auxAlbum.getId() == idAlbum) {
                System.out.println("Reproduciendo álbum \""
                        + auxAlbum.getNombre() + "\".");
                return true;
            }
        }
        System.out.println("El álbum no existe.");
        return false;
    }

    /**
     *
     * @param idListaReprod
     * @return
     */
    public boolean reproducirListaReproduccion(int idListaReprod) {
        Iterator<ListaReproduccion> itListaReprod;
        itListaReprod = bbdd_ListasReprod.iterator();
        while (itListaReprod.hasNext()) {
            ListaReproduccion auxListaReprod = itListaReprod.next();
            if (auxListaReprod.getId() == idListaReprod) {
                System.out.println("Reproduciendo lista de reproducción \""
                        + auxListaReprod.getNombre() + "\".");
                return true;
            }
        }
        System.out.println("La lista de reproduccion no existe.");
        return false;
    }

}
