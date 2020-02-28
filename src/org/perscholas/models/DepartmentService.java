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
public class DepartmentService extends AbstractService {

	public static Department createDepartment(String name, String state) {
		Department d1 = new Department(name, state);
		em.getTransaction().begin();
		em.persist(d1);
		em.getTransaction().commit();
		return d1;
	}

	@SuppressWarnings("unchecked")
	public static void searchDeptByState(String state) {
		Query query = em.createNamedQuery("Find by State");
		query.setParameter("state", state);
		List<Department> depart = query.getResultList();
		if (!depart.isEmpty()) {
			for (Department department : depart) {
				System.out.println(department.toString());
			}
		} else {
			System.out.println("Sorry there is no department in that state");
		}
	}

	public static void showAllDepart() {
		Query query = em.createNamedQuery("Find all Department");
		@SuppressWarnings("unchecked")
		List<Department> dept = query.getResultList();
		if (!dept.isEmpty()) {
			for (Department d : dept) {
				System.out.println(d);
			}
		} else {
			System.out.println("Sorry something has gone wrong cannot acces department");
		}

	}
	public static List<Department> showAllDepartList() {
		Query query = em.createNamedQuery("Find all Department");
		@SuppressWarnings("unchecked")
		List<Department> dept = query.getResultList();
		if (dept.isEmpty()) {
			System.out.println("Sorry something has gone wrong cannot acces department");
		}
		return dept;

	}

}
