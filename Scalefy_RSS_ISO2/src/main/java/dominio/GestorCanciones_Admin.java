package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.*;

/**
 * @version 1.3
 */
public class GestorCanciones_Admin {

    private LinkedList<Cancion> baseDeDatosCanciones;
    Iterator<Cancion> buscaDuplicados;
        
    /**
     * 
     * @param cancion
     * @return 
     */
    
    public boolean añadirCancion(Cancion cancion) {
        buscaDuplicados = baseDeDatosCanciones.iterator();
        boolean adicion = true;
        
        while(buscaDuplicados.hasNext()){
            if(buscaDuplicados.next().getId() == cancion.getId()){
                System.out.println("ERROR, Canción ya introducida");
                adicion = false;
                return adicion;
            }
        }
        
        if(adicion == true){
            System.out.println("Canción agregada con exito");
            adicion = true;
        }
        return adicion;
    }

    /**
     * 
     * @param patron
     * @return 
     */
    public LinkedList<Cancion> buscarCancion(String patron) {
        buscaDuplicados = baseDeDatosCanciones.iterator();
        LinkedList<Cancion> coincidencias = new LinkedList();
        Iterator<Cancion> cancionesEncontradas;
        
        while(buscaDuplicados.hasNext()){
            Cancion cancion = buscaDuplicados.next();
            if(cancion.getArtista().equals(patron)||cancion.getNombre().equals(patron)){
                coincidencias.add(cancion);
            }
        }
        
        System.out.println("Coincidencias encontradas: \n");
        cancionesEncontradas = coincidencias.iterator();
        
        while(cancionesEncontradas.hasNext()){
            Cancion cancion = cancionesEncontradas.next();
            
            System.out.println(cancion.toString());
        }
        
        return coincidencias;
    }

    /**
     * 
     * @param idCancionVieja
     * @param cancionNueva
     * @return 
     */
    public boolean modificarCancion(int idCancionVieja, Cancion cancionNueva) {
        boolean modificacion = true;
        
        try{
            baseDeDatosCanciones.remove(idCancionVieja);
        }catch(IndexOutOfBoundsException e){
            System.out.println("ERROR, la canción seleccionada no existe");
            modificacion = false;
        }
        if(modificacion == true && idCancionVieja < baseDeDatosCanciones.size()){
            baseDeDatosCanciones.add(idCancionVieja, cancionNueva);
        }
        
        return modificacion;
    }

    /**
     * 
     * @param idCancion
     * @return 
     */
    public boolean eliminarCancion(int idCancion) {
        boolean eliminacion = true;
        
        try{
            baseDeDatosCanciones.remove(idCancion);
        }catch(IndexOutOfBoundsException e){
            System.out.println("ERROR, id de canción inexistente en la base de datos");
            eliminacion = false;
        }
        
        if(eliminacion == true){
            System.out.println("Eliminación exitosa");
        }
        
        return eliminacion;
    }
}
