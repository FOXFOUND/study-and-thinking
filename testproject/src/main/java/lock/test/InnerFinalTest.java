package lock.test;

public class InnerFinalTest {

    /**
     * testobj released...lock.test.TestObj@6077d503
     * testobj released...lock.test.TestObj@293fda28
     * testobj released...lock.test.TestObj@1649f7e9
     * testobj released...lock.test.TestObj@2a957c82
     * testobj released...lock.test.TestObj@74946b1e
     * testobj released...lock.test.TestObj@23ad013e
     * testobj released...lock.test.TestObj@7a024c1d
     * testobj released...lock.test.TestObj@7bf25eb3
     * testobj released...lock.test.TestObj@2c691648
     * testobj released...lock.test.TestObj@6786560a
     * @param args
     */
    public static void main(String[] args) {
        for(;;){
            final TestObj o= new TestObj();
        }
    }
}


class TestObj {
    private int[] list = new int[1024*10];

    @Override
    protected void finalize() throws Throwable {
        System.out.println("testobj released..." + this);
        super.finalize();
    }
}