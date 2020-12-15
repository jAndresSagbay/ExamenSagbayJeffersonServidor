package ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.views;


import java.sql.SQLException;
import java.util.List;

import javax.ejb.Remote;

import ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.entity.Producto;

@Remote
public interface ProductoOnRemoto {
	public boolean registrar(Producto producto)throws SQLException ;
	public List<Producto> getProductos()throws SQLException;

	public boolean actualizar(Producto producto)throws SQLException;
	public boolean buscar(String nombre)throws SQLException;

}
