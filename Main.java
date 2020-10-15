import java.util.*;

/**
 * Description: This lab demonstrates money.
 */

public class Main
{    

    public static void main(String args[]) {
        Main a = new Main();
        a.chooseTest();
    }

    public void chooseTest() {
 
        int choice = -1;
        while (choice != 8) {
            Scanner scan = new Scanner(System.in);
            System.out.println();
            System.out.println("Type 1 (and enter) to try getDollarsFromMoney.");
            System.out.println("Type 2 (and enter) to test getDollarsFromMoney.");
            System.out.println("Type 3 (and enter) to try getCentsFromMoney.");
            System.out.println("Type 4 (and enter) to test getCentsFromMoney.");
            System.out.println("Type 5 (and enter) to try adding quarters to a Purse.");
            System.out.println("Type 6 (and enter) to try loadPurse.");
            System.out.println("Type 7 (and enter) to test the Purse.");
            System.out.println("Type 8 (and enter) to quit.");
            try {
                choice = scan.nextInt();
            } catch (Exception e) {
                System.out.println(e);
                scan.close();
                continue;
            }
            if (choice == 1)
                tryGetMoney(true);
            else if (choice == 2)
                testGetMoney(true);
            else if (choice == 3)
                tryGetMoney(false);
            else if (choice == 4)
                testGetMoney(false);
            else if (choice == 5)
                try_addQuarters();
            else if (choice == 6)
                try_loadPurse();

            else if (choice == 7)
                testPurse();

        }
    }

    /**
     * method to show how operations work with doubles
     */
    public void tryGetMoney(boolean doDollars)
    {
        System.out.println();
        Scanner scan = new Scanner(System.in);
        // Get two doubles from the user
        System.out.println("Enter any amount of money (something like 23.45):");
        double money = scan.nextDouble();
        MoneyIntro m = new MoneyIntro();
        if (doDollars) {
            int dollars = m.getDollarsFromMoney(money);
            System.out.println("The dollar amount is " + dollars);
        } else {
            int cents = m.getCentsFromMoney(money);
            System.out.println("The cents amount is " + cents);
        }

    }

    /**
     * method to show how operations work with integers
     */
    public void try_addQuarters()
    {
        Scanner scan = new Scanner(System.in);
        // Get two integers from the user

        Purse myPurse = new Purse();
        System.out.println("How many pennies do you have?");
        int count1 = scan.nextInt();
        myPurse.addPennies(count1);

        System.out.println("How many nickels do you have?");
        int count2 = scan.nextInt();
        myPurse.addNickels(count2);

        System.out.println("How many dimes do you have?");
        int count3 = scan.nextInt();
        myPurse.addDimes(count3);

        System.out.println("How many quarters do you have?");
        int count4 = scan.nextInt();
        PurseTest.addQuarters(myPurse, count4, false);

        double totalValue = myPurse.getTotal();
        System.out.println("The total is " + totalValue);
        int check = count1 + 5*count2 + 10*count3 + 25*count4;
        System.out.println("It should be " + (double)check/100);

    }

    public void try_loadPurse()
    {
        Scanner scan = new Scanner(System.in);
        // Get two integers from the user

        Purse myPurse = new Purse();
        System.out.println("How many cents are you putting in the purse (less than 100 please)?");
        int money = scan.nextInt();
        myPurse.loadPurse(money);

        System.out.println("It is holding a total of " + myPurse.getTotal());
        int numQuarters = PurseTest.getQuarters(myPurse, false);
        System.out.println("   " + numQuarters + " quarters");

        System.out.println("   " + myPurse.getDimes() + " dimes");
        System.out.println("   " + myPurse.getNickels() + " nickels");
        System.out.println("   " + myPurse.getPennies() + " pennies");
        System.out.println();

    }

    public void testGetMoney(boolean doDollars)
    {
        PurseTest test = new PurseTest();
        if (doDollars) {
            test.test_getDollarsFromMoney();
            System.out.println("getDollarsFromMoney worked");
        } else { 
            test.test_getCentsFromMoney();
            System.out.println("getCentsFromMoney worked");
        }

    }

    public void testPurse() {
        PurseTest test = new PurseTest();
        test.test_quarters();
        System.out.println("adding quarters to Purse worked");
        test.test_loadPurse();
        System.out.println("loadPurse worked");
    }
}
