/*
 * Modified example from the original of the book
 * JAVA A FONDO - Estudio del lenguaje y desarrollo de aplicaciones - 2ª Edición
 * Autor: SZNAJDLEDER, Pablo
 *
 */

// Using Runnable Interface
// This version is equivalent to ThreadDemo1, but does not limit the inheritance of the class.

public class ThreadDemo2 implements Runnable {
    private String name;

    public ThreadDemo2(String name) {
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

        Thread t1 = new Thread(new ThreadDemo2("Ana"));
        Thread t2 = new Thread(new ThreadDemo2("Diana"));
        Thread t3 = new Thread(new ThreadDemo2("Triana"));

        t1.start();
        t2.start();
        t3.start();

        // Wait for all three threads to finish
        t1.join();
        t2.join();
        t3.join();

        System.out.println("End of program!");

    }
}
