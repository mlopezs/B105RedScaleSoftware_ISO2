package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.*;

/**
 *
 * @version 1.0
 */
public class GestorUsuarios {

    private LinkedList<Usuario> bbdd_Usuarios = new LinkedList();

    public boolean anadirUsuario(Usuario usuario) {
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
