package com.db.util;

import java.sql.Connection;

public class demo {

	public static void main(String[] args) {
		try (Connection conn = DBUtil.proviedConnection()) {
			if(conn !=null)
				System.out.println("connected..");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
