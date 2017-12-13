package dominio;

import java.util.LinkedList;
import persistencia.*;

/**
 * @version 1.1
 */
public class GestorUsuarios_Admin {

    
    public boolean añadirUsuario(Usuario usuario) {
         LinkedList<Usuario> usuarios= new LinkedList<Usuario>();
        boolean añadir=true;
        
        for (int i=0; i<usuarios.size();i++){
            if(usuario.getNombreUsuario().equals(usuarios.get(i).getNombreUsuario())){
                añadir=false;
            }
        }
        if(añadir==true){
             usuarios.add(usuario);
             return true;
        }else{
            return false;
        }
       
        
  
    }

    
    public boolean eliminarUsuario(int idUsuario) {
        LinkedList<Usuario> usuarios = new LinkedList<Usuario>();
       
        for(int i=0; i<usuarios.size();i++){
            if(idUsuario==usuarios.get(i).getIdUsuario()){
                usuarios.remove(usuarios.get(i));
                return true;
            }
        }
        
        return false;
        
    }

}
