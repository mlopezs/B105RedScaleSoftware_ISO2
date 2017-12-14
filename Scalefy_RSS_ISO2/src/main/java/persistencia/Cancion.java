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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cancion other = (Cancion) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.idAlbum != other.idAlbum) {
            return false;
        }
        if (Double.doubleToLongBits(this.duracion) != Double.doubleToLongBits(other.duracion)) {
            return false;
        }
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        if ((this.artista == null) ? (other.artista != null) : !this.artista.equals(other.artista)) {
            return false;
        }
        if ((this.genero == null) ? (other.genero != null) : !this.genero.equals(other.genero)) {
            return false;
        }
        return true;
    }
        
        

}