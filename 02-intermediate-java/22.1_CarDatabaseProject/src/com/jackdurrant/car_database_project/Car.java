package com.jackdurrant.car_database_project;

import java.sql.*;


public class Car
{
	public static void main(String[] args)
	{
		Connection con = getConnection();
		createTable(con);
		insertRows(con);
		selectRows(con);
	}

	public static void createTable(Connection con)
	{

		String createString;
		createString =
			"create table Cars (" +
				"Reg VARCHAR (8), " +
				"Make VARCHAR (10), " +
				"Model VARCHAR (10), " +
				"Color VARCHAR (10)" +
			")";
		try
		{
			Statement stmt = con.createStatement();
			stmt.executeUpdate(createString);
			stmt.close();
			// con.close();
		}
		catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		System.out.println("Cars Table Created");
	}



	public static void insertRows(Connection con) {


		String insertString1 = "insert into Cars values('SW51 5TQ', 'Ford', 'Mustang', 'Red');";
		String insertString2 = "insert into Cars values('AWT 754T', 'Fiat', 'Panda', 'Black');";

		try
		{
			Statement stmt = con.createStatement();
			stmt.executeUpdate(insertString1);
			stmt.executeUpdate(insertString2);

			stmt.close();
		}
		catch (SQLException ex) {
			System.err.println("SQL Exception: " + ex.getMessage());
		}

		System.out.println("Rows Inserted");
	}

	public static void selectRows(Connection con) {
		String selectString = "Select * from Cars";

		String result = "Reg\t\tMake\t\tModel\t\tColor\n";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selectString);
			while (rs.next())
			{
				String Reg = rs.getString("Reg");
				String Make = rs.getString("Make");
				String Model = rs.getString("Model");
				String Color = rs.getString("Color");
				result += Reg + "\t" + Make + "\t\t" + Model + "\t\t" + Color + "\n";
			}
			stmt.close();
		}
		catch (SQLException ex) {
			System.err.println("SQL Exeception: " + ex.getMessage());
		}

		System.out.println(result);
	}

	public static Connection getConnection()
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
}