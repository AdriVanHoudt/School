package oef;

public class ExcecuteRunnable {
	
	 public static void main(String[] args) {
		 	DemoRunnable demo = new DemoRunnable();
	        Thread Draaddemo = new Thread(demo);
	        
	        demo.titel();
	        Draaddemo.start();
	        System.out.println(Draaddemo.getName());
	        try {
	            Draaddemo.join();
	        }
	        catch (InterruptedException e) {
	            // Doe niets
	        }
	        System.out.println(Draaddemo.isAlive());
	        Draaddemo.start();
	    }
}
