/**
 * 
 */
package org.perscholas.onetomany;

import java.util.List;

import javax.persistence.Query;

import org.perscholas.models.AbstractService;

/**
 * @author CTStudent
 *
 */
public class TeacherOTMService extends AbstractService{

	public void createTeacherOTM(int id, String name, double salary) {
		TeacherOTM t1 = new TeacherOTM(id, name, salary);
		em.getTransaction().begin();
		em.persist(t1);
		em.getTransaction().commit();
	}
	
	public void createTeacherOTM(int id, String name, double salary, DepartmentOTM dept) {
		TeacherOTM t1 = new TeacherOTM(id, name, salary,dept );
		em.getTransaction().begin();
		em.persist(t1);
		em.getTransaction().commit();
	}
	@SuppressWarnings("unchecked")
	public List<TeacherOTM> getTeacherOTMList(int id) {
		List<TeacherOTM> teach;
		Query query = em.createQuery("Select t from TeacherOTM t where t.id = :id");
		query.setParameter("id", id);
		teach = query.getResultList();
		return teach;
	}

	@SuppressWarnings("unchecked")
	public void showAllTeachers() {
		Query query = em.createQuery("Select t from TeacherOTM t");
		List<TeacherOTM> teach = query.getResultList();
		if(!teach.isEmpty()) {
		for (TeacherOTM t : teach) {
			System.out.println(t);
		}
		}else {
			System.out.println("Sorry there are no teachers");
		}
	}

	
	@SuppressWarnings("unchecked")
	public void searchTeachersById(int id) {
		Query query = em.createQuery("Select t from TeacherOTM t where t.id = :id");
		query.setParameter("id", id);
		List<TeacherOTM> teach = query.getResultList();
		if(!teach.isEmpty()) {
			for (TeacherOTM t : teach) {
				System.out.println(t);
			}
		}else {
			System.out.println("Sorry there is not a teacher with that id");
		}
	}
	
}
