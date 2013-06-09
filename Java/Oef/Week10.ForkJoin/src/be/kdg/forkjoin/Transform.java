package be.kdg.forkjoin;

import java.util.concurrent.RecursiveAction;

/**
 * @author Kristiaan Behiels
 * @version 1.0 14-12-11
 */
public class Transform extends RecursiveAction {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double[] data;
    int start;
    int end;
    int threshold;

    public Transform(double[] data, int start, int end, int threshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    protected void compute() {
        if ((end - start) < threshold) {
            for (int i = start; i < end; i++) {
                if ((data[i] % 2) == 0)
                    data[i] = Math.sqrt(data[i]);
                else
                    data[i] = Math.cbrt(data[i]);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new Transform(data, start, middle, threshold),new Transform(data, middle, end, threshold));
        }
    }
}
