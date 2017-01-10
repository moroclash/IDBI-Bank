package Managment;

import java.io.Serializable;

public class TransferInfo implements Serializable{
	// the value of transfered money
	private double transferedMoney;
	public void setTransferedMoney( double transferedMoney ){
		this.transferedMoney = transferedMoney;
	}
	public double getTransferedMoney( ){
		return this.transferedMoney;
	}
	// source of transfering
	private String source; // accountNum
	public void setSource( String source ){
		this.source = source;
	}
	public String getSource( ){
		return this.source;
	}
	// destination of transfering 
	private String destination; // accountNum
	public void setDestination ( String destination ){
		this.destination = destination;
	}
	public String getDestination( ){
		return this.destination;
	}
	// date
	private String data;
	public void setDate( String date ){
		this.data = date;
	}
	public String getDate( ){
		return this.data;
	}
	
}
