package be.kdg.sync;

/*
<pre>
SynchronizedRGB must be used carefully to avoid being seen in an inconsistent state.
Suppose, for example, a thread executes the following code:

SynchronizedRGB color = new SynchronizedRGB(0, 0, 0, "Pitch Black");
...
int myColorInt = color.getRGB();      //Statement 1
String myColorName = color.getName(); //Statement 2
If another thread invokes color.set after Statement 1 but before Statement 2,
the value of myColorInt won't match the value of myColorName.
To avoid this outcome, the two statements must be bound together:

synchronized (color) {
    int myColorInt = color.getRGB();
    String myColorName = color.getName();
}
</pre>
*/
public class Demo {
    public static void main(String[] args) {
        ImutableRGB color = new ImutableRGB(255, 255, 0, "Yellow");

        int myColorInt;
        String myColorName;

        synchronized (color) {
            myColorInt = color.getRGB();
            myColorName = color.getName();
        }

        System.out.println("Color: " + myColorInt + " " + myColorName);
    }
}
