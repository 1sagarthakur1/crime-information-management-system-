package com.InterfacesDaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.Beens.Crimes;
import com.Beens.CrimesAndCriminals;
import com.Beens.Criminal;
import com.Beens.PoliceStation;
import com.Interfaces.CrimeDao;
import com.exceptionshendal.CrimeException;
import com.exceptionshendal.CrimnalException;
import com.exceptionshendal.PoliceStationException;
import com.utility.GetConnectionFromDBMS;

public class CrimeDaoImplimantion implements CrimeDao {
	
	@Override
	public void showAllPS() throws PoliceStationException{
		// TODO Auto-generated method stub
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
			PreparedStatement pStatement = connection.prepareStatement("select * from policestation");
			
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				int psid            = resultSet.getInt("PSid");
				String psareaString = resultSet.getString("PSarea");
				String psidString   = resultSet.getString("PSloginid");
				
                System.out.println("Police Station area : "+psareaString+"                                               "+"Station id : "+psid);
				System.out.println("Station  login id   : "+ psidString);
				System.out.println();
				System.out.println("----------------------------------------------------------------------------");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new PoliceStationException(e.getMessage());
		}
		
	}

	@Override
	public String forloginPoliceStation(String PSid, String PSpass) throws PoliceStationException {
		// TODO Auto-generated method stub
		String string = "Invalid ID Or Password";
		
		try(Connection connection= GetConnectionFromDBMS.tackConnection()){
		   PreparedStatement pStatement = connection.prepareStatement("Select * from policestation where Psloginid = ? and PSpassword = ?");
		   pStatement.setString(1, PSid);
		   pStatement.setString(2, PSpass);
		   
		   ResultSet resultSet = pStatement.executeQuery();
		   
		   if(resultSet.next()) {
			   String psareaString       = resultSet.getString("PSarea");
			   int pSidString            = resultSet.getInt("PSid");
			   String pSinchargeString   = resultSet.getString("PSincharge");
			   String pSloginidString    = resultSet.getString("PSloginid");
			   if(pSinchargeString.length()>0) {
				   string= "                                          |==========================|"+"\n" 
				           +"                                          |     Login Successfuly..  |" + "\n" 
				           +"                                          |==========================|"+"\n"
				           +"\n"
						   +"                                 ******* Welcom to "+ psareaString + " Police Station *******" +"\n"
						   +"\n"
						   +"Incharge of Police Station    : " + pSinchargeString +"\n"
						   +"Police Station location       : " + psareaString +"\n"
						   +"Login ID of it Police Station : " + pSloginidString +"\n"
						   +"Police Station Id             : " + pSidString;
			   }
		   }
		   
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new PoliceStationException(e.getMessage());
			
		}
		
		return string;
	}

	@Override
	public String forRagistarPS(PoliceStation policeStation) throws PoliceStationException{
        String string = " < Police Station not Registed Please Enter details according conditions > ";
        
		try(Connection connection= GetConnectionFromDBMS.tackConnection()){
		   PreparedStatement pStatement = connection.prepareStatement(" insert into policestation values(?,?,?,?,?)");
		   pStatement.setInt(1, policeStation.getPsid());
		   pStatement.setString(2, policeStation.getPsareaString());
		   pStatement.setString(3, policeStation.getPsinchargeString());
		   pStatement.setString(4, policeStation.getPsloginidString());
		   pStatement.setString(5, policeStation.getpSpasswordString());
		   int i = pStatement.executeUpdate();
		   if(i>0) {
			   string = "< Police station registration done successfully >";
		   }
		   
		} catch (SQLException e) {
			// TODO: handle exception
			return string;
		}
		return string;
	}

	@Override
	public int forAddCrime()throws CrimeException {
		Scanner scanner6 = new Scanner(System.in);
		CrimeDao crimeDao = new CrimeDaoImplimantion();
        int i = 0;
        System.out.println();
		int crmimid = 0;
		try {
			crmimid = (crimeDao.forcountAllcrime())+1;
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
			System.out.print("Enter Crime date like - 2022-11-09 : ");
			String crmdate = scanner6.nextLine();
			System.out.print("Enter Crime type : ");
			String crmtype = scanner6.nextLine();
			System.out.print("Enter Victim Name : ");
			String victim = scanner6.nextLine();
			System.out.print("Enter Crime Description : ");
			String decription = scanner6.nextLine();
			System.out.print("Enter Criminal Name : ");
			String criminal = scanner6.nextLine();
			System.out.print("Enter SLOVE,NOT SOLVE : ");
			String SorN = scanner6.nextLine();
			System.out.print("Enter Police station ID : ");
			int psid = scanner6.nextInt();
			System.out.print("Enter Crime place : ");
			String crmplace = scanner6.next();
			
			Crimes crimes = new Crimes();
			
			crimes.setCrid(crmimid);
			crimes.setcRdateString(crmdate);
			crimes.setCrtypeString(crmtype);
			crimes.setVictimString(victim);
			crimes.setCrdetailString(decription);
			crimes.setCriminalString(criminal);
			crimes.setSolveornotString(SorN);
			crimes.setPsid(psid);
			crimes.setCrplaceString(crmplace);
			
			System.out.println();
			
			try(Connection connection= GetConnectionFromDBMS.tackConnection()){
				PreparedStatement pStatement = connection.prepareStatement(" insert into crimes values(?,?,?,?,?,?,?,?,?)");
				
				
				pStatement.setInt(1, crimes.getCrid());
				pStatement.setString(2, crimes.getcRdateString());
				pStatement.setString(3, crimes.getCrtypeString());
				pStatement.setString(4, crimes.getVictimString());
				pStatement.setString(5, crimes.getCrdetailString());
				pStatement.setString(6, crimes.getCriminalString());
				pStatement.setString(7, crimes.getSolveornotString());
				pStatement.setInt(8, crimes.getPsid());
				pStatement.setString(9, crimes.getCrplaceString());
				
				int j = pStatement.executeUpdate();
				if(j>0) {
					i=1;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				return i;
//			e.getMessage();
			}
			
		} catch (InputMismatchException e) {
			return i;
		}
		
		return i;
	}

	
	public int forAddCriminal()throws CrimnalException {
		Scanner scanner6 = new Scanner(System.in);
		Scanner scnata = new Scanner(System.in);
		CrimeDao crimeDao = new CrimeDaoImplimantion();
		Crimes crimes = new Crimes();
		
        int k = 0;
        System.out.println();
		
		int cid = 0;
		try {
			cid = (crimeDao.forcountAllcriminal())+1;
		} catch (CrimnalException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			System.out.print("Enter above Criminal Name again : ");
			String cname = scanner6.nextLine();
			System.out.print("Enter Criminal age : ");
			int cage = scanner6.nextInt();
			System.out.print("Enter Criminal gender : ");
			String cgender = scnata.nextLine();
			System.out.print("Enter Criminal address : ");
			String caddress = scnata.nextLine();
			System.out.print("Enter Criminal Mark in face : ");
			String cMarkface = scnata.nextLine();
			System.out.print("Enter Criminal arrested area : ");
			String carrestedarea = scnata.nextLine();
			
			Criminal criminal2 = new Criminal();
			
			criminal2.setCrno(cid);
			criminal2.setCnameString(cname);
			criminal2.setCage(cage);
			criminal2.setCgenderString(cgender);
			criminal2.setCaddressString(caddress);
			criminal2.setcMarkfString(cMarkface);
			criminal2.setArrestareaString(carrestedarea);
			criminal2.setCrimeid(cid);
			
			
			try(Connection connection= GetConnectionFromDBMS.tackConnection()){
				PreparedStatement pStatement = connection.prepareStatement(" insert into criminal values(?,?,?,?,?,?,?,?)");
				pStatement.setInt(1, criminal2.getCrno());
				pStatement.setString(2, criminal2.getCnameString());
				pStatement.setInt(3, criminal2.getCage());
				pStatement.setString(4, criminal2.getCgenderString());
				pStatement.setString(5, criminal2.getCaddressString());
				pStatement.setString(6, criminal2.getcMarkfString());
				pStatement.setString(7, criminal2.getArrestareaString());
				pStatement.setInt(8, criminal2.getCrimeid());
				
				int j = pStatement.executeUpdate();
				if(j>0) {
					k=1;
				}
			} catch (SQLException e) {
				// TODO: handle exception
				return k;
			}
			
		} catch (InputMismatchException e) {
			return k;
		}
		return k;
	}
	
	@Override
	public List<Crimes> forShowallCrimeList(String Psid)throws CrimeException {
		// TODO Auto-generated method stub
		List<Crimes> list = new ArrayList<>();
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
			PreparedStatement pStatement =	connection.prepareStatement("select * from crimes c inner join policestation p on c.psid = p.PSid and p.PSloginid = ?;");
			pStatement.setString(1, Psid);
			ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				int CRid          = resultSet.getInt("crid");
				String CRdate     = resultSet.getString("crtime");
				String crtype     = resultSet.getString("crtype");
				String victim     = resultSet.getString("victim");
				String crdetail   = resultSet.getString("crdetail");
				String criminal   = resultSet.getString("Criminal");
				String solveornot = resultSet.getString("solveornot");
				int PSid          = resultSet.getInt("psid");
				String crplace    = resultSet.getString("crplace");
				
				Crimes crimes = new Crimes();
				
				crimes.setCrid(CRid);
				crimes.setcRdateString(CRdate);
				crimes.setCrtypeString(crtype);
				crimes.setVictimString(victim);
				crimes.setCrdetailString(crdetail);
				crimes.setCriminalString(criminal);
				crimes.setSolveornotString(solveornot);
				crimes.setPsid(PSid);
				crimes.setCrplaceString(crplace);
				
				list.add(crimes);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<Crimes> forshowAllSolveCrimes(String slove,String PSid) throws CrimeException{
		// TODO Auto-generated method stub
		List<Crimes> list = new ArrayList<>();
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
		  PreparedStatement pStatement =	connection.prepareStatement("select * from crimes c inner join policestation p on c.psid = p.PSid and c.solveornot = ? and p.PSloginid = ?;");
		  pStatement.setString(1, slove);
		  pStatement.setString(2, PSid);
		  
		  ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				int CRid          = resultSet.getInt("crid");
				String CRdate     = resultSet.getString("crtime");
				String crtype     = resultSet.getString("crtype");
				String victim     = resultSet.getString("victim");
				String crdetail   = resultSet.getString("crdetail");
				String criminal   = resultSet.getString("Criminal");
				String solveornot = resultSet.getString("solveornot");
				int Psid          = resultSet.getInt("psid");
				String crplace    = resultSet.getString("crplace");
				
				Crimes crimes = new Crimes();
				
				crimes.setCrid(CRid);
				crimes.setcRdateString(CRdate);
				crimes.setCrtypeString(crtype);
				crimes.setVictimString(victim);
				crimes.setCrdetailString(crdetail);
				crimes.setCriminalString(criminal);
				crimes.setSolveornotString(solveornot);
				crimes.setPsid(Psid);
				crimes.setCrplaceString(crplace);
				
				list.add(crimes);
		  
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
	
		
		return list;
	}

	@Override
	public List<Crimes> forShowAllUNsolveCrimes(String notsolve,String PSLid) throws CrimeException{
		// TODO Auto-generated method stub
		List<Crimes> list = new ArrayList<>();
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
		  PreparedStatement pStatement =	connection.prepareStatement("select * from crimes c inner join policestation p on c.psid = p.PSid and c.solveornot = ? and p.PSloginid = ?;");
		  pStatement.setString(1, notsolve);
		  pStatement.setString(2, PSLid);
		  
		  ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				int CRid          = resultSet.getInt("crid");
				String CRdate     = resultSet.getString("crtime");
				String crtype     = resultSet.getString("crtype");
				String victim     = resultSet.getString("victim");
				String crdetail   = resultSet.getString("crdetail");
				String criminal   = resultSet.getString("Criminal");
				String solveornot = resultSet.getString("solveornot");
				int Psid          = resultSet.getInt("psid");
				String crplace    = resultSet.getString("crplace");
				
				Crimes crimes = new Crimes();
				
				crimes.setCrid(CRid);
				crimes.setcRdateString(CRdate);
				crimes.setCrtypeString(crtype);
				crimes.setVictimString(victim);
				crimes.setCrdetailString(crdetail);
				crimes.setCriminalString(criminal);
				crimes.setSolveornotString(solveornot);
				crimes.setPsid(Psid);
				crimes.setCrplaceString(crplace);
				
				list.add(crimes);
		  
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public String forChangeSVNSVcrimes(String sloveornot,int CRid) throws CrimeException {
		// TODO Auto-generated method stub
		String string = "NOT UPDATE";
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
			  PreparedStatement pStatement =	connection.prepareStatement("UPDATE crimes set solveornot = ? where CRID = ?");
			  pStatement.setString(1, sloveornot);
			  pStatement.setInt(2, CRid);
			  int i = pStatement.executeUpdate();
			  if(i>0) {
				  string = "UPDATED";
			  }
			  
				
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		return string;
	}

	@Override
	public List<CrimesAndCriminals> forShowAllCriminal(String PSLid)throws CrimnalException {
		List<CrimesAndCriminals> list = new ArrayList<>();
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
		  PreparedStatement pStatement =	connection.prepareStatement("select * from criminal cr inner join crimes c inner join policestation p on cr.crid = c.crid and c.psid = p.PSid and p.PSloginid = ?");
		  pStatement.setString(1, PSLid);
		  
		  ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				String crmName        = resultSet.getString("Ccrname");
			    int age               = resultSet.getInt("age");
			    String crmgender      = resultSet.getString("gender");
			    String crmaddress     = resultSet.getString("address");
			    String crmMark        = resultSet.getString("Markinface");
			    String cdate          = resultSet.getString("crtime");
			    String crType         = resultSet.getString("crtype");
			    String crdetail       = resultSet.getString("crdetail");
			    String crmarrestarean = resultSet.getString("arrestedarea");
			    String cvictim        = resultSet.getString("victim");
			    
//			    System.out.println(crmName);
			    CrimesAndCriminals crimesAndCriminals = new CrimesAndCriminals();
			    
			    crimesAndCriminals.setCrmNameString(crmName);
			    crimesAndCriminals.setAge(age);
			    crimesAndCriminals.setCrmgenderString(crmgender);
			    crimesAndCriminals.setCrmaddressString(crmaddress);
			    crimesAndCriminals.setCrmMarkString(crmMark);
			    crimesAndCriminals.setCdateString(cdate);
			    crimesAndCriminals.setCrTypeString(crType);
			    crimesAndCriminals.setCrdetailString(crdetail);
			    crimesAndCriminals.setCrmarrestareaString(crmarrestarean);
			    crimesAndCriminals.setCvictimString(cvictim);
			    
			    list.add(crimesAndCriminals);
		  
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new CrimnalException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public List<CrimesAndCriminals> forShowCriminalbydate(String date1, String date2)throws CrimnalException {
		List<CrimesAndCriminals> list = new ArrayList<>();
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
		  PreparedStatement pStatement =	connection.prepareStatement("select * from criminal cr inner join crimes c inner join policestation p on cr.crid = c.crid and c.psid = p.PSid and c.crtime>= ? and c.crtime<= ?");
		  pStatement.setString(1, date1);
		  pStatement.setString(2, date2);
		  
		  ResultSet resultSet = pStatement.executeQuery();
			while(resultSet.next()) {
				String crmName        = resultSet.getString("Ccrname");
			    int age               = resultSet.getInt("age");
			    String crmgender      = resultSet.getString("gender");
			    String crmaddress     = resultSet.getString("address");
			    String crmMark        = resultSet.getString("Markinface");
			    String cdate          = resultSet.getString("crtime");
			    String crType         = resultSet.getString("crtype");
			    String crdetail       = resultSet.getString("crdetail");
			    String crmarrestarean = resultSet.getString("arrestedarea");
			    String cvictim        = resultSet.getString("victim");
			    String PoliceStation  = resultSet.getString("PSarea");
			    int Policeid          = resultSet.getInt("PSid");
			    
//			    System.out.println(crmName);
			    CrimesAndCriminals crimesAndCriminals = new CrimesAndCriminals();
			    
			    crimesAndCriminals.setCrmNameString(crmName);
			    crimesAndCriminals.setAge(age);
			    crimesAndCriminals.setCrmgenderString(crmgender);
			    crimesAndCriminals.setCrmaddressString(crmaddress);
			    crimesAndCriminals.setCrmMarkString(crmMark);
			    crimesAndCriminals.setCdateString(cdate);
			    crimesAndCriminals.setCrTypeString(crType);
			    crimesAndCriminals.setCrdetailString(crdetail);
			    crimesAndCriminals.setCrmarrestareaString(crmarrestarean);
			    crimesAndCriminals.setCvictimString(cvictim);
			    crimesAndCriminals.setPoliceStationString(PoliceStation);
			    crimesAndCriminals.setPoliceID(Policeid);
			    
			    list.add(crimesAndCriminals);
		  
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			return list;
//			System.out.println("It is not right date");
		}
		
		return list;
	}
	
	@Override
	public int forDeleteCrime(String PSloginid) throws CrimeException {
		Scanner scanner = new Scanner(System.in);
		
		int i = 0;
		try {
			System.out.println();
			System.out.print("Enter Crime ID : ");
			int Crid = scanner.nextInt();
			try(Connection connection = GetConnectionFromDBMS.tackConnection()){
				PreparedStatement pStatement =	connection.prepareStatement("delete cr,c from criminal as cr INNER JOIN crimes as c on cr.crid = c.crid INNER JOIN policestation as p on c.psid = p.PSid WHERE c.crid = ? and p.PSloginid = ?");
				pStatement.setInt(1, Crid);
				pStatement.setString(2, PSloginid);
				
				int x = pStatement.executeUpdate();
				i = x;
				
			} catch (SQLException e) {
				return i;
			}
			
		} catch (InputMismatchException e) {
			return i;
		}
		
		return i;
	}

	@Override
	public int forcountAllpolicestation() throws PoliceStationException{
		int i=0;
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
			  PreparedStatement pStatement =	connection.prepareStatement("select * from policestation");
			  
			  ResultSet resultSet = pStatement.executeQuery();
				while(resultSet.next()) {
					i++;
				}
				
		} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			throw new PoliceStationException(e.getMessage());
		}
		
		return i;
	}

	@Override
	public int forcountAllcrime() throws CrimeException{
		int i=0;
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
			  PreparedStatement pStatement =	connection.prepareStatement("select * from crimes");
			  ResultSet resultSet = pStatement.executeQuery();
				while(resultSet.next()) {
					i++;
				}
				
		} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		return i;
	}

	@Override
	public int forcountAllcriminal()throws CrimnalException {
		int i=0;
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
			  PreparedStatement pStatement =	connection.prepareStatement("select * from criminal");
			  
			  ResultSet resultSet = pStatement.executeQuery();
				while(resultSet.next()) {
					i++;
				}
				
		} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			throw new CrimnalException(e.getMessage());
		}
		
		return i;
	}

	@Override
	public int forcountPoliceStationCrime(String PSLid) throws CrimeException {
		int i=0;
		try(Connection connection = GetConnectionFromDBMS.tackConnection()){
			  PreparedStatement pStatement =	connection.prepareStatement("select * from crimes c inner join policestation p on c.psid = p.PSid where p.PSloginid = ?");
			  pStatement.setString(1, PSLid);
			  ResultSet resultSet = pStatement.executeQuery();
				while(resultSet.next()) {
					i++;
				}
				
		} 
		catch (SQLException e) {
				// TODO: handle exception
			e.printStackTrace();
			throw new CrimeException(e.getMessage());
		}
		
		return i;
	}


}
