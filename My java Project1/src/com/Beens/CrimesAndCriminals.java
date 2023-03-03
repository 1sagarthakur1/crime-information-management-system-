package com.Beens;

public class CrimesAndCriminals {
    private	String crmNameString;
    private int age;
    private String crmgenderString;
    private String crmaddressString;
    private String crmMarkString;
    private String cdateString;
    private String crTypeString;
    private String crdetailString;
    private String crmarrestareaString;
    private String cvictimString;
	private String policeStationString;
	private int    policeID;
	public CrimesAndCriminals() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CrimesAndCriminals(String crmNameString, int age, String crmgenderString, String crmaddressString,
			String crmMarkString, String cdateString, String crTypeString, String crdetailString,
			String crmarrestareaString, String cvictimString, String policeStationString, int policeID) {
		super();
		this.crmNameString = crmNameString;
		this.age = age;
		this.crmgenderString = crmgenderString;
		this.crmaddressString = crmaddressString;
		this.crmMarkString = crmMarkString;
		this.cdateString = cdateString;
		this.crTypeString = crTypeString;
		this.crdetailString = crdetailString;
		this.crmarrestareaString = crmarrestareaString;
		this.cvictimString = cvictimString;
		this.policeStationString = policeStationString;
		this.policeID = policeID;
	}
	public String getCrmNameString() {
		return crmNameString;
	}
	public void setCrmNameString(String crmNameString) {
		this.crmNameString = crmNameString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCrmgenderString() {
		return crmgenderString;
	}
	public void setCrmgenderString(String crmgenderString) {
		this.crmgenderString = crmgenderString;
	}
	public String getCrmaddressString() {
		return crmaddressString;
	}
	public void setCrmaddressString(String crmaddressString) {
		this.crmaddressString = crmaddressString;
	}
	public String getCrmMarkString() {
		return crmMarkString;
	}
	public void setCrmMarkString(String crmMarkString) {
		this.crmMarkString = crmMarkString;
	}
	public String getCdateString() {
		return cdateString;
	}
	public void setCdateString(String cdateString) {
		this.cdateString = cdateString;
	}
	public String getCrTypeString() {
		return crTypeString;
	}
	public void setCrTypeString(String crTypeString) {
		this.crTypeString = crTypeString;
	}
	public String getCrdetailString() {
		return crdetailString;
	}
	public void setCrdetailString(String crdetailString) {
		this.crdetailString = crdetailString;
	}
	public String getCrmarrestareaString() {
		return crmarrestareaString;
	}
	public void setCrmarrestareaString(String crmarrestareaString) {
		this.crmarrestareaString = crmarrestareaString;
	}
	public String getCvictimString() {
		return cvictimString;
	}
	public void setCvictimString(String cvictimString) {
		this.cvictimString = cvictimString;
	}
	public String getPoliceStationString() {
		return policeStationString;
	}
	public void setPoliceStationString(String policeStationString) {
		this.policeStationString = policeStationString;
	}
	public int getPoliceID() {
		return policeID;
	}
	public void setPoliceID(int policeID) {
		this.policeID = policeID;
	}
	@Override
	public String toString() {
		return "CrimesAndCriminals [crmNameString=" + crmNameString + ", age=" + age + ", crmgenderString="
				+ crmgenderString + ", crmaddressString=" + crmaddressString + ", crmMarkString=" + crmMarkString
				+ ", cdateString=" + cdateString + ", crTypeString=" + crTypeString + ", crdetailString="
				+ crdetailString + ", crmarrestareaString=" + crmarrestareaString + ", cvictimString=" + cvictimString
				+ ", policeStationString=" + policeStationString + ", policeID=" + policeID + "]";
	}
	
    
}
