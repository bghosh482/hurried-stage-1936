package crime.information;

import com.crime.bean.Case;
import com.crime.bean.Person;
import com.crime.exception.PersonException;

public interface CrimeInterface {
	
	public String loginAdmin(String email,String password) throws PersonException;
	public String registrationAdmin(Person person) throws PersonException;
	public String registerCase(Case c);
	
}
