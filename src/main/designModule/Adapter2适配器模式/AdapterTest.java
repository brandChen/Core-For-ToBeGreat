package Adapter2适配器模式;

/**
 * 适配器模式将某个类的接口转换成客户端期望的另一个接口表示，
 * 目的是消除由于接口不匹配所造成的类的兼容性问题。
 * 主要分为三类：类的适配器模式、对象的适配器模式、接口的适配器模式
 */
public class AdapterTest {
 
    public static void main(String[] args) {
        /**
         * 类的适配器
         * 有一个Source类，拥有一个方法，待适配，目标接口时Targetable，
         * 通过Adapter类，将Source的功能扩展到Targetable里
         */
        Targetable target = new Adapter();
        target.method1();
        target.method2();

        /**
         * 对象的适配器模式
         * 基本思路和类的适配器模式相同，
         * 只是将Adapter类作修改，这次不继承Source类，而是持有Source类的实例，
         * 以达到解决兼容性的问题
         */
        Source source = new Source();
        Targetable target1 = new Wrapper(source);
        target1.method1();
        target1.method2();

        /**
         * 接口的适配器模式
         * 借助于一个抽象类，该抽象类实现了该接口，实现了所有的方法，
         * 而我们不和原始的接口打交道，只和该抽象类取得联系，
         * 所以我们写一个类，继承该抽象类，重写我们需要的方法就行
         */
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }
}