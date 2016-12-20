

import java.io.*;
import client.*;
import common.*;

//**** Class created for E50 (ET FS)   we copied the class ClientConsole
//**** and made the necessary changes
public class ServerConsole implements ChatIF 
{
  //Class variables *************************************************
  
  /**
   * The default port to connect on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Instance variables **********************************************
  
  /**
   * The instance of the client that created this ConsoleChat.
   */
  //*** changes made here for E50 (ET FS)
  ChatIF clientUI;
  EchoServer server;

  
  //Constructors ****************************************************

  /**
   * Constructs an instance of the ClientConsole UI.
   *
   * @param host The host to connect to.
   * @param port The port to connect on.
   */
  
  //*** changes made here for E50 (ET FS)
  public ServerConsole(int port) 
  {
    server= new EchoServer(port);
    try{
    	server.listen();
    }
    catch (IOException e ){
    	System.out.println("Error: Can't setup Connect! Terminating client.");
    }
  }

  
  //Instance methods ************************************************
  
  /**
   * This method waits for input from the console.  Once it is 
   * received, it sends it to the client's message handler.
   */
  //*** changes made here for E50 (ET FS)
  public void accept() 
  {
    try
    {
      BufferedReader fromConsole = 
        new BufferedReader(new InputStreamReader(System.in));
      String message;

      while (true) 
      {
        message = fromConsole.readLine();
        server.handleMessageFromServerConsole(message);
        display(message);
      }
    } 
    catch (Exception ex) 
    {
      System.out.println
        ("Unexpected error while reading from console!");
    }
  }

  /**
   * This method overrides the method in the ChatIF interface.  It
   * displays a message onto the screen.
   *
   * @param message The string to be displayed.
   */
  //******Changed for E50 (ET FS)
  public void display(String message) 
  {
	  if(message.startsWith("#")){
		  return;
	  }
	  else{
		  System.out.println("SERVER MSG> " + message);
	  }
  }

	  
  
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of the Client UI.
   *
   * @param args[0] The host to connect to.
   */
  //*** changes made here for E50 (ET FS)
  public static void main(String[] args) 
  {
    
    int port = 0;  //The port number

    try
    {
      port = Integer.parseInt(args[0]);
    }
    catch(Exception e)
    {
      port = DEFAULT_PORT;
    }
    ServerConsole servers= new ServerConsole(port);
    servers.accept();  //Wait for console data
  }
}
//End of ServerConsole class
