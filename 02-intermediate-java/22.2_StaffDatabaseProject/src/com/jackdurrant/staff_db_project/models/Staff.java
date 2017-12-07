package com.jackdurrant.staff_db_project.models;

import java.sql.*;

public class Staff {

	private Integer _id = null;
	private String forename;
	private String surname;
	private String postcode;

	public Staff(String forename, String surname, String postcode) {

		this.forename = forename;
		this.surname = surname;
		this.postcode = postcode;
	}

	public Staff(int id, String forename, String surname, String postcode) {

		this(forename, surname, postcode);
		this.set_id(id);
	}
	// Finds a staff member with the given id and returns it as a Staff object
	public static Staff find(int id) {

		Staff s = null;

		try {
			PreparedStatement stmt = Model.statement(
					"SELECT * FROM `staff` WHERE `_id` = ?");

			stmt.setInt(1, id);

			ResultSet query = stmt.executeQuery();
			query.next();

			s = new Staff(
					query.getInt("_id"),
					query.getString("forename"),
					query.getString("surname"),
					query.getString("postcode")
				);
		}
		catch (SQLException e) {
			System.err.println("Couldn't find staff member");
		}

		return s;
	}

	public void refresh() {

		if (this._id != null) {
			Staff s = Staff.find(this._id);

			this.forename = s.forename;
			this.surname = s.surname;
			this.postcode = s.postcode;
		}
		else {
			System.out.println("This Staff object isn't in the database.");
		}
	}

	public void save() {

		if (this._id == null) {
			PreparedStatement add = Model.statement(
					"INSERT INTO `staff` (`forename`, `surname`, `postcode`) VALUES (?, ?, ?)");

			try {
				add.setString(1, this.forename);
				add.setString(2, this.surname);
				add.setString(3, this.postcode);

				add.execute();

				PreparedStatement find = Model.statement(
						"SELECT _id FROM `staff` WHERE `forename` = ? AND `surname` = ? AND `postcode` = ?");

				find.setString(1, this.forename);
				find.setString(2, this.surname);
				find.setString(3, this.postcode);

				ResultSet query = find.executeQuery();
				query.next();

				this._id = query.getInt("_id");
			}
			catch (SQLException e) {
				System.err.println("SQLException: " + e.getMessage());
			}
		}
		else {
			PreparedStatement stmt = Model.statement(
					"UPDATE `staff` SET `forename` = ?, `surname` = ?, `postcode` = ? WHERE `_id` = ?");

			try {
				stmt.setString(1, this.forename);
				stmt.setString(2, this.surname);
				stmt.setString(3, this.postcode);
				stmt.setInt(4, this._id);

				stmt.execute();
			}
			catch (SQLException e) {
				System.err.println("SQLException: " + e.getMessage());
			}
		}
	}

	public void delete() {

		if (this._id != null) {
			PreparedStatement stmt = Model.statement("DELETE FROM `staff` WHERE `_id` = ?");

			try {
				stmt.setInt(1, this._id);
				stmt.execute();

				this._id = null;
			}
			catch (SQLException e) {
				System.err.println("SQLException: " + e.getMessage());
			}
		}
		else {
			System.out.println("This object hasn't been written to the database yet.");
		}
	}

	public Integer get_id() {
		return _id;
	}
	public String getForename() {
		return forename;
	}
	public String getSurname() {
		return surname;
	}
	public String getPostcode() {
		return postcode;
	}
	public void set_id(Integer id) {
		this._id = id;
	}
	public void setForename(String forename) {
		this.forename = forename;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
}
