// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************
  
//*** Changed for E50  (ET FS)
 public void handleMessageFromServerConsole(String input) throws IOException{
	  if(input.startsWith("#")){
		  String[] message = input.split(" ");
		  String toDo = message[0];
		  
		  
		  switch(toDo){
		  case "#quit":
			  
			  try {
				close();
			} catch (IOException e) {
				
				System.exit(1);
			}
			 System.exit(0);
			  
			  break;
			  
		  case "#stop":
			  stopListening();
			  break;
			  
		  case "#close":
			  try {
				close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			  
			  break;
			  
		  case "#setPort":
			  if(getNumberOfClients()==0 && !isListening() ){
				  setPort(Integer.parseInt(message[1]));
			  }
			  else{
				 System.out.println("Cannot set the new port"); 
			  }
			  
			  break;
			  
		  case "#start":
			  if(isListening()){
				  System.out.println("It is already started");
			  }
			  else{
				  try{
					  listen();
				  }
				  catch(IOException e){
					  
				  }
			  }
			  break;

		  case "#getport":
			  System.out.println(getPort());
			 break; 
			 
		  case "#number":
			  System.out.println(getNumberOfClients());
			  break;
			  
		  case "#all_users":
			  System.out.println(getClientConnections());
			  break;
			
		  case "#disconnect":
			 
			  System.out.println("hey");
			  break;
			  
		  case "#wait":
			  setTimeout(Integer.parseInt(message[1]));
			  break;
			  
		  default:
			  System.out.println("That command is not good");
			  break;
		  }}
	  else{
		  sendToAllClients(input);
	  }
			
 }
  

  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
    
  {
	  String message = msg.toString();
	 
	  if(message.startsWith("#")){
		  String[] argument = message.split(" ");
		  if(argument[0].equals("#login")){
			  if(client.getInfo("userID")!= null){
				  client.setInfo("userID", argument[1]);
		  }
	  }
	  }
	  if(client.getInfo("userID") == null){
		  try {
			System.out.println("you must have a userID");
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  else {
		  System.out.println("Message received: " + msg + " from " + client);
		  this.sendToAllClients(client.getInfo("userID") + ": " + message);
	  }
    
  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
}
//End of EchoServer class
