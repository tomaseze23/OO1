package datos;

import java.util.Objects;

public abstract class Stock {
	
	protected int idStock;
	protected Producto producto;
	
	public Stock () {}

	public Stock(Producto producto) {
		super();
		this.producto = producto;
	}

	public int getIdStock() {
		return idStock;
	}

	protected void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return idStock == other.idStock;
	}

	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", producto=" + producto + "]";
	}
	
}
