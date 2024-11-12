package Keywords;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedKeyword extends Thread {

	List<Integer> list= new ArrayList<>();
	
	public synchronized void run() {
		
		synchronized(list) {
			
			list.add(1);
			list.add(1);
			list.add(1);
			list.add(1);
			list.add(1);
			list.add(1);
			list.add(1);
			list.add(1);
			list.add(1);

			System.out.println(list);
		}
	}
	
	public static void main(String[] args) {

		
		SynchronizedKeyword t1= new SynchronizedKeyword();
		SynchronizedKeyword t2= new SynchronizedKeyword();
		
		t1.start();
		t2.start();
		
		
	}

}
