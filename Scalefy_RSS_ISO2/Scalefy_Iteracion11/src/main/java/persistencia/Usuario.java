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