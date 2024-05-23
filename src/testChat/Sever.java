package testChat;
import Thread.thread_createSocket;
import org.apache.log4j.Logger;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Sever {
    static ArrayList<thread_createSocket> clients = new ArrayList<thread_createSocket>();
     private static final Logger logger = Logger.getLogger(Sever.class.getName());
    int limit = 2;
    static int id = 0;
    ServerSocket sv =null;
    Socket socket =null;
    thread_createSocket thread_socket;
    DataOutputStream output =null;
    public void Sever() {
        try {
            ExecutorService ex = Executors.newFixedThreadPool(limit);
            sv = new ServerSocket(2001);
            System.out.println("Sever is running....");
            while (true) {
                thread_socket = new thread_createSocket(sv.accept());
                output = new DataOutputStream(thread_socket.socket.getOutputStream());
                if (clients.size() == limit) {
                    output.writeBoolean(true);
                }
                Thread thread = new Thread(thread_socket);
                ex.execute(thread);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void broadcastMessage(String message, thread_createSocket client) {
        if (message.equals("STOP")){
            client.sendMessage(message);
            clients.remove(client);
            message = client.name + "has split the chat group";
            for (thread_createSocket cl : clients) {
                cl.sendMessage(message);
            }
        }else {
            message = client.name + " : " + message;
            for (thread_createSocket cl : clients) {
                if (cl != client) {
                    cl.sendMessage(message);
                }
            }
    }

}

    public static void main(String[] args) {
        Sever sv = new Sever();
        sv.Sever();
    }
    public static void addClient(thread_createSocket createSocket) {
        clients.add(createSocket);
        String message = createSocket.name + "joined the chat group";
        System.out.println(message);
        for (thread_createSocket cl : clients) {
            if (cl != createSocket) {
                cl.sendMessage(message);
            }
        }
    }
}

