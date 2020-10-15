/**
A purse computes the total value of a collection of coins.
 */
public class Purse
{
    /**
    Constructs an empty purse.
     */
    public Purse()
    {
        pennies = 0;
        nickels = 0;
        dimes = 0;
    }

    /**
     * accessor for pennies
     */
    int getPennies() 
    { 
        return pennies;
    }

    /**
     * accessor for nickels
     */
    int getNickels() 
    { 
        return nickels;
    }

    /**
     * accessor for dimes
     */
    int getDimes() 
    { 
        return dimes;
    }

    /**
    Add pennies to the purse.
    @param count the number of pennies to add
     */
    public void addPennies(int count)
    {
        pennies = pennies + count;
    }

    /**
    Add nickels to the purse.
    @param count the number of nickels to add
     */
    public void addNickels(int count)
    {
        nickels = nickels + count;
    }

    /**
    Add dimes to the purse.
    @param count the number of dimes to add
     */
    public void addDimes(int count)
    {
        dimes = dimes + count;
    }

    /**
    Get the total value of the coins in the purse.
    @return the sum of all coin values
     */
    public double getTotal()
    {
        int cents =  pennies + nickels * NICKEL_VALUE + dimes * DIME_VALUE;
        return cents/100.0;
    }


    /**
     * Take an amount less than one dollar and calculates how many nickels, dimes, 
     * pennies and quarters are needed to make change.  
     * The results should be stored in the purse.  Use / and % operators.
     * For example, loadPurse(84) would set the purse to 3 quarters, 0 dimes, 
     * 1 nickel, and 4 pennies
     */
    public void loadPurse(int cents)
    {

    }

    private final int NICKEL_VALUE = 5;
    private final int DIME_VALUE = 10;

    private int pennies;
    private int nickels;
    private int dimes;

}

