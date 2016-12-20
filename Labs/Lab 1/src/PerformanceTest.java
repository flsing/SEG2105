import java.io.*;
/*
 * @author Felix Singerman 
 * @author Eyob Tilaye
 * 
 */

public class PerformanceTest {

	/** 
	 * Time it takes to instantiate PointCP
	 * @param type the type of point either Cartesian or Polar
	 * @param testTime amount of time to run the test
	 * @return time it takes to instantiate PointCP
	 */
	
	public static long instantiatePointCP(char type, long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			PointCP tmp = new PointCP(type, 10*Math.random(), 10*Math.random()); 
			
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}
	
	/**
	 * Time it takes to instantiate PointCP in Design 3
	 * @param testTime amount of time to run the test
	 * @return time it takes to instantiate PointCP in Design 3
	 */
	public static long instantiatePointCPDesign3(long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			PointCPDesign3 tmp = new PointCPDesign3(10*Math.random(), 10*Math.random()); 
			
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}
	
	/**
	 * Time it takes to instantiate a polar point in PointCP in Design 5
	 * @param testTime amount of time to run the test
	 * @return time it takes to instantiate Polar point in PointCP Design 5
	 */
	public static long instantiatePolarPointCPDesign5(long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			Coord tmp = new Polar(10*Math.random(), 10*Math.random()); 
			
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}
	
	/**
	 * Time it takes to instantiate a Cartesian pointPointCP design 5
	 * @param testTime amount of time to run the test
	 * @return time it takes to instantiate Cartesian point in PointCP Design 5
	 */
	public static long instantiateCartesianPointCPDesign5(long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			Coord tmp = new Cartesian(10*Math.random(), 10*Math.random()); 
			
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}
	
	/**
	 * Time it takes to get a cartesian point PointCP in design 1
	 * @param type the type of point either Cartesian or Polar
	 * @param testTime amount of time to run the test
	 * @return time it takes to get a cartesian point PointCP design 1
	 */
	public static long getCartesianPointCP(char type, long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			PointCP tmp = new PointCP(type, 10*Math.random(), 10*Math.random()); 
			tmp.getX();
			tmp.getY();
		
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}
	
	/**
	 * Time it takes to get a polar point PointCP in design 1
	 * @param type the type of point either Cartesian or Polar
	 * @param testTime amount of time to run the test
	 * @return time it takes to get a polar point PointCP design 1
	 */
	public static long getPolarPointCP(char type, long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			PointCP tmp = new PointCP(type, 10*Math.random(), 10*Math.random()); 
			tmp.getRho();
			tmp.getTheta();
		
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}
	
	/**
	 * Time it takes to get a cartesian point PointCP in design 3
	 * @param testTime amount of time to run the test
	 * @return time it takes to get a cartesian point PointCP design 3
	 */
	public static long getCartesianPointCPDesign3(long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			PointCPDesign3 tmp2 = new PointCPDesign3(10*Math.random(), 10*Math.random()); 
			tmp2.getX();
			tmp2.getY();
		
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}
	
	/**
	 * Time it takes to get a Polar point in  PointCP in design 3
	 * @param testTime amount of time to run the test
	 * @return time it takes to get a polar point PointCP design 3
	 */
	public static long getPolarPointCPDesign3(long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			PointCPDesign3 tmp2 = new PointCPDesign3(10*Math.random(), 10*Math.random()); 
			tmp2.getRho();
			tmp2.getTheta();
		
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}
	
	/**
	 * Time it takes to get a cartesian point in PointCP in design 5
	 * @param testTime amount of time to run the test
	 * @return time it takes to get a cartesian point PointCP design 5
	 */
	public static long getCartesianPointCPDesign5(long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			Coord tmp = new Cartesian(10*Math.random(), 10*Math.random()); 
			tmp.getX();
			tmp.getY();
		
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}
	
	/**
	 * Time it takes to get a Polar point PointCP in design 5
	 * @param testTime amount of time to run the test
	 * @return time it takes to get a Polar point PointCP design 5
	 */
	public static long getPolarPointCPDesign5(long testTime){
		long startTime = System.currentTimeMillis();
	
		for(int i=0; i< testTime; i++){
			
			Coord tmp = new Polar(10*Math.random(), 10*Math.random()); 
			tmp.getRho();
			tmp.getTheta();
		
		}
		long endTime = System.currentTimeMillis();
		return endTime- startTime;
	}

	
	
	public static void main(String[] args){
		
		
		int testTime= 99999;
		System.out.println("Time for getting Cartesian Point  in design 1: "+ getCartesianPointCP('C', testTime)+"millis");
		System.out.println("Time for getting Cartesian Point  in design 3: "+ getCartesianPointCPDesign3(testTime)+"millis");
		System.out.println("Time for getting Cartesian Point  in design 5: "+ getCartesianPointCPDesign5(testTime)+"millis");
		System.out.println("Time for getting Polar Point  in design 1: "+ getPolarPointCP('P', testTime)+"millis");
		System.out.println("Time for getting Polar Point  in design 3: "+ getPolarPointCPDesign3(testTime)+"millis");	
		System.out.println("Time for getting Polar Point  in design 5: "+ getPolarPointCPDesign5(testTime)+"millis");
		System.out.println("Time for instantiating a cartesian point PointCP  in design 1: "+ instantiatePointCP('C', testTime)+"millis");
		System.out.println("Time for instantiating a polar point PointCP  in design 1: "+ instantiatePointCP('P', testTime)+"millis");
		System.out.println("Time for instantiating a point in PointCP  in design 3: "+ instantiatePointCPDesign3(testTime)+"millis");
		System.out.println("Time for instantiating a cartesian point in PointCP  in design 5: "+ instantiateCartesianPointCPDesign5(testTime)+"millis");
		System.out.println("Time for instantiating a polar point in PointCP  in design 5: "+ instantiatePolarPointCPDesign5(testTime)+"millis");
	}
}
