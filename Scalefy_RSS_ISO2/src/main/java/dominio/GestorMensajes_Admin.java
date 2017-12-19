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
     * @param bbdd_Usuarios 
     */
    public GestorMensajes_Admin(LinkedList<Usuario> bbdd_Usuarios) {
        this.bbdd_Usuarios = bbdd_Usuarios;
    }
    
    /**
     * 
     * @param idUsuario
     * @param mensaje
     * @return 
     */
    public boolean enviarMensaje(int idUsuario, String mensaje) {
        Iterator<Usuario> it = bbdd_Usuarios.iterator();
        if(mensaje == null || mensaje.equals("") || idUsuario < 0){
            return false;
        }
        while(it.hasNext()){
            Usuario u = it.next();
            if(u.getIdUsuario() == idUsuario){
                u.getMensajes().add(mensaje);
                System.out.println("Mensaje enviado con éxito a *" + u.getNombre() + 
                        "*:\n\"" + mensaje + "\".");
                return true;
            }
        }
        System.out.println("El mensaje no pudo ser enviado.");
        return false;
    }

}
