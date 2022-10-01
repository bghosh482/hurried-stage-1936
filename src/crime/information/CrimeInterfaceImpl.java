package crime.information;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.crime.bean.Case;

import com.crime.bean.Person;
import com.crime.exception.CaseException;
import com.crime.exception.PersonException;
import com.db.util.DBUtil;

public class CrimeInterfaceImpl implements CrimeInterface {

	@Override
	public String loginAdmin(String email, String password) throws PersonException {
		String message = null;

		try (Connection conn = DBUtil.proviedConnection()) {

			PreparedStatement ps = conn.prepareStatement("select name from adminlogin where email=? AND password=? ");
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				message = rs.getString("name");
			} else {
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

		try (Connection conn = DBUtil.proviedConnection()) {

			PreparedStatement ps = conn
					.prepareStatement("insert into adminlogin(name,email,phone,address,password) values(?,?,?,?,?)");

			ps.setString(1, person.getName());
			ps.setString(2, person.getEmail());
			ps.setString(3, person.getPhone());
			ps.setString(4, person.getAddress());
			ps.setString(5, person.getPassword());
			int x = ps.executeUpdate();
			if (x > 0)
				message = "suceesfully registered...";
			else
				throw new PersonException("something wrong happens..");

		} catch (SQLException e) {

			throw new PersonException(e.getMessage());

		}

		return message;
	}

	@Override
	public String registerCase(Case c) throws CaseException {
		String message = null;

		try (Connection conn = DBUtil.proviedConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"insert into crime_case(name,address,crimedate,crime,crimedesc,mainsuspect,cname,cage,cgender,caddress,carrestedarea,status) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, c.getName());
			ps.setString(2, c.getAddress());
			ps.setDate(3, Date.valueOf(c.getDate()));
			ps.setString(4, c.getCrime());
			ps.setString(5, c.getDesc());
			ps.setString(6, c.getMainSuspect());

			ps.setString(7, c.getCriminalname());
			ps.setInt(8, c.getCriminalage());
			ps.setString(9, c.getCriminalgender());
			ps.setString(10, c.getCriminaladdress());
			ps.setString(11, c.getArrestedArea());
			ps.setString(12, "unsolved");
			int x = ps.executeUpdate();
			if (x > 0)
				message = "Your case registered successfully";
			else {
				throw new CaseException("some deatails are missing and try again...");
			}

		} catch (SQLException e) {
			throw new CaseException(e.getMessage());
		}

		return message;
	}

	@Override
	public List<Case> getAllTheCases() throws CaseException {
		List<Case> cases = new ArrayList<>();

		try (Connection conn = DBUtil.proviedConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from crime_case");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("id");
				String n = rs.getString("name");
				String ad = rs.getString("address");
				Date d = rs.getDate("crimedate");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String strdate = dateFormat.format(d);

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate ld = LocalDate.parse(strdate, dtf);

				String crime = rs.getString("crime");
				String crimedesc = rs.getString("crimedesc");
				String mainsuspect = rs.getString("mainsuspect");
				String cname = rs.getString("cname");
				int age = rs.getInt("cage");
				String cgender = rs.getString("cgender");
				String caddress = rs.getString("caddress");
				String carrestedArea = rs.getString("carrestedArea");

				Case c = new Case();
				c.setName(n);
				c.setAddress(ad);
				c.setDate(ld);
				c.setCrime(crime);
				c.setDesc(crimedesc);
				c.setMainSuspect(mainsuspect);
				c.setCriminalname(cname);
				c.setCriminalage(age);
				c.setCriminalgender(cgender);
				c.setCriminaladdress(caddress);
				c.setArrestedArea(carrestedArea);
				cases.add(c);

				if (cases.size() == 0)
					throw new CaseException("No record found..");

			}

		} catch (SQLException e) {
			throw new CaseException(e.getMessage());
		}

		return cases;
	}

	@Override
	public Case GetCaseById(int id) throws CaseException {
		Case c = new Case();
		try (Connection conn = DBUtil.proviedConnection()) {

			PreparedStatement ps = conn.prepareStatement("select * from crime_case where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int cid = rs.getInt("id");
				String n = rs.getString("name");
				String ad = rs.getString("address");
				Date d = rs.getDate("crimedate");
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String strdate = dateFormat.format(d);

				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
				LocalDate ld = LocalDate.parse(strdate, dtf);

				String crime = rs.getString("crime");
				String crimedesc = rs.getString("crimedesc");
				String mainsuspect = rs.getString("mainsuspect");
				String cname = rs.getString("cname");
				int age = rs.getInt("cage");
				String cgender = rs.getString("cgender");
				String caddress = rs.getString("caddress");
				String carrestedArea = rs.getString("carrestedArea");

				c.setName(n);
				c.setAddress(ad);
				c.setDate(ld);
				c.setCrime(crime);
				c.setDesc(crimedesc);
				c.setMainSuspect(mainsuspect);
				c.setCriminalname(cname);
				c.setCriminalage(age);
				c.setCriminalgender(cgender);
				c.setCriminaladdress(caddress);
				c.setArrestedArea(carrestedArea);

			}

		} catch (Exception e) {
			throw new CaseException(e.getMessage());
		}

		return c;
	}

	@Override
	public boolean changeStatusOfCase(int id, String status) throws CaseException {
		boolean state = false;

		try (Connection conn = DBUtil.proviedConnection()) {

			PreparedStatement ps = conn.prepareStatement("update crime_case set status = ? where id = ?");
			ps.setString(1, status);
			ps.setInt(2, id);

			int x = ps.executeUpdate();
			if (x > 0)
				state = true;
			else {
				throw new CaseException("Wrong case id...");
			}

			return state;
		} catch (Exception e) {
			throw new CaseException(e.getMessage());
		}

	}

	@Override
	public String NumberOfsolvedAndUnsolvedCase() throws CaseException {
		String m = null;

		try (Connection conn = DBUtil.proviedConnection()) {
			PreparedStatement ps = conn.prepareStatement("select status from crime_case");
			ResultSet rs = ps.executeQuery();
			int solved = 0;
			int unsolved = 0;
			while (rs.next()) {
				boolean x =  rs.getString("status").equals("solved");
				if (x) {
					solved++;
				} else {
					unsolved++;
				}
			}
			m = "solved case " + solved + " AND unsolved case " + unsolved;
		} catch (SQLException e) {
			throw new CaseException(e.getMessage());
		}

		return m;
	}
}
