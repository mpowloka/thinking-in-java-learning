package Phones;

import Interfaces.MobilePhone;

public class iPhone5S implements MobilePhone{

    @Override
    public void call(int number) {

        System.out.println("Calling..." + number);

    }

    @Override
    public void sendMessage(int number, int title, int body) {

        System.out.println("Message sent to: " + number);

    }

    public void takeAPhoto () {
        System.out.println("Photo added to gallery");
    }
}
