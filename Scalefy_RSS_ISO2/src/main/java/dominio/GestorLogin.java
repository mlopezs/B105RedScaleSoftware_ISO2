package dominio;

import java.util.Arrays;

/**
 * @version 1.0
 */
public class GestorLogin {

    String usuario= "Scalefy";
    char [] contraseña= {'s','o','f','t','w','a','r','e'};
  
    /**
     * 
     * @param usuario
     * @param contraseña
     * @return 
     */
    public boolean autenticar(String usuario, char[] contraseña) {
       
        if(usuario.equals(this.usuario) && Arrays.equals(contraseña, this.contraseña)){
            System.out.println("Autenticacion correcta.");
            return true;
        }else{
            System.out.println("Usuario o contraseña mal introducido. Pruebe de nuevo.");
            return false;
        }
        
        
    }

}
