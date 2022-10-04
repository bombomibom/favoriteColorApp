package com.bomi.favoriteColor.favoriteColor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DB {
	private Connection connection;
	private String dbTableName;
	private String dbUrl = "jdbc:mysql://au77784bkjx6ipju.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/w1uvnz6jjchf3f2s" ;
	private String dbUser = "h6dzhjbgi5nhh2o5";
	private String dbPasswd = "lpeq52n5xur4c44w";
	
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public DB(String dbTableName) {
		this.dbTableName = dbTableName;
	}
	
	public boolean open() {
		try {
			this.connection = DriverManager.getConnection(this.dbUrl, this.dbUser, this.dbPasswd);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean close() {
		if (this.connection == null) {
			return true;
		}
		try {
			this.connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	// insertData
	public void insertData(Color color) throws Exception {
		this.open();
		try {
			String query = "INSERT INTO " + this.dbTableName + "(color) VALUES (?);";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setString(1, color.colorNm);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.close();
	}
	
	// selectData
	public ArrayList<Color> selectData(){
		ArrayList<Color> color = new ArrayList<Color>();
		this.open();
		try {
			String query = "SELECT * FROM " + this.dbTableName + " WHERE ? ORDER BY IDX DESC";
			PreparedStatement preparedStatement = this.connection.prepareStatement(query);
			preparedStatement.setInt(1, 1);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				color.add(new Color(resultSet.getInt("idx"), resultSet.getString("color"), resultSet.getString("reg_datim")));
			}
			resultSet.close();
			preparedStatement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.close();
		return color;
	}
	
}

