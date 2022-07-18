package com.seatAllocation.operations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeallocateSeat
 */
@WebServlet("/DeallocateSeat")
public class DeallocateSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeallocateSeat() {
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
			String Floor = request.getParameter("floorNo");
			System.out.print("Floor number is : "+Floor);
	
			PreparedStatement preparedStatement = connection.prepareStatement("delete from seatDetails where emp_id=? and floor=?;");		
			preparedStatement.setString(1,Emp_id);
			preparedStatement.setString(2,Floor);
			
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
