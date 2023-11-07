package com.ems;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<a href='index.html'>Add New Employee</a>");
		out.print("<h1>Employee List</h1>");
		
		List<Emp> l= EmpDao.getAllEmployees();
		out.print("<table border='1' width=100%");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>country</th>"+"<th>Edit</th><th>Delete</th></tr>");
		
		for(Emp e:l)
		{
			out.print("<tr>"
			+"<td>"+e.getId()+"</td>"
			+"<td>"+e.getName()+"</td>"
			+"<td>"+e.getPassword()+"</td>"
			+"<td>"+e.getEmail()+"</td>"
			+"<td>"+e.getCountry()+"</td>"
			+"<td><a href='EditServlet?id="+e.getId()+" '>Edit</a></td>"
			+"<td><a href='DeleteServlet?id="+e.getId()+" '>Delete</a></td></tr>");
			
		}
		out.print("</table>");
		out.close();
		    
	}

}
