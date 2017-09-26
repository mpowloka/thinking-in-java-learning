package Multithreading;

import java.util.concurrent.TimeUnit;

public class NineEleven {

    private static class OutsideJob implements Runnable {

        @Override
        public void run() {
            Thread thread = new Thread(new InsideJob());
            thread.start();
            while (true) {
                System.out.println(Thread.currentThread() + " " + this.getClass().getSimpleName() + " working, Is Daemon: " + Thread.currentThread().isDaemon());
            }
        }
    }

    private static class InsideJob implements Runnable{

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread() + " - It was an " + this.getClass().getSimpleName() + ". Is Daemon: " + Thread.currentThread().isDaemon());
            }
        }
    }

    public static void main(String[] args) {
        for (int i=0; i<5; i++) {
            Thread thread = new Thread(new OutsideJob());
            thread.setDaemon(true);
            thread.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
