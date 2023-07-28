package baitap1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class Client {
    public static void main(String[] args) {
        try {
            String serverip = "127.0.0.1";
            int port = 8080;
            Socket socket = new Socket(serverip, port); //ket noi toi server
            //tao luong doc du lieu tu server
            BufferedReader inputFromSever = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //taoluong ghi du lieu tu server
            PrintWriter outputToServer = new PrintWriter(socket.getOutputStream(), true);
            //nhap 2 so tu nguoi dung
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("nhap so thu nhat: ");
            int number1 = Integer.parseInt(userInput.readLine());
            System.out.println("nhap so thu hai: ");
            int number2 = Integer.parseInt(userInput.readLine());

            //gui noi dung can len server
            outputToServer.println(number1);

            outputToServer.println(number2);
            //doc kqua tu server va hien thi
            String result = inputFromSever.readLine();
            System.out.println("ket qua: " + result);
            //dong
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}