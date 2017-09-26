package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class DaemonFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        return thread;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonFactory());
        for (int i=0; i<3; i++)
            executorService.execute(new SleepingPriorityDaemons.Lucifer());

        executorService.shutdown();

        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
