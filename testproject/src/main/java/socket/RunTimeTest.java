package socket;

import java.io.IOException;
import java.io.InputStream;

public class RunTimeTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String command = "cmd.exe /c  dir";
        Process process = Runtime.getRuntime().exec(command);

//        for (int i = 0; i < 10; i++) {
//
//            Thread.sleep(1000);
//            boolean exit =process.isAlive();
//            System.out.println(exit);
//        }
        int exitValue = process.waitFor();
        System.out.println(exitValue);
        InputStream inputStream = process.getInputStream();
        int available = inputStream.available();
        System.out.println(available);
        byte [] readByteArr = new byte[available];
        inputStream.read(readByteArr);



        System.out.println(new String(readByteArr));
    }
}
