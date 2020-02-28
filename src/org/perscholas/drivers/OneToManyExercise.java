/**
 * 
 */
package org.perscholas.drivers;

import java.util.ArrayList;
import java.util.List;

import org.perscholas.models.AbstractService;
import org.perscholas.onetomany.DepartmentOTMService;
import org.perscholas.onetomany.TeacherOTM;
import org.perscholas.onetomany.TeacherOTMService;

/**
 * @author CTStudent
 *
 */
public class OneToManyExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		OneToManyExercise oTME = new OneToManyExercise();
//		oTME.insert();
//		oTME.test();
		TeacherOTMService tos = new TeacherOTMService();

//		DepartmentOTMService.showAllDepart();
//		tos.showAllTeachers();
//		DepartmentOTMService.searchDeptByState("Hawaii");
		AbstractService.close();
	}


	public void insert() {
		TeacherOTMService tos = new TeacherOTMService();
		tos.createTeacherOTM(1, "Bob", 30000.90);
		tos.createTeacherOTM(2, "jim", 32900.30);
		tos.createTeacherOTM(3, "Tim", 90000.50);
		List<TeacherOTM> te = new ArrayList<TeacherOTM>();
		te.addAll(tos.getTeacherOTMList(1));
		te.addAll(tos.getTeacherOTMList(2));
		te.addAll(tos.getTeacherOTMList(3));
		DepartmentOTMService.createDepartmentOTM(1, "Math", "Hawaii", te);
		
		tos.createTeacherOTM(4, "Jane", 34800.90);
		tos.createTeacherOTM(5, "Doug", 32910.30);
		tos.createTeacherOTM(6, "John", 10000.50);
		List<TeacherOTM> ts = new ArrayList<TeacherOTM>();
		ts.addAll(tos.getTeacherOTMList(4));
		ts.addAll(tos.getTeacherOTMList(5));
		ts.addAll(tos.getTeacherOTMList(6));
		DepartmentOTMService.createDepartmentOTM(2, "Science", "Alaska", ts);
		
	}
	public void test() {
		TeacherOTMService tos = new TeacherOTMService();
		DepartmentOTMService.createDepartmentOTM(4, "Anger", "South Dakota");
		tos.createTeacherOTM(10, "tan", 30000.90, DepartmentOTMService.showDeptById(4));
		tos.createTeacherOTM(11, "jim", 32900.30, DepartmentOTMService.showDeptById(4));
		tos.createTeacherOTM(12, "Tim", 90000.50, DepartmentOTMService.showDeptById(4));

	}

}
