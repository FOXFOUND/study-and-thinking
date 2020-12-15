package proxy.test;

import cn.hutool.core.io.FileUtil;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * 代理模式[[ 客户端--》代理对象--》目标对象 ]]
 */
public class Client {
    public static void main(String[] args) {
//        System.out.println("**********************CGLibProxy**********************");
//        CGLibProxy cgLibProxy = new CGLibProxy();
//        IUserManager userManager = (IUserManager) cgLibProxy.createProxyObject(new UserManagerImpl());
//        userManager.addUser("jpeony", "123456");
//
//        System.out.println("**********************JDKProxy**********************");
//        JDKProxy jdkPrpxy = new JDKProxy();
//        IUserManager userManagerJDK = (IUserManager) jdkPrpxy.newProxy(new UserManagerImpl());
//        userManagerJDK.addUser("jpeony", "123456");


        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\java_project\\testproject\\com");
        Father father = new Father();
        CGLibProxy cgLibProxy = new CGLibProxy();

        System.out.println(father.getClass());
        Father fatherM = (Father)cgLibProxy.createProxyObject(father);
        Class c = fatherM.getClass();
        System.out.println(fatherM.getClass());

//        JDKProxy jdkPrpxy = new JDKProxy();
//        //Father fatherJDK = (Father)jdkPrpxy.newProxy(father);
//        Object o = jdkPrpxy.newProxy(father);
//        /**
//         * class com.sun.proxy.$Proxy0
//         */
//        System.out.println(o.getClass());
//        System.out.println(o.toString());

        /**
         * Father{}proxy.test.Father@23fc625e
         * ======检查权限checkPopedom()======
         * Father{}proxy.test.Father@23fc625e
         * Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to proxy.test.Father
         * 	at proxy.test.Client.main(Client.java:28)
         */

        /**
         * class proxy.test.Father
         * class proxy.test.Father$$EnhancerByCGLIB$$8f60b630
         * Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to proxy.test.Father
         * 	at proxy.test.Client.main(Client.java:28)
         */
    }
}