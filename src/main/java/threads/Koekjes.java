package threads;

import java.util.*;

class Koekje {
}

public class Koekjes extends Vector<Koekje> {
    public Koekjes(int aantal) {
        super(aantal);
        for (int i = 0; i < aantal; i++) {
            add(new Koekje());
        }
    }
}

class Feest {
    public static Koekjes koektrommel;

    public static void main(String args[]) {
        koektrommel = new Koekjes(20);
        Monster monster1 = new Monster("monster1");
        Monster monster2 = new Monster("monster2");
        Monster monster3 = new Monster("monster3");
        Bakker bakker = new Bakker(Integer.parseInt(args[0]));
    }

    public static boolean doorgaan() {
        return (koektrommel != null && koektrommel.size() > 0);
    }
}

class Bakker implements Runnable {
    private Thread thread;
    private int aantal = 0;

    Bakker(int aantal) {
        this.aantal = aantal;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (Feest.doorgaan()) {
            bak(Feest.koektrommel, aantal);
            try {
                Thread.sleep(300);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    public void bak(Koekjes koekjes, int aantal) {
        synchronized (koekjes) {
            for (int i = 0; i < aantal; i++) {
                koekjes.add(new Koekje());
            }
            System.out.println("voorraad: " + koekjes.size());
            koekjes.notify();
        }
    }
}

class Monster implements Runnable {

    private int gepakt = 0;
    private Thread thread;
    private String naam = null;

    Monster(String naam) {
        this.naam = naam;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (Feest.doorgaan()) {
            eet(Feest.koektrommel, 3);
            System.out.println(naam + ": " + gepakt);
        }
    }

    public void eet(Koekjes koekjes, int aantal) {
        int pakweg = 0;

        synchronized (koekjes) {
            try{
                koekjes.wait(1000);
            }
            catch (InterruptedException ie){
                ie.printStackTrace();
            }
            int resterend = koekjes.size();
            if (aantal < resterend) {
                pakweg = aantal;
            } else {
                pakweg = resterend;
            }
            for (int i = 0; i < pakweg; i++) {
                koekjes.remove(0);
                gepakt++;
            }
        }
    }
}


