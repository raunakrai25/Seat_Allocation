package manager.model;

public class Request {
	
	private String manager_id;
	private String manager_name;
	private String manager_email;
	private String emp_id;
	private String emp_name;
	private String emp_email;
	private int floor;
	private String seat_row;
	private String seat_col;
	
	public Request() {
		
	}
	
	public Request(String manager_id, String manager_name, String manager_email, String emp_id, String emp_name,
			String emp_email, int floor, String seat_row, String seat_col) {
		super();
		this.manager_id = manager_id;
		this.manager_name = manager_name;
		this.manager_email = manager_email;
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_email = emp_email;
		this.floor = floor;
		this.seat_row = seat_row;
		this.seat_col = seat_col;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getManager_email() {
		return manager_email;
	}

	public void setManager_email(String manager_email) {
		this.manager_email = manager_email;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getSeat_row() {
		return seat_row;
	}

	public void setSeat_row(String seat_row) {
		this.seat_row = seat_row;
	}

	public String getSeat_col() {
		return seat_col;
	}

	public void setSeat_col(String seat_col) {
		this.seat_col = seat_col;
	}
	
}
