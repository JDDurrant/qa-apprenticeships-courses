package com.jackdurrant.staff_db_project;

import java.sql.*;

import com.jackdurrant.staff_db_project.models.*;

public class Main {

	public static void main(String[] args) {

		init();
		test();
	}
	// Tests creation, updating and deletion of employees
	public static void test() {

		Staff fromCode = new Staff("Karl", "Pilkington", "AB12 3CD");
		fromCode.save();

		int id = fromCode.get_id();
		System.out.println("New staff member's ID in database: " + id);

		Staff fromDB = Staff.find(id);
		System.out.println("Postcode before: " + fromDB.getPostcode());

		fromCode.setPostcode("EF45 6GH");
		fromCode.save();

		fromDB.refresh();
		System.out.println("Postcode after: " + fromDB.getPostcode());

		fromCode.delete();
	}
	// Checks if staff table has been created, then creates it if it doesn't find one
	public static void init() {

		Connection c = Model.connect();

		try {
			DatabaseMetaData meta = c.getMetaData();
			ResultSet tables = meta.getTables(null, null, "staff", null);

			if(!tables.next()) {
				createTable();
			}
		}
		catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
	}
	// Creates staff table with columns _id:int(11), forename:varchar(45), surname:varchar(45), postcode:varchar(8)
	public static void createTable() {

		try {
			PreparedStatement stmt = Model.statement(
					"CREATE TABLE `staff`.`staff` (" +
							"`_id` INT NOT NULL AUTO_INCREMENT," +
							"`forename` VARCHAR(45) NOT NULL," +
							"`surname` VARCHAR(45) NOT NULL," +
							"`postcode` VARCHAR(8) NOT NULL," +
							"PRIMARY KEY (`_id`)," +
							"UNIQUE INDEX `_id_UNIQUE` (`_id` ASC))"
						);

			stmt.execute();
		}
		catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage());
		}
	}
}
