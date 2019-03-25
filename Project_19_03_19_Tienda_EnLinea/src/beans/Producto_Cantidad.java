package beans;

public class Producto_Cantidad extends Producto {
	
	protected int cantidad;

	public Producto_Cantidad(int id_producto, int idCategorias, String descripcion, double precio, int stock,
			int cantidad) {
		super(id_producto, idCategorias, descripcion, precio, stock);
		this.cantidad = cantidad;
	}

	public Producto_Cantidad() {
		super();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public double totalPrecio(int cantidad, double precio) {
		return cantidad*precio;
	}
	
	

}
