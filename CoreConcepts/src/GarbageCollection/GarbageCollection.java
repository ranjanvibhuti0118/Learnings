package GarbageCollection;

public class GarbageCollection {

	
		
		protected void finalize() throws Throwable{
			
			System.out.println("Automatically called");
			super.finalize();
			
		}
	
	
	
	public static void main(String[] args) throws Throwable {

		GarbageCollection gc= new GarbageCollection();
        gc.finalize();

		
		
	}

}
