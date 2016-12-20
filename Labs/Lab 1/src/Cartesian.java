// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in either polar or
 * cartesian format.  It also provides the utilities to convert
 * them into the other type. It is not an optimal design, it is used
 * only to illustrate some design issues.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @version July 2000
 */
public class Cartesian extends Coord
{
  //Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
 
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public Cartesian(double x, double y)
  {
   super(x,y);
  }

  
  //Instance methods **************************************************
 
 
  public double getX()
  {
      return firstCoord;
  }
  
  public double getY()
  {
      return secondCoord;
  }
  
  public double getRho()
  {
    
      return (Math.sqrt(Math.pow(firstCoord, 2) + Math.pow(secondCoord, 2)));
  }
  
  public double getTheta()
  {
    
      return Math.toDegrees(Math.atan2(secondCoord, firstCoord));
  }
  
 
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
    
      //Calculate RHO and THETA
      double temp = getRho();
      secondCoord = getTheta();
      firstCoord = temp;
      
       //Change coord type identifier
    }
  
 
  

  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as Cartesian  (" + getX() + "," + getY() + ")";
      
  }
  public String outputPolar()
  {
    return "Converted to  (" + getX() + "," + getY() + ")";
      
  }
}