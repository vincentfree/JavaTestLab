package opdracht2H3;//package threads.opdrachten;

import java.awt.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Brug implements Runnable {
    private boolean open = false;
    int positie, lengte;
    private Thread thread;
    Lock lock;
    Condition condition;


    public Brug(int positie, int lengte) {  // maak brug aan
        this.positie = positie;                 // met bepaalde positie en lengte
        this.lengte = lengte;
        thread = new Thread(this);
        thread.start();
    }

    public Brug(int positie, int lengte, Lock lock, Condition condition) {
        this(positie, lengte);
        this.lock = lock;
        this.condition = condition;
    }
   /* public Brug(int positie, int lengte, Lock lock) {
        this.positie = positie;
        this.lengte = lengte;
        this.lock = lock;
        thread = new Thread(this);
        thread.start();

    }*/

    public void run() {
        while (true) {
            openSluit();
            try {
                Thread.sleep(open ? 2000 : 3000);
            } // laat de brug langer gesloten dan open
            catch (InterruptedException ie) {
            }
        }
    }

    //TODO Condition toevoegen
    public void openSluit() {              // open of sluit de brug
            lock.lock();
            try {

                open = !open;
                if(!open()) {
                    //condition.await();
                    condition.signal();
                }
                //condition.await();
            } /*catch (InterruptedException e) {
                e.printStackTrace();
            }*/ finally {
                //condition.signalAll();
                lock.unlock();

            }
        }

    public boolean open() {
        return open;
    }

    public void paint(Graphics g) {        // teken een geopende of gesloten brug
        g.setColor(Color.red);
        if (open())
            g.drawLine(positie, 100, positie, 100 - lengte);
        else
            g.drawLine(positie, 100, positie + lengte, 100);
    }

}