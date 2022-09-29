package com.login.admin;

import java.util.Scanner;

import com.crime.exception.PersonException;

import crime.information.CrimeInterface;
import crime.information.CrimeInterfaceImpl;

public class LoginAsAdmin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter email : ");
		String email = sc.next();

		System.out.println("Enter password : ");
		String password = sc.next();

		CrimeInterface ci = new CrimeInterfaceImpl();
		try {
			String string = ci.loginAdmin(email, password);
			System.out.println("Welcome "+ string);
			

		} catch (PersonException e) {
			System.out.println(e.getMessage());
		}
	}
}
