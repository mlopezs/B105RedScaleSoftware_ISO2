package dominio;



/**
 * @version 1.1
 */
public class GestorReproduccion {
    
        private double duracion;
        private int[] numCancionesAlbum;
        private int[] numCancionesLista;
        
    public void reproducirCancion(int idCancion) {
        
        if(idCancion!=0){
             System.out.println("Reproduciendo canción: "+ idCancion+"\n"+"Duracion de la cancion: "+this.duracion);
        }else{
            System.out.println("Error al reproducir. La cancion no exite.");
        }  
    }

    
    public void reproducirAlbum(int idAlbum) {
        
        if(numCancionesAlbum.length !=0){
            System.out.println("Reproduciendo album: "+idAlbum);
        } else {
            System.out.println("Error al reproducir el album. No existe o está vacio");
        }
        
    }

   
    public void reproducirListaReproduccion(int idListaReproduccion) {
        
        if(numCancionesLista.length !=0){
            System.out.println("Reproduciendo lista: "+idListaReproduccion);
        }else{
            System.out.println("Error al reproducior la lista. No existe o está vacia");
        }
       
    }

}
