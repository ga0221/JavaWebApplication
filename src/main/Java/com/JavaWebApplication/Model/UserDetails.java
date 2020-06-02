package com.JavaWebApplication.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.JavaWebApplication.Beans.RegisterBean;

public class UserDetails {
	String s1 = null;

	public String insertUserDetails(RegisterBean regUser) {

		DbConnection db = new DbConnection();
		Connection con = db.getCon();

		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO userdetails (userName, email, password) VALUES ('" + regUser.getName()
					+ "','" + regUser.getEmail() + "','" + regUser.getPassword() + "')");
			s1 = "Data Inserted!";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s1;

	}

	public String readUserDetails(RegisterBean regUser) throws Exception {
		// RegisterBean regUser = new RegisterBean();
		DbConnection db = new DbConnection();
		Connection con = db.getCon();

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select userName, password from userdetails where email='"
					+ regUser.getEmail() + "' and password='" + regUser.getPassword() + "'");
			if (rs.next()) {
				return "Success";
			} else {
				return "fail";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Exception Exception = e;
			e.printStackTrace();
			throw Exception;
		}
	}

}
