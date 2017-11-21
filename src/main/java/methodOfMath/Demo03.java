package methodOfMath;

public class Demo03 {
    public static void main(String args[]) {
        math mymath = new math();
        for (int i = 100; i <= 999; i++)
            if (mymath.shuixianhua(i) == true)
                System.out.println(i);
    }
}
class math {
    public boolean shuixianhua(int x) {
        int i = 0, j = 0, k = 0;
        i = x/100;
        j = (x%100)/10;
        k = x%10;
        if (x == i*i*i + j*j*j + k*k*k)
            return true;
        else
            return false;
    }
}