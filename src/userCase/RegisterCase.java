package userCase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import com.crime.bean.Case;
import com.crime.exception.CaseException;

import crime.information.CrimeInterface;
import crime.information.CrimeInterfaceImpl;

public class RegisterCase {

	public  void register() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your name : ");
		String name = sc.nextLine();
		
		System.out.println("Enter your address : ");
		String address = sc.nextLine();
		
		System.out.println("Enter date : (yyyy/MM/dd) ");
		String date = sc.nextLine();
		
		
		System.out.println("Enter crime :(theft,homicide etc) ");
		String crime = sc.nextLine();
		System.out.println("Enter crime description : ");
		String desc = sc.nextLine();
		
		System.out.println("Enter main suspect: ");
		String mainsuspect = sc.nextLine();
		
		System.out.println("Enter criminal name :  ");
		String criminal = sc.nextLine();
		
		System.out.println("Enter criminal age : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter criminal gender : ");
		String gender = sc.nextLine();
		
		System.out.println("Enter criminal address : ");
		String criminalAddress = sc.nextLine();
		
		System.out.println("Enter Arrested area : ");
		String arrestedArea = sc.nextLine();
		
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate date2 = LocalDate.parse(date,dtf);
		
		
		Case case1 = new Case();
		
		case1.setName(name);
		case1.setAddress(address);
		case1.setDate(date2);
		case1.setCrime(crime);
		case1.setDesc(desc);
		case1.setMainSuspect(mainsuspect);
		case1.setCriminalname(criminal);
		case1.setCriminalgender(gender);
		case1.setCriminalage(age);
		case1.setCriminaladdress(criminalAddress);
		
		case1.setArrestedArea(arrestedArea);
		
		CrimeInterface c = new CrimeInterfaceImpl();
		try {
			String m = c.registerCase(case1);
			System.out.println(m);
			
		} catch (CaseException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		
		

	}

}
