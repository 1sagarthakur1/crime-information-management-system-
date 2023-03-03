package com.Beens;

public class Criminal {
	int Crno;
	String cnameString;
	int cage;
	String cgenderString;
	String caddressString;
	String cMarkfString;
	String arrestareaString;
	int crimeid;
	public Criminal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Criminal(int crno, String cnameString, int cage, String cgenderString, String caddressString,
			String cMarkfString, String arrestareaString, int crimeid) {
		super();
		Crno = crno;
		this.cnameString = cnameString;
		this.cage = cage;
		this.cgenderString = cgenderString;
		this.caddressString = caddressString;
		this.cMarkfString = cMarkfString;
		this.arrestareaString = arrestareaString;
		this.crimeid = crimeid;
	}
	public int getCrno() {
		return Crno;
	}
	public void setCrno(int crno) {
		Crno = crno;
	}
	public String getCnameString() {
		return cnameString;
	}
	public void setCnameString(String cnameString) {
		this.cnameString = cnameString;
	}
	public int getCage() {
		return cage;
	}
	public void setCage(int cage) {
		this.cage = cage;
	}
	public String getCgenderString() {
		return cgenderString;
	}
	public void setCgenderString(String cgenderString) {
		this.cgenderString = cgenderString;
	}
	public String getCaddressString() {
		return caddressString;
	}
	public void setCaddressString(String caddressString) {
		this.caddressString = caddressString;
	}
	public String getcMarkfString() {
		return cMarkfString;
	}
	public void setcMarkfString(String cMarkfString) {
		this.cMarkfString = cMarkfString;
	}
	public String getArrestareaString() {
		return arrestareaString;
	}
	public void setArrestareaString(String arrestareaString) {
		this.arrestareaString = arrestareaString;
	}
	public int getCrimeid() {
		return crimeid;
	}
	public void setCrimeid(int crimeid) {
		this.crimeid = crimeid;
	}
	@Override
	public String toString() {
		return "Criminal [Crno=" + Crno + ", cnameString=" + cnameString + ", cage=" + cage + ", cgenderString="
				+ cgenderString + ", caddressString=" + caddressString + ", cMarkfString=" + cMarkfString
				+ ", arrestareaString=" + arrestareaString + ", crimeid=" + crimeid + "]";
	}

}
