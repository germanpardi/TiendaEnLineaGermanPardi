package services;

import java.util.Vector;


import beans.Producto;
import interfaces.IProductoDAO;
import interfaces.IProductoSERVICE;
import util.TransactionManager;

public class ProductoSERVICE implements IProductoSERVICE {

	@Override
	public void borrarnombre(int id_producto) {
		TransactionManager manager = new TransactionManager();
		IProductoDAO productoDAO = manager.getProductoDAO();
		productoDAO.delete(id_producto);
		manager.cerrarconexion();
		
		

	}

	@Override
	public Vector<Producto> listarcategorias() {
		TransactionManager manager = new TransactionManager();
		IProductoDAO productoDAO = manager.getProductoDAO();
		Vector<Producto> productos = productoDAO.list();
		manager.cerrarconexion();

		return productos;
	}

	@Override
	public Producto buscarnombre(int id_producto) {
		TransactionManager manager = new TransactionManager();
		IProductoDAO productoDAO = manager.getProductoDAO();
		Producto producto = productoDAO.findbyId(id_producto);
		manager.cerrarconexion();
		return producto;
	}

	@Override
	public void altaproducto(Producto producto) {
		TransactionManager manager = new TransactionManager();
		IProductoDAO productoDAO = manager.getProductoDAO();
		productoDAO.add(producto);
		manager.cerrarconexion();
		
	}

	@Override
	public void modificarusuario(Producto producto) {
		TransactionManager manager = new TransactionManager();
		IProductoDAO productoDAO = manager.getProductoDAO();
		productoDAO.save(producto);
		manager.cerrarconexion();
		
	}

	@Override
	public Vector<Producto> listado_productos_por_descripcion(String descripcionCategoria) {
		
		TransactionManager manager = new TransactionManager();
		IProductoDAO productoDAO = manager.getProductoDAO();
		Vector<Producto> productos = productoDAO.list(descripcionCategoria);
		manager.cerrarconexion();

		return productos;
	}}
