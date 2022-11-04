package modelo;

public class ItemCarrito {
	private int idItem;
	private Producto producto;
	private int cantidad;

	public ItemCarrito(int idItem, Producto producto, int cantidad) {
		this.idItem = idItem;
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float calcularSubTotal() {
		return producto.getPrecio()*cantidad;
	}
	@Override
	public String toString() {
		return "[ID item=" + idItem + " Producto:" + producto.getProducto() + " Cantidad: " + cantidad + "]";
	}

}
