package ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.test;

import java.sql.SQLException;

import ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.business.ProductoON;
import ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.entity.Producto;

public class Principal {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ProductoON on= new ProductoON();
		Producto p= new Producto();
		p.setId(3);
		p.setNombre("leche");
		p.setDescripcion("Alimento");
		System.out.println(p.toString());
		on.registrar(p);

	}

}
