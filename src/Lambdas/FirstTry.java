package Lambdas;

import java.util.function.IntSupplier;

@FunctionalInterface
interface DoSomething {
    int toDo(int x);
}

@FunctionalInterface
interface DoSomethingElse<T ,R> {
    T toDo(R x);
}


public class FirstTry {

    public static void main(String... args) {

        DoSomething ds = a -> a*2;

        System.out.println(ds.toDo(15));

        DoSomethingElse<Integer, String> dse = (String s) -> {
            System.out.println(s);
            return s.length();
        };
        System.out.println(dse.toDo("Taxation is theft"));

        DoSomethingElse<Integer, String > dse2 = (String s) -> s.length();

        System.out.println(dse2.toDo("Taxation is the price we pay for civilized society"));


    }

}
