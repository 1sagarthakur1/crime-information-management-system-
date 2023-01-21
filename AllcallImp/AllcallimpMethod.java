package AllcallImp;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.Beens.Crimes;
import com.Beens.CrimesAndCriminals;
import com.Beens.Criminal;
import com.Beens.PoliceStation;
import com.Interfaces.CrimeDao;
import com.InterfacesDaoImp.CrimeDaoImplimantion;
import com.exceptionshendal.CrimeException;
import com.exceptionshendal.CrimnalException;
import com.exceptionshendal.PoliceStationException;

public class AllcallimpMethod extends Thread{
//	private static final String String = null;

	public static void allClassholder(){
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("              ________________________________________________________________________________");
		System.out.println("             |                                                                                |");
		System.out.println("             |                     ****Welcom to Crime information System****                 |");
		System.out.println("             |________________________________________________________________________________|");
		System.out.println();
		System.out.println("            ---------------------[   These are all registered Police Stations    ]-------------------");
		System.out.println();
		CrimeDao crimeDao = new CrimeDaoImplimantion();
		int NoPo;
		try {
			NoPo = crimeDao.forcountAllpolicestation();
			System.out.println("                                                                                                                    Total Police Station : "+NoPo);
		} catch (PoliceStationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			crimeDao.showAllPS();
		} catch (PoliceStationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		
		System.out.println("Enter 1 - For Police Station Ragistation");
		System.out.println("Enter 2 - Login Police Station");
		System.out.print("Enter Number : ");
		
		try {
			int num1 = scanner1.nextInt();
		   
		    if(num1==1) {
				System.out.println();
				AllcallimpMethod.policestationRagistetion();
			}
			else if(num1==2) {
				System.out.println();
	            AllcallimpMethod.loginCallMethod();
			}
			else {
				System.out.println("                                    |================================|");
				System.out.println("                                    |     < Enter valid Number >     |");
				System.out.println("                                    |================================|");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				allClassholder();
			}
		    
			
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("                                    |================================|");
			System.out.println("                                    |  < Please Enter right Number > |");
			System.out.println("                                    |================================|");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			allClassholder();
		}
		System.out.println();
		
		
	}
	
	
	public static void loginCallMethod() {
		Scanner scanner2 = new Scanner(System.in);
		
		System.out.print("Enter Login ID : ");
		String PsLid = scanner2.next();
		System.out.print("Enter Password : ");
		String pass = scanner2.next();
		System.out.println();
		CrimeDao cDao = new CrimeDaoImplimantion();
		String string = null;
		try {
			string = cDao.forloginPoliceStation(PsLid, pass);
		} catch (PoliceStationException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		if(string != "Invalid ID Or Password") {
			System.out.println("Processing.....");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(string);
			AllcallimpMethod.alladdCrimeCll(PsLid);
		}
		else {
			System.out.println("Processing.....");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("                                    |================================|");
			System.out.println("                                    |   < Invalid ID Or Password >   |");
			System.out.println("                                    |================================|");
			AllcallimpMethod.loginCallMethod();
		}
	}
	public static void policestationRagistetion() {
		Scanner scanner7 = new Scanner(System.in);
		CrimeDao crimeDao = new CrimeDaoImplimantion();
		System.out.println();
		int psid = 0;
		try {
			psid = (crimeDao.forcountAllpolicestation())+1;
		} catch (PoliceStationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.print("Enter police Station area : ");
		String psarea = scanner7.nextLine();
		System.out.print("Enter police Station incharge name : ");
		String psinchname = scanner7.nextLine();
		System.out.print("Enter new police Station loginid it should be 5 digit: ");
		String psloinid = scanner7.nextLine();
		System.out.print("Set Passwrod it should be 6 digit password Enter : ");
		String pspassword = scanner7.nextLine();
		
		PoliceStation policeStation = new PoliceStation();
		policeStation.setPsid(psid);
		policeStation.setPsareaString(psarea);
		policeStation.setPsinchargeString(psinchname);
		policeStation.setPsloginidString(psloinid);
		policeStation.setpSpasswordString(pspassword);
		
		
		String string = null;
		try {
			string = crimeDao.forRagistarPS(policeStation);
		} catch (PoliceStationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println("Processing....");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("                                     "+ string);
		System.out.println();
		System.out.println("Enter any number for back");
		System.out.print("Enter Number : ");
		try {
			int num12 = scanner7.nextInt();
			if(num12>0){
				System.out.println();
				AllcallimpMethod.allClassholder();
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println();
			AllcallimpMethod.allClassholder();
		}
				
	}
	public static void alladdCrimeCll(String PsLid) {
		Scanner scanner2 = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter 1- See All Crimes of it Police Station");
		System.out.println("Enter 2- See All criminals of it Police Station");
		System.out.println("Enter 3- Search criminals of any police Station By Date");
		System.out.println("Enter 4- Add Crime");
		System.out.println("Enter 5- Logout");
		System.out.println();
		System.out.print("Enter Number : ");
		try {
			int num2 = scanner2.nextInt();
			if(num2 == 1) {
				System.out.println();
				System.out.println("Processing....");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AllcallimpMethod.allcrimesCall(PsLid);
				System.out.println();
				System.out.println("                  ----------------[  This is all crime's list ]-----------------");
			}
			else if(num2 == 4) {
				System.out.println();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				AllcallimpMethod.allAddCrimeAndCriminalCall(PsLid);
			}
			else if(num2 == 5) {
				System.out.println();
				System.out.println("Processing....");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("                                 |==============================================|");
				System.out.println("                                 |             LogOut Successfully              |");
				System.out.println("                                 |==============================================|");
				System.out.println();
				System.out.println("                                              Please Wait few saconds");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AllcallimpMethod.allClassholder();
			}
			else if(num2 == 2){
				System.out.println();
				System.out.println("Processing....");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				AllcallimpMethod.allcriminalsCall(PsLid);
				System.out.println();
				
			}
			else if(num2 == 3) {
				System.out.println();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
				AllcallimpMethod.allCriminalBydate(PsLid);
			}
			else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("                                    |================================|");
				System.out.println("                                    |      < Enter valid Number >    |");
				System.out.println("                                    |================================|");
				AllcallimpMethod.alladdCrimeCll(PsLid);
			}
		} catch (InputMismatchException e) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO: handle exception
			System.out.println();
			System.out.println("                                    |================================|");
			System.out.println("                                    |  < Please Enter right Number > |");
			System.out.println("                                    |================================|");
			AllcallimpMethod.alladdCrimeCll(PsLid);
		}
		
	}
	
	public static void allAddCrimeAndCriminalCall(String pString) {
		Scanner scanner6 = new Scanner(System.in);
		System.out.println("                      --------------- [  Hello please enter details carefully ] ---------------");
		
		CrimeDao crimeDao = new CrimeDaoImplimantion();
		int tika =0;
		try {
			tika = crimeDao.forAddCrime();
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(tika!=1) {
			System.out.println();
			System.out.println("Processing....");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println();
			System.out.println("                  |==============================================|");
			System.out.println("                  |          Crime details is not right          |");
			System.out.println("                  |    you will go back in previous stap now     |");
			System.out.println("                  |            please wait few seconds           |");
			System.out.println("                  |==============================================|");
			System.out.println();
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AllcallimpMethod.alladdCrimeCll(pString);
		}
		System.out.println("                      --------------- [ Good  you will fill criminal details Now ] --------------");
		int sika = 0;
		try {
			sika = crimeDao.forAddCriminal();
		} catch (CrimnalException e) {
			// TODO Auto-generated catch block
			System.out.println("Criminal details is no right");;
		}
		if(sika!=1) {
			System.out.println("Processing....");
			System.out.println();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("                  |==============================================|");
			System.out.println("                  |           Criminal details is not right      |");
			System.out.println("                  |            please wait few seconds           |");
			System.out.println("                  |==============================================|");
			System.out.println();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(tika+sika==2) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Proccessing....");
			System.out.println();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("                  |==============================================|");
			System.out.println("                  |           Crime add successfully             |");
			System.out.println("                  |==============================================|");
		}
		else {
			System.out.println("Proccessing....");
			System.out.println();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("                  |==============================================|");
			System.out.println("                  |          Crime add did not happen            |");
			System.out.println("                  |==============================================|");
		}
		
		System.out.println();
		System.out.println("Enter 1- fill again");
		System.out.println("Enter 2- LogOut");
		System.out.println("Enter any number for back");
		System.out.print("Enter Number : ");
		
		try {
			int num11 = scanner6.nextInt();
			if(num11==1) {
				System.out.println();
				AllcallimpMethod.allAddCrimeAndCriminalCall(pString);
			}
			else if(num11 == 2) {
				System.out.println();
				System.out.println("Processing....");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("                                 |==============================================|");
				System.out.println("                                 |             LogOut Successfully              |");
				System.out.println("                                 |==============================================|");
				System.out.println();
				System.out.println("                                              Please Wait few saconds");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				AllcallimpMethod.allClassholder();
			}
			else {
				System.out.println();
				AllcallimpMethod.alladdCrimeCll(pString);
			}
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println();
			AllcallimpMethod.alladdCrimeCll(pString);
		}
		
	}
	
	public static void allcrimesCall(String PSLid) {
		Scanner scanner3 = new Scanner(System.in);
		
		CrimeDao crimeDao = new CrimeDaoImplimantion();
	
		List<Crimes> list = null;
		try {
			list = crimeDao.forShowallCrimeList(PSLid);
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		System.out.println();
		System.out.println("             --------------------[  All Crime details of it Police station    ]----------------------");
		System.out.println();
		list.forEach((l) -> System.out.println(
				"Date         : "+l.getcRdateString()+"                                     Crime ID : "+l.getCrid()+"\n"+
				"Criminal     : "+l.getCriminalString()+"\n"+
				"Crime        : "+l.getCrdetailString()+"\n"+
				"Solve or not : "+l.getSolveornotString()+"\n"+
				"---------------------------------------------------------------------------"+"\n"
				));
		try {
			int nut = crimeDao.forcountPoliceStationCrime(PSLid);
			System.out.println("                                                                                          Total Crime in it police Station : "+nut);
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Enter 1- See Slove Crimes");
		System.out.println("Enter 2- See Not Slove Crimes");
		System.out.println("Enter 3- Change Status");
		System.out.println("Enter 4- Back");
		System.out.println("Enter 5- LogOut");
		System.out.println("Enter 6- Delete Crime");
		
		try {
			System.out.print("Enter Number : ");
			int num3 = scanner3.nextInt();
			if(num3==1) {
				System.out.println();
				System.out.println("Processing.....");
				try {
					Thread.sleep(3000);
				} catch (Exception e2) {
					// TODO: handle exception
				}
				String solve = "SOLVE";
				CrimeDao crimeDao2 = new CrimeDaoImplimantion();
				List<Crimes> list1 = null;
				try {
					list1 = crimeDao2.forshowAllSolveCrimes(solve, PSLid);
				} catch (CrimeException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				if(list1.size()>0) {
					System.out.println();
					list1.forEach((l) -> System.out.println(
							"Date          : "+l.getcRdateString()+"                                                      Crime ID : "+l.getCrid()+"\n"+
							"Criminal      : "+l.getCriminalString()+"\n"+
							"Crime         : "+l.getCrdetailString()+"\n"+
							"Solve or Not  : "+l.getSolveornotString()+"\n"+
							"---------------------------------------------------------------------------"+"\n"
							));
					System.out.println("                  --------------    [  Above all solve crimes list ]    --------------");
				}
				else {
					System.out.println();
					System.out.println("                  |============================================|");
					System.out.println("                  | In this police station no any solve crime  |");
					System.out.println("                  |============================================|");
					System.out.println();
				}
				System.out.println("Enter any number for Back");
				System.out.print("Enter Number : ");
				try {
					int num5 = scanner3.nextInt();
					if(num5>=0) {
						System.out.println();
						AllcallimpMethod.allcrimesCall(PSLid);
					}
				} catch (InputMismatchException e3) {
					System.out.println();
					AllcallimpMethod.allcrimesCall(PSLid);
				}
			}
			else if(num3 == 2) {
				String notSolve = "NOTSOLVE";
				System.out.println();
				System.out.println("Processing....");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				CrimeDao crimeDao3 = new CrimeDaoImplimantion();
				List<Crimes> list2 = null;
				try {
					list2 = crimeDao3.forShowAllUNsolveCrimes(notSolve, PSLid);
				} catch (CrimeException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				if(list2.size()>0) {
					System.out.println();
					list2.forEach((l) -> System.out.println(
							"Date          : "+l.getcRdateString()+"                                                         Crime ID : "+l.getCrid()+"\n"+
							"Criminal      : "+l.getCriminalString()+"\n"+
							"Crime         : "+l.getCrdetailString()+"\n"+
							"Solve or Not  : "+l.getSolveornotString()+"\n"+
							"---------------------------------------------------------------------------"+"\n"
							));
					System.out.println("                  -------------- [ Above all  Unsolve crimes list ] --------------");
				}
				else {
					System.out.println();
					System.out.println("                  |==============================================|");
					System.out.println("                  |  In it police station no any Unsolve crime   |");
					System.out.println("                  |==============================================|");
				}
				System.out.println();
				System.out.println("Enter any number Back");
				System.out.print("Enter Number : ");
				try {
					int num6 = scanner3.nextInt();
					if(num6>=0) {
						System.out.println();
						AllcallimpMethod.allcrimesCall(PSLid);
					}
				} catch (InputMismatchException e) {
					// TODO: handle exception
					System.out.println();
					AllcallimpMethod.allcrimesCall(PSLid);
				}
				
			}
	        else if(num3 == 3) {
	        	System.out.println();
	        	try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        	CrimeDao crimeDao4 = new CrimeDaoImplimantion();
				System.out.print("Enter Crime ID : ");
				int num7 = scanner3.nextInt();
				System.out.print("Enter 'SOLVE' or 'NOTSOLVE' : ");
				String soString = scanner3.next();
				
				String geString = null;
				try {
					geString = crimeDao4.forChangeSVNSVcrimes(soString, num7);
				} catch (CrimeException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				System.out.println();
				System.out.println("Processing....");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println();
				System.out.println("|=============================|");
				System.out.println("|           "+geString+"            |");
				System.out.println("|=============================|");
				System.out.println();
				System.out.println("Enter any number for Back");
				System.out.print("Enter Number : ");
				try {
					int num8 = scanner3.nextInt();
					if(num8>0) {
						System.out.println();
						AllcallimpMethod.allcrimesCall(PSLid);
					}
					
				} catch (InputMismatchException e) {
					System.out.println();
					AllcallimpMethod.allcrimesCall(PSLid);				}
			}
			else if(num3 == 4) {
				AllcallimpMethod.alladdCrimeCll(PSLid);
			}
			else if(num3 == 5) {
				System.out.println();
				System.out.println("Processing....");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("                                 |==============================================|");
				System.out.println("                                 |             LogOut Successfully              |");
				System.out.println("                                 |==============================================|");
				System.out.println();
				System.out.println("                                              Please Wait few saconds");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AllcallimpMethod.allClassholder();
			}
			else if(num3 == 6) {
				AllcallimpMethod.deleteCrimeAndCriminal(PSLid);
			}
			else {
				System.out.println();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// TODO: handle exception
				System.out.println();
				System.out.println("                                    |================================|");
				System.out.println("                                    |      < Enter valid Number >    |");
				System.out.println("                                    |================================|");
				AllcallimpMethod.allcrimesCall(PSLid);
			}
		} catch (InputMismatchException e1) {
			System.out.println();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			// TODO: handle exception
			System.out.println();
			System.out.println("                                    |================================|");
			System.out.println("                                    |  < Please Enter right Number > |");
			System.out.println("                                    |================================|");
			AllcallimpMethod.allcrimesCall(PSLid);
		}
		
	}
	
	public static void allcriminalsCall(String PSid) {
		Scanner scanner4 = new Scanner(System.in);
		System.out.println();
		CrimeDao crimeDao = new CrimeDaoImplimantion();
		List<CrimesAndCriminals> list = null;
		try {
			list = crimeDao.forShowAllCriminal(PSid);
		} catch (CrimnalException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
//		System.out.println(list);
		list.forEach((l) -> System.out.println(
				"Criminal Name         : "+l.getCrmNameString()+"\n"+
				"Criminal age          : "+l.getAge()+"\n"+
				"Criminal Gender       : "+l.getCrmgenderString()+"\n"+
				"Criminal address      : "+l.getCrmaddressString()+"\n"+
				"Criminal Mark in face : "+l.getCrmMarkString()+"\n"+
				"Crime date            : "+l.getCdateString()+"\n"+
				"Crime Type            : "+l.getCrTypeString()+"\n"+
				"Crime                 : "+l.getCrdetailString()+"\n"+
				"Criminal arrest area  : "+l.getCrmarrestareaString()+"\n"+
				"Victim                : "+l.getCvictimString()+"\n"+
				"=============================================================="
				));
		System.out.println();
		try {
			int nut = crimeDao.forcountPoliceStationCrime(PSid);
			System.out.println("                                                                                          Total Criminal in it police Station : "+nut);
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("                 ------------------[ Above all criminals details of it Police Station ]-------------------");
		System.out.println("Enter 1- LogOut");
		System.out.println("Enter any number for back");
		System.out.print("Enter Number : ");
		try {
			int num9 = scanner4.nextInt();
			if(num9==1) {
				System.out.println();
				System.out.println("Processing....");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println();
				System.out.println("                                 |==============================================|");
				System.out.println("                                 |             LogOut Successfully              |");
				System.out.println("                                 |==============================================|");
				System.out.println();
				System.out.println("                                              Please Wait few saconds");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				AllcallimpMethod.allClassholder();
			}
			else {
				System.out.println();
				AllcallimpMethod.alladdCrimeCll(PSid);
			}
			
		} catch (InputMismatchException e) {
			System.out.println();
			AllcallimpMethod.alladdCrimeCll(PSid);
		}
	}
	
	public static void allCriminalBydate(String PSLid) {
		Scanner scanner4 = new Scanner(System.in);
		System.out.println();
		System.out.print("Enter first Date like(2022-11-03) : ");
		String date1 = scanner4.next();
		System.out.print("Enter Second Date like(2022-11-03) : ");
		String date2 = scanner4.next();
		System.out.println();
		CrimeDao crimeDao = new CrimeDaoImplimantion();
		List<CrimesAndCriminals> list = null;
		try {
			list = crimeDao.forShowCriminalbydate(date1, date2);
		} catch (CrimnalException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		if(list.size()>0) {
			System.out.println();
			System.out.println("Processing....");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list.forEach((l) -> System.out.println(
					        "Criminal Name         : "+l.getCrmNameString()+"\n"+
							"Criminal age          : "+l.getAge()+"\n"+
							"Criminal Gender       : "+l.getCrmgenderString()+"\n"+
							"Criminal address      : "+l.getCrmaddressString()+"\n"+
							"Criminal Mark in face : "+l.getCrmMarkString()+"\n"+
							"Crime date            : "+l.getCdateString()+"\n"+
							"Crime Type            : "+l.getCrTypeString()+"\n"+
							"Crime                 : "+l.getCrdetailString()+"\n"+
							"Criminal arrest area  : "+l.getCrmarrestareaString()+"\n"+
							"Victim                : "+l.getCvictimString()+"\n"+
							"Police Station        : "+l.getPoliceStationString()+"\n"+
							"Police Station ID     : "+l.getPoliceID()+"\n"+
							"=============================================================="
					));
			
		}
		else {
			System.out.println("Processing....");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("                              |=================================================|");
			System.out.println("                              |        No any crime between in these dates      |");
			System.out.println("                              |             Please enter right date             |");
			System.out.println("                              |=================================================|");
			System.out.println();

		}
		System.out.println();
		System.out.println("Enter 1- Search Again");
		System.out.println("Enter any Number for Back");
		System.out.print("Enter Number : ");
		try {
			int num10 = scanner4.nextInt();
			if(num10 == 1) {
				System.out.println();
				AllcallimpMethod.allCriminalBydate(PSLid);
			}
			else {
				System.out.println();
				AllcallimpMethod.alladdCrimeCll(PSLid);
			}
			
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println();
			AllcallimpMethod.alladdCrimeCll(PSLid);
		}
		
	}
	
	public static void deleteCrimeAndCriminal(String PSLid) {
		CrimeDao cDao = new CrimeDaoImplimantion();
		int nu = 0;
		try {
			nu = cDao.forDeleteCrime(PSLid);
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nu>0) {
			System.out.println();
			System.out.println("Processing....");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("                              |=================================================|");
			System.out.println("                              |             Crime deleted Successfully          |");
			System.out.println("                              |               Please wait few seconds           |");
			System.out.println("                              |=================================================|");
			System.out.println();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AllcallimpMethod.allcrimesCall(PSLid);;
		}
		else {
			System.out.println();
			System.out.println("Processing....");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			System.out.println("                              |=================================================|");
			System.out.println("                              |                 Something is wrong              |");
			System.out.println("                              |               Please try again later            |");
			System.out.println("                              |=================================================|");
			System.out.println();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AllcallimpMethod.allcrimesCall(PSLid);
		}
	}
}
