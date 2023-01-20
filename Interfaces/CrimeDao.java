package com.Interfaces;

import java.util.List;

//import javax.naming.directory.SearchControls;

import com.Beens.Crimes;
import com.Beens.CrimesAndCriminals;
import com.Beens.Criminal;
import com.Beens.PoliceStation;
import com.exceptionshendal.CrimeException;
import com.exceptionshendal.CrimnalException;
import com.exceptionshendal.PoliceStationException;

public interface CrimeDao {
//	for see all Police Station
	public void showAllPS()throws PoliceStationException;
	
//	for ragistar police station
	public String forRagistarPS(PoliceStation policeStation) throws PoliceStationException;
	
//	for login a particular police station
	public String forloginPoliceStation(String PSid,String PSpass)throws PoliceStationException;
	
//	for add crime and criminal
	public int forAddCrime()throws CrimeException;
	
//	for add criminal and criminal
	public int forAddCriminal()throws CrimnalException;
	
//	for show All Crimes
	public List<Crimes> forShowallCrimeList(String Psid) throws CrimeException;
	
//	for Solve crimes
	public List<Crimes> forshowAllSolveCrimes(String slove,String Psid)throws CrimeException;
	
//	for not solve crimes
	public List<Crimes> forShowAllUNsolveCrimes(String notsolve,String PSLid) throws CrimeException;
	
//	for change slove or not solve
	public String forChangeSVNSVcrimes(String sloveornot,int Crid) throws CrimeException;
	
//	for show all criminals
	public List<CrimesAndCriminals> forShowAllCriminal(String PSLid) throws CrimnalException;
	
//	for show all criminals by date
	public List<CrimesAndCriminals> forShowCriminalbydate(String date1,String date2)throws CrimnalException;
	
//	for count all police stations
	public int forcountAllpolicestation()throws PoliceStationException;
	
//	for count all crime
	public int forcountAllcrime() throws CrimeException;
	
//	for count all criminal
	public int forcountAllcriminal()throws CrimnalException;
	
//	for Delete Crime and Criminal
	public String forDeleteCrime(int crid)throws CrimeException;

}
