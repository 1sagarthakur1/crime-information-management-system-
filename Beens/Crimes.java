package com.Beens;

public class Crimes {
	private int crid;
	private String cRdateString;
	private String crtypeString;
	private String victimString;
	private String crdetailString;
	private String criminalString;
	private String solveornotString;
	private int psid;
	private String crplaceString;
	public Crimes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Crimes(int crid, String cRdateString, String crtypeString, String victimString, String crdetailString,
			String criminalString, String solveornotString, int psid, String crplaceString) {
		super();
		this.crid = crid;
		this.cRdateString = cRdateString;
		this.crtypeString = crtypeString;
		this.victimString = victimString;
		this.crdetailString = crdetailString;
		this.criminalString = criminalString;
		this.solveornotString = solveornotString;
		this.psid = psid;
		this.crplaceString = crplaceString;
	}
	public int getCrid() {
		return crid;
	}
	public void setCrid(int crid) {
		this.crid = crid;
	}
	public String getcRdateString() {
		return cRdateString;
	}
	public void setcRdateString(String cRdateString) {
		this.cRdateString = cRdateString;
	}
	public String getCrtypeString() {
		return crtypeString;
	}
	public void setCrtypeString(String crtypeString) {
		this.crtypeString = crtypeString;
	}
	public String getVictimString() {
		return victimString;
	}
	public void setVictimString(String victimString) {
		this.victimString = victimString;
	}
	public String getCrdetailString() {
		return crdetailString;
	}
	public void setCrdetailString(String crdetailString) {
		this.crdetailString = crdetailString;
	}
	public String getCriminalString() {
		return criminalString;
	}
	public void setCriminalString(String criminalString) {
		this.criminalString = criminalString;
	}
	public String getSolveornotString() {
		return solveornotString;
	}
	public void setSolveornotString(String solveornotString) {
		this.solveornotString = solveornotString;
	}
	public int getPsid() {
		return psid;
	}
	public void setPsid(int psid) {
		this.psid = psid;
	}
	public String getCrplaceString() {
		return crplaceString;
	}
	public void setCrplaceString(String crplaceString) {
		this.crplaceString = crplaceString;
	}
	@Override
	public String toString() {
		return "Crimes [crid=" + crid + ", cRdateString=" + cRdateString + ", crtypeString=" + crtypeString
				+ ", victimString=" + victimString + ", crdetailString=" + crdetailString + ", criminalString="
				+ criminalString + ", solveornotString=" + solveornotString + ", psid=" + psid + ", crplaceString="
				+ crplaceString + "]";
	}
	
}
