package persistencia;

/**
 * @version 1.0
 */
public class Cancion {

    private int idCancion;
    private String nombre;
    private String artista;
    private int idAlbum;
    private String genero;
    private double duracion;

    public Cancion(int idCancion, String nombre, String artista,
            int idAlbum, String genero, double duracion) {
        this.idCancion = idCancion;
        this.nombre = nombre;
        this.artista = artista;
        this.idAlbum = idAlbum;
        this.genero = genero;
        this.duracion = duracion;
    }

    public int getId() {
        return this.idCancion;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getArtista() {
        return this.artista;
    }

    public int getIdAlbum() {
        return this.idAlbum;
    }

    public double getDuracion() {
        return this.duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean equals(Cancion cancion1, Cancion cancion2) {

        return cancion1.getId() == cancion2.getId()
                && cancion1.getNombre().equals(cancion2.getNombre());
    }
}
