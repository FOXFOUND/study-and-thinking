package lock.test;

public   class SyncnizedTest {

    public synchronized static void  testFun(){

    }

    public static void main(String[] args) {
        synchronized (SyncnizedTest.class){

        }
    }
}
