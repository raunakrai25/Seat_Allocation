package com.seatAllocation.operations;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class AllocateSeat
 */
@WebServlet("/AllocateSeat")
public class AllocateSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllocateSeat() {
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
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seat_allocation", "root", "1234");
			System.out.print("Connection Established...");
			String Emp_id = request.getParameter("textEmpId");
			String Full_name = request.getParameter("textName");
			String Floor = request.getParameter("floorNo");
			String Row = request.getParameter("row_no");
			String Col = request.getParameter("col_no");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into seatDetails values(?, ?, ?, ?, ? )");		
			preparedStatement.setString(1,Emp_id);
			preparedStatement.setString(2,Full_name);
			preparedStatement.setString(3,Floor);
			preparedStatement.setString(4,Row);
			preparedStatement.setString(5,Col);
			int i = preparedStatement.executeUpdate();

	        if(i > 0) {
	        	
	            out.println("Seat successfully removed...");
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
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
