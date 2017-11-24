package persistencia;

public class Album {

	private int id;
	private String nombre;
	private int[] canciones;

	public int getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public int[] getCanciones(){
		return this.canciones;
	}

}