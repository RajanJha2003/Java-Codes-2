package main;

import model.User;
import operationsImp.OperationsImp;

public class Main {
  public static void main(String[] args) {
	User user=new User();
    user.setId(1);
    user.setUsername("rajan_jha");
    user.setPassword("Rajan@123");  
    user.setEmail("rajan.jha@example.com");
    user.setPhone("9876543210");
    user.setGender("Male");
    user.setCity("Mumbai");
//    
    OperationsImp imp=new OperationsImp();
//    System.out.println(imp.addUser(user));
    
    System.out.println(imp.getAllUsers());
    
	
}
}
