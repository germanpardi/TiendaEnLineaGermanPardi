package interfaces;

import java.util.Vector;

import beans.Categoria;
import beans.Producto;

public interface IProductoSERVICE {
	
	public Vector<Producto> listarcategorias();
	public Producto buscarnombre(int id_producto);
	public void borrarnombre(int id_producto);
	public void altaproducto(Producto producto);
	public void modificarusuario(Producto producto);
	public Vector<Producto> listado_productos_por_descripcion(String descripcionCategoria);
	


}
