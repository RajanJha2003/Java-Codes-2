package authentication_authorization;

import java.util.Scanner;

public class Authorization {
  public static void main(String[] args) {
	  
	  Scanner scanner=new Scanner(System.in);
      System.out.print("Enter username: ");
      String username = scanner.nextLine();

      System.out.print("Enter password: ");
      String password = scanner.nextLine();
      
      String role=Authentication.authenticateUser(username, password);
      if(role!=null) {
    	  System.out.println("Logged in");
    	  
    	  if (role.equals("ADMIN")) {
              System.out.println("logged in as admin.");
          } else if (role.equals("USER")) {
              System.out.println("Logged in as user.");
          }

      } else {
          System.out.println("Invalid username or password!");
      }
      
      
      
      scanner.close();

}
}
