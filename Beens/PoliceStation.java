package com.Beens;

public class PoliceStation {
	int psid;
	String psareaString;
	String psinchargeString;
	String psloginidString;
	String pSpasswordString;
	public PoliceStation(int psid, String psareaString, String psinchargeString, String psloginidString,
			String pSpasswordString) {
		super();
		this.psid = psid;
		this.psareaString = psareaString;
		this.psinchargeString = psinchargeString;
		this.psloginidString = psloginidString;
		this.pSpasswordString = pSpasswordString;
	}
	public PoliceStation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPsid() {
		return psid;
	}
	public void setPsid(int psid) {
		this.psid = psid;
	}
	public String getPsareaString() {
		return psareaString;
	}
	public void setPsareaString(String psareaString) {
		this.psareaString = psareaString;
	}
	public String getPsinchargeString() {
		return psinchargeString;
	}
	public void setPsinchargeString(String psinchargeString) {
		this.psinchargeString = psinchargeString;
	}
	public String getPsloginidString() {
		return psloginidString;
	}
	public void setPsloginidString(String psloginidString) {
		this.psloginidString = psloginidString;
	}
	public String getpSpasswordString() {
		return pSpasswordString;
	}
	public void setpSpasswordString(String pSpasswordString) {
		this.pSpasswordString = pSpasswordString;
	}
	@Override
	public String toString() {
		return "PoliceStation [psid=" + psid + ", psareaString=" + psareaString + ", psinchargeString="
				+ psinchargeString + ", psloginidString=" + psloginidString + ", pSpasswordString=" + pSpasswordString
				+ "]";
	}
	

}
