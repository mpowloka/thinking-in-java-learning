package Exceptions;

public class FailingConstructorNeedsCleaning {

    public FailingConstructorNeedsCleaning(boolean fail) throws Exception{

        NeedsCleaning needsCleaning = new NeedsCleaning();
        try {
            System.out.println(needsCleaning.toString() + " performing some actions.");
        }
        finally {
            needsCleaning.dispose();
        }

        if(fail) {
            System.out.println("Exception thrown!");
            throw new Exception();
        }

    }

}
