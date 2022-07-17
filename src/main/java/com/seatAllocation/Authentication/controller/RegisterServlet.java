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

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
			System.out.print("Connection Established...");
			String Full_name = request.getParameter("textName");
			String emp_id = request.getParameter("textEmp_id");
			String email = request.getParameter("textEmail");
			String password = request.getParameter("textPassword");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into teamOPDetails values (?, ?, ?, ?);");		
			preparedStatement.setString(1,emp_id);
			preparedStatement.setString(2,Full_name);
			preparedStatement.setString(3,email);
			preparedStatement.setString(4,password);
			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement("select Full_name from teamOPDetails where Email=? and password=?");
			
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,password);
//			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String fullName = resultSet.getString("Full_name");
				request.setAttribute("Full_name", fullName);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Homepage.jsp");
				
				requestDispatcher.forward(request, response);
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
