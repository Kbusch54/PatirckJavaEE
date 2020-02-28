/**
 * 
 */
package org.perscholas.models;

import java.util.List;

import javax.persistence.Query;

/**
 * @author CTStudent
 *
 */
public class EmployeeService extends AbstractService {
	public static void createEmployee(int id, String firstName, String lastName, String email, String jobDesc) {
		Employee e1 = new Employee(id, firstName, lastName, email, jobDesc);
		em.getTransaction().begin();
		em.persist(e1);
		em.getTransaction().commit();
	}

	public static void employeeSearchById(int x) {
		Query query = em.createQuery("Select e from Employee e where e.employeeNumber = :id");
		query.setParameter("id", x);
		@SuppressWarnings("unchecked")
		List<Employee> employees = query.getResultList();
		if (!employees.isEmpty()) {
			for (Employee e : employees) {
				System.out.println(e.toString());
			}
		} else {
			System.out.println("Sorry that id does not match any employee in our system");
		}
	}

	public static void showAllEmployee() {
		Query query = em.createNamedQuery("Show all Employees");
		@SuppressWarnings("unchecked")
		List<Employee> emp = query.getResultList();
		if (!emp.isEmpty()) {
			for (Employee e : emp) {
				System.out.println(e);
			}
		} else {
			System.out.println("Sorry something has gone wrong cannot acces department");
		}
	}
}
