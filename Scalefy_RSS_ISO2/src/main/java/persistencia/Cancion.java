package persistencia;

/**
* @version 1.0
*/
public class Cancion {

	private int id;
	private String nombre;
	private String artista;
	private int idAlbum;
	private String genero;
	private double duracion;

    public Cancion(int id, String nombre, String artista, int idAlbum, String genero, double duracion) {
        this.id = id;
        this.nombre = nombre;
        this.artista = artista;
        this.idAlbum = idAlbum;
        this.genero = genero;
        this.duracion = duracion;
    }

	public int getId() {
		return this.id;
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

}