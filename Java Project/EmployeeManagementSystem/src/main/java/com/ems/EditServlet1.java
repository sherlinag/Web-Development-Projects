package com.ems;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet1")
public class EditServlet1 extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		
		String sid=req.getParameter("id");
		int id =Integer.parseInt(sid);
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String country=req.getParameter("country");
		//making write only data
		Emp e =new Emp();
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		//check update is done or not
		int status =EmpDao.update(e);
		if(status>0)
		{
			resp.sendRedirect("ViewServlet");
		}
		else 
		{
			out.print("Sorry! Unable to Update the Record");
		}
		out.close();
		
	}

}
