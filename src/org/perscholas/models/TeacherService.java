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
public class TeacherService extends AbstractService {
	public void createTeacher(int id, String name, double salary, Department deptId) {
		Teacher t1 = new Teacher(id, name, salary, deptId);
		em.getTransaction().begin();
		em.persist(t1);
		em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public void showAllTeachers() {
		Query query = em.createQuery("Select t from Teacher t");
		List<Teacher> teach = query.getResultList();
		for (Teacher t : teach) {
			System.out.println(t);
		}
	}

	@SuppressWarnings("unchecked")
	public void showDepartState(int id) {
		Query query = em.createQuery("Select t from Teacher t where t.id = :id");
		query.setParameter("id", id);
		List<Teacher> teach = query.getResultList();
		if (!teach.isEmpty()) {
			for (Teacher t : teach) {
				System.out.println(t.getState());
			}
		} else {
			System.out.println("Sorry something went wrong with Teacher table or there are no teachers");
		}
	}

	@SuppressWarnings("unchecked")
	public void showDepartName(int id) {
		Query query = em.createQuery("Select t from Teacher t where t.id = :id");
		query.setParameter("id", id);
		List<Teacher> teach = query.getResultList();
		if (!teach.isEmpty()) {
			for (Teacher t : teach) {
				System.out.println(t.getDName());
			}
		} else {
			System.out.println("Sorry not teacher exists with that Id");
		}
	}
	@SuppressWarnings("unchecked")
	public void searchTeachersById(int id) {
		Query query = em.createQuery("Select t from Teacher t where t.id = :id");
		query.setParameter("id", id);
		List<Teacher> teach = query.getResultList();
		if(!teach.isEmpty()) {
			for (Teacher t : teach) {
				System.out.println(t);
			}
		}else {
			System.out.println("Sorry there is not a teacher with that id");
		}
	}
}
