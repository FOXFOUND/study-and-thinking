package proxy.test;

public class JdkProxyTest {
    public static void main(String[] args) {
        System.out.println("**********************JDKProxy**********************");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        JDKProxy jdkPrpxy = new JDKProxy();
        IUserManager userManagerJDK = (IUserManager) jdkPrpxy.newProxy(new UserManagerImpl());
        userManagerJDK.addUser("jpeony", "123456");
        IUserManager userManagerJDK2 = (IUserManager) jdkPrpxy.newProxy(userManagerJDK);
        userManagerJDK2.addUser("jpeony", "123456");

        /**
         * jdk 二次代理会出现死循环
         */
        /**
         * at proxy.test.JDKProxy.invoke(JDKProxy.java:36)
         * 	at com.sun.proxy.$Proxy0.addUser(Unknown Source)
         * 	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
         * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         * 	at java.lang.reflect.Method.invoke(Method.java:498)
         * 	at proxy.test.JDKProxy.invoke(JDKProxy.java:36)
         * 	at com.sun.proxy.$Proxy0.addUser(Unknown Source)
         * 	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
         * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         * 	at java.lang.reflect.Method.invoke(Method.java:498)
         * 	at proxy.test.JDKProxy.invoke(JDKProxy.java:36)
         * 	at com.sun.proxy.$Proxy0.addUser(Unknown Source)
         * 	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
         * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         * 	at java.lang.reflect.Method.invoke(Method.java:498)
         * 	at proxy.test.JDKProxy.invoke(JDKProxy.java:36)
         * 	at com.sun.proxy.$Proxy0.addUser(Unknown Source)
         * 	at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
         * 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
         * 	at java.lang.reflect.Method.invoke(Method.java:498)
         */
    }
}
