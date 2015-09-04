package threads;

import java.util.Calendar;
import java.awt.*;
import java.awt.event.*;

class Klok2 extends Label implements Runnable {

    Thread t = null;

    Klok2() {
        t = new Thread(this);                    // maak een nieuwe thread aan
        t.start();                             // start de thread
    }

    public void run() {
        while (true) {
            Calendar c = Calendar.getInstance();  // huidige moment ophalen
            setText(c.getTime().toString());     // tekst van het label wordt huidige tijd
            repaint();
            try {
                Thread.sleep(1000);                // wacht 1000 miliseconden
            } catch (InterruptedException ie) {
            }
        }
    }
}

class KlokVoorbeeld extends Frame {

    KlokVoorbeeld() {
        super("klokvoorbeeld");                // maak frame aan met titel
        Klok2 klok = new Klok2();                // maak klok aan, waardoor de thread start
        add(klok);                             // plaats klok op 't frame
        pack();                                // zorg dat alleen klok zichtbaar
        setVisible(true);                      // toon het frame
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                // als het frame wordt gesloten,
                System.exit(0);  // sluit dan de hele applicatie af
            }
        });
    }

    public static void main(String args[]) {
        new KlokVoorbeeld();
    }
}
