package crime.information;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crime.bean.Case;
import com.crime.bean.Person;
import com.crime.exception.PersonException;
import com.db.util.DBUtil;

public class CrimeInterfaceImpl implements CrimeInterface {

	@Override
	public String loginAdmin(String email, String password) throws PersonException{
		String message = null;
		
		
		try(Connection conn = DBUtil.proviedConnection()) {
		
			PreparedStatement ps = conn.prepareStatement("select name from adminlogin where email=? AND password=? ");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs =  ps.executeQuery();
			if(rs.next()) {
				message=rs.getString("name");
			}
			else {
				throw new PersonException("wrong username and password");
			}
			
		} catch (SQLException e) {
			throw new PersonException(e.getMessage());
		}
		
		
		
		return message;
	}

	@Override
	public String registrationAdmin(Person person) throws PersonException {
		String message = null;
		
		try (Connection conn =  DBUtil.proviedConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("insert into adminlogin(name,email,phone,address,password) values(?,?,?,?,?)");
			
			ps.setString(1, person.getName());
			ps.setString(2, person.getEmail());
			ps.setString(3, person.getPhone());
			ps.setString(4, person.getAddress());
			ps.setString(5, person.getPassword());
			int x =  ps.executeUpdate();
			if(x>0)
				message="suceesfully registered...";
			else
				throw new PersonException("something wrong happens..");
			
		} catch (SQLException e) {
			
			throw new PersonException(e.getMessage());
			
		}
		
		return message;
	}

	@Override
	public String registerCase(Case c) {
		String message = null;
		
		try (Connection conn = DBUtil.proviedConnection()){
			
		
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		
		return message;
	}
	
	

}
