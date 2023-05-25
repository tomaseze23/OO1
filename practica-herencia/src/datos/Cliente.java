package datos;

public abstract class Cliente {
	protected int idCliente;
	protected String nroCliente;
	
	public Cliente() {}
	
	public Cliente(String nroCliente) {
		super();
		this.nroCliente = nroCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nroCliente=" + nroCliente + "]";
	}
	
	
}
