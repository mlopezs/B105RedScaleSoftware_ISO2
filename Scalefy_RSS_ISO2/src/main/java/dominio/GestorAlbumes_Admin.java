package dominio;

import java.util.LinkedList;
import persistencia.*;

/**
 * 
 * @version 1.1
 */
public class GestorAlbumes_Admin {

   
    public int añadirAlbum(Album album) {
        LinkedList<Album> albumes = new LinkedList<Album>();
        boolean añadirAlbum=true;
        
        for(int i=0; i<albumes.size(); i++){
            if(album.getId() !=albumes.get(i).getId()){
                añadirAlbum=false;
            }
        }
        
        if(añadirAlbum==true){
            albumes.add(album);
            return album.getId();
        }else{
            System.out.println("Error al añadir el album. Ya existe");
            return 0;
        }
        
    }

    
    public boolean eliminarAlbum(int idAlbum) {
        LinkedList<Album> albumes = new LinkedList<Album>();
        boolean eliminarAlbum=false;
        for(int i=0; i<albumes.size();i++){
            if(idAlbum==albumes.get(i).getId()){
                albumes.remove(albumes.get(i));
                eliminarAlbum=true;
            }
        }
        return eliminarAlbum;
        
    }

}
