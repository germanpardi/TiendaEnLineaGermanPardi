package interfaces;

import java.util.Vector;

import beans.Factura;

public interface ICab_facturaSERVICE {
	
	public Vector<Factura> listarfacturas();
	public Factura buscarnombre(String id_factura);
	public void borrarnombre(String id_factura);
	public int altausuario(Factura factura);
	public void modificarusuario(Factura factura);
	public int buscarMAX();

}
