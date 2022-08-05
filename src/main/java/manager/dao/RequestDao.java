package manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import manager.model.Request;

public class RequestDao {
	
	private Connection connection;
	private String query;
	private PreparedStatement preparedstatement;
	private ResultSet resultSet;
	public RequestDao(Connection connection) {
		
		this.connection = connection;
	}
	
	public List<Request> getAllRequest(){
		List<Request> request = new ArrayList<Request>();
		
		try {
			query="select * from managerRequest;";
			preparedstatement = this.connection.prepareStatement(query);
			resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				Request row = new Request();
				row.setEmp_name(resultSet.getString("employee_fullName"));
				row.setManager_name(resultSet.getString("Manager_Name"));
				row.setEmp_id(resultSet.getString("employee_ID"));
				row.setEmp_email(resultSet.getString("Employee_email"));
				row.setFloor(resultSet.getInt("floor"));
				row.setSeat_col(resultSet.getString("seat_col"));
				row.setSeat_row(resultSet.getString("seat_row"));
				
				request.add(row);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return request;
	}
}
