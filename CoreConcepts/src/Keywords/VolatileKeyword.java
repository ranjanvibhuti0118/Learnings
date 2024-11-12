package Keywords;

public class VolatileKeyword  implements Runnable{

	private static  int sharedVar=0;
	
	public static void main(String args[]) {
		
		VolatileKeyword v1= new VolatileKeyword();
		VolatileKeyword v2= new VolatileKeyword();

		Thread t1= new Thread(v1);
		Thread t2= new Thread(v2);

		t1.start();
		t2.start();

	}

	@Override
	public void run() {
		
		while(true) {
			sharedVar++;
			System.out.println(Thread.currentThread().getName() +" : " + sharedVar);
		}
		
	}
}

/*
 * The volatile keyword in Java is used to ensure that all threads see the same
 * value for a variable. It does this by marking a variable as being stored in
 * the computer's main memory, rather than in the CPU registers. This means that
 * every read and write to the variable will be performed directly from the main
 * memory, bypassing any caches
 */