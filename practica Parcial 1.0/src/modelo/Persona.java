package modelo;

public abstract class Persona {
	protected int id;
	protected String apellido;
	protected String nombre;
	protected int dni;

	public Persona(int id, String apellido, String nombre, int dni) {
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "ID Persona: " + id + " Nombre: " + apellido + ", " + nombre + " DNI:" + dni;
	}

	public boolean equals(Persona persona) {
		return id == persona.getId();
	}

}
