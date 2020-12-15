package object.test;

public class ValidateTest {

    //public volatile int msg = 1;
    public int msg = 1;

    public static void main(String[] args) {
        ValidateTest validateTest = new ValidateTest();
        VolatileTestTwo volatileTestTwo = new VolatileTestTwo();

        System.out.println(validateTest.msg);
        validateTest.msg++;
        System.out.println(validateTest.msg);

        
        /**
         * 11 is right =11
         * 11 is right =11
         * 11 is right =10
         * 11 is right =11
         * 11 is right =11
         * 11 is right =11
         */
        for (int i = 0; i < 100; i++) {
            VolatileTestTwo testTwo = new VolatileTestTwo();
            testTwo.modify2();
        }

    }
}
