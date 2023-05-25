package negocio;

import java.time.LocalDate;

import dao.EspacioDao;
import datos.Aula;
import datos.Funciones;
import datos.Espacio;
public class EspacioABM {

	EspacioDao dao = new EspacioDao();
	
	//CU 3
	public Espacio traer(LocalDate fecha, char turno, Aula aula) {
		return dao.traer(fecha, turno, aula);
	}
	
	//CU 4
	
	public int agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception {
		if(dao.traer(fecha, turno, aula) != null) {
			throw new Exception("ERROR: el objeto ya existe en la BD.");
		}
		return dao.agregar(new Espacio(fecha, turno, aula, libre));
	}
	
	// CU 5
	public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) throws Exception {		
		int ultimoDiaMes = Funciones.traerCantDiasDeUnMes(anio, mes); // Calculo el ultimo dia del mes		
		
		LocalDate fechaInicio = LocalDate.of(anio, mes, 1); // Genero la fechaInicio con los parametros
		LocalDate fechaFin = LocalDate.of(anio, mes, ultimoDiaMes); // Genero el ultimo dia que funcionara como rompedor del while
		
		// Condicion: se itera MIENTRAS la fechaInicio sea menor o igual (generado con el plusDays(1)) a fechaFin
		while(fechaInicio.isBefore(fechaFin.plusDays(1))) {			
			try {
				this.agregar(fechaInicio, turno, aula, true);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} // Agregar el espacio en la iteracion que corresponda
			
			fechaInicio = fechaInicio.plusDays(1); // Funciona como index ++  1, 2, 3, 4, 5 ...	
		}		
	}
}
