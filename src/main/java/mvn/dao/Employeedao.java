package mvn.dao;

import java.util.List;

import java.util.logging.ErrorManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import mvn.dto.Employee;

@Repository
public class Employeedao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("m5");
	EntityManager manager =factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void save(Employee employe)
	{
		transaction.begin();
		manager.persist(employe);
		transaction.commit();
	}
	
	public List<Employee> fetchAll()
	{
		return manager.createNativeQuery("select * from employee",Employee.class).getResultList();
	}

	public Employee find(int id) {
		return manager.find(Employee.class, id);
	}

	public void delete(Employee employee) {
		transaction.begin();
		manager.remove(employee);
		transaction.commit();
	}

	public void update(Employee employee) {
		transaction.begin();
		manager.merge(employee);
		transaction.commit();
	}
	
}	
