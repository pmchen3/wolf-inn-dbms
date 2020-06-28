import java.sql.*;
import java.util.Scanner;

/**
 * The WolfInns program is a  database management system for a demo hotel database.
 * @author Chen, Kollipara
 *
 */
public class WolfInns {

	private static final String jdbcURL = "jdbc:mariadb://";
	private static final String user = "";
	private static final String password = "";
	
	public Scanner console = new Scanner(System.in);
	
	Connection connection = null;
	Statement statement = null;
	ResultSet result = null;
	
	// Start program
	public static void main(String[] args) {
		WolfInns wolfinns = new WolfInns();
		wolfinns.run();
	}
	
	// Run the program. Contains main menu.
	public void run() {
		try {
			// Loading the driver. This creates an instance of the driver
			// and calls the registerDriver method to make MySql(MariaDB) Thin available to clients.
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Get a connection instance from the first driver in the
			// DriverManager list that recognizes the URL jdbcURL
			connection = DriverManager.getConnection(jdbcURL, user, password);

			// Create a statement instance that will be sending
			// your SQL statements to the DBMS
			statement = connection.createStatement();

		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		boolean cont = true;
		
		while(cont) {
			String actionNumber;
			
			System.out.print("Enter action (number) 1-Hotel, 2-Staff, 3-Customer, 4-Billing, 5-ServiceReq, 6-Room, 7-Checkin, 8-Report, 0-Quit:  ");
			actionNumber = console.nextLine();
			
			if (actionNumber.length() == 1) {
				
				if (actionNumber.equals("1")) {
					System.out.println("Hotel");
					
					System.out.print("Enter action (number) 1-Add, 2-Update, 3-Delete: ");
					actionNumber = console.nextLine();
					
					if (actionNumber.length() == 1) {
						
						if (actionNumber.equals("1")) {
							System.out.println("Add");
							addHotel();
							
						} else if (actionNumber.equals("2")) {
							System.out.println("Update");
							updateHotel();
							
						} else if (actionNumber.equals("3")) {
							System.out.println("Delete");
							deleteHotel();
							
						} else {
							System.out.println("Invalid number.");
						}
						
					} else {
						System.out.println("Invalid input.");
					}
					
				} else if (actionNumber.equals("2")) {
					System.out.println("Staff");
					
					System.out.print("Enter action (number) 1-Add, 2-Update, 3-Delete: ");
					actionNumber = console.nextLine();
					
					if (actionNumber.length() == 1) {
						if (actionNumber.equals("1")) {
							System.out.println("Add");
							addStaff();
							
						} else if (actionNumber.equals("2")) {
							System.out.println("Update");
							updateStaff();
							
						} else if (actionNumber.equals("3")) {
							System.out.println("Delete");
							deleteStaff();
							
						} else {
							System.out.println("Invalid number.");
						}
					} else {
						System.out.println("Invalid input.");
					}
					
				} else if (actionNumber.equals("3")) {
					System.out.println("Customer");
					
					System.out.print("Enter action (number) 1-Add, 2-Update, 3-Delete: ");
					actionNumber = console.nextLine();
					
					if (actionNumber.length() == 1) {
						if (actionNumber.equals("1")) {
							System.out.println("Add");
							addCustomer();
							
						} else if (actionNumber.equals("2")) {
							System.out.println("Update");
							updateCustomer();
							
						} else if (actionNumber.equals("3")) {
							System.out.println("Delete");
							deleteCustomer();
							
						} else {
							System.out.println("Invalid number.");
						}
					} else {
						System.out.println("Invalid input.");
					}
					
				} else if (actionNumber.equals("4")) {
					System.out.println("Billing Account");
					
					System.out.print("Enter action (number) 1-Add, 2-Update, 3-Delete: ");
					actionNumber = console.nextLine();
					
					if (actionNumber.length() == 1) {
						if (actionNumber.equals("1")) {
							System.out.println("Add");
							addBillAccount();
							
						} else if (actionNumber.equals("2")) {
							System.out.println("Update");
							updateBillAccount();
							
						} else if (actionNumber.equals("3")) {
							System.out.println("Delete");
							deleteBillAccount();
							
						} else {
							System.out.println("Invalid number.");
						}
					} else {
						System.out.println("Invalid input.");
					}
					
				} else if (actionNumber.equals("5")) {
					System.out.println("Service Request");
					
					System.out.print("Enter action (number) 1-Add, 2-Update, 3-Delete: ");
					actionNumber = console.nextLine();
					
					if (actionNumber.length() == 1) {
						if (actionNumber.equals("1")) {
							System.out.println("Add");
							addServiceReq();
							
						} else if (actionNumber.equals("2")) {
							System.out.println("Update");
							updateServiceReq();
							
						} else if (actionNumber.equals("3")) {
							System.out.println("Delete");
							deleteServiceReq();
							
						} else {
							System.out.println("Invalid number.");
						}
					} else {
						System.out.println("Invalid input.");
					}
					
				} else if (actionNumber.equals("6")) {
					System.out.println("Room");
					
					System.out.print("Enter action (number) 1-Add, 2-Update, 3-Delete: ");
					actionNumber = console.nextLine();
					
					if (actionNumber.length() == 1) {
						if (actionNumber.equals("1")) {
							System.out.println("Add");
							addRoom();
							
						} else if (actionNumber.equals("2")) {
							System.out.println("Update");
							updateRoom();
							
						} else if (actionNumber.equals("3")) {
							System.out.println("Delete");
							deleteRoom();
							
						} else {
							System.out.println("Invalid number.");
						}
					} else {
						System.out.println("Invalid input.");
					}
					
				} else if (actionNumber.equals("7")) {
					System.out.println("Checkin");
					
					System.out.print("Enter action (number) 1-Add, 2-Update, 3-Delete: ");
					actionNumber = console.nextLine();
					
					if (actionNumber.length() == 1) {
						if (actionNumber.equals("1")) {
							System.out.println("Add");
							addCheckin();
							
						} else if (actionNumber.equals("2")) {
							System.out.println("Update");
							updateCheckin();
							
						} else if (actionNumber.equals("3")) {
							System.out.println("Delete");
							deleteCheckin();
							
						} else {
							System.out.println("Invalid number.");
						}
					} else {
						System.out.println("Invalid input.");
					}
					
				} else if (actionNumber.equals("8")) {
					System.out.println("Report");
					
					System.out.print("Enter action (number) 1-Occupancy, 2-Total Occupancy, 3-Staff, 4-Check-in, 5-Room, 6-Bill, 7-Revenue: ");
					actionNumber = console.nextLine();
					
					if (actionNumber.length() == 1) {
						if (actionNumber.equals("1")) {
							System.out.println("Occupancy");
							generateOccupancy();
							
						} else if (actionNumber.equals("2")) {
							System.out.println("Total Occupancy");
							generateTotalOccupancy();
							
						} else if (actionNumber.equals("3")) {
							System.out.println("Staff");
							generateStaff();
							
						} else if (actionNumber.equals("4")) {
							System.out.println("Check-in");
							generateCheckStaff();

						} else if (actionNumber.equals("5")) {
							System.out.println("Room");
							generateRoomAvail();
							
						} else if (actionNumber.equals("6")) {
							System.out.println("Bill");
							generateBill();

						} else if (actionNumber.equals("7")) {
							System.out.println("Revenue");
							generateRevenue();

						} else {
							System.out.println("Invalid number.");
						}
					} else {
						System.out.println("Invalid input.");
					}
				} else if (actionNumber.equals("0")) {
					System.out.println("Quit");
					cont = false;
					
				} else {
					System.out.println("Input error. Try again. Invalid number.");
				}
			} else {
				System.out.println("Input error. Try again. Enter a number.");
			}
		}
	}
	
	// Add a hotel.
	public void addHotel() {
		String hotel_id;
		String name;
		String address;
		String city;
		String phone;
		String manager_id;

		System.out.print("Enter hotel ID (Integer): ");
		hotel_id = console.nextLine();
		System.out.print("Enter name (String): ");
		name = console.nextLine();
		System.out.print("Enter address (String): ");
		address = console.nextLine();
		System.out.print("Enter city (String): ");
		city = console.nextLine();
		System.out.print("Enter phone number (String): ");
		phone = console.nextLine();
		System.out.print("Enter manager ID (Integer): ");
		manager_id = console.nextLine();
		
		String cmd = "INSERT INTO hotel VALUES (";
		int result = 0;
		
		cmd += hotel_id + ",";
		if (name.length() > 0) {cmd += "'" + name + "',";} else {cmd += "NULL,";}
		if (address.length() > 0) {cmd += "'" + address + "',";} else {cmd += "NULL,";}
		if (city.length() > 0) {cmd += "'" + city + "',";} else {cmd += "NULL,";}
		if (phone.length() > 0) {cmd += "'" + phone + "',";} else {cmd += "NULL,";}
		if (manager_id.length() > 0) {cmd += manager_id + ")";} else {cmd += "NULL)";}
		//System.out.println("Cmd: " + cmd); // test
		
		try {
			/*result = statement.executeUpdate("INSERT INTO hotel VALUES (" + hotel_id + 
					",'" + name + "','" + address + "','" + phone + "')");*/
			result = statement.executeUpdate(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + result); // test
	}
	
	// Update an existing hotel.
	public void updateHotel() {
		String hotel_id;
		String name;
		String address;
		String city;
		String phone;
		String manager_id;
		
		System.out.print("Enter hotel ID (Integer): ");
		hotel_id = console.nextLine();
		System.out.print("Enter name (String): ");
		name = console.nextLine();
		System.out.print("Enter address (String): ");
		address = console.nextLine();
		System.out.print("Enter city (String): ");
		city = console.nextLine();
		System.out.print("Enter phone number (String): ");
		phone = console.nextLine();
		System.out.print("Enter manager ID (Integer): ");
		manager_id = console.nextLine();
		
		String cmd = "UPDATE hotel SET";
		int result = 0;
		
		if (hotel_id.length() == 0 || (name + address + phone + manager_id).length() == 0) {
			System.out.println("Invalid input.");
		} else {
			if (name.length() > 0) {cmd += " name = '" + name + "',";}
			if (address.length() > 0) {cmd += " address = '" + address + "',";}
			if (city.length() > 0) {cmd += " city = '" + city + "',";}
			if (phone.length() > 0) {cmd += " phone_number = '" + phone + "',";}
			if (manager_id.length() > 0) {cmd += "manager_id = " + manager_id + ",";}
			
			cmd = cmd.substring(0, cmd.length() - 1); // Remove the comma. Can have different combinations.
			cmd += " WHERE id = " + hotel_id;
			//System.out.println("Cmd: " + cmd); // test
			
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Delete a hotel.
	public void deleteHotel() {
		String hotel_id;

		System.out.print("Enter hotel ID (Integer): ");
		hotel_id = console.nextLine();
		
		String cmd = "DELETE FROM hotel ";
		int result = 0;
		
		cmd += "WHERE id = " + hotel_id;
		//System.out.println("Cmd: " + cmd); // test
		
		if (hotel_id.length() == 0) {
			System.out.println("Invalid input.");
		} else {
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Add a staff member.
	public void addStaff() {
		String staff_id;
		String name;
		String age;
		String title;
		String hotel_serving;
		String department;
		String phone;
		String address;

		System.out.print("Enter staff ID (Integer): ");
		staff_id = console.nextLine();
		System.out.print("Enter name (String): ");
		name = console.nextLine();
		System.out.print("Enter age (Integer): ");
		age = console.nextLine();
		System.out.print("Enter title (String): ");
		title = console.nextLine();
		System.out.print("Enter hotel serving (Integer)): ");
		hotel_serving = console.nextLine();
		System.out.print("Enter department (String)): ");
		department = console.nextLine();
		System.out.print("Enter phone number (String)): ");
		phone = console.nextLine();
		System.out.print("Enter address (String)): ");
		address = console.nextLine();
		
		String cmd = "INSERT INTO staff VALUES (";
		int result = 0;
		
		cmd += staff_id + ",";
		if (name.length() > 0) {cmd += "'" + name + "',";} else {cmd += "NULL,";}
		if (age.length() > 0) {cmd += age + ",";} else {cmd += "NULL,";}
		if (phone.length() > 0) {cmd += "'" + phone + "',";} else {cmd += "NULL,";}
		if (title.length() > 0) {cmd += "'" + title + "',";} else {cmd += "NULL,";}
		if (department.length() > 0) {cmd += "'" + department + "',";} else {cmd += "NULL,";}
		if (hotel_serving.length() > 0) {cmd += hotel_serving + ",";} else {cmd += "NULL,";}
		if (address.length() > 0) {cmd += "'" + address + "')";} else {cmd += "NULL)";}
		//System.out.println("Cmd: " + cmd); // test
		
		try {
			/*result = statement.executeUpdate("INSERT INTO staff VALUES (" + staff_id + 
					",'" + name + "'," + age + ",'" + phone + "','" + title + "','" + 
					department + "'," + hotel_serving + ")");*/
			result = statement.executeUpdate(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + result); // test
	}
	
	// Update an existing staff.
	public void updateStaff() {
		String staff_id;
		String name;
		String age;
		String title;
		String hotel_serving;
		String department;
		String phone;
		String address;
		
		System.out.print("Enter staff ID (Integer): ");
		staff_id = console.nextLine();
		System.out.print("Enter name (String): ");
		name = console.nextLine();
		System.out.print("Enter age (Integer): ");
		age = console.nextLine();
		System.out.print("Enter title (String): ");
		title = console.nextLine();
		System.out.print("Enter hotel serving (Integer): ");
		hotel_serving = console.nextLine();
		System.out.print("Enter department (String): ");
		department = console.nextLine();
		System.out.print("Enter phone number (String): ");
		phone = console.nextLine();
		System.out.print("Enter address (String): ");
		address = console.nextLine();
		
		String cmd = "UPDATE staff SET";
		int result = 0;
		
		if (staff_id.length() == 0 || (name + age + title + hotel_serving +
				department + phone + address).length() == 0) {
			System.out.println("Invalid input.");
		} else {
			if (name.length() > 0) {cmd += " name = '" + name + "',";}
			if (age.length() > 0) {cmd += " age = " + age + ",";}
			if (title.length() > 0) {cmd += " title = '" + title + "',";}
			if (hotel_serving.length() > 0) {cmd += " hotel_id = " + hotel_serving + ",";}
			if (department.length() > 0) {cmd += " department = '" + department + "',";}
			if (phone.length() > 0) {cmd += " phone_number = '" + phone + "',";}
			if (address.length() > 0) {cmd += " address = '" + address + "',";}
			
			cmd = cmd.substring(0, cmd.length() - 1); // Remove the comma.
			cmd += " WHERE id = " + staff_id;
			//System.out.println("Cmd: " + cmd); // test
			
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Delete a staff.
	public void deleteStaff() {
		String staff_id;

		System.out.print("Enter staff ID (Integer): ");
		staff_id = console.nextLine();
		
		String cmd = "DELETE FROM staff ";
		int result = 0;
		
		cmd += "WHERE id = " + staff_id;
		//System.out.println("Cmd: " + cmd); // test
		
		if (staff_id.length() == 0) {
			System.out.println("Invalid input.");
		} else {
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}

	// Add a customer.
	public void addCustomer() {
		String cust_id;
		String name;
		String dob;
		String phone;
		String email;

		System.out.print("Enter customer ID (Integer): ");
		cust_id = console.nextLine();
		System.out.print("Enter name (String): ");
		name = console.nextLine();
		System.out.print("Enter date of birth (Date): ");
		dob = console.nextLine();
		System.out.print("Enter phone number (String): ");
		phone = console.nextLine();
		System.out.print("Enter email (String)): ");
		email = console.nextLine();
		
		String cmd = "INSERT INTO customer VALUES (";
		int result = 0;
		
		cmd += cust_id + ",";
		if (name.length() > 0) {cmd += "'" + name + "',";} else {cmd += "NULL,";}
		if (dob.length() > 0) {cmd += "'" + dob + "',";} else {cmd += "NULL,";}
		if (phone.length() > 0) {cmd += "'" + phone + "',";} else {cmd += "NULL,";}
		if (email.length() > 0) {cmd += "'" + email + "')";} else {cmd += "NULL)";}
		//System.out.println("Cmd: " + cmd); // test
		
		try {
			/*result = statement.executeUpdate("INSERT INTO customer VALUES (" + cust_id + 
					",'" + name + "','" + dob + "','" + phone + "','" + email + "')");*/
			result = statement.executeUpdate(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + result); // test
	}
	
	// Update customeor information.
	public void updateCustomer() {
		String cust_id;
		String name;
		String dob;
		String phone;
		String email;
		
		System.out.print("Enter customer ID (Integer): ");
		cust_id = console.nextLine();
		System.out.print("Enter name (String): ");
		name = console.nextLine();
		System.out.print("Enter date of birth (Date): ");
		dob = console.nextLine();
		System.out.print("Enter phone number (String): ");
		phone = console.nextLine();
		System.out.print("Enter email (String)): ");
		email = console.nextLine();
		
		String cmd = "UPDATE customer SET";
		int result = 0;
		
		if (cust_id.length() == 0 || (name + dob + phone + email).length() == 0) {
			System.out.println("Invalid input.");
		} else {
			if (name.length() > 0) {cmd += " name = '" + name + "',";}
			if (dob.length() > 0) {cmd += " dob = '" + dob + "',";}
			if (phone.length() > 0) {cmd += " phone_number = '" + phone + "',";}
			if (email.length() > 0) {cmd += " email = '" + email + "',";}
			
			cmd = cmd.substring(0, cmd.length() - 1); // Remove the comma.
			cmd += " WHERE id = " + cust_id;
			//System.out.println("Cmd: " + cmd); // test
			
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Delete a customer.
	public void deleteCustomer() {
		String cust_id;

		System.out.print("Enter customer ID (Integer): ");
		cust_id = console.nextLine();
		
		String cmd = "DELETE FROM customer ";
		int result = 0;
		
		cmd += "WHERE id = " + cust_id;
		//System.out.println("Cmd: " + cmd); // test
		
		if (cust_id.length() == 0) {
			System.out.println("Invalid input.");
		} else {
			try {
				connection.setAutoCommit(false); // Start of transaction.
				
				result = statement.executeUpdate(cmd);
				/*
				result = statement.executeUpdate("DELETE FROM billing_account WHERE cust_id=" + cust_id);
				if (result > 0) {
					connection.commit();
				} else {
					connection.rollback();
				}
				*/
				connection.commit();
				connection.setAutoCommit(true); // End transaction.
				
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					connection.rollback();
					connection.setAutoCommit(true); // End transaction after rollback.
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Add a billing account.
	public void addBillAccount() {
		String cust_id;
		String ssn;
		String address;
		String pay_type;
		String card_num;

		System.out.print("Enter customer ID (Integer): ");
		cust_id = console.nextLine();
		System.out.print("Enter payer SSN (String): ");
		ssn = console.nextLine();
		System.out.print("Enter billing address (String): ");
		address = console.nextLine();
		System.out.print("Enter payment method (String): ");
		pay_type = console.nextLine();
		System.out.print("Enter card number (String)): ");
		card_num = console.nextLine();
		
		String cmd = "INSERT INTO billing_account VALUES (";
		int result = 0;
		
		// Build command string.
		cmd += cust_id + ",";
		if (ssn.length() > 0) {cmd += "'" + ssn + "',";} else {cmd += "NULL,";}
		if (address.length() > 0) {cmd += "'" + address + "',";} else {cmd += "NULL,";}
		if (pay_type.length() > 0) {cmd += "'" + pay_type + "',";} else {cmd += "NULL,";}
		if (card_num.length() > 0) {cmd += "'" + card_num + "')";} else {cmd += "NULL)";}
		//System.out.println("Cmd: " + cmd); // test
		
		try {
			result = statement.executeUpdate(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + result); // test
	}
	
	// Update billing account information.
	public void updateBillAccount() {
		String cust_id;
		String ssn;
		String address;
		String pay_type;
		String card_num;

		System.out.print("Enter customer ID (Integer): ");
		cust_id = console.nextLine();
		System.out.print("Enter payer SSN (String): ");
		ssn = console.nextLine();
		System.out.print("Enter billing address (String): ");
		address = console.nextLine();
		System.out.print("Enter payment method (String): ");
		pay_type = console.nextLine();
		System.out.print("Enter card number (String)): ");
		card_num = console.nextLine();
		
		String cmd = "UPDATE billing_account SET";
		int result = 0;
		
		if (cust_id.length() == 0 || (ssn + address + pay_type + card_num).length() == 0) {
			System.out.println("Invalid input.");
		} else {
			if (ssn.length() > 0) {cmd += " ssn = '" + ssn + "',";}
			if (address.length() > 0) {cmd += " address = '" + address + "',";}
			if (pay_type.length() > 0) {cmd += " payment_type = '" + pay_type + "',";}
			if (card_num.length() > 0) {cmd += " card_number = '" + card_num + "',";}
			
			cmd = cmd.substring(0, cmd.length() - 1); // Remove the comma.
			cmd += " WHERE cust_id = " + cust_id;
			//System.out.println("Cmd: " + cmd); // test
			
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Delete a billing account.
	public void deleteBillAccount() {
		String cust_id;

		System.out.print("Enter customer ID (Integer): ");
		cust_id = console.nextLine();
		
		String cmd = "DELETE FROM billing_account ";
		int result = 0;
		
		cmd += "WHERE cust_id = " + cust_id;
		//System.out.println("Cmd: " + cmd); // test
		
		if (cust_id.length() == 0) {
			System.out.println("Invalid input.");
		} else {
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Add a service request.
	public void addServiceReq() {
		String servreq_id;
		String type;
		String fee;
		String server_id;
		String check_id;

		System.out.print("Enter service request ID (Integer): ");
		servreq_id = console.nextLine();
		System.out.print("Enter type (String): ");
		type = console.nextLine();
		System.out.print("Enter fee (Float): ");
		fee = console.nextLine();
		System.out.print("Enter server ID (Integer): ");
		server_id = console.nextLine();
		System.out.print("Enter checkin ID (Integer): ");
		check_id = console.nextLine();
		
		String cmd = "INSERT INTO service_request VALUES (";
		int result = 0;
		
		cmd += servreq_id + ",";
		if (type.length() > 0) {cmd += "'" + type + "',";} else {cmd += "NULL,";}
		if (fee.length() > 0) {cmd += fee + ",";} else {cmd += "NULL,";}
		if (server_id.length() > 0) {cmd += server_id + ",";} else {cmd += "NULL,";}
		if (check_id.length() > 0) {cmd += check_id + ")";} else {cmd += "NULL)";}
		//System.out.println("Cmd: " + cmd); // test
		
		try {
			result = statement.executeUpdate(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + result); // test
	}
	
	// Update service request information.
	public void updateServiceReq() {
		String servreq_id;
		String type;
		String fee;
		String server_id;
		String check_id;

		System.out.print("Enter service request ID (Integer): ");
		servreq_id = console.nextLine();
		System.out.print("Enter type (String): ");
		type = console.nextLine();
		System.out.print("Enter fee (Float): ");
		fee = console.nextLine();
		System.out.print("Enter server ID (Integer): ");
		server_id = console.nextLine();
		System.out.print("Enter checkin ID (Integer): ");
		check_id = console.nextLine();
		
		String cmd = "UPDATE service_request SET";
		int result = 0;
		
		if (servreq_id.length() == 0 || (type + fee + server_id + check_id).length() == 0) {
			System.out.println("Invalid input.");
		} else {
			if (type.length() > 0) {cmd += " type = '" + type + "',";}
			if (fee.length() > 0) {cmd += " rate = " + fee + ",";}
			if (server_id.length() > 0) {cmd += " server_id = " + server_id + ",";}
			if (check_id.length() > 0) {cmd += " check_id = " + check_id + ",";}
			
			cmd = cmd.substring(0, cmd.length() - 1); // Remove the comma.
			cmd += " WHERE id = " + servreq_id;
			//System.out.println("Cmd: " + cmd); // test
			
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Delete a service request.
	public void deleteServiceReq() {
		String servreq_id;
		
		System.out.print("Enter service request ID (Integer): ");
		servreq_id = console.nextLine();
		
		String cmd = "DELETE FROM service_request ";
		int result = 0;
		
		cmd += "WHERE id = " + servreq_id;
		//System.out.println("Cmd: " + cmd); // test
		
		if (servreq_id.length() == 0) {
			System.out.println("Invalid input.");
		} else {
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Add a room.
	public void addRoom() {
		String room_num;
		String hotel_id;
		String category;
		String max_cap;
		String rate;
		String available;

		System.out.print("Enter room number (Integer): ");
		room_num = console.nextLine();
		System.out.print("Enter hotel ID (Integer): ");
		hotel_id = console.nextLine();
		System.out.print("Enter category (String): ");
		category = console.nextLine();
		System.out.print("Enter max capacity (Integer): ");
		max_cap = console.nextLine();
		System.out.print("Enter nightly rate (Float): ");
		rate = console.nextLine();
		System.out.print("Enter availability (Boolean): ");
		available = console.nextLine();
		
		String cmd = "INSERT INTO room VALUES (";
		int result = 0;
		
		cmd += hotel_id + ",";
		cmd += room_num + ",";
		if (category.length() > 0) {cmd += "'" + category + "',";} else {cmd += "NULL,";}
		if (max_cap.length() > 0) {cmd += max_cap + ",";} else {cmd += "NULL,";}
		if (rate.length() > 0) {cmd += rate + ",";} else {cmd += "NULL,";}
		if (available.length() > 0) {cmd += available + ")";} else {cmd += "NULL)";}
		//System.out.println("Cmd: " + cmd); // test
		
		try {
			result = statement.executeUpdate(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + result); // test
	}
	
	// Update room information.
	public void updateRoom() {
		String room_num;
		String hotel_id;
		String category;
		String max_cap;
		String rate;
		String available;
		
		System.out.print("Enter room number (Integer): ");
		room_num = console.nextLine();
		System.out.print("Enter hotel ID (Integer): ");
		hotel_id = console.nextLine();
		System.out.print("Enter category (String): ");
		category = console.nextLine();
		System.out.print("Enter max capacity (Integer): ");
		max_cap = console.nextLine();
		System.out.print("Enter nightly rate (Float): ");
		rate = console.nextLine();
		System.out.print("Enter availability (Boolean): ");
		available = console.nextLine();
		
		String cmd = "UPDATE room SET";
		int result = 0;
		
		if (room_num.length() == 0 || hotel_id.length() == 0 || (category + max_cap + rate + available).length() == 0) {
			System.out.println("Invalid input.");
		} else {
			if (category.length() > 0) {cmd += " category = '" + category + "',";}
			if (max_cap.length() > 0) {cmd += " max_occupancy = " + max_cap + ",";}
			if (rate.length() > 0) {cmd += " rate = " + rate + ",";}
			if (available.length() > 0) {cmd += " available = " + available + ",";}
			
			cmd = cmd.substring(0, cmd.length() - 1); // Remove the comma.
			cmd += " WHERE id = " + hotel_id + " AND number = " + room_num;
			//System.out.println("Cmd: " + cmd); // test
			
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Delete a room.
	public void deleteRoom() {
		String room_num;
		String hotel_id;
		
		System.out.print("Enter room number (Integer): ");
		room_num = console.nextLine();
		System.out.print("Enter hotel ID (Integer): ");
		hotel_id = console.nextLine();
		
		String cmd = "DELETE FROM room ";
		int result = 0;
		
		cmd += "WHERE number = " + room_num;
		cmd += " AND id = " + hotel_id;
		//System.out.println("Cmd: " + cmd); // test
		
		if (room_num.length() == 0 || hotel_id.length() == 0) {
			System.out.println("Invalid input.");
		} else {
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Add a check-in.
	public void addCheckin() {
		String check_id;
		String cust_id;
		String hotel_id;
		String room_num;
		String num_guest;
		String start_date;
		String end_date;
		String start_time;
		String end_time;
		// Services offered will be tracked in service request.
		
		System.out.print("Enter check-in ID (Integer): ");
		check_id = console.nextLine();
		System.out.print("Enter customer ID (Integer): ");
		cust_id = console.nextLine();
		System.out.print("Enter hotel ID (Integer): ");
		hotel_id = console.nextLine();
		System.out.print("Enter room number (Integer): ");
		room_num = console.nextLine();
		System.out.print("Enter number of guests (Integer): ");
		num_guest = console.nextLine();
		System.out.print("Enter start date (Date): ");
		start_date = console.nextLine();
		System.out.print("Enter end date (Date): ");
		end_date = console.nextLine();
		System.out.print("Enter start time (Time): ");
		start_time = console.nextLine();
		System.out.print("Enter end time (Time): ");
		end_time = console.nextLine();
		
		String cmd = "INSERT INTO check_in VALUES (";
		int result = 0;
		
		cmd += check_id + ",";
		if (cust_id.length() > 0) {cmd += cust_id + ",";} else {cmd += "NULL,";}
		if (hotel_id.length() > 0) {cmd += hotel_id + ",";} else {cmd += "NULL,";}
		if (room_num.length() > 0) {cmd += room_num + ",";} else {cmd += "NULL,";}
		if (num_guest.length() > 0) {cmd += num_guest + ",";} else {cmd += "NULL,";}
		if (start_date.length() > 0) {cmd += "'" + start_date + "',";} else {cmd += "NULL,";}
		if (start_time.length() > 0) {cmd += "'" + start_time + "',";} else {cmd += "NULL,";}
		if (end_date.length() > 0) {cmd += "'" + end_date + "',";} else {cmd += "NULL,";}
		if (end_time.length() > 0) {cmd += "'" + end_time + "')";} else {cmd += "NULL)";}
		//cmd += "NULL)"; // For bill, which may not be used.
		//System.out.println("Cmd: " + cmd); // test
		
		try {
			result = statement.executeUpdate(cmd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Result: " + result); // test
	}
	
	// Update check-in information.
	public void updateCheckin() {
		String check_id;
		String cust_id;
		String hotel_id;
		String room_num;
		String num_guest;
		String start_date;
		String end_date;
		String start_time;
		String end_time;
		// Services offered will be tracked in service request.
		
		System.out.print("Enter check-in ID (Integer): ");
		check_id = console.nextLine();
		System.out.print("Enter customer ID (Integer): ");
		cust_id = console.nextLine();
		System.out.print("Enter hotel ID (Integer): ");
		hotel_id = console.nextLine();
		System.out.print("Enter room number (Integer): ");
		room_num = console.nextLine();
		System.out.print("Enter number of guests (Integer): ");
		num_guest = console.nextLine();
		System.out.print("Enter start date (Date): ");
		start_date = console.nextLine();
		System.out.print("Enter end date (Date): ");
		end_date = console.nextLine();
		System.out.print("Enter start time (Time): ");
		start_time = console.nextLine();
		System.out.print("Enter end time (Time): ");
		end_time = console.nextLine();
		
		String cmd = "UPDATE check_in SET";
		int result = 0;
		
		if (check_id.length() == 0 || (cust_id + hotel_id + room_num + num_guest + 
				start_date + end_date + start_time + end_time).length() == 0) {
			System.out.println("Invalid input.");
		} else {
			if (cust_id.length() > 0) {cmd += " cust_id = " + cust_id + ",";}
			if (hotel_id.length() > 0) {cmd += " hotel_id = " + hotel_id + ",";}
			if (room_num.length() > 0) {cmd += " room_number = " + room_num + ",";}
			if (num_guest.length() > 0) {cmd += " guests = " + num_guest + ",";}
			if (start_date.length() > 0) {cmd += " start_date = '" + start_date + "',";}
			if (start_time.length() > 0) {cmd += " start_time = '" + start_time + "',";}
			if (end_date.length() > 0) {cmd += " end_date = '" + end_date + "',";}
			if (end_time.length() > 0) {cmd += " end_time = '" + end_time + "',";}
			
			cmd = cmd.substring(0, cmd.length() - 1); // Remove the comma.
			cmd += " WHERE id = " + check_id;
			//System.out.println("Cmd: " + cmd); // test
			
			try {
				connection.setAutoCommit(false); // Start of transaction.
				
				result = statement.executeUpdate(cmd);
				/*
				if (end_time.length() > 0) {
					result = statement.executeUpdate("UPDATE room SET available=TRUE WHERE number=" + room_num + " AND id=" + hotel_id);
				}
				if (result > 0) {
					connection.commit();
				} else {
					connection.rollback();
				}
				*/
				connection.commit();
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					connection.rollback();
					connection.setAutoCommit(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Delete a check-in.
	public void deleteCheckin() {
		String check_id;
		
		System.out.print("Enter check-in ID (Integer): ");
		check_id = console.nextLine();
		
		String cmd = "DELETE FROM check_in ";
		int result = 0;
		
		cmd += "WHERE id = " + check_id;
		//System.out.println("Cmd: " + cmd); // test
		
		if (check_id.length() == 0) {
			System.out.println("Invalid input.");
		} else {
			try {
				result = statement.executeUpdate(cmd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Result: " + result); // test
		}
	}
	
	// Generate reports by occupancy.
	public void generateOccupancy() {
		String actionNumber;
		
		System.out.print("Enter occupancy by (number) 1-Hotel, 2-Category, 3-City, 4-Date: ");
		actionNumber = console.nextLine();
		
		if (actionNumber.length() == 1) {
			if (actionNumber.equals("1")) {
				System.out.println("Hotel");
				
				try {
					result = statement.executeQuery("SELECT hotel.id, hotel.name, SUM(check_in.guests) AS occupancy "
							+ "FROM (hotel INNER JOIN check_in ON hotel.id=check_in.hotel_id) "
							+ "WHERE check_in.end_time IS NULL "
							+ "GROUP BY hotel.id");
					
					System.out.printf("%-3s%-12s%-10s\n", "id", "name", "occupancy");
					while (result.next()) {
						String id = result.getString("id");
						String name = result.getString("name");
						String occupancy = result.getString("occupancy");
						
						System.out.printf("%-3s%-12s%-10s\n", id, name, occupancy);
					}
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else if (actionNumber.equals("2")) {
				System.out.println("Category");
				
				try {
					result = statement.executeQuery("SELECT room.category, SUM(check_in.guests) AS occupancy "
							+ "FROM (room INNER JOIN check_in ON room.number=check_in.room_number) "
							+ "WHERE check_in.end_time IS NULL AND check_in.hotel_id = room.id "
							+ "GROUP BY room.category");
					
					System.out.printf("%-15s%-10s\n", "category", "occupancy");
					while (result.next()) {
						String category = result.getString("category");
						String occupancy = result.getString("occupancy");
						
						System.out.printf("%-15s%-10s\n", category, occupancy);
					}
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else if (actionNumber.equals("3")) {
				System.out.println("City");
				
				try {
					result = statement.executeQuery("SELECT hotel.city, SUM(check_in.guests) AS occupancy "
							+ "FROM (hotel INNER JOIN check_in ON hotel.id=check_in.hotel_id) "
							+ "WHERE check_in.end_time IS NULL "
							+ "GROUP BY hotel.city");
					
					System.out.printf("%-15s%-10s\n", "city", "occupancy");
					while (result.next()) {
						String city = result.getString("city");
						String occupancy = result.getString("occupancy");
						
						System.out.printf("%-15s%-10s\n", city, occupancy);
					}
					System.out.println();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else if (actionNumber.equals("4")) {
				System.out.println("Date");
				
				// TODO
				System.out.println("This functionality is not currently available.");
				
			} else {
				System.out.println("Invalid number.");
			}
		} else {
			System.out.println("Invalid input.");
		}
	}
	
	// Generate a report for total occupancy.
	public void generateTotalOccupancy() {
		String sub_query = "SELECT SUM(check_in.guests) AS Occupancy, (SELECT SUM(room.max_occupancy) FROM room) AS MaxOccupancy "
				+ "FROM check_in "
				+ "WHERE check_in.end_time IS NULL";
		
		try {
			result = statement.executeQuery("SELECT a.Occupancy AS TotalOcc, a.MaxOccupancy AS MaxOcc, a.Occupancy / a.MaxOccupancy AS TotalOccupancyPercentage "
					+ "FROM (" + sub_query + ")a");
			
			System.out.printf("%-15s%-15s%-15s\n", "Total Occ.", "Max Occ.", "Total Occ. Perc.");
			result.next();
			String total = result.getString("TotalOcc");
			String max = result.getString("MaxOcc");
			String perc = result.getString("TotalOccupancyPercentage");
			System.out.printf("%-15s%-15s%-15s\n", total, max, perc);
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Generate a report on staff members.
	public void generateStaff() {
		try {
			result = statement.executeQuery("SELECT title, id, name, age, phone_number, department, hotel_id "
					+ "FROM staff "
					+ "GROUP BY title, id");
			
			System.out.printf("%-20s%-10s%-15s%-10s%-15s%-15s%-15s\n", "Title", "ID", "Name", "Age", "Phone", "Dept.", "Hotel Asgn.");
			while (result.next()) {
				String title = result.getString("title");
				String id = result.getString("id");
				String name = result.getString("name");
				String age = result.getString("age");
				String phone = result.getString("phone_number");
				String dept = result.getString("department");
				String hotel_id = result.getString("hotel_id");
				
				System.out.printf("%-20s%-10s%-15s%-10s%-15s%-15s%-15s\n", title, id, name, age, phone, dept, hotel_id);
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Generate information on what staff served a customer stay.
	public void generateCheckStaff() {
		try {
			result = statement.executeQuery("SELECT check_in.id AS Checkin, staff.id AS Staff_ID, staff.name AS Name, staff.title AS Title, staff.age AS Age, staff.phone_number AS Phone, staff.department AS Department, staff.hotel_id AS Hotel "
					+ "FROM ((staff INNER JOIN service_request ON staff.id=service_request.server_id) INNER JOIN check_in ON service_request.check_id=check_in.id) "
					+ "GROUP BY check_in.id, staff.id");
			
			System.out.printf("%-15s%-10s%-15s%-20s%-10s%-15s%-15s%-10s\n", "Checkin ID", "Staff ID", "Name", "Title", "Age", "Phone", "Dept.", "Hotel ID");
			while (result.next()) {
				String check_id = result.getString("Checkin");
				String staff_id = result.getString("Staff_ID");
				String name = result.getString("Name");
				String title = result.getString("Title");
				String age = result.getString("Age");
				String phone = result.getString("Phone");
				String dept = result.getString("Department");
				String hotel_id = result.getString("Hotel");
				
				System.out.printf("%-15s%-10s%-15s%-20s%-10s%-15s%-15s%-10s\n", check_id, staff_id, name, title, age, phone, dept, hotel_id);
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Generate room availability based on room type.
	public void generateRoomAvail() {
		String category;

		System.out.print("Enter room type (String): ");
		category = console.nextLine();
		
		try {
			result = statement.executeQuery("SELECT id AS Hotel, number AS Room "
					+ "FROM room "
					+ "WHERE category='" + category + "' AND available=TRUE");
			
			System.out.printf("%-10s%-10s\n", "Hotel", "Room Avail.");
			while (result.next()) {
				String hotel = result.getString("Hotel");
				String room = result.getString("Room");
				
				System.out.printf("%-10s%-10s\n", hotel, room);
			}
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Generate report for itemized cost and total bill.
	public void generateBill() {
		String checkin;

		System.out.print("Enter check-in ID (Integer): ");
		checkin = console.nextLine();
		
		try {
			result = statement.executeQuery("(SELECT type, rate, COUNT(type) AS quantity "
					+ "FROM service_request "
					+ "WHERE check_id=" + checkin + " "
					+ "GROUP BY type) UNION ("
					+ "SELECT room.category AS type, rate, DATEDIFF(end_date, start_date) AS quantity "
					+ "FROM (room INNER JOIN check_in ON room.number=check_in.room_number) "
					+ "WHERE check_in.id=" + checkin + " AND check_in.hotel_id = room.id)");
			
			System.out.printf("%-15s%-10s%-10s\n", "Item", "Rate", "Quantity");
			while (result.next()) {
				String item = result.getString("type");
				String rate = result.getString("rate");
				String quant = result.getString("quantity");
				
				System.out.printf("%-15s%-10s%-10s\n", item, rate, quant);
			}
			System.out.println();
			
			// Get total
			String sub_query1 = "SELECT type, rate, COUNT(type) AS quantity "
					+ "FROM service_request "
					+ "WHERE check_id=" + checkin + " "
					+ "GROUP BY type";
			
			String sub_query2 = "SELECT room.category AS type, rate, DATEDIFF(end_date, start_date) AS quantity "
					+ "FROM (room INNER JOIN check_in ON room.number=check_in.room_number) "
					+ "WHERE check_in.id=" + checkin + " AND check_in.hotel_id = room.id";
			
			result = statement.executeQuery("SELECT SUM(a.rate*a.quantity) AS total "
					+ "FROM ((" + sub_query1 + ") UNION (" + sub_query2 + "))a");
			
			System.out.println("Total bill:");
			result.next();
			String bill = result.getString("total");
			System.out.println(bill);
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Generate report for total revenue over a date range.
	public void generateRevenue() {
		String start_date;
		String end_date;
		
		System.out.print("Enter start date (Date): ");
		start_date = console.nextLine();
		System.out.print("Enter end date (Date): ");
		end_date = console.nextLine();
		
		String sub_query1_1 = "SELECT * "
				+ "FROM check_in "
				+ "WHERE check_in.start_date >= '" + start_date + "' AND check_in.end_date <= '" + end_date + "'";

		String sub_query1 = "SELECT type, rate, COUNT(type) AS quantity "
				+ "FROM (service_request INNER JOIN (" + sub_query1_1 + ")a ON service_request.check_id = a.id) "
				+ "GROUP BY type";

		// String sub_query2_1 = sub_query1_1;

		String sub_query2 = "SELECT room.category AS type, rate, SUM(DATEDIFF(end_date, start_date)) AS quantity "
				+ "FROM (room INNER JOIN (" + sub_query1_1 + ")b ON room.number=b.room_number) "
				+ "WHERE room.id = b.hotel_id "
				+ "GROUP BY category, rate";
		
		try {
			result = statement.executeQuery("SELECT SUM(c.rate*c.quantity) AS total "
					+ "FROM ((" + sub_query1 + ") UNION (" + sub_query2 + "))c");
			
			System.out.printf("%-15s\n", "Total Rev.");
			result.next();
			String total = result.getString("total");
			System.out.printf("%-15s\n", total);
			
			System.out.println();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
