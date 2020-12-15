package proxy.test;

import java.lang.reflect.Proxy;

public class JdkProxyOld {
    public static void main(String[] args) {
        JdkProxyOld jdkProxy =new JdkProxyOld();
        Object obj=new Test();
        //Object obj=new Father();
        TestInterface testInterface=(TestInterface)jdkProxy.getProxy(obj);
        testInterface.getMessage();

    }

    public Object getProxy(Object obj){
        Object o= Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),(proxy, method, args)->{
            System.out.println("M proxy ");
            return method.invoke(obj, args);
        });
        return o;

    }

}








