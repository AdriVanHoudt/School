package observer;

import observer.model.Croque;
import observer.view.CroqueFrame;
import observer.view.CroqueFrameTwo;

public class RunCroque {
    public static void main(String[] args) {
        Croque croque = new Croque();
        new CroqueFrame(croque);
        new CroqueFrameTwo(croque);
    }
}
