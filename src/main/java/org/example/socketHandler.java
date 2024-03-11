package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Objects;

public class socketHandler extends Thread {
	Socket incoming;
	Sql sql; 
	
	socketHandler(Socket _in , Sql sql)
	{
		incoming=_in;
		this.sql = sql ; 
	}
	
	public void run()
	{
		String clientSentence; 
	    String capitalizedSentence = null; 
	   int num ; 
	   int num2;
		try {

			ObjectInputStream inFromClient = new ObjectInputStream(incoming.getInputStream());

			DataOutputStream outToClient =new DataOutputStream(incoming.getOutputStream());
          
		while(true) {

			try {
//				Object obj = inFromClient.toString();
				String[] input = inFromClient.readObject().toString().split("-");
				System.out.println(input);
				String sendToClient = "ok";

				if (Objects.equals(input[0], "1")){

					sql.insertStatement(input[1],input[2],input[3],input[4]);

				} else if (Objects.equals(input[0], "2")) {

					sendToClient = Sql.selectQuery(input[1]);

				}else if (Objects.equals(input[0], "3")) {
					sql.deleteStatement(input[1]);

				} else if (Objects.equals(input[0], "4")) {
					sql.updateStatement(input[1],input[2],input[3],input[4]);
				}


				outToClient.writeUTF(sendToClient + "\n");

//				if ( obj instanceof Student) {
//					Student s = (Student) obj;
//
//				sql.insertStatement(s.id, s.name, s.phone,"0");
//
//				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				outToClient.writeBytes("it was not ok\n");
				e.printStackTrace();
			}
			
	           
	         
	          

		}

	} catch (IOException ex) {
		throw new RuntimeException(ex);
	}
}}
