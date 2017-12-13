package dominio;

/**
 * @version 1.0
 */
public class GestorCompras {

    
    public boolean adquirirCancion(int idCancion) {
        
        System.out.println("Cancion "+idCancion+" adquirida");
        return true;
        
    }

   
    
    public boolean adquirirAlbum(int idAlbum) {
        
        System.out.println("Album "+idAlbum+" adquirido");
        return true;
    }

}
