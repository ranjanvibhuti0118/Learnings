package RuntimePolymorphism;


public class MethodOverriding {


	public static void main(String args[]) {
		Parent p = new Parent();	
		System.out.println(p.exampleMethod1("Vibhuti"));
		
		Child c= new Child();
		System.out.println(c.exampleMethod1("Unknown"));
		
		//Call to a overridden method is resolved at run time rather than compile time
		//Which method will be called is decided based on type of object reference variable is holding
		
		Parent pc= new Child();
		System.out.println(pc.exampleMethod1("Unknown"));
		
		//Method Shadowing concept
		//Child implementation of over-riden static method will be called, ignoring parent implementation
		System.out.println(Child.methodShadowing());

	}
}
