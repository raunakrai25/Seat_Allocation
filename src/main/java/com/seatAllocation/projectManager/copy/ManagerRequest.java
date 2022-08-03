package com.seatAllocation.projectManager.copy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerRequest
 */
@WebServlet("/ManagerRequest")
public class ManagerRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerRequest() {
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
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seat_allocation", "root", "1234");
			
			System.out.print("Connection Established...");
			
			String manager_id = request.getParameter("textManagerId");
			String manager_name = request.getParameter("textManagerName");
			String manager_email = request.getParameter("textManagerEmail");
			String emp_id = request.getParameter("textEmpId");
			String full_name = request.getParameter("textName");
			String floor = request.getParameter("floorNo");
			String row = request.getParameter("row_no");
			String col = request.getParameter("col_no");
			String email = request.getParameter("textEmail");
			
			
					
					System.out.println("Working fine till here");
					PreparedStatement preparedStatementToInseret = connection.prepareStatement("insert into managerRequest values(?, ?, ?, ?, ?, ?, ?, ? , ?)");		
					preparedStatementToInseret.setString(1,manager_id);
					preparedStatementToInseret.setString(2,manager_name);
					preparedStatementToInseret.setString(3,manager_email);
					preparedStatementToInseret.setString(4,emp_id);
					preparedStatementToInseret.setString(5,full_name);
					preparedStatementToInseret.setString(6,email);
					preparedStatementToInseret.setString(7,floor);
					preparedStatementToInseret.setString(8,row);
					preparedStatementToInseret.setString(9,col);
					int checkStatus = preparedStatementToInseret.executeUpdate();
					System.out.println(checkStatus);	
			        if(checkStatus > 0) {
			        
			            RequestDispatcher requestDispatcher = request.getRequestDispatcher("View.jsp");
						requestDispatcher.forward(request, response);
			        }
			        
			        String to = manager_email;
			        String from = "rairaunak25@gmail.com";
			        String password = "lodbktzwiaohwgvg";
			        String sub = "Request Send";
			        
			        Properties props = new Properties();    
			          props.put("mail.smtp.host", "smtp.gmail.com");    
			          props.put("mail.smtp.socketFactory.port", "465");    
			          props.put("mail.smtp.socketFactory.class",    
			                    "javax.net.ssl.SSLSocketFactory");    
			          props.put("mail.smtp.auth", "true");    
			          props.put("mail.smtp.port", "465");    
			          
			          Session session = Session.getDefaultInstance(props,    
			                  new javax.mail.Authenticator() {    
			                  protected PasswordAuthentication getPasswordAuthentication() {    
			                  return new PasswordAuthentication(from,password);  
			                  }    
			                 });    
			          
			          try {    
			              MimeMessage message = new MimeMessage(session);    
			              message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
			              message.setSubject(sub);    
			              message.setText("Request send for Seat Number: "+row+col);
			              Transport.send(message);    
			              System.out.println("message sent successfully");    
			             } catch (MessagingException e) {throw new RuntimeException(e);}   
			
				

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
