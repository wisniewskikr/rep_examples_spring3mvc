package pl.kwi.db.spring;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract class for daos using hibernate template. It implements methods of
 * CRUD.
 * 
 * @author Krzysztof Wisniewski
 * 
 * @param <T>
 *            object implements Serializable
 */
public class AbstractDao<T extends Serializable> {

	
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	
	/**
	 * Method indicates what entity is handled by this Dao.
	 * 
	 * @param clazzToSet object <code>Class</code> with class of entity
	 * which is handled by this Dao
	 */
	public void setClazz(final Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}
	

	/**
	 * Method implements one of CRUD actions - Create. It creates
	 * entity in database
	 * 
	 * @param entity object which should be created in database
	 */
	public void create(final T entity) {
		sessionFactory.getCurrentSession().persist(entity);
	}

	/**
	 * Method implements one of CRUD actions - Read. It gets entity from
	 * database with specified id.
	 * 
	 * @param id
	 *            object <code>Long</code> with id of entity which should be get
	 *            from database
	 * @return entity from database with specified id
	 */
	@SuppressWarnings("unchecked")
	public T read(final Long id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	/**
	 * Method implements one of CRUD actions - Update. It updates
	 * entity in database.
	 * 
	 * @param entity object which should be updated in database
	 */
	public void update(final T entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}

	/**
	 * Method implements one of CRUD actions - Delete. It deletes
	 * entity from database.
	 * 
	 * @param entity object which should be deleted from database
	 */
	public void delete(final T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	/**
	 * Method implements one of CRUD actions - Delete. It deletes
	 * entity with specified id from database.
	 * 
	 * @param id object <code>Long</code> with id of entity which 
	 * should be deleted from database
	 */
	public void deleteById(final Long id) {
		final T entity = read(id);
		delete(entity);
	}

	/**
	 * Method gets all entities from database.
	 * 
	 * @return list of all entities from database 
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String query = "from " + clazz.getName();
		Query hibQuery = sessionFactory.getCurrentSession().createQuery(query);
		return hibQuery.list();
	}

}
