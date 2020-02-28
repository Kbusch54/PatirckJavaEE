/**
 * 
 */
package org.perscholas.onetomany;

/**
 * 
 */

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.perscholas.models.Teacher;

/**
 * @author CTStudent
 *
 */
@Entity

public class DepartmentOTM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	public int deptId;
	public String name;
	public String state;

	@OneToMany(targetEntity = TeacherOTM.class, fetch=FetchType.EAGER)
	private List<TeacherOTM> teachList;

	/**
	 * 
	 */
	public DepartmentOTM() {
		super();
	}

	/**
	 * @param deptId
	 * @param name
	 * @param state
	 * @param teachList
	 */
	public DepartmentOTM(int deptId, String name, String state, List<TeacherOTM> teachList) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.state = state;
		this.teachList = teachList;
	}
	

	/**
	 * @param deptId
	 * @param name
	 * @param state
	 */
	public DepartmentOTM(int deptId, String name, String state) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.state = state;
	}

	/**
	 * @return the deptId
	 */
	public int getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(int deptId) {
		this.deptId = deptId;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the teachList
	 */
	public List<TeacherOTM> getTeachList() {
		return teachList;
	}

	/**
	 * @param teachList the teachList to set
	 */
	public void setTeachList(List<TeacherOTM> teachList) {
		this.teachList = teachList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((teachList == null) ? 0 : teachList.hashCode());
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
		DepartmentOTM other = (DepartmentOTM) obj;
		if (deptId != other.deptId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (teachList == null) {
			if (other.teachList != null)
				return false;
		} else if (!teachList.equals(other.teachList))
			return false;
		return true;
	}

//	@Override
//	public String toString() {
//		return "DepartmentOneToMany [deptId=" + deptId + ", name=" + name + ", state=" + state + ", teachList="
//				+ fore teachList. + "]";
//	}

}
