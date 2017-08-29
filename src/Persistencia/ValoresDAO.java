package Persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Negocio.Valores;

import java.util.List;

public class ValoresDAO {
	    
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernate");
	    EntityManager entityManager = factory.createEntityManager();
	    
	    public ValoresDAO() {
	    	factory = Persistence.createEntityManagerFactory("crudHibernate");
		    entityManager = factory.createEntityManager();
	    
	    }
	    
	
	
	    public void salvar(Valores item) {
	        try {
	                 entityManager.getTransaction().begin();
	                 entityManager.merge(item);
	                 entityManager.getTransaction().commit();
	                // entityManager.close();
	        } catch (Exception ex) {
	                 ex.printStackTrace();
	                 entityManager.getTransaction().rollback();
	        }
	   }
	    public void Remover(int id) {
	    	try {
	    		Valores v = new Valores (id);
                entityManager.getTransaction().begin();
                                  
                v = entityManager.find(v.getClass(), v.getIdvalores());
                entityManager.remove(v);
               
                entityManager.getTransaction().commit();
                //entityManager.close();
		       } catch (Exception ex) {
		                ex.printStackTrace();
		                entityManager.getTransaction().rollback();
		       }
	    }
	    
	    @SuppressWarnings("unchecked")
	    public List<Valores> ConsultarTodos() {
	    	List<Valores> Valores = null;
	    	try {
                entityManager.getTransaction().begin();
                Query consulta = entityManager.createQuery("from Valores valores");
                Valores = consulta.getResultList();
                entityManager.getTransaction().commit();
                //entityManager.close();
		       } catch (Exception ex) {
		                ex.printStackTrace();
		                entityManager.getTransaction().rollback();
		       }
	    	
	    	return Valores;
	    }
	    
	    public Valores ConsultarPeloId(int id) {
	    	Valores item = null;
	    	try {
                entityManager.getTransaction().begin();
                Query consulta = entityManager.createQuery("select item from Item item where item.id = :id");
                consulta.setParameter("id", id);
				item = (Valores) consulta.getSingleResult();
                entityManager.getTransaction().commit();
                entityManager.close();
		       } catch (Exception ex) {
		                ex.printStackTrace();
		                entityManager.getTransaction().rollback();
		       }
	    	
	    	return item;
	    }
	    
	    
}