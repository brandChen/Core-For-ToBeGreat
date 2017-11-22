package Bridge2桥接模式;

public class SourceSub2 implements Sourceable {
 
    @Override
    public void method() {
        System.out.println("this is the second sub!");
    }
}