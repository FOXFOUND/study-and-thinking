package annotation.test;

public class AssertTest {
    public static void main(String[] args) {
        int x = -1;
        assert x > 0 : "x must above 0";
        //-enableassertions  启动断言需要设置jvm参数

        /**
         * Exception in thread "main" java.lang.AssertionError: x must above 0
         * 	at annotation.test.AssertTest.main(AssertTest.java:6)
         */

        /**
         * 还可以有选择地对特定地类启用断言，
         * 命令行参数是：-ea:com.itranswarp.sample.Main，
         * 表示只对com.itranswarp.sample.Main这个类启用断言。
         */
        System.out.println("ok");
    }
}
