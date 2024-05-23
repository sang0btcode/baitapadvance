package Thread;


import testChat.Sever;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;


public class thread_createSocket implements Runnable{
        public Socket socket= null;
        public String name=null;
        String message="";
        DataInputStream input=null;
        DataOutputStream output=null;
        private static final Logger logger = Logger.getLogger(thread_createSocket.class.getName());

        public thread_createSocket(Socket socket){
            this.socket=socket;
        }
@Override
        public void run(){
            try {
                input = new DataInputStream(socket.getInputStream());
                output = new DataOutputStream(socket.getOutputStream());
                output.writeBoolean(false);
                name = input.readUTF();
                Sever.addClient(this);
                while((message = input.readUTF()) != null){
                    if(message.equals("END")){
                        Sever.broadcastMessage(message,this);
                        break;
                    }
                    Sever.broadcastMessage(message,this);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    output.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

}
public void sendMessage(String message){
            try {
                output.writeUTF(message);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
}
}

