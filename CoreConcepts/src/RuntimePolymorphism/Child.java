package RuntimePolymorphism;

public class Child extends Parent{

	
	/*
	 * A method is said to be over-riden if the parent class method and child class
	 * method has same name and same parameters,same return type and child class method
	 * has equal or greater visibility
	 * 
	 */
	protected String exampleMethod1(String name) {
		
		return name;
		
	}
	
	public static String methodShadowing() {
		
		return "Child Method";
	}
}
