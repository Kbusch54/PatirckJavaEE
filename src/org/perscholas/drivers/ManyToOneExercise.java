/**
 * 
 */
package org.perscholas.drivers;

import org.perscholas.models.AbstractService;
import org.perscholas.models.TeacherService;

/**
 * @author CTStudent
 *
 */
public class ManyToOneExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TeacherService ts = new TeacherService();
		ts.showAllTeachers();
		ts.showDepartState(2);
		ts.showDepartName(2);
		AbstractService.close();

	}
	

}
