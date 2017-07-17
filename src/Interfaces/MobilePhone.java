package Interfaces;


public interface MobilePhone {

    public static final int interfaceID = 0;

    public void call(int number);

    public void sendMessage(int number, int title, int body);

}
