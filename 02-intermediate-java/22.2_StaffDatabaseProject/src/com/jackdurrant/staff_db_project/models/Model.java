package com.jackdurrant.staff_db_project.models;

import java.sql.*;
import java.util.ArrayList;

public class Model {

	public static Connection connect(String db, String user, String pass)
	{
		Connection c = null;

		try {
			c = DriverManager.getConnection("jdbc:mysql://" + db, user, pass);
		}
		catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}

		return c;
	}

	public static Connection connect()
	{
		return connect("localhost:3306/staff", "root", "Pa$$w0rd");
	}

	public static ResultSet query(String sql) {

		Connection c = connect();
		ResultSet q = null;

		try {
			PreparedStatement stmt = c.prepareStatement(sql);
			q = stmt.executeQuery();
		}
		catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}

		return q;
	}

	public static PreparedStatement statement(String sql) {

		Connection c = connect();
		PreparedStatement s = null;

		try {
			s = c.prepareStatement(sql);
		}
		catch (Exception e) {
			s = null;
		}

		return s;
	}

	public static ResultSet find(String table) {
		return query("SELECT * FROM `?`");
	}
}
