package com.jackdurrant.car_database_project;

import java.sql.*;

import javax.swing.*;

public class Cars_2
{
	public static void main(String[] args)
	{
		DataUtil dsCar = new DataUtil();
		Connection con = dsCar.getConnection();

		String createString;
		createString = "create table Cars (" + 	"Reg VARCHAR (8), " +
						"Make VARCHAR (10), " +
						"Model VARCHAR (10), " +
						"Color VARCHAR (10))";

		dsCar.createTable(con, createString);
		String strRow1 = "insert into Cars values('SW51 5TQ', 'Ford', 'Mustang', 'Red');";
		String strRow2 = "insert into Cars values('AWT 754T', 'Fiat', 'Panda', 'Black');";
		dsCar.insertRows(con,strRow1 );
		dsCar.insertRows(con,strRow2 );

		String strUpdate = "UPDATE Cars SET Make='Benz' WHERE Reg='AWT 754T'";
		dsCar.updateRows(con, strUpdate );

		String strSelect = "Select * from Cars";
		dsCar.selectRows(con,strSelect);

		String strUpdateWithPar = "UPDATE Cars SET Make='Benz' WHERE Reg=?";
		String strPar1 = "SW51 5TQ";
		dsCar.updateRowsWithPar(con, strUpdateWithPar, strPar1);

		strSelect = "Select * from Cars";
		dsCar.selectRows(con, strSelect);

		strSelect = "delete from Cars where Make='Benz'";
		dsCar.deleteRows(con, strSelect);

		strSelect = "Select * from Cars";
		dsCar.selectRows(con, strSelect);

	}

}