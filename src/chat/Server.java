//package chat;
//
//import java.io.*;
//import java.net.*;
//import java.util.*;
//
//public class Server {
//    private static final int PORT = 12345;
//    private static Map<PrintWriter, String> clientMap = new HashMap<>();
//
//    public static void main(String[] args) {
//        try {
//            ServerSocket serverSocket = new ServerSocket(PORT);
//            System.out.println("Server is running...");
//
//            while (true) {
//                new ClientHandler(serverSocket.accept()).start();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static class ClientHandler extends Thread {
//        private Socket clientSocket;
//        private PrintWriter out;
//        private BufferedReader in;
//        private String clientName;
//
//        public ClientHandler(Socket socket) {
//            this.clientSocket = socket;
//        }
//
//        public void run() {
//            try {
//                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//                out = new PrintWriter(clientSocket.getOutputStream(), true);
//
//                // Yêu cầu client nhập tên
//                out.println("Enter your name:");
//                clientName = in.readLine();
//                System.out.println(clientName + " connected.");
//
//                synchronized (clientMap) {
//                    clientMap.put(out, clientName);
//                }
//
//                String message;
//                while ((message = in.readLine()) != null) {
//                    System.out.println("Received message from " + clientName + ": " + message);
//                    broadcast(clientName + ": " + message);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                // Xóa client ra khỏi map khi client đóng kết nối
//                synchronized (clientMap) {
//                    clientMap.remove(out);
//                }
//            }
//        }
//
//        private void broadcast(String message) {
//            synchronized (clientMap) {
//                for (PrintWriter writer : clientMap.keySet()) {
//                    writer.println(message);
//                }
//            }
//        }
//    }
//}
