package InternalClasses;

public class Task23 {
    public static void main(String[] args) {

        B b = new B();
        A a = new A();
        for(int i = 0; i<10; i++) {
            b.addU(a.factory());
        }
        b.execute();
        b.nullU(5);
        System.out.println(b.tab[5]);

    }
}

interface U {
    void method1 ();
    void method2 ();
    void method3 ();
}

class A {

    public U factory() {

        return new U() {

            @Override
            public void method1() {
                System.out.println("xD");
            }

            @Override
            public void method2() {

            }

            @Override
            public void method3() {

            }
        };

    }

}

class B {

    U[] tab = new U[10];
    private int counter;

    public void addU (U u) {
        tab[counter++] = u;
    }
    public void nullU (int i) {
        tab[i] = null;
    }
    public void execute() {
        for(U u : tab)
        {
            u.method1();
        }
    }


}
