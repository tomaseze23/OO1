package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

	private List<Empleado> lstEmpleados;
	private List<Tarea> lstTareas;
	
	public Sistema() {
		lstEmpleados =new ArrayList<Empleado>();
		lstTareas = new ArrayList<Tarea>();
	}

	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}

	public List<Tarea> getLstTareas() {
		return lstTareas;
	}

	@Override
	public String toString() {
		String auxEmpleado="Lista Empleados\n";
		String auxTarea="Lista Tareas\n";
		for (Empleado empleado : lstEmpleados) {
			auxEmpleado = auxEmpleado + empleado.toString() + "\n";
		}
		for (Tarea tarea : lstTareas) {
			auxTarea = auxTarea + tarea.toString() + "\n";
		}
		return auxEmpleado + "\n" + auxTarea;
	}

	public Empleado traerEmpleado(String nroLegajo) {
		int indice=0;
		Empleado empleado=null;
		while(indice<lstEmpleados.size()) {
			if(lstEmpleados.get(indice).getNroLegajo().equals(nroLegajo)) {
				empleado=lstEmpleados.get(indice);
			}
			indice++;
		}
		return empleado;
	}
	
	public Tarea traerTarea(int id) {
		int indice=0;
		Tarea tarea=null;
		while(indice<lstTareas.size()) {
			if(lstTareas.get(indice).getIdTarea()==id) {
				tarea=lstTareas.get(indice);
			}
			indice++;
		}
		return tarea;
	}
	
	public boolean agregarEmpleado(String apellido, String nombre, String nroLegajo, double valorHora) {
		return lstEmpleados.add(new Empleado(apellido, nombre, nroLegajo, valorHora));
	}
	
	public boolean agregarTarea(String tarea, LocalDate fechaInicio, LocalDate fechaFin, 
			Empleado responsable, int cantHorasDiarias, boolean habil) {
		int idTarea=1;
		if(!lstTareas.isEmpty()) {
			idTarea= lstTareas.get(lstTareas.size() - 1).getIdTarea()+1;
		}
		return lstTareas.add(new Tarea(idTarea, tarea, fechaInicio, fechaFin, responsable, cantHorasDiarias, habil));
	}
}
