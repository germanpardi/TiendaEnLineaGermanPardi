package services;

import java.util.Vector;

import beans.Factura;
import beans.Posicion;
import interfaces.IPosicionSERVICE;
import interfaces.ICab_facturaDAO;
import interfaces.IPosicionDAO;
import util.TransactionManager;

public class PosicionSERVICE implements IPosicionSERVICE {

	@Override
	public Vector<Posicion> listarcategorias() {
		TransactionManager manager = new TransactionManager();
		IPosicionDAO posicionDAO = manager.getPosicionDAO();
		Vector<Posicion> posiciones = posicionDAO.list();
		manager.cerrarconexion();

		return posiciones;
		
	}

	@Override
	public Posicion buscarnombre(String id_factura) {
		return null;
		
	}

	@Override
	public void borrarnombre(String id_factura) {
		TransactionManager manager = new TransactionManager();
		IPosicionDAO PosicionDAO = manager.getPosicionDAO();
		PosicionDAO.delete(id_factura);
		manager.cerrarconexion();
		
	}

	@Override
	public void altausuario(Posicion posicion) {
		TransactionManager manager = new TransactionManager();
		IPosicionDAO PosicionDAO = manager.getPosicionDAO();
		PosicionDAO.add(posicion);
		manager.cerrarconexion();
		
	}

	@Override
	public void modificarusuario(Posicion posicion) {
		
	}

}
