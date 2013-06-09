package oef;

public class DemoRunnable implements Runnable {
	    public void run() {
	        System.out.println(getClass());
	    }
	    
	    public void titel() {
	        System.out.println("\nDemoThread");
	    }
}
