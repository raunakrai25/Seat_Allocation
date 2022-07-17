package com.seatAllocation.Authentication.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

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
		System.out.print(resultSet);
		String count1 = resultSet.getString("COUNT(*)");
		
		if(floor_no == 1) {
			if(resultSet.next()) {
				String count = resultSet.getString("COUNT(*)");
				int allocated = Integer.parseInt(count);
				int AvailableInt = floor1Capacity - allocated;
				String available = String.valueOf(AvailableInt);
				System.out.println(count);
				request.setAttribute("Allocated", count);
				request.setAttribute("Available", available);
//				RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
//				
//				requestDispatcher.forward(request, response);
			}
			
//			preparedStatement = connection.prepareStatement("select emp_id, full_name, seat_row, seat_col from seatDetails where floor=?;");
//			preparedStatement.setString(1,Floor_no);
//			ResultSet resultSet2 = preparedStatement.executeQuery();
//			
//			ResultSetMetaData resultMeta = (ResultSetMetaData) resultSet2.getMetaData();
//			int columnsNumber = resultMeta.getColumnCount();
//			
//			System.out.println("Number of Rows: " + columnsNumber);
//			
//			ArrayList<String> list1=new ArrayList<String>();
//			ArrayList<String> list2=new ArrayList<String>();
//			ArrayList<String> list3=new ArrayList<String>();
//			ArrayList<String> list4=new ArrayList<String>();
//			while (resultSet2.next()) {
////				int colCount = Integer.parseInt(count1);;
////				for(int x = 1; x>=colCount ; x++) {
////					String emp_id = resultSet2.getString("emp_id");
////					String full_name = resultSet2.getString("full_name");
////					String seat_row = resultSet2.getString("seat_row");
////					String seat_col = resultSet2.getString("seat_col");
////					
////					ArrayList<String> list
////					
////					listx.add(c)
////				}
//				
//				//List<String> Info = new ArrayList<String>();
//				String emp_id = resultSet2.getString("emp_id");
//				list1.add(emp_id);
//				//request.setAttribute("emp_id", emp_id);
//				String full_name = resultSet2.getString("full_name");
//				list2.add(full_name);
//				//request.setAttribute("FullName", full_name);
//
//				String seat_row = resultSet2.getString("seat_row");
//				list3.add(seat_row);
//				//request.setAttribute("seat_row", seat_row);
//
//				String seat_col = resultSet2.getString("seat_col");
//				list4.add(seat_col);
//				
//				//request.setAttribute("seat_col", seat_col);
//				
//				//RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
//			}
//			
//			
//			
//			request.setAttribute("emp_id", list1);
//			request.setAttribute("full_name", list2);
//			request.setAttribute("seat_row", list3);
//			request.setAttribute("seat_col", list4);
//			request.setAttribute("result", resultSet2);
//			
//			System.out.print(list1);
//			System.out.print(list2);
//			System.out.print(list3);
//			System.out.print(list4);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
			
			requestDispatcher.forward(request, response);
//			else {
//				out.println("<font-color=red size=18>Credantials Not Matched");
//				out.println("<a href=/Seat-Allocation/login.jsp>Try Again!!</a>");
//			}
		}
		else if(floor_no == 2) {
			if(resultSet.next()) {
				String count = resultSet.getString("COUNT(*)");
				int allocated = Integer.parseInt(count);
				int AvailableInt = floor2Capacity - allocated;
				String available = String.valueOf(AvailableInt);
				System.out.println(count);
				request.setAttribute("Allocated", count);
				request.setAttribute("Available", available);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
				
				requestDispatcher.forward(request, response);
			}
//			else {
//				out.println("<font-color=red size=18>Credantials Not Matched");
//				out.println("<a href=/Seat-Allocation/login.jsp>Try Again!!</a>");
//			}
		}
		
		else if(floor_no == 3) {
			if(resultSet.next()) {
				String count = resultSet.getString("COUNT(*)");
				int allocated = Integer.parseInt(count);
				int AvailableInt = floor3Capacity - allocated;
				String available = String.valueOf(AvailableInt);
				System.out.println(count);
				request.setAttribute("Allocated", count);
				request.setAttribute("Available", available);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
				
				requestDispatcher.forward(request, response);
			}
//			else {
//				out.println("<font-color=red size=18>Credantials Not Matched");
//				out.println("<a href=/Seat-Allocation/login.jsp>Try Again!!</a>");
//			}
		}
		
		else if(floor_no == 4) {
			if(resultSet.next()) {
				String count = resultSet.getString("COUNT(*)");
				int allocated = Integer.parseInt(count);
				int AvailableInt = floor4Capacity - allocated;
				String available = String.valueOf(AvailableInt);
				System.out.println(count);
				request.setAttribute("Allocated", count);
				request.setAttribute("Available", available);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
				
				requestDispatcher.forward(request, response);
			}
//			else {
//				out.println("<font-color=red size=18>Credantials Not Matched");
//				out.println("<a href=/Seat-Allocation/login.jsp>Try Again!!</a>");
//			}
		}
		
		else if(floor_no == 5) {
			if(resultSet.next()) {
				String count = resultSet.getString("COUNT(*)");
				int allocated = Integer.parseInt(count);
				int AvailableInt = floor5Capacity - allocated;
				String available = String.valueOf(AvailableInt);
				System.out.println(count);
				request.setAttribute("Allocated", count);
				request.setAttribute("Available", available);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
				
				requestDispatcher.forward(request, response);
			}
			
			
//			
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
