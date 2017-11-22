package AbstractFactory1抽象工厂模式;

public class SendMailFactory implements Provider {
     
    @Override
    public Sender produce(){
        return new MailSender();
    }
}