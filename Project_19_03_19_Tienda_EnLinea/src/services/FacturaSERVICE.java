package services;

import java.util.Vector;

import beans.Factura;
import interfaces.ICab_facturaSERVICE;
import interfaces.ICab_facturaDAO;
import util.TransactionManager;

public class FacturaSERVICE implements ICab_facturaSERVICE {

	@Override
	public Vector<Factura> listarfacturas() {
		TransactionManager manager = new TransactionManager();
		ICab_facturaDAO facturaDAO = manager.getFacturaDAO();
		Vector<Factura> facturas = facturaDAO.list();
		manager.cerrarconexion();

		return facturas;
	}

	@Override
	public Factura buscarnombre(String id_factura) {
		TransactionManager manager = new TransactionManager();
		ICab_facturaDAO facturaDAO = manager.getFacturaDAO();
		Factura facturas = facturaDAO.findbyId(id_factura);
		manager.cerrarconexion();

		return facturas;
	}

	@Override
	public void borrarnombre(String id_factura) {
		TransactionManager manager = new TransactionManager();
		ICab_facturaDAO facturaDAO = manager.getFacturaDAO();
		facturaDAO.delete(id_factura);
		manager.cerrarconexion();

	}

	@Override
	public int altausuario(Factura factura) {
		TransactionManager manager = new TransactionManager();
		ICab_facturaDAO facturaDAO = manager.getFacturaDAO();
		facturaDAO.add(factura);
		int id_factura = facturaDAO.findMax();
		manager.cerrarconexion();
		
		return id_factura;

	}

	@Override
	public void modificarusuario(Factura factura) {
		TransactionManager manager = new TransactionManager();
		ICab_facturaDAO facturaDAO = manager.getFacturaDAO();
		facturaDAO.save(factura);
		manager.cerrarconexion();

	}
	
	public int buscarMAX(){
		
		TransactionManager manager = new TransactionManager();
		ICab_facturaDAO facturaDAO = manager.getFacturaDAO();
		int id_factura = facturaDAO.findMax();
		manager.cerrarconexion();
		
		return id_factura;
	}

}
