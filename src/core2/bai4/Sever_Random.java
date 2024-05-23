package core2.bai4;

import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever_Random {
private static final Logger log = Logger.getLogger(Sever_Random.class);
private static final  int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();
        DataInputStream in = new DataInputStream(socket.getInputStream());
        while (true) {
            String msg = in.readUTF();
            log.info(msg);
            System.out.println("Nhận " + msg);
        }
    }
}
