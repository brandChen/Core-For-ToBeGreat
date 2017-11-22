package FactoryMethod1工厂模式;

/**
 * 工厂方法模式
 *
 */
public class FactoryTest {

    public static void main(String[] args) {
        /**
         * 普通工厂模式，就是建立一个工厂类，对实现了同一接口的一些类进行实例的创建
         */
        SendFactory factory = new SendFactory();
        Sender sender = factory.produce("mail");
        /**
         * 多个工厂方法模式，是对普通工厂方法模式的改进，在普通工厂方法模式中，
         * 如果传递的字符串出错，则不能正确创建对象，
         * 而多个工厂方法模式是提供多个工厂方法，分别创建对象
         */
        Sender sender1 = factory.produceMail();

        /**
         * 静态工厂模式，将上面的多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可
         */
        Sender sender2 = SendFactory.produceMail();
        sender.Send();
        sender1.Send();
        sender2.Send();
    }
}