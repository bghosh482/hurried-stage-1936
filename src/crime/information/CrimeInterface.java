package crime.information;

import java.util.List;

import com.crime.bean.Case;

import com.crime.bean.Person;
import com.crime.exception.CaseException;
import com.crime.exception.PersonException;

public interface CrimeInterface {
	
	public String loginAdmin(String email,String password) throws PersonException;
	public String registrationAdmin(Person person) throws PersonException;
	public String registerCase(Case c) throws CaseException;
	public List<Case> getAllTheCases() throws CaseException;
	public Case GetCaseById(int id) throws CaseException;
	
	public boolean changeStatusOfCase(int id, String status) throws CaseException;
	
	public String NumberOfsolvedAndUnsolvedCase() throws CaseException;
	
	
}
