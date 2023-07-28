package baitap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {

    public static void main(String[] args) {
        try {
            int port = 8080; //mo cong ket noi
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server đang chạy và lắng nghe kết nối từ Client...");
            while (true) {
                Socket clientSocket = serverSocket.accept(); //chap nhan ket noi tu client
                BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
                int number1 = Integer.parseInt(inputFromClient.readLine());

                int number2 = Integer.parseInt(inputFromClient.readLine());
                //thuc hien phep tinh va gui ket qua ve client
                int sum = number1 + number2;
                outputToClient.println("ket qua: " + sum);
                //dong ket noi
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
