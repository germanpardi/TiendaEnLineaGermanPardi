package interfaces;

import java.util.Vector;

import beans.Producto;

public interface IProductoDAO {
	
		public Producto findbyId(int id_producto);
		public void add(Producto producto);
		public void save(Producto producto); 
		public Vector<Producto> list();
	    public void delete(int id_producto);
	    public Vector<Producto> list(String descripcionCategoria);
	    
			
	}


