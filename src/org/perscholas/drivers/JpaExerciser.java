/**
 * 
 */
package org.perscholas.drivers;

import org.perscholas.models.AbstractService;
import org.perscholas.models.DepartmentService;
import org.perscholas.models.EmployeeService;
import org.perscholas.models.TeacherService;

/**
 * @author CTStudent
 *
 */
public class JpaExerciser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DepartmentService.searchDeptByState("ohio");
//		
//		EmployeeService.employeeSearchById(3);
//		AbstractService.close();
		JpaExerciser je = new JpaExerciser();
		je.showAll();
		je.showPeepsById(6);
		
		AbstractService.close();
	}
	public void showAll() {
		EmployeeService.showAllEmployee();
		DepartmentService.showAllDepart();
		TeacherService ts = new TeacherService();
		ts.showAllTeachers();
	}
	public void showPeepsById(int id) {
		TeacherService ts = new TeacherService();
		EmployeeService.employeeSearchById(id);
		ts.searchTeachersById(id);
	}
}
