package io.chillout.lib;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyClass {

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        try{
            serverSocket = new ServerSocket(8046);
            System.out.println("Waiting for Client to connect");
            socket = serverSocket.accept();
            System.out.println("__________________");
            System.out.println(" Client Connect ");
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int size = dataInputStream.readInt();
            System.out.println("Image Size is "+ size/1024 +"KB");
            byte[] dataArray = new byte[size];
            dataInputStream.readFully(dataArray);
            dataInputStream.close();
            inputStream.close();
            InputStream stream1 = new ByteArrayInputStream(dataArray);
            BufferedImage bufferedReader = ImageIO.read(stream1);
            JFrame frame = new JFrame("Server Image");
            ImageIcon icon = new ImageIcon(bufferedReader);
            JLabel label = new JLabel();
            label.setIcon(icon);
            frame.add(label);
            frame.pack();
            frame.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
