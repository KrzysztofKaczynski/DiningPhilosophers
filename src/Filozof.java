/**
 * Created by Krzysztof Kaczynski on 21:00 - 28.05.2021.
 */
public class Filozof implements Runnable {

    private final Object lewyWidelec;
    private final Object prawyWidelec;

    public Filozof(Object lewyWidelec, Object prawyWidelec) {
        this.lewyWidelec = lewyWidelec;
        this.prawyWidelec = prawyWidelec;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(System.nanoTime() + ": Myœli");
                synchronized (lewyWidelec) {
                    doAction(
                            System.nanoTime()
                                    + ": Podnosi lewy widelec");
                    synchronized (prawyWidelec) {
                        doAction(
                                System.nanoTime()
                                        + ": Podnosi prawy widelec - zaczyna jeœæ");

                        doAction(
                                System.nanoTime()
                                        + ": Odk³ada prawy widelec");
                    }

                    doAction(
                            System.nanoTime()
                                    + ": Odk³ada lewy widelec. Wraca do myœlenia.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
