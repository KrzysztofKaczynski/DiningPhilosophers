/**
 * Created by Krzysztof Kaczynski on 21:04 - 28.05.2021.
 */
public class FourPhilosopers {

    public static void main(String[] args) throws Exception {

        Filozof[] filozof = new Filozof[4];
        Object[] widelec = new Object[filozof.length];

        for (int i = 0; i < widelec.length; i++) {
            widelec[i] = new Object();
        }

        for (int i = 0; i < filozof.length; i++) {
            Object lewyWidelec = widelec[i];
            Object prawyWidelec = widelec[(i + 1) % widelec.length];

            filozof[i] = new Filozof(lewyWidelec, prawyWidelec);

            Thread t
                    = new Thread(filozof[i], "Filozof " + (i + 1));
            t.start();
        }
    }
}
