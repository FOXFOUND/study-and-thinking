package proxy.test;

public class JDKCgLibTest {
    public static void main(String[] args) {
        JDKProxy jdkPrpxy = new JDKProxy();
        IUserManager userManagerJDK = (IUserManager) jdkPrpxy.newProxy(new UserManagerImpl());
        userManagerJDK.addUser("jpeony", "123456");
        CGLibProxy cgLibProxy = new CGLibProxy();
        IUserManager iUserManagerCgLib = (IUserManager) cgLibProxy.createProxyObject(userManagerJDK);
        iUserManagerCgLib.addUser("jpeony", "123456");

        /**
         * ======检查权限checkPopedom()======
         * ======调用了UserManagerImpl.addUser()方法======
         * Exception in thread "main" java.lang.IllegalArgumentException: Cannot subclass final class com.sun.proxy.$Proxy0
         * 	at net.sf.cglib.proxy.Enhancer.generateClass(Enhancer.java:565)
         * 	at net.sf.cglib.core.DefaultGeneratorStrategy.generate(DefaultGeneratorStrategy.java:25)
         */
    }
}
