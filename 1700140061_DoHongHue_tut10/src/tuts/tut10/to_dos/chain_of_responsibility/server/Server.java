package tuts.tut10.to_dos.chain_of_responsibility.server;

import java.util.HashMap;
import java.util.Map;

import tuts.tut10.to_dos.chain_of_responsibility.middleware.Middleware;

/**
 * Server class.
 */
public class Server {
    private Map<String, String> users = new HashMap<>();
    private Middleware middleware;

    //TO-DO: Implement the setMiddleWare() method
    /**
     * Client passes a chain of object to server. This improves flexibility and
     * makes testing the server class easier.
     */
    public void setMiddleware(Middleware middleware) {
      if(middleware == null) {
    	  throw new NullPointerException("Object is null!");
      } else {
    	  this.middleware = middleware;
      }
    }

    /**
     * Server gets email and password from client and sends the authorization
     * request to the chain.
     */
    public boolean logIn(String email, String password) {
        if (middleware.check(email, password)) {
            System.out.println("Authorization have been successful!");

            // Do something useful here for authorized users.
            return true;
        }
        return false;
    }

    public void register(String email, String password) {
    	//TO-DO: put given email & password to 'users' Map
    	if(email == null || password == null || email.isEmpty() || password.isEmpty()) {
    		System.err.println("Email or password is invalid!");
    	} else {
    		users.put(email, password);
            
    	}
    	
    }

    public boolean hasEmail(String email) {
    	//TO-DO: check for existed email in 'users' Map
    if(email == null || email.isEmpty()) {
    	System.err.println("Email is invalid!");
    }
    	return users.containsKey(email);
  
    }

    public boolean isValidPassword(String email, String password) {
    	//TO-DO: check for valid password for existed email in 'users' Map
    	if(email != null && password != null && !email.isEmpty() && !password.isEmpty()) {
    		if(users.containsKey(email)) {
    			if(users.get(email).equalsIgnoreCase(password)) 
    				return true;
    			else 
    				return false;
    		} else {
    			return false;
    		}
    	}
    	return false;
    	
    }
}