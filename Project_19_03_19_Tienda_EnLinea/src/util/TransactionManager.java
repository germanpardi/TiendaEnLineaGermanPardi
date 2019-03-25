package util;

import java.sql.Connection;

import dao.CategoriaDAO;
import dao.FacturaDAO;

import dao.PosicionDAO;
import dao.ProductoDAO;
import dao.UsuarioDAO;
import interfaces.ICab_facturaDAO;
import interfaces.ICategoriaDAO;

import interfaces.IPosicionDAO;
import interfaces.IProductoDAO;
import interfaces.IUsuarioDAO;

public class TransactionManager {

	private Connection con;

	public TransactionManager() {
		super();
		this.con = ConexionBBDD.conexion();
	}
	public IProductoDAO getProductoDAO() {
		return new ProductoDAO(con);
	}
	public ICab_facturaDAO getFacturaDAO() {
		return new FacturaDAO(con);
	}
	public IPosicionDAO getPosicionDAO() {
		return new PosicionDAO(con);
	}
	public IUsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO(con);
	}

	public ICategoriaDAO getCategoriaDAO() {
		return new CategoriaDAO(con);
	}

	public void cerrarconexion() {
		ConexionBBDD.desconexion();
	}

}
