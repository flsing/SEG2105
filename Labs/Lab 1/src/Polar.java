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
public class Polar extends Coord
{
  
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public Polar(double Rho, double Theta)
  {
    
    super(Rho,Theta);
  }
 
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
       return (Math.cos(Math.toRadians(secondCoord)) * firstCoord);
  }
  
  public double getY()
  {
     return (Math.sin(Math.toRadians(secondCoord)) * firstCoord);
  }
  
  public double getRho()
  {
    
     return firstCoord;
  }
  
  public double getTheta()
  {
    
      return secondCoord;
  }
  
   public void convertStorageToCartesian()
  {
    
      //Calculate X and Y
      double temp = getX();
      secondCoord = getY();
      firstCoord = temp;
   
     
    }
  

  
   public String toString()
  {
    return "Stored as Polar  (" + getRho() + "," + getTheta() + ")";
      
  }
   public String outputCartesian()
  {
    return "Converted to  (" + getRho() + "," + getTheta() + ")";
      
  }
 
 
}