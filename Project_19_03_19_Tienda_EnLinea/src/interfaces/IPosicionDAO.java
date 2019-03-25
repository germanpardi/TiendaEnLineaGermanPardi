package interfaces;

import java.util.Vector;

import beans.Posicion;

public interface IPosicionDAO {

	public Posicion findbyId(String id_factura);

	public void add(Posicion posicion);

	public void save(Posicion posicion);

	public Vector<Posicion> list();

	public void delete(String id_Posicion);

}
