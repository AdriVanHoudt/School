package be.kdg.syncobject;

public class MyClass {
    private int number;

    public synchronized  int getNumber() {
        return number;
    }

    public synchronized void setNumber(int number) {
        this.number = number;
    }
}
