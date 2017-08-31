package Exceptions;

public class Main {

    public static void main(String[] args) {
        try{
            FailingConstructorNeedsCleaning fcnc = new FailingConstructorNeedsCleaning(true);

        }
        catch (Exception e){
            System.out.println("Exception handled");
        }

    }
}
