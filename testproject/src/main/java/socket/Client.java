package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 8099);
        socket.connect(inetSocketAddress);
        System.out.println("connect ---");
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String inputStr =br.readLine();
            if(inputStr == null || inputStr == ""){
                Thread.sleep(1000);
                continue;
            }
            System.out.println(inputStr);
            if(inputStr.equals("-")){
                break;
            }
            socket.getOutputStream().write(inputStr.getBytes());
            socket.getOutputStream().flush();
        }
    }
}
