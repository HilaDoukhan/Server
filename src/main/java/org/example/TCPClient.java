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

            Scanner scanner = new Scanner(System.in);
            int input ;

            while (true) {

                String sendToServer = "";
                System.out.println("plz press 1 to Add new person ");
                System.out.println("plz press 2 for Searching a person ");
                System.out.println("plz press 3 for Delete person");
                System.out.println("plz press 4 for Update person");

                input = scanner.nextInt();
                sendToServer += input + "-";

                if (input ==1 || input == 4){

                    System.out.println("plz insert id");
                    String id = inFromUser.nextLine();

                    System.out.println("plz insert name");
                    String name = inFromUser.nextLine();

                    System.out.println("plz insert phone");
                    String phone = inFromUser.nextLine();

                    System.out.println("plz insert password");
                    String password = inFromUser.nextLine();

                    sendToServer+=id+"-"+name+"-"+phone+"-"+password;

                    //איך נשתמש בפונקציית SQL?
                    if (input == 1){
                        System.out.println("Successfully added person");
                    }else {
                        System.out.println("Update Successfully");
                    }

                } else if (input == 2) {
                    System.out.println("plz insert id");
                    String id = inFromUser.nextLine();

                    sendToServer+=id;



                } else if (input == 3) {
                    System.out.println("plz insert id");
                    String id = inFromUser.nextLine();
                    sendToServer+=id;


                    System.out.println("Delete Successfully");
                }

//                System.out.println("123456789*hila*0543041603*G66");
                //Student s = new Student(id, name, phone);
                outToServer.writeObject(sendToServer); // send all the student object

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

