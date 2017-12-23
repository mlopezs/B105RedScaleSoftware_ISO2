package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.Album;
import persistencia.Cancion;

/**
 * @version 1.0
 */
public class GestorCompras {

    private final LinkedList<Cancion> bbdd_Canciones;
    private final LinkedList<Album> bbdd_Albumes;
    private LinkedList<Cancion> adqC;
    private LinkedList<Album> adqA;

    /**
     * Constructor.
     *
     * @param bbddCanciones
     * @param bbddAlbumes
     * @param adqC
     * @param adqA
     */
    public GestorCompras(LinkedList<Cancion> bbddCanciones,
            LinkedList<Album> bbddAlbumes, LinkedList<Cancion> adqC,
            LinkedList<Album> adqA) {
        this.bbdd_Canciones = bbddCanciones;
        this.bbdd_Albumes = bbddAlbumes;
        this.adqC = adqC;
        this.adqA = adqA;
    }

    /**
     *
     * @param idCancion
     * @return
     */
    public boolean adquirirCancion(int idCancion) {
        Iterator<Cancion> itc = adqC.iterator();
        while (itc.hasNext()) {
            Cancion auxCancion = itc.next();
            if (auxCancion.getId() == idCancion) {
                System.out.println("Ya posee la canción \""
                        + auxCancion.getNombre() + "\".");
                return false;
            }
        }

        Iterator<Cancion> itb = bbdd_Canciones.iterator();
        while (itb.hasNext()) {
            Cancion auxCancion = itb.next();
            if (auxCancion.getId() == idCancion) {
                adqC.add(auxCancion);
                System.out.println("Ha adquirido la canción \""
                        + auxCancion.getNombre() + "\".");
                return true;
            }
        }

        System.out.println("No se ha podido adquirir la canción.");
        return false;
    }

    /**
     *
     * @param idAlbum
     * @return
     */
    public boolean adquirirAlbum(int idAlbum) {
        Iterator<Album> itc = adqA.iterator();
        while (itc.hasNext()) {
            Album auxAlbum = itc.next();
            if (auxAlbum.getId() == idAlbum) {
                System.out.println("Ya posee la canción \""
                        + auxAlbum.getNombre() + "\".");
                return false;
            }
        }

        Iterator<Album> itb = bbdd_Albumes.iterator();
        while (itb.hasNext()) {
            Album auxCancion = itb.next();
            if (auxCancion.getId() == idAlbum) {
                adqA.add(auxCancion);
                System.out.println("Ha adquirido el álbum \""
                        + auxCancion.getNombre() + "\".");
                return true;
            }
        }

        System.out.println("No se ha podido adquirir la canción.");
        return false;
    }

}
