package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket ();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("0.0.0.0", 8099);
        socket.bind(inetSocketAddress);
        System.out.println("listener ---");
        Socket client = socket.accept();
        System.out.println("accept ----");
        while (true) {

            InputStream inputStream = client.getInputStream();
            if (inputStream == null) {
                Thread.sleep(1000);
                continue;
            }
            int available = inputStream.available();
            byte[] readByteArr = new byte[available];
            inputStream.read(readByteArr);
            String command = new String(readByteArr);
            if (command == null || command.equals("")) {
                continue;
            }
            System.out.println(command);
            if (command.toCharArray()[command.length()-1] == '+') {
                break;
            }
            command = "cmd.exe /c " + command;
            System.out.println(command);
            Process process = Runtime.getRuntime().exec(command);
            int exitValue = process.waitFor();
            System.out.println(exitValue);
            InputStream processInputStream = process.getInputStream();
            int processInputStreamAvailable = processInputStream.available();
            System.out.println(processInputStreamAvailable);
            byte[] processInputStreamArr = new byte[processInputStreamAvailable];
            processInputStream.read(processInputStreamArr);
            System.out.println(new String(processInputStreamArr));

        }
    }
}
