package org.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

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
		try
		{
	    
          
          ObjectInputStream inFromClient = new ObjectInputStream(incoming.getInputStream());
               
           DataOutputStream  outToClient = 
        		   new DataOutputStream (incoming.getOutputStream() );
          
//		while(true) {

			sql.delete_statement("324125897");

//			try {
//				Object obj = inFromClient.readObject();
//				if ( obj instanceof Student) {
//					Student s = (Student) obj;
//
//					sql.insert_statement(s.id, s.name, s.phone);
//					outToClient.writeBytes("it was ok everything here\n");
//				}
//
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				outToClient.writeBytes("it was not ok\n");
//				e.printStackTrace();
//			}
			
	           
	         
	          
	        } catch (IOException ex) {
			throw new RuntimeException(ex);
		}

	}
}
