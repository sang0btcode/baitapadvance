package Thread;

import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Thread_read implements Runnable{
    private Socket socket = null;
    DataInputStream input = null;
    //	public static boolean check = true;
    private static final Logger logger = Logger.getLogger(Thread_read.class.getName());

    public Thread_read(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {

        try {
            input = new DataInputStream(socket.getInputStream());
            while (true) {
                String mes = (input.readUTF());
                if (mes.equals("END")) {
                    System.out.println("You have left the group chat");
                     logger.info("You have left the group chat");
                    break;
                } else {
                    System.out.println(mes);
					logger.info(mes);
                }
            }
//			while (check) {
//				String mes = (input.readUTF());
//				System.out.println(mes);
//			}
//			System.out.println("You have left the chat");
        } catch (IOException e) {
            logger.error("IOException read : ", e);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (socket != null && !socket.isClosed()) {
                    socket.close();
                }
            } catch (IOException e) {
                logger.error("IOException while closing resources", e);
            }
        }

    }
}
