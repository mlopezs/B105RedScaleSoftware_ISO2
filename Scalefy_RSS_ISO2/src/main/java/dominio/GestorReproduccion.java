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

    private LinkedList<Cancion> bbdd_Canciones = new LinkedList();
    private LinkedList<Album> bbdd_Albumes = new LinkedList();
    private LinkedList<ListaReproduccion> bbdd_ListasReproduccion = new LinkedList();

    /**
     *
     * @param idCancion
     */
    public void reproducirCancion(int idCancion) {
        Iterator<Cancion> it = bbdd_Canciones.iterator();
        while (it.hasNext()) {
            Cancion c = it.next();
            if (c.getId() == idCancion) {
                System.out.println("Reproduciendo canción \"" + c.getNombre()
                        + "\" de \"" + c.getArtista() + "\".");
            }
        }
        System.out.println("La canción no existe.");
    }

    /**
     *
     * @param idAlbum
     */
    public void reproducirAlbum(int idAlbum) {
        Iterator<Album> it = bbdd_Albumes.iterator();
        while (it.hasNext()) {
            Album a = it.next();
            if (a.getId() == idAlbum) {
                System.out.println("Reproduciendo álbum \"" + a.getNombre() + "\".");
            }
        }
        System.out.println("El álbum no existe.");
    }

    /**
     *
     * @param idListaReproduccion
     */
    public void reproducirListaReproduccion(int idListaReproduccion) {
        Iterator<ListaReproduccion> it = bbdd_ListasReproduccion.iterator();
        while (it.hasNext()) {
            ListaReproduccion lr = it.next();
            if (lr.getId() == idListaReproduccion) {
                System.out.println("Reproduciendo lista de reproducción \"" + lr.getNombre() + "\".");
            }
        }
        System.out.println("La lista de reproduccion no existe.");
    }

}
