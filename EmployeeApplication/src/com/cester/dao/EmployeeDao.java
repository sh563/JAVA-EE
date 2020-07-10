package com.cester.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cester.model.Employee;

public class EmployeeDao {

	public Connection getConnection() {

		Connection con = null;

		String url = "jdbc:mysql://localhost:3306/emps";
		String user = "root";
		String pwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

			System.out.println("Connection successful:");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public List<Employee> display() {

		Connection con = getConnection();

		String sql = "select * from employee";

		List<Employee> list = new ArrayList<>();

		try {
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			
			
			while (rs.next()) {

				Employee e = new Employee(rs.getInt("employeeId"), rs.getString("emplyeename"), rs.getString("contact"),rs.getString("city"));

				list.add(e);
			}

			System.out.println(list);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
	
	public Employee getEmployeeByID(int curr_id){
		
		Connection con = getConnection();
		
		String sql ="select * from Employee where id=?";
		
		int status = 0 ;
		
		Employee emp = null ;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, curr_id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				 emp = new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("contact"),rs.getString("city"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
		
		
	}
	
	/*public int update(int old_id ,Employee e_updated){
		
		Connection con = getConnection();
		
		int status = 0 ;
		String sql = "update Employee set id=? ,name=? , contact=? , city=? where id=? ";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,e_updated.getId());
			
			pstmt.setString(2,e_updated.getName());
			
			pstmt.setString(3, e_updated.getContact());
			
			pstmt.setString(4, e_updated.getCity());
			
			pstmt.setInt(5, old_id);
			
			status = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;*/
	public int update (int curr_id,Employee emp_updated) {
		
		int status =0;
		String sql ="update Employee set id=? , neme=?, contact=?, city=? where id=?";
		Connection con =getConnection();
		try {
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, emp_updated.getEmployeeId());
		pstmt.setString(2,emp_updated.getEmplyeename());
		
		pstmt.setString(3, emp_updated.getContact());
		
		pstmt.setString(4, emp_updated.getcity());
		pstmt.setInt(5, curr_id);
		
		status = pstmt.executeUpdate();
		
		
		
		}
		
				
	}
		
		
		
		
		
		
		
	}
	
	

}
