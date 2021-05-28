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
                doAction(System.nanoTime() + ": My�li");
                synchronized (lewyWidelec) {
                    doAction(
                            System.nanoTime()
                                    + ": Podnosi lewy widelec");
                    synchronized (prawyWidelec) {
                        doAction(
                                System.nanoTime()
                                        + ": Podnosi prawy widelec - zaczyna je��");

                        doAction(
                                System.nanoTime()
                                        + ": Odk�ada prawy widelec");
                    }

                    doAction(
                            System.nanoTime()
                                    + ": Odk�ada lewy widelec. Wraca do my�lenia.");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
