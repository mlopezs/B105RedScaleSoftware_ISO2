package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.Usuario;

/**
 * @version 1.1
 */
public class GestorUsuarios_Admin {

    private final LinkedList<Usuario> bbdd_Usuarios;

    /**
     * Constructor.
     *
     * @param bbddUsuarios
     */
    public GestorUsuarios_Admin(LinkedList<Usuario> bbddUsuarios) {
        this.bbdd_Usuarios = bbddUsuarios;
    }

    /**
     *
     * @param usuario
     * @return
     */
    public boolean añadirUsuario(Usuario usuario) {
        if (usuario.getIdUsuario() < 0) {
            System.out.println("ERROR. El id no puede ser negativo.");
            return false;
        }
        Iterator<Usuario> itUsuarios = bbdd_Usuarios.iterator();
        while (itUsuarios.hasNext()) {
            Usuario auxUsuario = itUsuarios.next();
            if (usuario.getIdUsuario() == auxUsuario.getIdUsuario()) {
                System.out.println("ERROR: El id del usuario "
                        + "ya está registrado.");
                return false;
            }
            if (usuario.getApellidos().equals(auxUsuario.getApellidos())) {
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
        Iterator<Usuario> itUsuarios = bbdd_Usuarios.iterator();
        while (itUsuarios.hasNext()) {
            Usuario auxUsuarios = itUsuarios.next();
            if (auxUsuarios.getIdUsuario() == idUsuario) {
                bbdd_Usuarios.remove(auxUsuarios);
                System.out.println("Usuario eliminado con éxito.");
                return true;
            }
        }
        System.out.println("El usuario no se pudo eliminar.");
        return false;
    }

}
