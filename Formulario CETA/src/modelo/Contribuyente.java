package modelo;

public class Contribuyente {
	private int idContribuyente;
	private String nombre;
	private String apellido;
	private long dni;
	private char sexo;
	private String cuil;

	public Contribuyente(int idContribuyente, String nombre, String apellido, long dni, char sexo, String cuil) {
		this.idContribuyente = idContribuyente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		setSexo(sexo);
		setCuil(cuil);
	}
	
	public int getIdContribuyente() {
		return idContribuyente;
	}

	public void setIdContribuyente(int idContribuyente) {
		this.idContribuyente = idContribuyente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		if (validarSexo(sexo)) {
			this.sexo = sexo;
		} else {
			System.out.println("La letra no corrresponde a ningún sexo.");
		}
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		try {
			if (validarCuil(cuil)) {
				this.cuil = cuil;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "ID Contribuyente: " + idContribuyente + " Nombre: " + nombre + " "+ apellido + " DNI: " + dni + " Sexo: "
				+ sexo + " CUIL: " + cuil;
	}

	public boolean equals(Contribuyente c) {
		return (c.getCuil().equals(cuil));
	}

	public boolean validarSexo(char sexo) {
		return (Character.toUpperCase(sexo) == 'M' || Character.toUpperCase(sexo) == 'F');
	}

	public boolean validarCuil(String cuil) throws Exception {
		boolean esValido = false;
		String parte = cuil.replaceAll("-", "");
		int[] cadenaProductos = new int[] { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };
		int numeroSexo = Integer.parseInt(cuil.substring(0, 2));
		if ((numeroSexo == 20 && sexo == 'M') || (numeroSexo == 27 && sexo == 'F') || (numeroSexo == 23)) {
			int acumulador = 0;
			for (int n = 0; n < 10; n++) {
				acumulador = acumulador + ((Character.getNumericValue(parte.charAt(n))) * cadenaProductos[n]);
			}
			int ultimoDigito = acumulador % 11;
			switch (ultimoDigito) {
			case 0:
				ultimoDigito = 0;
				break;
			case 1:
				if (sexo == 'F') {
					ultimoDigito = 4;
				} else {
					ultimoDigito = 9;
				}
				break;
			default:
				ultimoDigito = 11 - ultimoDigito;
			}

			esValido = ultimoDigito == Character.getNumericValue(cuil.charAt(12));
		}
		if (!esValido)
			throw new Exception("ERROR: CUIL inválido");
		return esValido;

	}
}
