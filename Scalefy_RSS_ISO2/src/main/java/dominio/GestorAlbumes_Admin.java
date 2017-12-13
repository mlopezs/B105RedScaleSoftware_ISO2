package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.*;

/**
 * 
 * @version 1.1
 */
public class GestorAlbumes_Admin {
    
    LinkedList<Album> bbdd_Albumes = new LinkedList();

   /**
    * 
    * @param album
    * @return 
    */
    public boolean añadirAlbum(Album album) {        
        Iterator<Album> it = bbdd_Albumes.iterator();
        while(it.hasNext()){
            if(it.next().getId() == album.getId()){
                bbdd_Albumes.add(album);
                return true;
            }
        }
        return false;        
    }

    /**
     * 
     * @param idAlbum
     * @return 
     */
    public boolean eliminarAlbum(int idAlbum) {
        Iterator<Album> it = bbdd_Albumes.iterator();
        while(it.hasNext()){
            Album a = it.next();
            if(a.getId() == idAlbum){
                bbdd_Albumes.remove(a);
                return true;
            }
        }
        return false;
    }

}