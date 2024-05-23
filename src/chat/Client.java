//package chat;
//
//import java.io.*;
//import java.net.*;
//
//public class Client {
//    private static final String SERVER_ADDRESS = "localhost";
//    private static final int SERVER_PORT = 12345;
//
//    public static void main(String[] args) {
//        try {
//            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
//            System.out.println("Connected to server.");
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//
//            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
//
//            Thread receivingThread = new Thread(() -> {
//                try {
//                    String message;
//                    while ((message = in.readLine()) != null) {
//                        System.out.println("Received message from server: " + message);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });
//            receivingThread.start();
//
//            String userInputMessage;
//            while (true) {
//                userInputMessage = userInput.readLine();
//                if (userInputMessage.equalsIgnoreCase("exit")) {
//                    break;
//                }
//                out.println(userInputMessage);
//            }
//
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
