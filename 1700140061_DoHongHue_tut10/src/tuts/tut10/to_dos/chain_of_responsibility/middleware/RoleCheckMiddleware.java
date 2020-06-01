package tuts.tut10.to_dos.chain_of_responsibility.middleware;

/**
 * ConcreteHandler. Checks a user's role.
 */
public class RoleCheckMiddleware extends Middleware {
	//TO-DO: Implement the check() method
    public boolean check(String email, String password) {
    	/*if email = 'admin@example.com' => display welcome message for admin then return true
        else, display welcome message for normal user */
    	if(email == null || email.isEmpty()) {
    		System.err.println("Email is invalid!");
    	}
    	if(password == null || password.isEmpty()) {
    		System.err.println("Password is invalid!");
    	}
         if("admin@example.com".equalsIgnoreCase(email)) {
        	System.out.println("Welcome, admin!");
        	return true;
         } else {
        	 System.err.println("Welcom, user!");
        	 
         }
        return checkNext(email, password);
    }
}