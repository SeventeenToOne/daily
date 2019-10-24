package JVM;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: algorithms
 * @description: jvm P283
 * @author: wxq
 * @date 2019-04-28 19:45
 **/
public class DynamicProxyTest {
    interface IHello{
        void sayHello();
    }

    static class Hello implements IHello{
        @Override
        public void sayHello() {
            System.out.println("hello word");
        }
    }

    static class DynamicProxy implements InvocationHandler{
        Object originalObj;

        public Object bind(Object originalObj){
            this.originalObj = originalObj;
            return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);

        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("welcome");
            return method.invoke(originalObj, args);
        }
    }

    public static void main(String[] args) {
        IHello hello = (IHello) new DynamicProxy().bind(new Hello());
        hello.sayHello();
    }
}
