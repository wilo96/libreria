package utilidades;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class resources {
	 
	@Produces
	@PersistenceContext
	private EntityManager em;
}
