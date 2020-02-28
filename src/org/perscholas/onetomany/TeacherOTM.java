/**
 * 
 */
package org.perscholas.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author CTStudent
 *
 */
@Entity

public class TeacherOTM {
	@Id
	private int id;
	private String name;
	private double salary;
	/**
	 * @param id
	 * @param name
	 * @param salary
	 */
	@ManyToOne
	private DepartmentOTM dept;
	public TeacherOTM(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param salary
	 * @param dept
	 */
	public TeacherOTM(int id, String name, double salary, DepartmentOTM dept) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

	/**
	 * 
	 */
	public TeacherOTM() {
		super();
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the dept
	 */
	public DepartmentOTM getDept() {
		return dept;
	}

	/**
	 * @param dept the dept to set
	 */
	public void setDept(DepartmentOTM dept) {
		this.dept = dept;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dept == null) ? 0 : dept.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherOTM other = (TeacherOTM) obj;
		if (dept == null) {
			if (other.dept != null)
				return false;
		} else if (!dept.equals(other.dept))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TeacherOTM [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept.getName() + "]";
	}
	
	

}
