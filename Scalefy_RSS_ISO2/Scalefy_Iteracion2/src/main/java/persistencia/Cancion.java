package persistencia;

public class Cancion {

	private int id;
	private String nombre;
	private String artista;
	private int idAlbum;
	private String genero;
	private double duracion;

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