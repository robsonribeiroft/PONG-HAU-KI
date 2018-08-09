package com.robsonribeiroft;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private String sendMsg;
    private String receivedMsg;
    private Scanner scan = new Scanner(System.in);

    public Client(){
        try {
            socket = new Socket("localhost", Server.port);
            System.out.println("Connected....");
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            this.start();

            while (true){
                System.out.print("Message: ");
                sendMsg = scan.nextLine();
                outputStream.writeUTF(sendMsg);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            receivedMsg = inputStream.readUTF();
            System.out.println(receivedMsg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
