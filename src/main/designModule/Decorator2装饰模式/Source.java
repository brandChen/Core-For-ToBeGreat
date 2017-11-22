package Decorator2装饰模式;

public class Source implements Sourceable {
 
    @Override
    public void method() {
        System.out.println("the original method!");
    }
}