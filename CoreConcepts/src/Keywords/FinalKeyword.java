package Keywords;

/*A final class can not be sub classed*/
public class FinalKeyword /* extends StaticKeyword */{

	final String finalStringVal="NewString";
			
	public final void testMethod() {
		System.out.println("Overiden method");
	}
	
	
	public static void main(String args[]) {
		
	}
	
}

class SubClass extends FinalKeyword{
	
	/*
	 * public void testMethod(){
	 * System.out.println("Can not overirde a final method"); }
	 * 
	 */	
}