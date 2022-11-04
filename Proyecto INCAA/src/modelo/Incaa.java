package modelo;

import java.util.ArrayList;
import java.util.List;

public class Incaa {
	//atributos
	private List<Pelicula> catalogo = new ArrayList<Pelicula>();

	//constructor
	public Incaa() {
		this.catalogo = new ArrayList<Pelicula>();
	}

	//getter y setter
	public List<Pelicula> getCatalogo() {
		return catalogo;
	}

	
	//metodos
	public boolean agregarPelicula(String pelicula, Genero genero) throws Exception {
		int indice = 0;
		while (indice < catalogo.size()) {
			if (catalogo.get(indice).getPelicula().equals(pelicula)) {
				throw new Exception("ERROR: La pelicula '"+pelicula+"' ya se encuentra en la lista.");
			}
			indice++;
		}
		return catalogo.add(new Pelicula(indice, pelicula, genero));
	}

	public Pelicula traerPelicula(int idPelicula) throws Exception {
		Pelicula p = null;
		int indice = 0;
		while (p==null&&indice < catalogo.size()) {
			if (idPelicula == catalogo.get(indice).getIdPelicula()) {
				p = catalogo.get(indice);
			}
			indice++;
		}
		if (p == null) {
			throw new Exception("La pelicula por 'ID " + idPelicula + "' no se encontró.");
		}
		return p;
	}
	public List<Pelicula> traerPelicula(Genero genero) throws Exception {
		List<Pelicula> peliculasHalladas = new ArrayList<Pelicula>();
		int indice = 0;
		while (indice < catalogo.size()) {
			if (catalogo.get(indice).getGenero()==genero) {
				peliculasHalladas.add(catalogo.get(indice));
			}
			indice++;
		}
		if(peliculasHalladas.size()==0) {
			throw new Exception("ERROR: no se encuentran peliculas del genero '"+genero.getGenero()+"' en el catalogo");
		}
		return peliculasHalladas;
	}
	public List<Pelicula> traerPelicula(String partePelicula) throws Exception{
		List<Pelicula> peliculasHalladas = new ArrayList<Pelicula>();
		int indice=0;
		while(indice<catalogo.size()) {
			if(catalogo.get(indice).getPelicula().toLowerCase().contains(partePelicula.toLowerCase())){
				peliculasHalladas.add(catalogo.get(indice));
			}
			indice++;
		}
		if(peliculasHalladas.size()==0) {
			throw new Exception("ERROR: no se contraron peliculas que contengan '"+partePelicula+ "' en su titulo.");
		}
		return peliculasHalladas;
	}	
	
	public void modificarPelicula(int idPelicula, String pelicula, Genero genero) throws Exception {
		if(traerPelicula(idPelicula)!=null) {
			traerPelicula(idPelicula).setPelicula(pelicula);
			traerPelicula(idPelicula).setGenero(genero);
		}else {
			throw new Exception("ERROR: La pelicula '"+pelicula+"' no se encuentra en el catalogo.");	
		}
	}

	public boolean eliminarPelicula(int idPelicula) throws Exception {
		int indice = 0;
		if (traerPelicula(idPelicula)!=null) {
			indice=idPelicula+1;
			while(indice<catalogo.size()){
				traerPelicula(indice).setIdPelicula(indice-1);
				indice++;
			}
		}else {
			throw new Exception("ERROR: La pelicula con 'ID " + idPelicula + "' no existe en el catalogo.");
		}
		return catalogo.remove(traerPelicula(idPelicula));
	}

	@Override
	public String toString() {
		return "CATALOGO\n" + catalogo.toString();
	}
	
}
