import java.sql.*;

import javax.swing.*;

import com.mysql.jdbc.Statement;

public class Cars_1
{
	public static void main(String[] args)
	{
			Connection con = getConnection();
			//updateData(con);
			updateDataWithParameter(con);
			//createTable(con);
			//insertRows(con);
			selectRows(con);
			selectRecord(con, "Lexus", "Black");
	}

	public static Connection getConnection()
	{
			System.out.println("MySQL Connect Example.");
			Connection conn = null;
			String url = "jdbc:mysql://localhost:3306/";
			String dbName = "car";
			String driver = "com.mysql.jdbc.Driver";

			String userName = "root";
			String password = "";
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

	public static void createTable(Connection con)
	{
		String createString;
			createString = "create table Cars (" + 	"Reg VARCHAR (8), " +
					"Make VARCHAR (10), " +
					"Model VARCHAR (10), " +
					"Color VARCHAR (10))";
			try
			{
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate(createString);
				stmt.close();
				// con.close();
			}catch (SQLException ex){System.err.println("SQLException: " + ex.getMessage());}

			System.out.println("Cars Table Created");
	}
	public static void insertRows(Connection con) {

			String insertString1 = "insert into Cars values('SW51 5TQ', 'Ford', 'Mustang', 'Red');";
			String insertString2 = "insert into Cars values('AWT 754T', 'Fiat', 'Panda', 'Black');";
			String insertString3 = "insert into Cars values('AWT 754T', 'BMW', 'X6', 'Black');";

			try
			{
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate(insertString1);
				stmt.executeUpdate(insertString2);
				stmt.executeUpdate(insertString3);

				stmt.close();
			}catch (SQLException ex){System.err.println("SQL Exception: " + ex.getMessage());}
			System.out.println("Rows Inserted");
	}
	public static void selectRows(Connection con) {
			String selectString = "Select * from Cars ";
			String result = "Reg\t\tMake\t\tModel\t\tColor\n";
			try
			{
				java.sql.Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(selectString);
				System.out.println(rowCount(rs));
				//rs.setFetchSize(10);

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

	public static void selectRecord(Connection con, String make, String colour) {
		String result = "Reg\t\tMake\t\tModel\t\tColor\n";
		String selectString = "SELECT * FROM Cars WHERE Make = ? and Color = ?";
		try
		{
			PreparedStatement pStmt = con.prepareStatement(selectString);
			pStmt.setString(1, make);
			pStmt.setString(2, colour);
			ResultSet rs = pStmt.executeQuery();
			System.out.println(rowCount(rs));

			while (rs.next())
			{
				String Reg = rs.getString("Reg");
				String Make = rs.getString("Make");
				String Model = rs.getString("Model");
				String Color = rs.getString("Color");
				result += Reg + "\t" + Make + "\t\t" + Model + "\t\t" + Color + "\n";
			}
			pStmt.close();
		}catch(SQLException ex){System.err.println("SQL Exeception: " + ex.getMessage());}
		System.out.println(result);
}
	public static void updateData(Connection con) {
		String selectString = "update Cars set Make = 'Ford' where Reg = 'SW51 5TQ'";
		try
		{
			java.sql.Statement stmt = con.createStatement();
			stmt.executeUpdate(selectString);
			stmt.close();
		}
		catch (SQLException ex)
		{
			System.err.println("SQL Exception: " + ex.getMessage());
		}
	}

	public static void updateDataWithParameter(Connection con) {
		String selectString = "UPDATE Cars SET Make=? WHERE Reg=?";


		try
		{
			PreparedStatement pStmt = con.prepareStatement(selectString);
			pStmt.setString(1,"Audi");
			pStmt.setString(2,"SW51 5TQ");

			pStmt.executeUpdate();

			pStmt.close();
		}
		catch (SQLException ex)
		{
			System.err.println("SQL Exception: " + ex.getMessage());
		}
	}

	public static int rowCount(ResultSet rs) throws SQLException{
	     int rowCount = 0;
	     int currRow = rs.getRow();
	     // Valid ResultSet?
	     if (!rs.last()) return -1;
	     rowCount = rs.getRow();
	     // Return the cursor to the current position
	     if (currRow == 0) rs.beforeFirst();
	     else rs.absolute(currRow);
	    return rowCount;
	 }
}