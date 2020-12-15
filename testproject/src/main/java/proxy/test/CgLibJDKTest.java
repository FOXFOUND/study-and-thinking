package proxy.test;

public class CgLibJDKTest {
    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        IUserManager iUserManagerCgLib = (IUserManager) cgLibProxy.createProxyObject(new UserManagerImpl());
        iUserManagerCgLib.addUser("jpeony", "123456");
        JDKProxy jdkPrpxy = new JDKProxy();
        IUserManager userManagerJDK = (IUserManager) jdkPrpxy.newProxy(iUserManagerCgLib);
        userManagerJDK.addUser("jpeony", "123456");
        /**
         * ======CgLib检查权限checkPopedom()======
         * ======调用了UserManagerImpl.addUser()方法======
         * Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to proxy.test.IUserManager
         * 	at proxy.test.CgLibJDKTest.main(CgLibJDKTest.java:9)
         */
    }
}
