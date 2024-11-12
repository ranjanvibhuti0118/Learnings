package RuntimePolymorphism;

public class Parent {

	
	
	protected String exampleMethod1(String name) {
		
		return name;
		
	}
	
	public static String methodShadowing() {
			
			return "Child Method";
		}
}
