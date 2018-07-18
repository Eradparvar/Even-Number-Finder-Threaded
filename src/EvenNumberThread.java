import java.util.ArrayList;

import org.omg.CORBA.Current;

public class EvenNumberThread implements Runnable {
    private NextNumber nn;
    private ArrayList<Integer> results;

    public EvenNumberThread(NextNumber nn, ArrayList<Integer> results) {
	this.nn = nn;
	this.results = results;
    }

    @Override
    public void run() {
	boolean goAgain = true;
	int num=0;
	do {
	    synchronized (nn) {
		num = nn.getNextNumber();
	    }

	    if (num > nn.getLimit()) {
		break;
	    }
	    if (isEven(num)) {
		synchronized (results) {
		    results.add(num);
		}
	    }

	} while (goAgain);

    }

    private boolean isEven(int num) {
	if ((num % 2) == 0) {
	    return true;
	}
	return false;
    }

}
