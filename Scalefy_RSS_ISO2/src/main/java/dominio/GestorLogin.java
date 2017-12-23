package dominio;

import java.util.Iterator;
import java.util.LinkedList;
import persistencia.Usuario;

/**
 * @version 1.0
 */
public class GestorLogin {

    private final LinkedList<Usuario> bbdd_Usuarios;

    /**
     * Constructor.
     *
     * @param bbddUsuarios
     */
    public GestorLogin(LinkedList<Usuario> bbddUsuarios) {
        this.bbdd_Usuarios = bbddUsuarios;
    }

    /**
     *
     * @param usuario
     * @param contraseña
     * @return
     */
    public boolean autenticar(String usuario, char[] contraseña) {

        Iterator<Usuario> itUsuario = bbdd_Usuarios.iterator();
        while (itUsuario.hasNext()) {
            Usuario auxUsuario = itUsuario.next();
            if (auxUsuario.getNombreUsuario().equals(usuario)) {
                if (compararContraseña(auxUsuario.getContraseña().toCharArray(),
                         contraseña)) {
                    System.out.println("Autenticación correcta.");
                    return true;
                }
                System.out.println("Contraseña incorrecta.");
                return false;
            }
        }
        System.out.println("Autenticación fallida.");
        return false;
    }

    /**
     *
     * @param password1
     * @param password2
     * @return
     */
    private boolean compararContraseña(char[] password1, char[] password2) {
        for (int i = 0; i < password1.length; i++) {
            if (password1[i] != password2[i]) {
                return false;
            }
        }
        return true;
    }

}
