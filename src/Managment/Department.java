package Managment;

import java.io.Serializable;

public class Department extends Manager implements Serializable{
	private String deptName;
	public void setDeptName( String deptName ){
		this.deptName = deptName;
	}
	public String getDeptName( ){
		return this.deptName;
	}

	private String description;
	public void setDescription( String description ){
		this.description = description;
	}
	public String getDescription( ){
		return this.description;
	}

	private String telephone;
	public void setTelephone( String telephone ){
		this.telephone = telephone;
	}
	public String getTelephone( ){
		return this.telephone;
	}
	
	
}
