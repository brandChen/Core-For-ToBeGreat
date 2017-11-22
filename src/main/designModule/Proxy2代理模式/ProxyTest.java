package Proxy2代理模式;

/**
 * 多一个代理类出来，替原对象进行一些操
 */
public class ProxyTest {
 
    public static void main(String[] args) {
        Sourceable source = new Proxy();
        source.method();
    }
 
}