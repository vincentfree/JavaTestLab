package opdracht2H3;//package threads.opdrachten;

import java.applet.Applet;
import java.awt.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Auto implements Runnable {
    private Image plaatje;                     //het plaatje van Auto.
    int x;                                     //x-positie van Auto.
    int y;                                     //y-positie van Auto.
    private Thread thread;                     //Thread voor Auto.
    boolean doorgaan = true;                   //boolean om aan te geven of Auto thread doorgaat.
    private Brug brug;
    private int snelheid;
    Lock lock;
    Condition condition;

    public Auto(int x, int y, int snelheid) { //constructor van Auto.
        this.x = x;                              //zetten van de x-positie.
        this.y = y;                              //zetten van de y-positie.
        this.snelheid = snelheid;
    }

    public Auto(int x, int y, int snelheid, Lock lock, Condition condition) {
        this(x, y, snelheid);
        this.lock = lock;
        this.condition = condition;

    }

    public void setPlaatje(Image plaatje) {    //plaatje zetten.
        this.plaatje = plaatje;
    }

    public void setBrug(Brug brug) {           //melden van brug
        this.brug = brug;
    }

    public void start() {                       //methode om de Thread voor Auto (thread) te starten.
        if (thread == null) {
            thread = new Thread(this);
            thread.setDaemon(true);               //de thread thread is een daemon thread.
            thread.start();
        }
    }

    public void stop() {                       //methode om de Thread voor Auto (thread) te stoppen.
        if (thread != null) {
            thread = null;
            doorgaan = false;
        }
    }

    public void run() {                          //run methode van de thread thread.
        while (doorgaan) {
            if (x > -37) {                           //Auto is nog niet van het scherm gereden.
                if (x <= brug.positie + brug.lengte + 10 &&
                        x >= brug.positie - brug.lengte) {    //Auto komt aan bij de brug.
                    oversteken(brug);                   //steek de brug over
                } else {
                    x -= 1;                               //het gewone rijden van Auto.
                    try {
                        Thread.sleep(snelheid);
                    }     //50 milliseconden wachten tot de volgende stap.
                    catch (InterruptedException e) {
                    }
                }
            } else {                                  //Auto is van het scherm afgereden.
                x = 363;                                //x- en y-positie weer op de begin situatie zetten.
                y = 79;
            }
        }
    }

    //TODO Condition toevoegen
    public void oversteken(Brug brug)           //methode om de brug over te steken.
    {
        lock.lock();
        try {
            condition.await();
            while (x <= brug.positie + brug.lengte + 10 &&
                    x >= brug.positie - brug.lengte /*&& !brug.open()*/)      //verplaats de auto over de brug.
            {

                x -= 1;
                try {
                    Thread.sleep(snelheid);
                }       //laat de meegegeven thread
                catch (InterruptedException e) {
                }     //wachten tot de volgende verplaatsing.
            }
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            lock.unlock();
        }
    }

    public void paint(Graphics g, Applet a) {
        g.drawImage(plaatje, x, y, a);               //toon de auto op deze positie
    }

}
