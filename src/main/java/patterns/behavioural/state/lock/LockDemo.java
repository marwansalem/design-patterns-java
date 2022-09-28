package patterns.behavioural.state.lock;

import static org.junit.Assert.assertEquals;

public class LockDemo {

    public void testSuccess()
    {
        CombinationLock cl = new CombinationLock(new int[]{1, 2, 3, 4});
        assertEquals("LOCKED", cl.status);

        cl.enterDigit(1);
        assertEquals("1", cl.status);

        cl.enterDigit(2);
        assertEquals("12", cl.status);

        cl.enterDigit(3);
        assertEquals("123", cl.status);

        cl.enterDigit(4);
        assertEquals("OPEN", cl.status);
    }

    public void testFailure()
    {
        CombinationLock cl = new CombinationLock( new int[]{1, 2, 3});

        assertEquals("LOCKED", cl.status);

        cl.enterDigit(1);
        assertEquals("1", cl.status);

        cl.enterDigit(2);
        assertEquals("12", cl.status);

        cl.enterDigit(5);
        assertEquals("ERROR", cl.status);
    }

    public static void main(String[] args) {
        LockDemo l = new LockDemo();
        l.testFailure();
        l.testSuccess();
    }


}
