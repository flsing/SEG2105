// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.util.Scanner;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPDesign5Test
{
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java 
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
  public static void main(String[] args)
  {
    Coord point;

    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP object from these arguments.
    // If he did not, prompt the user for them.
    

      try
      {
        point = getInput();
      }
      catch(IOException ex)
      {
        System.out.println("Error getting input. Ending program.");
        return;
      }
     Scanner reader = new Scanner (System.in);
     String a="";
     
      if(point instanceof Cartesian){
          System.out.println(point);
    System.out.println("\nDo you want to convert to polar (YES/NO):\n");
    a = reader.next();
  String b= a.toUpperCase();

    if (b.equals("YES")){
      Cartesian p =(Cartesian)point;
      p.convertStorageToPolar();
      System.out.println("\nAfter asking to convert to Polar:\n" + p.outputPolar());
   }
   else { System.out.println("The program has ended");
   return;}
      }
      else{
       System.out.println(point);
    System.out.println("\nDo you want to convert to cartesian (YES/NO):\n");
    a = reader.next();
  String b= a.toUpperCase();

    if (b.equals("YES")){
     
      Polar p =(Polar)point;
        p.convertStorageToCartesian();
      System.out.println("\nAfter asking to convert to Cartesian:\n" + p.outputCartesian());
   }
   else { System.out.println("The program has ended");
   return;}
      }
  
   
  
}
  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained 
   *         from the user.
   * @throws IOException If there is an error getting input from
   *         the user.
   */
  private static Coord getInput() throws IOException
  {
   
    //Information to be passed to the constructor
    Scanner typeOfCoord = new Scanner(System.in);
    System.out.print("Enter the type of Coordinates you "
            + "are inputting ((C)artesian / (P)olar): ");
    char type = typeOfCoord.next().charAt(0);
    type = Character.toUpperCase(type); 
    
    if (type == 'C'){
     Scanner first = new Scanner(System.in);
     System.out.print("Enter the X Coordinate using a decimal point(.):");
     double x = first.nextDouble();
     
     Scanner second = new Scanner(System.in);
     System.out.print("Enter the Y Coordinate using a decimal point(.):");
     double y = second.nextDouble();
    
     
     return new Cartesian(x,y);
    }
    else if (type == 'P');{
      
       Scanner first = new Scanner(System.in);
     System.out.print("Enter the Rho Coordinate using a decimal point(.):");
     double rho = first.nextDouble();
     
     Scanner second = new Scanner(System.in);
     System.out.print("Enter the Theta Coordinate using a decimal point(.):");
     double theta = second.nextDouble();
    
      return new Polar(rho,theta);
    }
   
    
     
    
    
}
}