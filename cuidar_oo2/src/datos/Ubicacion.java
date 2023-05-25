package datos;

public class Ubicacion extends Lugar{
	private int idUbicacion;
	private double longitud;
	private double latitud;
	
	public Ubicacion() {}
	
	public Ubicacion(String lugar, double longitud, double latitud) {
		super(lugar);
		this.longitud = longitud;
		this.latitud = latitud;
	}

	public int getIdUbicacion() {
		return idUbicacion;
	}

	protected void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	@Override
	public String toString() {
		return "Ubicacion [idUbicacion=" + idUbicacion + ", longitud=" + longitud + ", latitud=" + latitud + ", lugar="
				+ lugar + "]";
	}
	
	
}
