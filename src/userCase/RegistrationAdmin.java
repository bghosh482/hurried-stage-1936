package userCase;

import java.util.Scanner;

import com.crime.bean.Person;
import com.crime.exception.PersonException;

import crime.information.CrimeInterface;
import crime.information.CrimeInterfaceImpl;

public class RegistrationAdmin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name : ");
		String name = sc.next();
		
		System.out.println("Enter email : ");
		String email = sc.next();
		System.out.println("Enter phone : ");
		String phone = sc.next();
		System.out.println("Enter Address : ");
		String adress = sc.next();
		System.out.println("Enter password : ");
		String password = sc.next();
		
		Person p = new Person();
		p.setName(name);
		p.setEmail(email);
		p.setPhone(phone);
		p.setAddress(adress);
		p.setPassword(password);
		
		
		CrimeInterface ci = new CrimeInterfaceImpl();
		String m;
		try {
			m = ci.registrationAdmin(p);
		} catch (PersonException e) {
			System.out.println(e.getMessage());
		}
	
		

	}

}
