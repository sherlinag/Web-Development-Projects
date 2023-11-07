package com.ems;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String country=req.getParameter("country");
		
		Emp e=new Emp();
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		
		int status=EmpDao.save(e);
		//check weather data inserted or not 
		if(status>0)
		{
			out.write("<script type = 'text/javascript'>");
			out.print("alert('Record saved successfully')");
			out.print("</script>");
			RequestDispatcher rd =req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		else {
			out.write("<script type = 'text/javascript'>");
			out.print("alert('sorry! unable to save record')");
			out.print("</script>");
			//resp.sendRedirect("Table.html");
			RequestDispatcher rd =req.getRequestDispatcher("index.html");
			rd.include(req, resp);
		}
		//out.close();

	}
	

}
