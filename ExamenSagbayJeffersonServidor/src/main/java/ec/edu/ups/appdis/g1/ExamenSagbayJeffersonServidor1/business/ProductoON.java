package ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.business;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.dao.ProductoDAO;
import ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.entity.Producto;
import ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.views.ProductoOnRemoto;

@Stateless

public class ProductoON implements ProductoOnRemoto, Serializable{
	
	@Inject
	ProductoDAO productoON;
	
	private List<Producto> productos = new ArrayList<Producto>();

	public boolean registrar(Producto producto) throws SQLException {
		this.productoON.crear(producto);
		return true;

	}
	public List<Producto> getProductos(){
		System.out.println(productos);
		return productos;
	}

	public boolean actualizar(Producto producto) throws SQLException {
		productoON.update(producto);
		return true;

	}
	public boolean buscar(String nombre) throws SQLException {
		productoON.buscarProducto(nombre);
		return true;

	}

}
