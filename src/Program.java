import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Program {

    public static void main(String[] args) throws InterruptedException {
	System.out.println("Start");
	final int THREAD_NUM = 5;
	int limit = 100000;

	ArrayList<Integer> results = new ArrayList<>();
	ArrayList<Thread> threads = new ArrayList<>();
	NextNumber nn = new NextNumber(limit);

	for (int i = 0; i < THREAD_NUM; i++) {
	    Thread t = new Thread(new EvenNumberThread(nn, results));
	    threads.add(t);
	    t.start();

	}

	for (Thread t : threads) {
	    t.join();
	}
	Collections.sort(results);
	Thread.sleep(500);
	for (Integer t : results) {
	    System.out.println(t + " ");
	}
	System.out.println("End");
    }

}
