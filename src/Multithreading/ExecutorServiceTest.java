package Multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {

    public static void runTasks(List<Runnable> tasks, ExecutorService executor) {
        System.out.println("Running task set with: " + executor.getClass().getSimpleName());
        for(Runnable task : tasks) {
            executor.execute(task);
        }
        executor.shutdown();

    }

    public static void main(String[] args) {

        runTasks(Arrays.asList(new Countdown(), new Countdown(), new Countdown()), Executors.newCachedThreadPool());

        runTasks(Arrays.asList(new Countdown(), new Countdown(), new Countdown()), Executors.newFixedThreadPool(3));

        runTasks(Arrays.asList(new Countdown(), new Countdown(), new Countdown()), Executors.newSingleThreadExecutor());


    }

}
