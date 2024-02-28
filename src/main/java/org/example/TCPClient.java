package org.example;

import java.io.*;
import java.net.*;
import java.util.Scanner;

class TCPClient {

    public static void main(String argv[]) {
        String sentence;
        String modifiedSentence;

        try {


            Scanner inFromUser = new Scanner(System.in);

            Socket clientSocket = new Socket("localhost", 10000);


            ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer =
                    new BufferedReader(new
                            InputStreamReader(clientSocket.getInputStream()));

            while (true) {

                System.out.println("plz insert id");
                String id = inFromUser.nextLine();

                System.out.println("plz insert name");
                String name = inFromUser.nextLine();

                System.out.println("plz insert phone");
                String phone = inFromUser.nextLine();

                Student s = new Student(id, name, phone);

                outToServer.writeObject(s); // send all the student object

                modifiedSentence = inFromServer.readLine();

                System.out.println("FROM SERVER: " + modifiedSentence);

            }


        } catch (ConnectException e) {
            System.out.println(" 404 C'ant connect to the Server");
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

