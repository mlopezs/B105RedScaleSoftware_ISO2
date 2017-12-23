package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.*;

/**
 *
 * @version 1.1
 */
public class GestorAlbumes_Admin {

    private final LinkedList<Album> bbdd_Albumes;

    public GestorAlbumes_Admin(LinkedList<Album> bbddAlbumes) {
        this.bbdd_Albumes = bbddAlbumes;
    }

    /**
     *
     * @param album
     * @return 
     */
    public boolean añadirAlbum(Album album) {
        Iterator<Album> it = bbdd_Albumes.iterator();
        while (it.hasNext()) {
            try {
                if (it.next().getId() == album.getId()) {
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
        Iterator<Album> it = bbdd_Albumes.iterator();
        while (it.hasNext()) {
            Album albumAuxiliar = it.next();
            if (albumAuxiliar.getId() == idAlbum) {
                bbdd_Albumes.remove(albumAuxiliar);
                return true;
            }
        }
        return false;
    }

}