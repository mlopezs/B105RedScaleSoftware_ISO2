package persistencia;

import java.util.Queue;

/**
 * @version 1.3
 */
public class Usuario {

    private int idUsuario;
    private String nombre;
    private String apellidos;
    private String nombreUsuario;
    private String contraseña;
    private int[] cancionesAdq;
    private int[] listasReprod;
    private double saldo;
    private Queue<String> mensajes;

    public Usuario(int idUsuario, String nombre, String apellidos,
            String nombreUsuario, String contraseña, int[] cancionesAdq,
            int[] listasReprod, double saldo, Queue<String> mensajes) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.cancionesAdq = cancionesAdq;
        this.listasReprod = listasReprod;
        this.saldo = saldo;
        this.mensajes = mensajes;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

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
        return cancionesAdq;
    }

    public void setCancionesAdquiridas(int[] cancionesAdq) {
        this.cancionesAdq = cancionesAdq;
    }

    public int[] getListasReproduccion() {
        return listasReprod;
    }

    public void setListasReproduccion(int[] listasReprod) {
        this.listasReprod = listasReprod;
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
     *
     * @param numTarjeta
     * @param cvvTarjeta
     * @param saldoDeseado
     * @return
     */
    public double añadirSaldo(String numTarjeta,
            int cvvTarjeta, double saldoDeseado) {
        boolean din = comprobarDatosBancarios(numTarjeta,
                cvvTarjeta, saldoDeseado);
        if (din) {
            this.saldo += saldoDeseado;
            return this.saldo;
        }
        return -1;
    }

    /**
     * Se comprueban los datos y se devuelve true si el saldo se cobra.
     *
     * @param numTarjeta
     * @param cvvTarjeta
     * @param saldoDeseado
     * @return
     */
    private boolean comprobarDatosBancarios(String numTarjeta,
            int cvvTarjeta, double saldoDeseado) {
        System.out.printf("Comprobando datos%nTarjeta -> %s%nCVV -> %d%n"
                + "SaldoDeseado -> %.2f euros.", numTarjeta,
                cvvTarjeta, saldoDeseado);
        return true;
    }

}
