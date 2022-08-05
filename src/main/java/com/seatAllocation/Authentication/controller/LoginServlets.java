package com.seatAllocation.Authentication.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlets
 */
@WebServlet("/LoginServlets")
public class LoginServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seat_allocation", "root", "1234");
			String email = request.getParameter("textEmail");
			String password = request.getParameter("textPassword");
			
			PreparedStatement preparedStatement = connection.prepareStatement("select Full_name from teamOPDetails where Email=? and password=?");
		
			HttpSession session = request.getSession();
			
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,password);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String fullName = resultSet.getString("Full_name");
				//request.setAttribute("Full_name", fullName);
				session.setAttribute("username", fullName);
				if(session!=null) {
					response.sendRedirect("Homepage.jsp?name=" + fullName);
				}
//				RequestDispatcher  = request.getRequestDispatcher("Homepage.jsp"); 
//				requestDispatcher.forward(request, response);
			}
			else {
				String wrong = "Invalid Password or Email";
	            request.setAttribute("displayError", wrong);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
	            requestDispatcher.include(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
