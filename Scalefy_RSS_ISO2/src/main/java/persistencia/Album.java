package persistencia;

/**
 * @version 1.0
 */
public class Album {

    private int idAlbum;
    private String nombre;
    private int[] canciones;

    public Album(int idAlbum, String nombre, int[] canciones) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.canciones = canciones;
    }

    public int getId() {
        return this.idAlbum;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int[] getCanciones() {
        return canciones;
    }

    public void setCanciones(int[] canciones) {
        this.canciones = canciones;
    }

}
