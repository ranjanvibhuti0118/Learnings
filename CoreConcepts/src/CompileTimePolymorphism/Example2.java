package CompileTimePolymorphism;

public class Example2 {

	/*
	 * A method is said to be overloaded when class has two methods with same name
	 * but different parameters, Return type may or may not vary
	 * 
	 */
	public double add(int x, double y) {
		
		return x+y;
	}
	
	public int add(double x, int y) {
		
		return (int) (x+y);
		
	}
	
	//Method overloading with static methods is possible
	public static double subtract(int x, double y) {
		
		return x-y;
	}
	
	public static double subtract(double x, int y) {
		
		return (x-y);
		
	}
}
