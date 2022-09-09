package patterns.creational.singleton.innerstatic;

public class InnerStaticSingleton {
    private InnerStaticSingleton() {}
    private static class Inner {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();
    }

    public InnerStaticSingleton getInstance() {
        return Inner.INSTANCE;
    }
}
