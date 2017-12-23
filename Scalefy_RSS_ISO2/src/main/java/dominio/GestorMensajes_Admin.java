package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.Usuario;

/**
 * @version 1.0
 */
public class GestorMensajes_Admin {

    private final LinkedList<Usuario> bbdd_Usuarios;

    /**
     * Constructor
     *
     * @param bbddUsuarios
     */
    public GestorMensajes_Admin(LinkedList<Usuario> bbddUsuarios) {
        this.bbdd_Usuarios = bbddUsuarios;
    }

    /**
     *
     * @param idUsuario
     * @param mensaje
     * @return
     */
    public boolean enviarMensaje(int idUsuario, String mensaje) {
        Iterator<Usuario> itUsuario = bbdd_Usuarios.iterator();
        if (mensaje == null || mensaje.equals("") || idUsuario < 0) {
            return false;
        }
        while (itUsuario.hasNext()) {
            Usuario auxUsuario = itUsuario.next();
            if (auxUsuario.getIdUsuario() == idUsuario) {
                auxUsuario.getMensajes().add(mensaje);
                System.out.println("Mensaje enviado con éxito a *"
                        + auxUsuario.getNombre()
                        + "*:\n\"" + mensaje + "\".");
                return true;
            }
        }
        System.out.println("El mensaje no pudo ser enviado.");
        return false;
    }

}
