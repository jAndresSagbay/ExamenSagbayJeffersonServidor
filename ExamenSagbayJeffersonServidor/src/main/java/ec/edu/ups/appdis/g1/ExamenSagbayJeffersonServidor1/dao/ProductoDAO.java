package ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.entity.Producto;


public class ProductoDAO {
	//Insertar , listar, buscar y editar productos de primera necesidad, desde una aplicación Swing .
	
	@Inject
	private EntityManager em;
	
	public void crear(Producto entity) {
		em.persist(entity);
	}
	
	public void update(Producto producto) {
		em.merge(producto);
	}
	
	public void remove(String nombre) {
		em.remove(this.read(nombre));
	}
	
	public Producto read(String nombre) {
		Producto producto = em.find(Producto.class, nombre);
		return producto;
	}

	
	public Producto buscarProducto(String nombre) {
		String jpql = "SELECT a FROM Producto a JOIN FETCH a where a.nombre = :nombre";
		Query query = em.createQuery(jpql, Producto.class);
		query.setParameter("nombre", nombre);
		Producto producto = (Producto) query.getSingleResult();
		return producto;
	}
	
	public List<Producto> mostrarProductos() {
		String jpql = "SELECT a FROM Producto a";
		Query query = em.createQuery(jpql, Producto.class);
		List<Producto> productos = query.getResultList();
		/*for(Persona persona : personas) {
			persona.getLibros().size();
		}*/
		return productos;
	}

}
