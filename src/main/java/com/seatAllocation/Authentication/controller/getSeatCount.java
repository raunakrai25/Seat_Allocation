package com.seatAllocation.Authentication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getSeatCount
 */
@WebServlet("/getSeatCount")
public class getSeatCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getSeatCount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = response.getWriter();
			String Floor_no = request.getParameter("Floor_no");
			
			int floor_no = Integer.parseInt(Floor_no);
			
			request.setAttribute("floor", floor_no);
			request.setAttribute("floorNo", Floor_no);
			
			ServletContext context = getServletContext(); // method inherit from HttpServlet
			String CapacityOf1stFloor = context.getInitParameter("Capacity-of-Floor-1");
			String CapacityOf2ndFloor = context.getInitParameter("Capacity-of-Floor-2");
			String CapacityOf3rdFloor = context.getInitParameter("Capacity-of-Floor-3");
			String CapacityOf4thFloor = context.getInitParameter("Capacity-of-Floor-4");
			String CapacityOf5thFloor = context.getInitParameter("Capacity-of-Floor-5");
			
			int floor1Capacity = Integer.parseInt(CapacityOf1stFloor);
			int floor2Capacity = Integer.parseInt(CapacityOf2ndFloor);
			int floor3Capacity = Integer.parseInt(CapacityOf3rdFloor);
			int floor4Capacity = Integer.parseInt(CapacityOf4thFloor);
			int floor5Capacity = Integer.parseInt(CapacityOf5thFloor);
	
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seat_allocation", "root", "1234");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) from  seatDetails where floor=? ;");
			preparedStatement.setString(1,Floor_no);
			ResultSet resultSet = preparedStatement.executeQuery();
		
			if(floor_no == 1) {
				if(resultSet.next()) {
					String count = resultSet.getString("COUNT(*)");
					int allocated = Integer.parseInt(count);
					int AvailableInt = floor1Capacity - allocated;
					String available = String.valueOf(AvailableInt);
					// System.out.println(count);
					request.setAttribute("Allocated", count);
					request.setAttribute("Available", available);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			else if(floor_no == 2) {
				if(resultSet.next()) {
					String count = resultSet.getString("COUNT(*)");
					int allocated = Integer.parseInt(count);
					int AvailableInt = floor2Capacity - allocated;
					String available = String.valueOf(AvailableInt);
					// System.out.println(count);
					request.setAttribute("Allocated", count);
					request.setAttribute("Available", available);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			
			else if(floor_no == 3) {
				if(resultSet.next()) {
					String count = resultSet.getString("COUNT(*)");
					int allocated = Integer.parseInt(count);
					int AvailableInt = floor3Capacity - allocated;
					String available = String.valueOf(AvailableInt);
					// System.out.println(count);
					request.setAttribute("Allocated", count);
					request.setAttribute("Available", available);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");	
					requestDispatcher.forward(request, response);
				}
			}
			
			else if(floor_no == 4) {
				if(resultSet.next()) {
					String count = resultSet.getString("COUNT(*)");
					int allocated = Integer.parseInt(count);
					int AvailableInt = floor4Capacity - allocated;
					String available = String.valueOf(AvailableInt);
					// System.out.println(count);
					request.setAttribute("Allocated", count);
					request.setAttribute("Available", available);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");	
					requestDispatcher.forward(request, response);
				}
			}
			
			else if(floor_no == 5) {
				if(resultSet.next()) {
					String count = resultSet.getString("COUNT(*)");
					int allocated = Integer.parseInt(count);
					int AvailableInt = floor5Capacity - allocated;
					String available = String.valueOf(AvailableInt);
					// System.out.println(count);
					request.setAttribute("Allocated", count);
					request.setAttribute("Available", available);

					RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");	
					requestDispatcher.forward(request, response);
				}
			}
			
			else {
				out.println("<font-color=red size=18>Credantials Not Matched");
				out.println("<a href=/Seat-Allocation/login.jsp>Try Again!!</a>");
			}
		
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}