package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.Album;
import persistencia.Cancion;

/**
 * @version 1.0
 */
public class GestorCompras {
    
    private LinkedList<Cancion> bbdd_Canciones = new LinkedList();
    private LinkedList<Album> bbdd_Albumes = new LinkedList();
    private LinkedList<Cancion> adqC = new LinkedList();
    private LinkedList<Album> adqA = new LinkedList();

    
    public boolean adquirirCancion(int idCancion) {
        Iterator<Cancion> itc = adqC.iterator();
        while(itc.hasNext()){
            Cancion c = itc.next();
            if(c.getId() == idCancion){
                System.out.println("Ya posee la canción \"" + c.getNombre() + "\".");
                return false;
            }
        }
        
        Iterator<Cancion> itb = bbdd_Canciones.iterator();
        while(itb.hasNext()){
            Cancion c = itb.next();
            if(c.getId() == idCancion){
                adqC.add(c);
                System.out.println("Ha adquirido la canción \"" + c.getNombre() + "\".");
                return true;
            }
        }
        
        System.out.println("No se ha podido adquirir la canción.");
        return false;        
    }

   
    
    public boolean adquirirAlbum(int idAlbum) {
        Iterator<Album> itc = adqA.iterator();
        while(itc.hasNext()){
            Album a = itc.next();
            if(a.getId() == idAlbum){
                System.out.println("Ya posee la canción \"" + a.getNombre() + "\".");
                return false;
            }
        }
        
        Iterator<Album> itb = bbdd_Albumes.iterator();
        while(itb.hasNext()){
            Album c = itb.next();
            if(c.getId() == idAlbum){
                adqA.add(c);
                System.out.println("Ha adquirido el álbum \"" + c.getNombre() + "\".");
                return true;
            }
        }
        
        System.out.println("No se ha podido adquirir la canción.");
        return false;  
    }

}
