package proxy.test;

public class Test extends Father implements TestInterface {
    @Override
    public void getMessage() {
        System.out.println("M test");
    }
}