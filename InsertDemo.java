package com.jsp.insert;

import java.sql.*;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Name :");
		String name=sc.next();
		System.out.println("Enter the Email :");
		String email=sc.next();
		System.out.println("Enter the Password :");
		String pass=sc.next();
		System.out.println("Entet the Gender :");
		String gen=sc.next();
		System.out.println("Enter the City :");
		String city=sc.next();
		Connection con=null;
		PreparedStatement pstmt=null;
		String query="insert into student values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Load and Register the Driver class");
			String db="jdbc:mysql://localhost:3306/jdbc_db";
			String user="root";
			String password="neha928@";
			con=DriverManager.getConnection(db,user,password);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, pass);
			pstmt.setString(4, gen);
			pstmt.setString(5, city);
			int i=pstmt.executeUpdate();
			if(i>0) {
				System.out.println("Data is succesfully inserted");
			}else{
				System.out.println("Data is not inserted");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}


	}

}
