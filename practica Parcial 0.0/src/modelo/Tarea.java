package modelo;

import java.time.LocalDate;
import java.util.Objects;

public class Tarea {
	private int idTarea;
	private String tarea;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Empleado responsable;
	private int cantHorasDiarias;
	private boolean habil;
	public Tarea(int idTarea, String tarea, LocalDate fechaInicio, LocalDate fechaFin, Empleado responsable,
			int cantHorasDiarias, boolean habil) {
		this.idTarea = idTarea;
		this.tarea = tarea;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.responsable = responsable;
		this.cantHorasDiarias = cantHorasDiarias;
		this.habil = habil;
	}
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	public String getTarea() {
		return tarea;
	}
	public void setTarea(String tarea) {
		this.tarea = tarea;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Empleado getResponsable() {
		return responsable;
	}
	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
	}
	public int getCantHorasDiarias() {
		return cantHorasDiarias;
	}
	public void setCantHorasDiarias(int cantHorasDiarias) {
		this.cantHorasDiarias = cantHorasDiarias;
	}
	public boolean isHabil() {
		return habil;
	}
	public void setHabil(boolean habil) {
		this.habil = habil;
	}
	@Override
	public String toString() {
		return "ID Tarea: " + idTarea + " Nombre de Tarea: " + tarea + "\nFecha de Inicio: " + Funciones.traerFechaCorta(fechaInicio) 
		+ " Fecha de Fin: " + Funciones.traerFechaCorta(fechaFin) + "\nResponsable: " + responsable.getNombre() + " " 
		+ responsable.getApellido() + " Cantidad de Horas Diarias: " + cantHorasDiarias + " HABIL: " + habil;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cantHorasDiarias, fechaFin, fechaInicio, habil, idTarea, responsable, tarea);
	}
	public boolean equals(Tarea tarea) {
		return tarea.getIdTarea()== this.idTarea;
	}
	
	public double calcularJornal() {
		double jornal=0;
		if(habil) {
			jornal=cantHorasDiarias*responsable.getValorHora();
		}else {
			jornal=cantHorasDiarias*responsable.getValorHora()*1.5;
		}
		return jornal;
	}

	public int calcularCantDiasTrabajados(int mes, int anio) {
		int diasTrabajados=0;
		LocalDate fechaAux=fechaInicio;
		boolean chequeoMes=(mes>=fechaInicio.getMonthValue()&&mes<=fechaFin.getMonthValue());
		boolean chequeoAnio=(anio>=fechaInicio.getYear()&&anio<=fechaFin.getYear());
		while(fechaAux.isBefore(fechaFin.plusDays(1))&&chequeoMes&&chequeoAnio) {
			if(habil&&Funciones.esDiaHabil(fechaAux)&&fechaAux.getMonthValue()==mes) {
				diasTrabajados++;
			}
			if(!habil&&!Funciones.esDiaHabil(fechaAux)&&fechaAux.getMonthValue()==mes) {
				diasTrabajados++;
			}
			fechaAux=fechaAux.plusDays(1);
		}
		return diasTrabajados;
	}
	
	public double calcularHonorarios(int mes, int anio) {
		return calcularCantDiasTrabajados(mes, anio)*calcularJornal();
	}
}
