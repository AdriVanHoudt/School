package be.kdg.shared;

public class Show {
   private static String strings[] = {"Dit","is","een","demo"};

   public synchronized  void display(String name) {
        for (int i = 0; i < 4; i++) {
            System.out.println(name + " " + strings[i]);
        }
    }
}
