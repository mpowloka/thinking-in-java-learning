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

    public static void main (String[] args) {
        TestInterface x = new Dummy1();

        x.method1();
        // invalid
        // x.method2();

        Dummy1 y = new Dummy1();
        y.method1();
        y.method2();
    }
}
