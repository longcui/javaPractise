package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StreamServer {

    public static void main(String []args) throws IOException {
        while(true) {
            ServerSocket serverSocket = new ServerSocket(50000);
            Socket socket = serverSocket.accept();
            String s = new String(socket.getInputStream().readAllBytes());
            System.out.println(s);
        }
    }
}
