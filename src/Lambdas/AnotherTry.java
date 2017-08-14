package Lambdas;

import java.util.function.Consumer;
import java.util.function.ToIntFunction;

@FunctionalInterface
interface keepGoing <T, R> {
    boolean going(T t, R r);
}

public class AnotherTry {

    private static boolean isEqual(Object o1, Object o2) {
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        return o1.equals(o2);
    }

    private boolean nonStaticIsEqual(Object o1, Object o2) {
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
        return o1.equals(o2);
    }

    public static void main(String[] args) {

        keepGoing<Object, String> kg = (Object o, String s) -> o==s;
        System.out.println(kg.going(new Object(), new String()));

        // incorrect
        // keepGoing<Object, String> kg1 = (String s, Object o) -> o==s;

        kg = AnotherTry::isEqual;
        System.out.println(kg.going(new Object(), new String()));

        AnotherTry at = new AnotherTry();
        kg = at::nonStaticIsEqual;
        System.out.println(kg.going(new String("asdf"), new String("asdf")));



    }
}
