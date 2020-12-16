package classLoader.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 使用自定义classLoader 加载类
 */
public class ReadClassByteArr {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        ClassLoader appClassLoader = MyTest.class.getClassLoader();
        System.out.println(appClassLoader);
        FileInputStream fileInputStream = new FileInputStream("D:\\github_project\\study-and-thinking\\testproject\\target\\classes\\classLoader\\test\\MyTest.class");
        int fileSize = fileInputStream.available();
        byte[] byteArr = new byte[fileSize];
        fileInputStream.read(byteArr);
        MyClassLoader myClassLoader = new MyClassLoader();
        Class aClass = myClassLoader.defineClass("classLoader.test.MyTest", byteArr);
        /**
         * 包名必须一致
         *
         * Exception in thread "main" java.lang.NoClassDefFoundError: classLoader/MyTest (wrong name: classLoader/test/MyTest)
         * 	at java.lang.ClassLoader.defineClass1(Native Method)
         */
        //Class aClass = myClassLoader.defineClass("classLoader.MyTest", byteArr);
        Object obj = aClass.newInstance();
        Method method = aClass.getMethod("test");
        method.invoke(obj);
        System.out.println(aClass.getClassLoader());

        /**
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * you read it
         * classLoader.test.MyClassLoader@77459877
         */

    }
}
