package com.ems;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<h1>Update Employee</h1>");
		String sid= req.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Emp e =EmpDao.getEmployeeById(id);
		out.print("<Form action='EditServlet1' method='post'>");
		out.print("<table>");
		//for id
		out.print("<tr><td></td><td><input type ='hidden' name='id' value=" +e.getId()+"></td></tr>");
		//for Name
		out.print("<tr><td>Name :</td><td><input type ='text' name='name' value=" +e.getName()+"></td></tr>");
		//for Password
		out.print("<tr><td>Password :</td><td><input type ='password' name='password' value=" +e.getPassword()+"></td></tr>");
		//for Email
		out.print("<tr><td>Email :</td><td><input type ='email' name='email' value=" +e.getEmail()+"></td></tr>");
		//for Country
		out.print("<tr><td>Country :</td><td>");
		out.print("<select name = 'country' style = 'width : 150px;'>");
		out.print("<option hidden>-Select Country-</option><option>India</option><option>USA</option><option>UK</option><option>UAE</option><option>Canada</option></select></td></tr>");
		
		out.print("<tr><td colspan='2'><input type ='submit' value='Edit & Save'></td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();
	}
}
