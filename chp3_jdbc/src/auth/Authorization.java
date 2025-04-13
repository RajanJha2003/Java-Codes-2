package auth;

import java.util.Scanner;

public class Authorization {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter username: ");
	        String username = scanner.nextLine();

	        System.out.print("Enter password: ");
	        String password = scanner.nextLine();
	        
	        User user=Authentication.authenticateUser(username, password);
	        
	        if (user != null) {
	            System.out.println("Logged in");

	            String role = user.getRole();
	            if ("ADMIN".equals(role)) {
	                System.out.println("Logged in as admin.");
	            } else if ("USER".equals(role)) {
	                System.out.println("Logged in as user.");
	            } 

	        } else {
	            System.out.println("Invalid username or password!");
	        }
	        
	        scanner.close();

	}

}
