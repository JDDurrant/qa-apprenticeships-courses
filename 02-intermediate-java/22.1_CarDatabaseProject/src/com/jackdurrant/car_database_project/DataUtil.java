package com.jackdurrant.car_database_project;

import java.sql.*;

public class DataUtil {

	public Connection getConnection()
	{
			System.out.println("MySQL Connect Example.");
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "cars";
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
	public void createTable(Connection con, String sql)
	{
		try
		{
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
			// con.close();
		}catch (SQLException ex){System.err.println("SQLException: " + ex.getMessage());}

		System.out.println("Cars Table Created");
	}

	public void insertRows(Connection con, String sql) {
		try
		{
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);
			stmt.close();
		}catch (SQLException ex){System.err.println("SQL Exception: " + ex.getMessage());}
		System.out.println("Rows Inserted");
	}

	public void deleteRows(Connection con, String sql) {
		try
		{
			Statement stmt = con.createStatement();
			int rows = stmt.executeUpdate(sql);
			System.out.println("Rows impacted : " + rows );
			stmt.close();
		}
		catch (SQLException ex)
		{
			System.err.println("SQL Exception: " + ex.getMessage());
		}
	}
	public void updateRows(Connection con, String sql) {
		try
		{
			Statement stmt = con.createStatement();
			int rows = stmt.executeUpdate(sql);
			System.out.println("Rows impacted : " + rows );
			stmt.close();
		}
		catch (SQLException ex)
		{
			System.err.println("SQL Exception: " + ex.getMessage());
		}
	}

	public void updateRowsWithPar(Connection con, String sql, String par1 ) {

		PreparedStatement stmt = null;
		try
		{
			stmt = con.prepareStatement(sql);
			stmt.setString(1,par1);
			int rows = stmt.executeUpdate();
			System.out.println("Rows impacted : " + rows );
			stmt.close();
		}
		catch (SQLException ex)
		{
			System.err.println("SQL Exception: " + ex.getMessage());
		}
	}

	public void selectRows(Connection con, String sql) {
		String result = "Reg\t\tMake\t\tModel\t\tColor\n";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next())
			{
				String Reg = rs.getString("Reg");
				String Make = rs.getString("Make");
				String Model = rs.getString("Model");
				String Color = rs.getString("Color");
				result += Reg + "\t" + Make + "\t\t" + Model + "\t\t" + Color + "\n";
			}
			stmt.close();
		}catch(SQLException ex){System.err.println("SQL Exeception: " + ex.getMessage());}
		System.out.println(result);
	}

}
