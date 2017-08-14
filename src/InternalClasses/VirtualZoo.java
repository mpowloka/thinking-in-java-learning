package InternalClasses;

import java.util.Random;

interface Animal {
    public void makeNoise();
    public void sleep();
}

public class VirtualZoo {
    public ZooDatabase f () {
        return  new ZooDatabase();
    }

    public VirtualZoo() { ZooDatabase.ZooCounter++; }

    //made only to see a way of making
    //anonymous classes using superclass non-standard constructor
    public VirtualZoo(int x) { this(); }



    public void lionShow(int number) {
        System.out.println();
        System.out.println("Visiting lion show");
        //local inner class implementing interface (no access modifier allowed, like private etc.)
        // available only inside method
        class Lion implements Animal{

            @Override
            public void makeNoise() {
                System.out.println("ROOOOOOOOOAAAAARRRRRR");
            }

            @Override
            public void sleep() {
                System.out.println("*Lion falls asleep*");
            }
        }

        for (int i=0; i<number; i++)
        {
            Lion l = new Lion();
            System.out.println("Lion no. " + (i+1) + " appears");
            l.makeNoise();
            l.sleep();
        }
        System.out.println();
        System.out.println("Thank you for visiting our lion show!");
    }

    public boolean penguinShow () {
        System.out.println();
        System.out.println("Visiting penguin show");
        System.out.println("We cannot guarantee that any penguin will show up. They are really shy!");

        Random rand = new Random();
        // 3/5 chances of seeing a penguin
        // local class defined within certain range
        // note: compiler builds class always, regardless of if statement success/failure
        if(rand.nextInt(5) <3) {
            class Penguin implements Animal {

                @Override
                public void makeNoise() {
                    //This is correct, it shows the way of addressing parent object
                    //VirtualZoo.this.lionShow(3);
                    System.out.println("*I don't really know what kind of noise penguins make... Sorry!*");
                }

                @Override
                public void sleep() {
                    System.out.println("*Penguin looks like is about to start dancing. Unfortunately it drops down and falls asleep.*");
                }
            }
            Penguin p = new Penguin();
            System.out.println("A penguin has appeared!");
            p.makeNoise();
            p.sleep();
            //Success, you've seen a penguin!
            return true;
        }
            else {
                System.out.println("No penguin has appeared, try luck next time!");
                return false;
                // illegal expression below, class Penguin available only within brackets it has been declared (if statement)
                // Penguin p = new Penguin();
            }
    }

    public VirtualZoo getMobileVirtualZoo(int version, String userName) {
        System.out.println();
        System.out.println("Now you can get your own virtual zoo on your mobile device!");
        switch (version) {
            // creating anonymous class inheriting from VirtualZoo class
            case 1: return new VirtualZoo() {
                {
                    // code executed during creating instance of anonymous class
                    System.out.println("Downloading music...");
                }
                public void playMusic() {
                    System.out.println("'MAKE THEM SUFFER - ETHER' IS ON TRACK");
                }
            };
            // creating anonymous class inheriting from VirtualZoo class, using alternative constructor
            case 2: return new VirtualZoo(5) {
                public void showUserGuide() {
                    System.out.println("*Lots of letters*");
                }
            };
            default: System.out.println("No valid version selected. Available versions: 1, 2"); return null;
        }
    }

    private static class ZooDatabase {
        // static inner class and own static fields/methods
        // while typical inner class cannot
        private static int ZooCounter;

        public ZooDatabase() {
            // incorrect, 'static class' might not reference parent object (bcs it has none)
            // VirtualZoo.this.lionShow(3);
        }
    }

    public static void main(String[] args) {
        VirtualZoo vz = new VirtualZoo();

        vz.lionShow(3);
        while(!vz.penguinShow());

        VirtualZoo mvz1 = vz.getMobileVirtualZoo(1, "Michal");
        // cannot use methods from anonymous class, which have not been declared
        // in superclass / implemented interface
        // mvz1.playMusic();
        VirtualZoo mvz2 = vz.getMobileVirtualZoo(2, "Michal");
        // mvz2.showUserGuide();

        ZooDatabase a = new ZooDatabase();
    }
}
