package dominio;

import java.util.LinkedList;
import persistencia.*;

/**
 * 
 * @version 1.0
 */
public class GestorUsuarios {

    
    public boolean anadirUsuario(Usuario usuario) {
        
        LinkedList<Usuario> usuarios= new LinkedList<Usuario>();
        boolean añadir=true;
        
        for (int i=0; i<usuarios.size();i++){
            if(usuario.getNombreUsuario().equals(usuarios.get(i).getNombreUsuario())){
                añadir=false;
            }
        }
        if(añadir==true){
             usuarios.add(usuario);
        }else{
            return false;
        }
       
        
        return true;
    }

}