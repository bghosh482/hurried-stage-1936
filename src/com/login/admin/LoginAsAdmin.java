package com.login.admin;

import java.util.Scanner;

import com.crime.bean.Case;
import com.crime.exception.PersonException;

import crime.information.CrimeInterface;
import crime.information.CrimeInterfaceImpl;

public class LoginAsAdmin {

	public boolean login() throws PersonException {
		Scanner sc = new Scanner(System.in);
		boolean status = false;
		System.out.println("Enter email : ");
		String email = sc.next();

		System.out.println("Enter password : ");
		String password = sc.next();

		CrimeInterface ci = new CrimeInterfaceImpl();
		try {
			String string = ci.loginAdmin(email, password);
			System.out.println("Welcome " + string);
			status = true;

		} catch (Exception e) {
			throw new PersonException(e.getMessage());
		}
		return status;

	}

	public void loginOption() {
		Scanner sc = new Scanner(System.in);

		System.out.println("1.Get All details of cases....");
		System.out.println("2.Get all detais of victim...");
		System.out.println("3. change status of case.");
		System.out.println("4.get case by id ..");
		int choice = sc.nextInt();
		try {
			switch (choice) {
			
			case 3:
				System.out.println("enter case id : ");
				int cid = sc.nextInt();
				System.out.println("Enter staus of the case : ");
				String status = sc.next();
				CrimeInterface ci = new CrimeInterfaceImpl();
				boolean s =  ci.changeStatusOfCase(cid, status);
				if(s)
					System.out.println("update staus sucessfully..");
				else System.out.println("something went wrong.try again..");
				break;
			case 4: {
				System.out.println("Enter case id : ");
				int id = sc.nextInt();
				CrimeInterface ci1 = new CrimeInterfaceImpl();
				Case c= ci1.GetCaseById(id);
				System.out.println(c);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
