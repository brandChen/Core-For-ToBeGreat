package State3状态模式;
 
/**
 * 状态类的核心类
 * V型知识库 www.vxzsk.com
 * @author erqing
 *
 */
public class State {
     
    private String value;
     
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }
 
    public void method1(){
        System.out.println("execute the first opt!");
    }
     
    public void method2(){
        System.out.println("execute the second opt!");
    }
}