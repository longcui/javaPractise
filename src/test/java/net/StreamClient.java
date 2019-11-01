package net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class StreamClient {

    public static void main(String []args) {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost(), 50000);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(50);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
