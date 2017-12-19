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
     * @param bbdd_Usuarios 
     */
    public GestorLogin(LinkedList<Usuario> bbdd_Usuarios) {
        this.bbdd_Usuarios = bbdd_Usuarios;
    }
    
    /**
     * 
     * @param usuario
     * @param contraseña
     * @return 
     */
    public boolean autenticar(String usuario, char[] contraseña) {
       
        Iterator<Usuario> it = bbdd_Usuarios.iterator();
        while(it.hasNext()){
            Usuario u = it.next();
            if(u.getNombreUsuario().equals(usuario)){
                if(compararContraseña(u.getContraseña().toCharArray(), contraseña)){
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
     * @param a
     * @param b
     * @return 
     */
    private boolean compararContraseña(char[] a, char[] b) {
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }

}
