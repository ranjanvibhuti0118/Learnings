package Keywords;

public final class StaticKeyword {
	
	//Instance & static variable assigned memory in heap area and assigned a default value if not initialized
	String instanceVar;
	static String name ="Test Static";

	static {
		//Static Init block called every-time during class loading and assigned memory in heap

		System.out.println("Print This " +name);
	}
	{
		//Init block called every-time before a constructor
		System.out.println("init block");
	}

	public StaticKeyword() {
		System.out.println("Constructor");
	}
	

// A static method does not belong to object but class
	public static void main(String args[]) {


		System.out.println(name);
		System.out.println(StaticKeyword.name);

		//Local Variable always assigned memory in stack memory area
		//Local Variable must be initialized during declaration
		String localVariable="localVariable";
		
		StaticKeyword ex1= new StaticKeyword();

		System.out.println(ex1.instanceVar);
		System.out.println(localVariable);




	}
}
