package Command3命令模式;

public class Invoker {
     
    private Command command;
     
    public Invoker(Command command) {
        this.command = command;
    }
 
    public void action(){
        command.exe();
    }
}