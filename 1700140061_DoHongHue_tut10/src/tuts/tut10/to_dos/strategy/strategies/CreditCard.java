package tuts.tut10.to_dos.strategy.strategies;

/**
 * Dummy credit card class.
 */
public class CreditCard {
    private int amount;
    private String number;
    private String date;
    private String cvv;

    CreditCard(String number, String date, String cvv) {
        this.amount = 100_000;
        this.number = number;
        this.date = date;
        this.cvv = cvv;
    }

    //TO-DO: Implement the setAmount() method
    public void setAmount(int amount) {
         if(amount < 0) {
        	 System.err.println("Amount can not be negative!");
         } else {
        	 this.amount = amount;
         }
    }

    //TO-DO: Implement the getAmount() method
    public int getAmount() {
        return this.amount;
    }
}