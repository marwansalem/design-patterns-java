package patterns.behavioural.nullobject.bank;

import java.lang.reflect.Proxy;

public class Bank {
    // Dynamic proxy approach
    // it is computationally expensive since it is at runtime
    @SuppressWarnings("unchecked")
    public static <T> T noOp(Class<T> itf) {
        return (T) Proxy.newProxyInstance(
            itf.getClassLoader(),
            new Class<?>[] {itf},
            (proxy, method, args) -> {
                if (method.getReturnType().equals(Void.TYPE)) {
                    return null;
                } else {
                    // won't work if there is no proper constructor
                    // or if building is not that simple and requires more than just constructor
                    // if you know which objects you are dealing with you can fix this here
                    return method.getReturnType().getConstructor().newInstance();
                }
            }
        );
    }
    public static void main(String[] args) {
        Log log = new ConsoleLog();
        BankAccount ba = new BankAccount(log);
        ba.deposit(100);

        // you want to disable logging
        // new BankAccount(null) will not work
        Log nullLog = new NullLog();
        BankAccount bankAccount = new BankAccount(nullLog);
        bankAccount.deposit(200);

        Log noOpLog = noOp(Log.class);
        BankAccount ba2 = new BankAccount(noOpLog);
        ba2.deposit(300);
    }
}
