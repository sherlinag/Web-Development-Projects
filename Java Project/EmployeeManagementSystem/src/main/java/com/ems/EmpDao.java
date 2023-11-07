package com.ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDao 
{
	public static Connection getConnection()
	{
		Connection con=null;
		String dburl = "jdbc:mysql://localhost:3306/ems?user=root&password=root";
		//loading the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(dburl);
			
		}
		catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return con;
		
	}
	public static int save(Emp e)//inserting the data
	{
		int status=0;
		int count =0;
		Connection con =EmpDao.getConnection();
		try {
			PreparedStatement psmt=con.prepareStatement("insert into user(name,password,email,country)values(?,?,?,?)");
			psmt.setString(1,e.getName());
			psmt.setString(2,e.getPassword());
			psmt.setString(3,e.getEmail());
			psmt.setString(4,e.getCountry());
			count=psmt.executeUpdate();
			con.close();
		} 
		catch (SQLException e1) 
		{
			
			e1.printStackTrace();
		}
		return count;
	}
	public static int update(Emp e)// modification purpose
	{
		int status=0;
		int count=0;
		Connection con=EmpDao.getConnection(); 
		try {
			PreparedStatement psmt = con.prepareStatement("update user set name=?,password=?,email=?,country=? where id=?");
			psmt.setString(1,e.getName());
			psmt.setString(2,e.getPassword());
			psmt.setString(3,e.getEmail());
			psmt.setString(4,e.getCountry());
			psmt.setInt(5, e.getId());
			status=psmt.executeUpdate();
			count=psmt.executeUpdate();
			con.close();
		} 
		catch (SQLException e1)
		{
			
			e1.printStackTrace();
		} 
		return status;
		
	}
	public static int delete(int id)
	{
		int status=0;
		Connection con=EmpDao.getConnection();
		try {
			PreparedStatement psmt= con.prepareStatement("delete from user where id=?");
			psmt.setInt(1, id);
			status=psmt.executeUpdate();
			con.close();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}
	public static Emp getEmployeeById(int id)
	{
		Emp e =new Emp();
		Connection con = EmpDao.getConnection();
		PreparedStatement psmt;
		try {
			psmt = con.prepareStatement("select * from user where id=?");
			psmt.setInt(1,id);
			ResultSet rs=psmt.executeQuery();
			if(rs.next())
			{
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			else
			{
				System.out.println("Given Id is not Present : "+id);
			}
			con.close();
			
	
		}
		catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		return e;
	}
	public static List<Emp> getAllEmployees()
	{
		Connection con = EmpDao.getConnection();
		List <Emp> l = new ArrayList<Emp>();
		try {
			PreparedStatement psmt = con.prepareStatement("select * from user");
			ResultSet rs = psmt.executeQuery();	
			
			while(rs.next())
			{
				Emp e=new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setEmail(rs.getString(4));
				e.setCountry(rs.getString(5));
				l.add(e);	
			}
			con.close();
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return l;
	}
}