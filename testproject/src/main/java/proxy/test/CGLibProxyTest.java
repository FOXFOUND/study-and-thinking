package proxy.test;

import net.sf.cglib.core.DebuggingClassWriter;

public class CGLibProxyTest {
    public static void main(String[] args) {
        //System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\java_project\\testproject\\com");
        CGLibProxy cgLibProxy = new CGLibProxy();
        IUserManager iUserManagerCgLib = (IUserManager) cgLibProxy.createProxyObject(new UserManagerImpl());
        iUserManagerCgLib.addUser("jpeony", "123456");
        IUserManager iUserManagerCgLib2 = (IUserManager) cgLibProxy.createProxyObject(iUserManagerCgLib);
        iUserManagerCgLib2.addUser("jpeony", "123456");

        /*
        * ======CgLib检查权限checkPopedom()======
======调用了UserManagerImpl.addUser()方法======
Exception in thread "main" net.sf.cglib.core.CodeGenerationException: java.lang.reflect.InvocationTargetException-->null
	at net.sf.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:348)
        * */
    }
}
