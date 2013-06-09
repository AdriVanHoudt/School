package be.kdg.syncobject;

public class MyRunnable implements Runnable{
    private MyClass myClass;

    public MyRunnable(MyClass myClass) {
        this.myClass = myClass;
    }

    public  void run() {  	
        for (int i = 0; i < 10000; i++) {
        	synchronized(myClass){
        		myClass.setNumber(myClass.getNumber() + 1);
        	}
    	}
    }
}
