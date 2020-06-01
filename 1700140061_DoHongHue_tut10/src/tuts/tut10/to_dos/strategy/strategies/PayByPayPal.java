package tuts.tut10.to_dos.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Concrete strategy. Implements PayPal payment method.
 */
public class PayByPayPal implements PayStrategy {
    private static final Map<String, String> DATA_BASE = new HashMap<>();
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private String email;
    private String password;
    private boolean signedIn;

    static {
    	//TO-DO: 'put' some test data (password & email) to DATA_BASE
    	DATA_BASE.put("@nana.com", "123456");
    	DATA_BASE.put("@ken.com", "1234567");
      
    }

    //TO-DO: Implement the collectPaymentDetails() method
    /**
     * Collect customer's data.
     */
    @Override
    public void collectPaymentDetails() {
       //TO-DO: Add 'try-catch' block to catch the IO error
            while (!signedIn) {
            	//TO-DO: Ask for email & password then save them to suitable variables
            	try {
            		 System.out.println("Enter your email: ");
                    email = READER.readLine().trim();
                     System.out.println("Enter your password: ");
                     password = READER.readLine().trim();
                     
            	}catch(Exception e) {
            		e.printStackTrace();
            	}
            	if(email == null || !email.isEmpty()) {
            		System.err.println("Email is not valid!");
            	}
            	if(password == null || !password.isEmpty()) {
            		System.err.println("Password is not valid!");
            	}
            	if(verify()) {
            		setSignedIn(true);
            		System.out.println("Signed in successfully!");
            	}
              
            	//TO-DO: Verify the input values then display suitable message
                 
            }

    }

    private boolean verify() {
        setSignedIn(email.equals(DATA_BASE.get(password)));
        return signedIn;
    }

    //TO-DO: Implement the pay() method
    /**
     * Save customer data for future shopping attempts.
     */
    @Override
    public boolean pay(int paymentAmount) {
    	if(signedIn) {
    		System.out.println("You are paying " + paymentAmount + " with PayPal");
    		return true;
    	}
    	/*if customer already 'signedIn' => display a message 
    	to show that customer is paying with PayPal with money amount
    	then return true else return false */
    	return false;
    }

    private void setSignedIn(boolean signedIn) {
        this.signedIn = signedIn;
    }
}