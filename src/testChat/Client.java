package testChat;
import Thread.Thread_read;
import Thread.Thread_write;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
    private static final Logger logger = Logger.getLogger(Client.class.getName());
    Socket socket = null;
    Scanner scanner = null;
    DataOutputStream output;
    DataInputStream input;
    boolean check = true;

    public void connect() {

        try {
            socket = new Socket("localhost", 2001);

        } catch (UnknownHostException e) {
            logger.error("Unknown host exception", e);
        }
		catch (ConnectException e) {
            logger.error("Connect exception", e);
		}
        catch (IOException e) {
            logger.warn("Connect Fail, doing it again. Please wait !");
            while (true) {
                try {
                    Thread.sleep(2000);
                    socket = new Socket("localhost", 2001);
                    break;
                } catch (IOException | InterruptedException ex) {
                }
            }
        } finally {
            System.out.println("Connected to the server.");
            System.out.println("What is your name ? ");
            scanner = new Scanner(System.in);
            try {
                output = new DataOutputStream(socket.getOutputStream());
                input = new DataInputStream(socket.getInputStream());
            } catch (IOException e) {
                logger.error("IOException create data input output : " + e);
            } catch (NullPointerException e) {
                logger.error("NullPointerException create data output : " + e);
            }

            try {
                String name = scanner.nextLine();
                output.writeUTF(name);

            } catch (IOException e) {
                logger.error("IOException write data name : " + e);
            }

            while (true) {
                if (input != null) {
                    try {
                        check = input.readBoolean();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (!check) {
                    break;
                }
                System.out.println("Full Group. pls wait !");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Start chat :");
            Runnable read = new Thread_read(socket);
            Runnable write = new Thread_write(socket);
            Thread tr = new Thread(read);
            Thread tw = new Thread(write);
            tr.start();
            tw.start();
        }
    }

    public static void main(String[] args) {
        Client cl = new Client();
        cl.connect();
    }
}

