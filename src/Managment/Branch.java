package Managment;

import java.io.Serializable;

public class Branch implements Serializable {
	// location
	private String location;
	public void setLocation( String location ){
		this.location = location;
	}
	public String getLocation( ){
		return this.location;
	}
	// telephone
	private String telephone;
	public void setTelephone( String telephone ){
		this.telephone = telephone;
	}
	public String getTelephone( ){
		return this.telephone;
	}
	// fax
	private String fax;
	public void setFax(  String fax ){
		this.fax = fax;
	}
	public String getFax( ){
		return this.fax;
	}
	// budget
	private double budget;
	public void setBudget( double budget ){
		this.budget = budget;
	}
	public double getBudget( ){
		return this.budget;
	}
	// totalSalaries
	private double totalSalaries;
	public void setTotalSalaries( double totalSalaries ){
		this.totalSalaries = totalSalaries;	
	}
	public double getTotalSalaries( ){
		return this.totalSalaries;
	}
	
}
