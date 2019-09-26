package com.excilys.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/views/editComputer")
public class EditComputer extends HttpServlet {

	//public static final String VUE = "/views/editComputer.html";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
