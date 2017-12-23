package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.Album;

/**
 *
 * @version 1.1
 */
public class GestorAlbumes_Admin {

    private final LinkedList<Album> bbdd_Albumes;

    /**
     *
     * @param bbddAlbumes
     */
    public GestorAlbumes_Admin(LinkedList<Album> bbddAlbumes) {
        this.bbdd_Albumes = bbddAlbumes;
    }

    /**
     *
     * @param album
     * @return
     */
    public boolean añadirAlbum(Album album) {
        Iterator<Album> itAlbumes = bbdd_Albumes.iterator();
        while (itAlbumes.hasNext()) {
            try {
                if (itAlbumes.next().getId() == album.getId()) {
                    return false;
                }
            } catch (NullPointerException e) {
                System.out.println("ERROR, album nulo");
                return false;
            }
        }
        bbdd_Albumes.add(album);
        return true;
    }

    /**
     *
     * @param idAlbum
     * @return
     */
    public boolean eliminarAlbum(int idAlbum) {
        Iterator<Album> itAlbumes = bbdd_Albumes.iterator();
        while (itAlbumes.hasNext()) {
            Album albumAuxiliar = itAlbumes.next();
            if (albumAuxiliar.getId() == idAlbum) {
                bbdd_Albumes.remove(albumAuxiliar);
                return true;
            }
        }
        return false;
    }

}
