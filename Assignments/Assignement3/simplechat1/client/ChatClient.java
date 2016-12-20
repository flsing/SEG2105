// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

package client;

import ocsf.client.*;
import common.*;
import java.io.*;

/**
 * This class overrides some of the methods defined in the abstract
 * superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient
{
  //Instance variables **********************************************
  
  /**
   * The interface type variable.  It allows the implementation of 
   * the display method in the client.
   */
  ChatIF clientUI;
private String userID = "";
  

  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the chat client.
   *
   * @param host The server to connect to.
   * @param port The port number to connect on.
   * @param clientUI The interface type variable.
   */
  //*** changed for E51
  public ChatClient(String userID, String host, int port, ChatIF clientUI) 
    throws IOException 
  {
    super(host, port); //Call the superclass constructor
    this.clientUI = clientUI;
    this.userID = userID;
    openConnection();
    sendToServer("#login " + userID);
  }  
  //Instance methods ************************************************
    
  
  // *** Changed for E50  (ET FS)
  public void handleMessageFromClientConsole(String input){
	  if(input.startsWith("#")){
		  String[] message = input.split(" ");
		  String toDo = message[0];
		  
		  
		  switch(toDo){
		  case "#quit":
			  quit();
			  break;
			  
		  case "#logoff":
			  try {
				closeConnection();
			} catch (IOException e1) {
				
				System.out.println("There was an error loging off");
			}
			  break;
			  
		  case "#setHost":
			  if(isConnected()){
				  System.out.println("Cannot do that since you are connected");
			  }
			  else{
				  setHost(message[1]);
			  }
			  break;
			  
		  case "#setPort":
			  if(isConnected()){
				  System.out.println("Cannot do that since you are already connected");
			  }
			  else{
				  setPort(Integer.parseInt(message[1]));
			  }
			  break;
			  
		  case "#login":
			  if(isConnected()){
				  System.out.println("You are already logged in");
			  }
			  else{
				  try {
					openConnection();
				} catch (IOException e) {
					System.out.println("There is an error loging in");
					
				}
			  }
			  break;

		  case "#gethost":
			  System.out.println(getHost());
			 break; 
			 
		  case "#getport":
			  System.out.println(getPort());
			  break;
			  

			  
		default:
			System.out.println("That command is not valid");
			break;
			
		
		  }
		  }
		  else{
			  try {
				sendToServer(input);
			} catch (IOException e) {
				
				e.printStackTrace();
				quit();
			}
		  }
		  

	  }
  

  
  /**
   * This method handles all data that comes in from the server.
   *
   * @param msg The message from the server.
   */
  public void handleMessageFromServer(Object msg) 
  {
    clientUI.display(msg.toString());
  }

  /**
   * This method handles all data coming from the UI            
   *
   * @param message The message from the UI.    
   */
  public void handleMessageFromClientUI(String message)
  {
    try
    {
      sendToServer(message);
    }
    catch(IOException e)
    {
      clientUI.display
        ("Could not send message to server.  Terminating client.");
      quit();
    }
  }
  
  /**
   * This method terminates the client.
   */
  public void quit()
  {
    try
    {
      closeConnection();
    }
    catch(IOException e) {}
    System.exit(0);
  }
  

}
//End of ChatClient class
