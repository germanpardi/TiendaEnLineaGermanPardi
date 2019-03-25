package interfaces;

import java.util.Vector;

import beans.Posicion;

public interface IPosicionSERVICE {
	
	public Vector<Posicion> listarcategorias();
	public Posicion buscarnombre(String id_factura);
	public void borrarnombre(String id_factura);
	public void altausuario(Posicion posicion);
	public void modificarusuario(Posicion posicion);
	
}
