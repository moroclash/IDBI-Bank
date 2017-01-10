package Managment;

import java.io.Serializable;

public class Manager extends Employee implements Serializable{
	private Branch managerBranch;

	public void setManagerBranch( Branch managerBranch ){
		this.managerBranch = managerBranch;
	}
	public Branch getmanagerBranch(){
		return this.managerBranch;
	}

	
	
}
