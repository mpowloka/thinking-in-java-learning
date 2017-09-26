package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingPriorityDaemons {
    static class Lucifer implements Runnable{

        @Override
        public void run() {
            while(true) {
                System.out.println("---Background music---");
                try {
                    TimeUnit.MILLISECONDS.sleep(100l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class VIP
           extends Guest implements Runnable{

        protected String name = "VIP";

        public VIP(int priority) {
            super(priority);
        }

    }

    private static class Guest implements Runnable {

        protected String name = "Guest";
        protected int partiesLeft = 5;
        protected int priority;

        public Guest(int priority) {
            this.priority = priority;
        }

        @Override
        public void run() {
            Thread.currentThread().setPriority(priority);
            while (true) {

                String partyStatus = "";
                for (int i = 0; i < 100000; i++) {
                    partyStatus += "Drinking";
                    partyStatus = partyStatus.substring(8);
                }
                System.out.println(Thread.currentThread()+" " + this.getClass().getSimpleName() + " party status: " + partyStatus);
                if(--partiesLeft == 0) return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Thread daemon = new Thread(new Lucifer());
        daemon.setDaemon(true);
        daemon.start();
        for (int i=0; i<6; i++)
            executorService.execute(new Guest(Thread.MIN_PRIORITY));
        executorService.execute(new VIP(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
