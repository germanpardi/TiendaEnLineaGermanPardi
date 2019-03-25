package beans;

public class Producto {
	protected int id_producto;
	protected int idCategorias;
	protected String descripcion;
	protected double precio;
	protected int stock;
	public Producto() {
		super();
	}
	public Producto(int id_producto, int idCategorias, String descripcion, double precio, int stock) {
		super();
		this.id_producto = id_producto;
		this.idCategorias = idCategorias;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", idCategorias=" + idCategorias + ", descripcion="
				+ descripcion + ", precio=" + precio + ", stock=" + stock + "]";
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public int getIdCategorias() {
		return idCategorias;
	}
	public void setIdCategorias(int idCategorias) {
		this.idCategorias = idCategorias;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	

}
