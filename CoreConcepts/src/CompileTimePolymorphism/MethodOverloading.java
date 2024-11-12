package CompileTimePolymorphism;

public class MethodOverloading {

	
	
	
	public static void main(String args[]) {
		
		
		Example2 ex2= new Example2();
		// Call to a over loaded methods is resolved at compile time ,based on order of parameters. 
		//Implicit type casting happens if possible and a overloading method is not present
		System.out.println(ex2.add(1, 1.0));
		
	}
	
	
}
