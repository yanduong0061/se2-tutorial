package tuts.tut10.to_dos.strategy.strategies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Concrete strategy. Implements credit card payment method.
 */
public class PayByCreditCard implements PayStrategy {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
    private CreditCard card;
    private static final int CARD_NUMBER_LENGTH = 16;

    /**
     * Collect credit card data.
     */
    @Override
    public void collectPaymentDetails() {
    	try {
    		System.out.println("Enter your card number: ");
    		String cardNumber = READER.readLine().trim();
    		if(cardNumber.length() < 0 || cardNumber.length() != CARD_NUMBER_LENGTH) {
    			System.err.println("Card number contains 16 numbers");
    		}
    		System.out.println("Enter our expiration date: ");
    		String expDate = READER.readLine().trim();
    		System.out.println("Enter our CVV code: ");
    		String cvvCode = READER.readLine().trim();
    		try {
    			Integer number = Integer.parseInt(cardNumber);
    			if(number < 0 ) {
    				System.err.println("Card number can not be negatie!");
    			}
    			
    		} catch(NumberFormatException e) {
    			e.printStackTrace();
    		}
    		card = new CreditCard(cardNumber, expDate, cvvCode);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	//TO-DO: Add 'try-catch' block to catch the IO error
    	
    	//TO-DO: Ask for card number, expiration date, CVV code then save them to suitable variables
        
    	//TO-DO: Create new CreditCard instance with given information

        //TO-DO: Validate credit card number...
 
    }

    //TO-DO: Implement the pay() method
    /**
     * After card validation we can charge customer's credit card.
     */
    @Override
    public boolean pay(int paymentAmount) {
    	/*if 'cardIsPresent' => display a message 
    	to show that customer is paying with Credit Card with money amount
    	then reduce the card amount with that number
    	finally return true else return false */
        if(cardIsPresent()) {
        	System.out.println("The fee is " + paymentAmount);
        	card.setAmount(card.getAmount() - paymentAmount);
        	return true;
        }
        return false;
    }

    private boolean cardIsPresent() {
        return card != null;
    }
}
