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
			
			String emp_id = request.getParameter("textEmpId");
			String full_name = request.getParameter("textName");
			String floor = request.getParameter("floorNo");
			String row = request.getParameter("row_no");
			String col = request.getParameter("col_no");
			
			PreparedStatement preparedStatementToVerify = connection.prepareStatement("select full_name, seat_row, seat_col from seatDetails where floor = ? and seat_row = ? and seat_col = ?;");
			preparedStatementToVerify.setString(1,floor);
			preparedStatementToVerify.setString(2,row);
			preparedStatementToVerify.setString(3,col);
			
			ResultSet resultSet = preparedStatementToVerify.executeQuery();
			
			System.out.println(resultSet.toString());
			
			if(resultSet.next()) {
				System.out.print("working");
				String rowDB = resultSet.getString("seat_row");
				System.out.println("rowDB");
				String colDB = resultSet.getString("seat_col");
				System.out.println("colDB");
				String nameDB = resultSet.getString("full_name");
				System.out.println("nameDB");
				if (row.equals(rowDB)&&col.equals(colDB)) {
					out.println("<font-color=red size=18>Seat already occupied by: "+nameDB);
					out.println("<a href=/Seat-Allocation/allocateSeat.jsp>Try Again!!</a>");
				}
				
			}else {
					
					System.out.println("Working fine till here");
					PreparedStatement preparedStatementToInseret = connection.prepareStatement("insert into seatDetails values(?, ?, ?, ?, ? )");		
					preparedStatementToInseret.setString(1,emp_id);
					preparedStatementToInseret.setString(2,full_name);
					preparedStatementToInseret.setString(3,floor);
					preparedStatementToInseret.setString(4,row);
					preparedStatementToInseret.setString(5,col);
					int checkStatus = preparedStatementToInseret.executeUpdate();
					System.out.println(checkStatus);	
			        if(checkStatus > 0) {
			        
			            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
						requestDispatcher.forward(request, response);
			        }
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
