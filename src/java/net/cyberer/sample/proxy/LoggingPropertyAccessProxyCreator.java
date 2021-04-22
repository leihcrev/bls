package net.cyberer.sample.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggingPropertyAccessProxyCreator {
  @SuppressWarnings("unchecked")
  public static <T> T create(final T target) {
    InvocationHandler handler = new LoggingPropertyAccessInvocationHandler(target);
    return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
  }

  private static final class LoggingPropertyAccessInvocationHandler implements InvocationHandler {
    private final Object target;

    private LoggingPropertyAccessInvocationHandler(final Object target) {
      this.target = target;
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
      try {
        return method.invoke(target, args);
      } finally {
        String methodName = method.getName();
        if (methodName.startsWith("get") || methodName.startsWith("set")) {
          System.out.println(methodName + " is invoked.");
        }
      }
    }
  }
}