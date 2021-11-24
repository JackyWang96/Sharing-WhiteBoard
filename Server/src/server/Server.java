package server;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.List;
import java.awt.*;
import javax.swing.*;

public class Server extends JFrame {
    private List<Integer> portList;
    // Text area for displaying contents
    private JTextArea jta = new JTextArea();
    private List<HandleAClient> handleAClient = new ArrayList<HandleAClient>();
    private List<HandleAClientTwo> handleAClientTwo = new ArrayList<HandleAClientTwo>();

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        // Place text area on the frame
        setLayout(new BorderLayout());
        add(new JScrollPane(jta), BorderLayout.CENTER);

        setTitle("Server");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        // It is necessary to show the frame here!

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            ServerSocket serverSocketTwo = new ServerSocket(8100);
            jta.append("Service Open..." + new Date() + '\n');

            // Number a client
            int clientNo = 1;

            while (true) {
                // Listen for a new connection request
                Socket socket = serverSocket.accept();
                System.out.println(socket.getPort());
                System.out.println(socket.toString());
                Socket socketTwo = serverSocketTwo.accept();
                // Display the client number
                jta.append("Starting thread for client " + clientNo +
                        " at " + new Date() + '\n');

                // Find the client's host name, and IP address
                InetAddress inetAddress = socket.getInetAddress();
                jta.append("Client " + clientNo + "'s host name is "
                        + inetAddress.getHostName() + "\n");
                jta.append("Client " + clientNo + "'s IP Address is "
                        + inetAddress.getHostAddress() + "\n");

                // Create a new thread for the connection
                HandleAClient task = new HandleAClient(socket);
                HandleAClientTwo taskTwo = new HandleAClientTwo(socketTwo);
                handleAClient.add(task);
                handleAClientTwo.add(taskTwo);
                // Start the new thread
                new Thread(task).start();
                new Thread(taskTwo).start();
                // Increment clientNo
                clientNo++;

            }
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }

    class HandleAClient implements Runnable {
        private Socket socket; // A connected socket
        DataInputStream inputFromClient;
        private int drawMessage;
        DataOutputStream outputFromClient;

        public HandleAClient(Socket socket) {
            this.socket = socket;
            try {
                inputFromClient = new DataInputStream(this.socket.getInputStream());
                outputFromClient = new DataOutputStream(this.socket.getOutputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

        public void sendDrawMessage(int message) {
            try {
                outputFromClient.writeInt(message);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public Socket getSocket() {
            return this.socket;
        }

        public void run() {
            try {
                // Create data input and output streams

                // Continuously serve the client
                while (true) {
                    drawMessage = inputFromClient.readInt();
                    for (HandleAClient temp : handleAClient) {
                        temp.sendDrawMessage(drawMessage);
                    }

                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }


    class HandleAClientTwo implements Runnable {
        private Socket socket; // A connected socket
        DataInputStream inputFromClient;
        private String wordMessage;
        DataOutputStream outputFromClient;

        public HandleAClientTwo(Socket socket) {
            this.socket = socket;
            try {
                inputFromClient = new DataInputStream(this.socket.getInputStream());
                outputFromClient = new DataOutputStream(this.socket.getOutputStream());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

        public void sendWordMessage(String message) {
            try {
                outputFromClient.writeUTF(message);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public Socket getSocket() {
            return this.socket;
        }

        public void run() {
            try {
                // Create data input and output streams

                // Flag = inputFromClient.readInt();
                // Continuously serve the client
                while (true) {

                    wordMessage = inputFromClient.readUTF();
                    for (HandleAClientTwo temp : handleAClientTwo) {
                        temp.sendWordMessage(wordMessage);
                    }

                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }

}

