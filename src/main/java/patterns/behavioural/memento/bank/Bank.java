package patterns.behavioural.memento.bank;

import org.junit.Assert;

public class Bank {

    public static void main(String[] args) {
        BankAccount ba = new BankAccount(1000);
        BalanceMemento initialMemento = ba.makeBackup();
        BalanceMemento m1 = ba.deposit(50);
        BalanceMemento m2 = ba.deposit(25);
        System.out.println(ba);

        // restore to m1
        ba.restore(m1);
        System.out.println(ba);
        Assert.assertEquals(1050, ba.getBalance());

        // restore to m2

        ba.restore(m2);
        System.out.println(ba);
        Assert.assertEquals(1075, ba.getBalance());

        // restore to initial

        ba.restore(initialMemento);
        System.out.println(ba);
        Assert.assertEquals(1000, ba.getBalance());

    }
}
