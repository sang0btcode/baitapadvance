package core2.bai4;

import org.apache.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;


public class Client_Random {
    private static final Logger logger = Logger.getLogger(Client_Random.class);
    private static final int PORT = 8080; // Cổng kết nối
    private static final String HOST = "localhost"; // Địa chỉ IP máy B
    public static String generateRandomString(){
        Random random = new Random();
        int length = 10 + random.nextInt(20);

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException, InterruptedException {
    Socket socket = new Socket(HOST, PORT);
    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

    while (true) {
        String msg = generateRandomString();

        dos.writeUTF(msg);

        System.out.println("Gửi: " + msg);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
}


