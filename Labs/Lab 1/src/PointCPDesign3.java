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
public class PointCPDesign3 
{
  //Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
 
  
  //Constructors ******************************************************
	private double x;
	private double y;
  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointCPDesign3(double x, double y)
  {
   this.x = x;
   this.y =y;
  }

  
  //Instance methods **************************************************
 
 
  public double getX()
  {
      return x;
  }
  
  public double getY()
  {
      return y;
  }
  
  public double getRho()
  {
    
      return (Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)));
  }
  
  public double getTheta()
  {
    
      return Math.toDegrees(Math.atan2(y, x));
  }
  
 
  /**
   * Converts Cartesian coordinates to Polar coordinates.
   */
  public void convertStorageToPolar()
  {
    
      //Calculate RHO and THETA
      double temp = getRho();
      y = getTheta();
      x = temp;
      
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