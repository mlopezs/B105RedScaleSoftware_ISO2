package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.*;

/**
 * @version 1.1
 */
public class GestorUsuarios_Admin {

    private final LinkedList<Usuario> bbdd_Usuarios;

    /**
     * Constructor.
     * @param bbdd_Usuarios 
     */
    public GestorUsuarios_Admin(LinkedList<Usuario> bbdd_Usuarios) {
        this.bbdd_Usuarios = bbdd_Usuarios;
    }
    
    /**
     * 
     * @param usuario
     * @return 
     */
    public boolean añadirUsuario(Usuario usuario) {
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

    /**
     * 
     * @param idUsuario
     * @return 
     */
    public boolean eliminarUsuario(int idUsuario) {
        Iterator<Usuario> it = bbdd_Usuarios.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            if(u.getIdUsuario() == idUsuario){
                bbdd_Usuarios.remove(u);
                System.out.println("Usuario eliminado con éxito.");
                return true;
            }
        }
        System.out.println("El usuario no se pudo eliminar.");
        return false;        
    }

}
