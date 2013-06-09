package be.kdg.syncobject;

public class MyMain {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Thread threadOne = new Thread(new MyRunnable(myClass));
        Thread threadTwo = new Thread(new MyRunnable(myClass));

        System.out.println("Starting threads...");
        threadOne.start();
        threadTwo.start();
        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {   // leeg
        }
        System.out.println("Number: " + myClass.getNumber());
    }
}
