package Bridge2桥接模式;

public class MyBridge extends Bridge {
    public void method(){
        getSource().method();
    }
}