public abstract class  Coord {

 protected double firstCoord, secondCoord;

public Coord (double firstCoord, double secondCoord){
 this.firstCoord=firstCoord;
 this.secondCoord=secondCoord;
}

//public String outputPolar(){return "";}
//public String outputCartesian(){return "";}

public abstract double getX();
public abstract double getY();
public abstract double getRho();
public abstract double getTheta();
public abstract String toString();




}