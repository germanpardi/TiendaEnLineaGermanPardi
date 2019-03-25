package interfaces;

import java.util.Vector;

import beans.Factura;

public interface ICab_facturaDAO {
	
	public Factura findbyId(String id_factura);
	public void add(Factura factura);
	public void save(Factura factura); 
	public Vector<Factura> list();
    public void delete(String id_factura);
    public int findMax();
}
