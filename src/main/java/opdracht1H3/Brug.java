package opdracht1H3;//package threads.opdrachten;

import java.awt.*;

public class Brug implements Runnable {
    private boolean open = false;
    int positie, lengte;
    private Thread thread;


    public Brug(int positie, int lengte) {  // maak brug aan
        this.positie = positie;                 // met bepaalde positie en lengte
        this.lengte = lengte;
        thread = new Thread(this);
        thread.start();
    }

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

    //TODO
    public void openSluit() {              // open of sluit de brug

        synchronized (Brug.this) {
            open = !open;
            this.notify();
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