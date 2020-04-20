/*
 * Modified example from the original of the book
 * JAVA A FONDO - Estudio del lenguaje y desarrollo de aplicaciones - 2ª Edición
 * Autor: SZNAJDLEDER, Pablo
 *
 */

// Using Runnable Interface

public class ThreadDemo1 extends Thread {
    private String name;

    public ThreadDemo1(String name) {
        this.name = name;
    }

    public void run() {
        try {
            int x = (int) (Math.random() * 5000);
            Thread.sleep(x);
            System.out.println("I'm \"" + name + "\" (" + x + ")");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Starting...");

        ThreadDemo1 t1 = new ThreadDemo1("Ana");
        ThreadDemo1 t2 = new ThreadDemo1("Diana");
        ThreadDemo1 t3 = new ThreadDemo1("Triana");

        t1.start();
        t2.start();
        t3.start();

        // Wait for all three threads to finish
        /*
        t1.join();
        t2.join();
        t3.join();
        */

        System.out.println("End of program!");

    }
}
