/**
 * 
 */
package org.perscholas.onetomany;

import java.util.List;

import javax.persistence.Query;

import org.perscholas.models.AbstractService;
import org.perscholas.models.Teacher;


/**
 * @author CTStudent
 *
 */
public class DepartmentOTMService extends AbstractService{

	public static DepartmentOTM createDepartmentOTM(int id, String name, String state, List<TeacherOTM> teach) {
		DepartmentOTM d1 = new DepartmentOTM(id, name, state, teach);
		em.getTransaction().begin();
		em.persist(d1);
		em.getTransaction().commit();
		return d1;
	}
	public static DepartmentOTM createDepartmentOTM(int id, String name, String state) {
		DepartmentOTM d1 = new DepartmentOTM(id, name, state);
		em.getTransaction().begin();
		em.persist(d1);
		em.getTransaction().commit();
		return d1;
	}

	@SuppressWarnings("unchecked")
	public static void searchDeptByState(String state) {
		Query query = em.createQuery("Select d from DepartmentOTM d where d.state = :state");
		query.setParameter("state", state);
		List<DepartmentOTM> depart = query.getResultList();
		if (!depart.isEmpty()) {
			for (DepartmentOTM department : depart) {
				System.out.println(department.toString());
			}
		} else {
			System.out.println("Sorry there is no department in that state");
		}
	}

	public static void showAllDepart() {
		Query query = em.createQuery("Select d from DepartmentOTM d");
		@SuppressWarnings("unchecked")
		List<DepartmentOTM> dept = query.getResultList();
		List<TeacherOTM> teach;
		if (!dept.isEmpty()) {
			for (DepartmentOTM d : dept) {
				System.out.println(d);
			}
		} else {
			System.out.println("Sorry something has gone wrong cannot acces department");
		}

	}
	public static List<DepartmentOTM> showAllDepartList() {
		Query query = em.createQuery("Select d from DepartmentOTM d");
		@SuppressWarnings("unchecked")
		List<DepartmentOTM> dept = query.getResultList();
		if (dept.isEmpty()) {
			System.out.println("Sorry something has gone wrong cannot acces department");
		}
		return dept;

	}
	@SuppressWarnings("unchecked")
	public void showTeachersDept(int id) {
		Query query = em.createQuery("Select t from DepartmentOTM t where t.deptId = :id");
		query.setParameter("id", id);
		List<DepartmentOTM> depart = query.getResultList();
		if (!depart.isEmpty()) {
			for (DepartmentOTM t : depart) {
				List<TeacherOTM> teach = t.getTeachList();
				for (TeacherOTM d : teach) {
					System.out.println(d);
				}
				
			}
		} else {
			System.out.println("Sorry something went wrong with Department table or there are no departments");
		}
	}
		public static DepartmentOTM showDeptById(int id) {
			Object dept;
			Query query = em.createQuery("Select d from DepartmentOTM d where d.deptId = :id");
			query.setParameter("id", id);
			dept = query.getSingleResult();
			return (DepartmentOTM) dept;
			
		}
	}

//	@SuppressWarnings("unchecked")
//	public void showDepartName(int id) {
//		Query query = em.createQuery("Select t from TeacherOTM t where t.id = :id");
//		query.setParameter("id", id);
//		List<TeacherOTM> teach = query.getResultList();
//		if (!teach.isEmpty()) {
//			for (TeacherOTM t : teach) {
//				System.out.println(t.getDName());
//			}
//		} else {
//			System.out.println("Sorry not teacher exists with that Id");
//		}
//	}

