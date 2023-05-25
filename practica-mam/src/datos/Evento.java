package datos;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Evento {
	private long idEvento;
	private String evento;
	private LocalDate fecha;
	private Set<Cliente> clientes;
	
	public Evento() {}
	
	public Evento(String evento, LocalDate fecha) {
		super();
		this.evento = evento;
		this.fecha = fecha;
	}

	public long getIdEvento() {
		return idEvento;
	}

	protected void setIdEvento(long idEvento) {
		this.idEvento = idEvento;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", evento=" + evento + ", fecha=" + fecha + "]";
	}

	public boolean equals(Evento evento) {
		return this.idEvento == evento.getIdEvento();
	}
	
	
}
