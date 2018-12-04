/**
 * 
 */
package ua.kyiv.time.calc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import ua.kyiv.time.calc.configuratin.HibernateConfig;
import ua.kyiv.time.calc.configuratin.SettingsApplication;
import ua.kyiv.time.calc.entities.Airline;

/**
 * @author firsov
 *
 */
public class AirlineDao {
	
	public void add(Airline airline) {
		try(Session session = HibernateConfig.getSession();) {
			session.beginTransaction();
			session.save(airline);
			SettingsApplication.setObservableAirline(airline);
		}catch(HibernateException ex) {
		    ex.printStackTrace();
		}
	}
	
	public List<Airline> all(){
		List<Airline> result = new ArrayList<>();
		String query = "FROM Airline a";
		try (Session session = HibernateConfig.getSession();){
			session.beginTransaction();
			TypedQuery<Airline> typedQuery = session.createQuery(query, Airline.class);
			result = typedQuery.getResultList();
		}catch(HibernateException ex) {
		    ex.printStackTrace();
		}
		return result;
	}

	public Airline findName(String name) {
		String query = "FROM Airline a WHERE a.name = :name";
		try(Session session = HibernateConfig.getSession();) {
			session.beginTransaction();
			TypedQuery<Airline> typedQuery = session.createQuery(query, Airline.class);
			typedQuery.setParameter("name", name);
			Airline airline = typedQuery.getSingleResult();
			return airline;
		}catch(HibernateException ex) {
		    ex.printStackTrace();
		}catch (NoResultException e) {
			return null;
		}
		return null;
	}

}
