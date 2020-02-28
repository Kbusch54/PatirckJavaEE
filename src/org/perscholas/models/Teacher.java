/**
 * 
 */
package org.perscholas.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import org.perscholas.onetoone.Credentials;

/**
 * @author CTStudent
 *
 */
@Entity
public class Teacher {
	@Id
	private int id;
	
	@OneToOne(optional=false)
	@MapsId
	private Credentials credentials;
	private String name;
	private double salary;
	
	@ManyToOne
	private Department department;

	/**
	 * @param id
	 * @param name
	 * @param salary
	 * @param department
	 */
	
	public Teacher(int id, String name, double salary, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	/**
	 * 
	 */
	public Teacher() {
		super();
	}
	
	/**
	 * @param id
	 * @param credentials
	 * @param name
	 * @param salary
	 * @param department
	 */
//	public Teacher(int id, Credentials credentials, String name, double salary, Department department) {
//		super();
//		this.id = id;
//		this.credentials = credentials;
//		this.name = name;
//		this.salary = salary;
//		this.department = department;
//	}

	public String getState() {
		return department.state;
	}
	public String getDName() {
		return department.name;
	}
	public int getDeptId() {
		return department.deptId;
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
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}

	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
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
		Teacher other = (Teacher) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
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
		return "Teacher [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}

	
	
	
}
