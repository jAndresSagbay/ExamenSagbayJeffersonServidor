package ec.edu.ups.appdis.g1.ExamenSagbayJeffersonServidor1.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

public class Resources {

	//String dsName = "java:comp/DefaultDataSource";
	String dsName = "java:jboss/datasources/productoDS";

    @Produces
    private Connection createConnection() throws SQLException, NamingException {
        InitialContext ic = new InitialContext();
        DataSource ds = (DataSource)ic.lookup(dsName);
        return ds.getConnection();
    }
    
    private void closeConnection(@Disposes Connection conn) throws SQLException {
        conn.close();
    }
    
    @Produces
    @PersistenceContext(name ="ExamenSagbayJeffersonServidor1PersistenceUnit")
    private EntityManager em;
    
    @Produces
	@RequestScoped public FacesContext produceFC() {
    	return FacesContext.getCurrentInstance();
    }
    
    
}

