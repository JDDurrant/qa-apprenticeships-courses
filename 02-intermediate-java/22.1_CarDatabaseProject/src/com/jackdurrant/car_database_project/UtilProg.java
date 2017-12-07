package com.jackdurrant.car_database_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilProg {

	public static Connection getConnection(String dbName)
	{
		System.out.println("MySQL Connect Example.");
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "Pa$$w0rd";
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url+dbName,userName,password);
			System.out.println("Connected to the database");
			return conn;
			// conn.close();
			// System.out.println("Disconnected from database");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void createTable(Connection con, String sql)
	{
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		System.out.println("Cars Table Created");
	}

	public static void insertRows(Connection con, String sql) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException ex){
			System.err.println("SQL Exception: " + ex.getMessage());
		}

		System.out.println("Rows Inserted");
	}

	public static void deleteRows(Connection con, String sql) {
		try {
			Statement stmt = con.createStatement();
			int rows = stmt.executeUpdate(sql);
			System.out.println("Rows impacted : " + rows );
			stmt.close();
		}
		catch (SQLException ex) {
			System.err.println("SQL Exception: " + ex.getMessage());
		}
	}

	public static void excecuteRowsWithParam(Connection con, String sql, String param) {
		try {
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString(1,param);
			pStmt.executeUpdate();
			pStmt.close();
		}
		catch (SQLException ex) {
			System.err.println("SQL Exception: " + ex.getMessage());
		}
	}

	public static String selectRowsWithParameter(Connection con, String sql, String param) {
		String result = "Name\t\tAge\t\tSex\t\tLocation\t\tJob\n";
		try {
			PreparedStatement pStmt = con.prepareStatement(sql);
			pStmt.setString( 1, param);
			ResultSet rs = pStmt.executeQuery(sql);
			while (rs.next())
			{
				String name = rs.getString("name");
				String age = rs.getString("age");
				String sex = rs.getString("sex");
				String location = rs.getString("location");
				String job = rs.getString("job");
				result += name + "\t" + age + "\t\t" + sex + "\t\t" + location +
						"\t\t" + job + "\n";
			}
			pStmt.close();
		}
		catch (SQLException ex) {
			System.err.println("SQL Exception: " + ex.getMessage());
		}
		return result;
	}

	public static void updateRows(Connection con, String sql) {
		try {
			Statement stmt = con.createStatement();
			int rows = stmt.executeUpdate(sql);
			System.out.println("Rows impacted : " + rows );
			stmt.close();
		}
		catch (SQLException ex) {
			System.err.println("SQL Exception: " + ex.getMessage());
		}
	}

	public static void updateRowsWithPar(Connection con, String sql, String par1 ) {

		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1,par1);
			int rows = stmt.executeUpdate();
			System.out.println("Rows impacted : " + rows );
			stmt.close();
		}
		catch (SQLException ex) {
			System.err.println("SQL Exception: " + ex.getMessage());
		}
	}

	public static String selectRows(Connection con, String sql) {
		String result = "Name\t\tAge\t\tSex\t\tLocation\t\tJob\n";
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				String name = rs.getString("name");
				String age = rs.getString("age");
				String sex = rs.getString("sex");
				String location = rs.getString("location");
				String job = rs.getString("job");
				result += name + "\t" + age + "\t\t" + sex + "\t\t" + location +
						"\t\t" + job + "\n";
			}
			stmt.close();
		}
		catch (SQLException ex) {
			System.err.println("SQL Exeception: " + ex.getMessage());
		}
		return result;
	}



}
