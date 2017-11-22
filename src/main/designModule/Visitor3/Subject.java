package Visitor3;

public interface Subject {
    public void accept(Visitor visitor);
    public String getSubject();
}