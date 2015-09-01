public class ThreadVoorbeeld {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Taak taak = new Taak(i + 1);
            taak.run();
        }
        System.out.println("Main methode afgerond...");
    }
}

class Taak implements Runnable {

    int num;

    public Taak(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Uitvoeren van taak " + num + "...");
        try {
            Thread.sleep((long)(Math.random() * 10000));
        } catch (InterruptedException e) {}
        System.out.println("taak " + num + " afgerond...");
    }
}
