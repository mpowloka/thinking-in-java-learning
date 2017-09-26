package Multithreading;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Result implements Callable<String> {

    private static Random random = new Random();

    @Override
    public String call() throws Exception {
        StringBuilder builder = new StringBuilder();
        int length = random.nextInt(6) + 2;
        System.out.println(length + " letters:");
        for (int i=0; i<length; i++) {
            builder.append("A");
        }
        return builder.toString();
    }
}

public class CallableDemo {

    private static List<Future<String>> callResult(List<Callable<String>> calls, ExecutorService executor) {
        List<Future<String>> results = new LinkedList<>();
        for (Callable callable: calls) {
            results.add(executor.submit(callable));
        }
        executor.shutdown();
        return results;
    }

    public static void main(String[] args) {

            List<Future<String>> list = callResult( Arrays.asList( new Result(), new Result(), new Result() ), Executors.newSingleThreadExecutor());

            for(int i=0; i<list.size(); i++) {
                if ( !list.get(i).isDone() ) {
                    i--;
                    continue;
                }
                try {
                    System.out.println(list.get(i).get());
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


    }

}
