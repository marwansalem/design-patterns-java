package patterns.structural.proxy.dynamic.logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import patterns.structural.proxy.dynamic.human.Human;
import patterns.structural.proxy.dynamic.human.Person;

public class LoggingHandler implements InvocationHandler {
    private final Object target;
    Map<String, Integer> methodCalls = new HashMap<>();

    public LoggingHandler(Object target) {
        this.target = target;
    }

    // allows us to intercept methods
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String methodName = method.getName();

        if (methodName.contains("toString")) {
            return methodCalls.toString();
        }
        methodCalls.merge(methodName, 1, Integer::sum);
        return method.invoke(target, objects);

    }

    @SuppressWarnings("unchecked")
    public static <T> T withLogging(T target, Class<T> itf) {
        return (T) Proxy.newProxyInstance(
            itf.getClassLoader(),
            new Class<?>[] { itf },
            new LoggingHandler(target)
        );
    }

    public static void main(String[] args) {
        Person person = new Person();

        Human logged = withLogging(person, Human.class);

        logged.talk();
        logged.walk();
        logged.walk();

        System.out.println(logged);
    }
}
