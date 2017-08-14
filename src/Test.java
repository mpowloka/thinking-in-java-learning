import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

interface  TestInterface {
    public void method1();
}

class Dummy1 implements TestInterface {

    @Override
    public void method1() {

    }

    public void method2() {

    }
}

public class Test {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        // correct even if forEach is not in List interface, WTF
        numbers.forEach(System.out::println);

        List<Integer> numbers2 = new LinkedList<>();

        //incorrect bcs addFirst is not in List interface
        // numbers2.addFirst(5);

        numbers2.forEach(System.out::println);

    }
}
