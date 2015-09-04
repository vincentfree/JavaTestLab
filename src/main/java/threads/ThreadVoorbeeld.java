package threads;

public class ThreadVoorbeeld {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Taak taak = new Taak(i + 1);
            //taak.run();
        }
        System.out.println("Main methode afgerond...");
    }
}

class Taak implements Runnable {

    private int num;
    private Thread thread = null;

    public Taak(int num) {
        this.num = num;
        thread = new Thread(this,"taak "+num);
        thread.setDaemon(true);
        thread.start();
    }

    public void run() {
        System.out.println("Uitvoeren van thread " +thread.getName()+ "...");
        try {
            Thread.sleep((long)(Math.random() * 10000));
        } catch (InterruptedException e) {}
        System.out.println("thread " + thread.getName() + " afgerond...");
    }
}