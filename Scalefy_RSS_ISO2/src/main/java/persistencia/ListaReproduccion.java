package persistencia;

/**
 * @version 1.0
 */
public class ListaReproduccion {

    private int idListaReprod;
    private String nombre;
    private int idUsuario;
    private int[] canciones;

    public ListaReproduccion(int idListaReprod, String nombre,
            int idUsuario, int[] canciones) {
        this.idListaReprod = idListaReprod;
        this.nombre = nombre;
        this.idUsuario = idUsuario;
        this.canciones = canciones;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public int[] getCanciones() {
        return this.canciones;
    }

    public int getId() {
        return this.idListaReprod;
    }

    public void setCanciones(int[] canciones) {
        this.canciones = canciones;
    }

}
