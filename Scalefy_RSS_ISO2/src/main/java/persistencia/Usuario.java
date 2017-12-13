package persistencia;

import java.util.Queue;

/**
* @version 1.3
*/
public class Usuario {

	private String nombre;
	private String apellidos;
	private String nombreUsuario;
	private String contraseña;
	private int[] cancionesAdquiridas;
	private int[] listasReproduccion;
	private double saldo;
	private Queue<String> mensajes;

	public double getSaldo() {
		return this.saldo;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int[] getCancionesAdquiridas() {
        return cancionesAdquiridas;
    }

    public void setCancionesAdquiridas(int[] cancionesAdquiridas) {
        this.cancionesAdquiridas = cancionesAdquiridas;
    }

    public int[] getListasReproduccion() {
        return listasReproduccion;
    }

    public void setListasReproduccion(int[] listasReproduccion) {
        this.listasReproduccion = listasReproduccion;
    }

    public Queue<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(Queue<String> mensajes) {
        this.mensajes = mensajes;
    }
        

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	/**
	 * Retorna el saldo final.
	 * @param numTarjeta
	 * @param cvvTarjeta
	 * @param saldoDeseado
	 */
	public double añadirSaldo(String numTarjeta, int cvvTarjeta, double saldoDeseado) {
		// TODO - implement Usuario.añadirSaldo
		throw new UnsupportedOperationException();
	}

}