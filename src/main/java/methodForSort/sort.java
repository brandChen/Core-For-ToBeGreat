package methodForSort;

import java.util.Date;

public class sort {
    public static void main(String[] args) {
        int maxSize = 1000000;
        Array arr = new Array(maxSize);
        for (int j = 0; j < maxSize; j++) {
            long n = (long) (Math.random() * 9999999);
            arr.insert(n);
        }
//        for (int i = 3; i < 7; i++) {
        int i =5;
            try {
                Thread thread = new Thread(new SortRunable(i,arr));
                thread.start();
//                System.out.println(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
//        }
    }
}
