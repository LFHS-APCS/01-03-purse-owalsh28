import org.junit.*;
import java.lang.reflect.*;

/**
 * Test the Purse class
 */
public class PurseTest extends junit.framework.TestCase {

    public static void main(String[] args) {
        PurseTest test = new PurseTest();
        test.test_getDollarsFromMoney();
        test.test_getCentsFromMoney();
        test.test_quarters();
        test.test_loadPurse();
    }
    @Test
    public void test_getDollarsFromMoney()
    {
        MoneyIntro m = new MoneyIntro();

        assertEquals(34, m.getDollarsFromMoney(34.56));
        assertEquals(4, m.getDollarsFromMoney(4.70));
    }
    
     @Test
    public void test_getCentsFromMoney()
    {
        MoneyIntro m = new MoneyIntro();

        assertEquals(56, m.getCentsFromMoney(34.56));
        assertEquals(70, m.getCentsFromMoney(4.70));
    }

    @Test
    public void test_quarters()
    {
        Purse myPurse = new Purse();
        myPurse.addPennies(2);
        myPurse.addNickels(3);
        myPurse.addDimes(1);
        //    myPurse.addQuarters(2);

        addQuarters(myPurse, 2, true);
        double totalValue = myPurse.getTotal();
        assertEquals(0.77, totalValue, .001);
    }

    public static void addQuarters(Purse myPurse, int numQuarters, boolean doFail) {
        try {
            Class<?> c = Class.forName("Purse");
            Method s = c.getDeclaredMethod("addQuarters", new Class[] {int.class});
            Object[] args = new Object[] {numQuarters};
            s.invoke(myPurse, args);
        } catch (Exception e) {
            String message = "addQuarters(int numQuarters) not created properly";
            if (doFail)
            fail(message);
            else 
            System.out.println(message);
        }
    }

    public static int getQuarters(Purse myPurse, boolean doFail) {
        try {
            Class<?> c = Class.forName("Purse");
            Method s = c.getDeclaredMethod("getQuarters");
            int numQuarters = (Integer)s.invoke(myPurse);
            return numQuarters;
        } catch (Exception e) {
            String msg = "getQuarters() not created properly";
            if (doFail)
            fail(msg);
            else
            System.out.println(msg);
        }

        return 0;
    }

    @Test
    public void test_loadPurse()
    {
        Purse myPurse = new Purse();
        myPurse.loadPurse(84);
        //    assertEquals(3, myPurse.getQuarters());
        int numQuarters = getQuarters(myPurse, true);
        assertEquals("For 84 cents, should be 3 quarters, not " + numQuarters, 3, numQuarters);

        assertEquals(0, myPurse.getDimes());
        assertEquals(1, myPurse.getNickels());
        assertEquals(4, myPurse.getPennies());
        assertEquals(.84, myPurse.getTotal());

        myPurse.loadPurse(42);
        numQuarters = getQuarters(myPurse, true);
        assertEquals("For 42 cents, should be 1 quarter, not " + numQuarters, 1, numQuarters);

        assertEquals(1, myPurse.getDimes());
        assertEquals(1, myPurse.getNickels());
        assertEquals(2, myPurse.getPennies());
        assertEquals(.42, myPurse.getTotal());
    }


}

