package com.robsonribeiroft;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Thread {

    public static final int port = 9090;
    private static final String FINISH = "FINISHED";
    private Socket socket;
    private ServerSocket serverSocket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    private Scanner scan = new Scanner(System.in);
    private String sendMsg;
    private String receivedMsg;

    public Server(){

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Aguardando conexão...");
            socket = serverSocket.accept();
            System.out.println("Conexão Estabelecida.");
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            this.start();

            while (true){
                sendMsg = scan.nextLine();
                outputStream.writeUTF(sendMsg);
                outputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run(){
        while(true){
            try {
                receivedMsg = inputStream.readUTF();
                if (receivedMsg.equals(FINISH)){
                    System.out.print("Finished");
                    break;

                }
                System.out.print("received: "+receivedMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Server();
    }
}
