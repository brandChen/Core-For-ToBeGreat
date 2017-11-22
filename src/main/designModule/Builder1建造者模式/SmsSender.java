package Builder1建造者模式;

public class SmsSender implements Sender {
 
    @Override
    public void Send() {
        System.out.println("this is sms sender!");
    }
}