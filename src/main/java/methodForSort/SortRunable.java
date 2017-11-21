package methodForSort;

import jdk.nashorn.internal.objects.annotations.Function;

/**
 * Created by Administrator on 2017/11/15.
 */
public class SortRunable implements Runnable{

    private int function;
    private Array array;
    public SortRunable(int function,Array array){
        this.function =function;
        this.array =array;
    }

    public void run() {
        try {
            System.out.println("waitting...");
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        long currentTime = System.currentTimeMillis();
        switch (function){
            case 1: array.bubbleSort();
                System.out.print("冒泡排序：");
                System.out.println(System.currentTimeMillis()-currentTime);
                
                break;
            case 2:array.selectionSort();
                System.out.print("选择排序：");
                System.out.println(System.currentTimeMillis()-currentTime);
                
                break;
            case 3:array.insertionSort();
                System.out.print("插入排序：");
                System.out.println(System.currentTimeMillis()-currentTime);
                
                break;
            case 4:array.shellSort();
                System.out.print("希尔排序：");
                System.out.println(System.currentTimeMillis()-currentTime);
                
                break;
            case 5:array.quickSort();
                System.out.print("快速排序：");
                System.out.println(System.currentTimeMillis()-currentTime);
                
                break;
            case 6:array.mergeSort();
                System.out.print("归并排序：");
                System.out.println(System.currentTimeMillis()-currentTime);
                
                break;
        }
    }
}
