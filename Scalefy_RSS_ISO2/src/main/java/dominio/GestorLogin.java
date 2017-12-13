package dominio;

import java.util.Arrays;

/**
 * @version 1.0
 */
public class GestorLogin {

    
    
    String usuario= "Scalefy";
    char [] contraseña= {'s','o','f','t','w','a','r','e'};
  
    public boolean autenticar(String usuario, char[] contraseña) {
       
        if(usuario.equals(this.usuario) && Arrays.equals(contraseña, this.contraseña)){
            System.out.println("Autenticacion correcta");
            return true;
        }else{
            System.err.println("Usuario o contraseña mal introducido. Pruebe de nuevo");
            
            return false;
        }
        
        
    }

}
