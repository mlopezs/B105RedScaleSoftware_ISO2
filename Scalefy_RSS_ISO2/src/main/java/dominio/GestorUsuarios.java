package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.*;

/**
 *
 * @version 1.0
 */
public class GestorUsuarios {

    private final LinkedList<Usuario> bbdd_Usuarios;

    /**
     * COnstructor.
     * @param bbdd_Usuarios 
     */
    public GestorUsuarios(LinkedList<Usuario> bbdd_Usuarios) {
        this.bbdd_Usuarios = bbdd_Usuarios;
    }   
    
    /**
     * 
     * @param usuario
     * @return 
     */
    public boolean anadirUsuario(Usuario usuario) {
        try{
            if(usuario == null){
                throw new NullPointerException();
            }
        }catch (NullPointerException ex){
            return false;
        }
      
        Iterator<Usuario> it = bbdd_Usuarios.iterator();
        while (it.hasNext()) {
            Usuario u = it.next();
            if (usuario.getIdUsuario() == u.getIdUsuario()) {
                System.out.println("ERROR: El id del usuario ya está registrado.");
                return false;
            }
            if (usuario.getApellidos().equals(u.getApellidos())) {
                System.out.println("ERROR: El apellido ya está registrado.");
                return false;
            }
        }
        bbdd_Usuarios.add(usuario);
        System.out.println("Usuario añadido con éxito:\n" + usuario.toString());        
        return true;
    }

}
