package userCase;

import java.util.List;
import java.util.Scanner;

import com.crime.bean.Case;
import com.crime.exception.PersonException;
import com.login.admin.LoginAsAdmin;

import crime.information.CrimeInterface;
import crime.information.CrimeInterfaceImpl;

public class Home {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice : ");
		System.out.println("1.Login as admin");
		System.out.println("2.Register Case");
		System.out.println("3.Registered as admin");
		System.out.println("4.Get all cases..");
		System.out.println("5.solve and unsolved cases number");
		int choice = sc.nextInt();
		try {
			switch (choice) {
			case 1: {
				LoginAsAdmin loginAsAdmin = new LoginAsAdmin();
				boolean status =  loginAsAdmin.login();
				if(status) {
					loginAsAdmin.loginOption();
				}
				
				break;

			}
			case 2: {
				RegisterCase registerCase = new RegisterCase();
				registerCase.register();
				break;
			}
			case 3: {
				RegistrationAdmin registrationAdmin = new RegistrationAdmin();
				registrationAdmin.registerAdmin();
				break;
			}
			case 4: {
				CrimeInterface crimeInterface = new CrimeInterfaceImpl();
				List<Case> cases = crimeInterface.getAllTheCases();
				cases.forEach(c -> System.out.println(c));                                                                                                                                                                                                     
				break;
			}
			case 5:
				CrimeInterface ci = new CrimeInterfaceImpl();
				String m =  ci.NumberOfsolvedAndUnsolvedCase();
				System.out.println(m);
				break;
			default:
				System.out.println("enter wrong input");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
