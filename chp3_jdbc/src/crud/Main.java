package crud;

public class Main {
	  public static void main(String[] args) {
		User user=new User();
	    user.setId(1);
	    user.setUsername("rajan_jha");
	    user.setPassword("Rajan@123");  
	    user.setEmail("rajan@gmailcom");
	    user.setPhone("9876543210");
	    user.setGender("Male");
	    user.setCity("Mumbai");
	//    
	    OperationsImp imp=new OperationsImp();
	    System.out.println(imp.addUser(user));
	    
	    System.out.println(imp.getAllUsers());
	    
	    User updatedUser = new User();
	    
	    updatedUser.setId(1);
	    updatedUser.setUsername("Rajan Jha");
	    updatedUser.setPassword("RajanJha2003");
	    updatedUser.setEmail("rajan448.com");
	    updatedUser.setPhone("9998887777");
	    updatedUser.setGender("Male");
	    updatedUser.setCity("Pune");
   
	    System.out.println(imp.updateUser(updatedUser));
	    System.out.println(imp.getAllUsers());
	    
	    System.out.println(imp.deleteUser(1));
	    System.out.println(imp.getAllUsers());
	    
	    System.out.println(imp.searchUser("rajan_jha"));
	    
	    
	    
	    
		
	}
	}