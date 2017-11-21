package methodOfMath;

/**
 * 棋盘覆盖问题--分治法
 */
public class Qipanfugai {
    public int tile = 1;
    public int[][] board;//整型数组保存棋盘

    public Qipanfugai(int size) {
        board = new int[size][size];
        /*A a=new B();
                        是否可以解释为:声明了一个A类名叫a，为它开辟了一块内存空间B并保存在B中！*/
        /*对象的成员变量初始化。在对象的初始化过程中，基本数据类型（例如int,char,byte等）都会有默认值，比如int类型的成员变量的默认值为0；但非基本数据类型的其他对象类型则默认值为Null，例如String类型的默认值为null，Date类型的默认值也是null。*/
    }

    /**
     * 实现棋盘覆盖的分枝法
     *
     * @param tr 棋盘左上角行号（从0开始）
     * @param tc 棋盘左上角列号
     * @param dr 特殊方格行号
     * @param dc 特殊方格列号
     * @param size 棋盘规格（size*size）
     */
    public void chessBoard(int tr, int tc, int dr, int dc, int size) {

        if (size == 1) return;
        int t = tile;
        tile++;
        int s = size / 2;
        //左上角
        if (dr < tr + s && dc < tc + s) {
            chessBoard(tr, tc, dr, dc, s);
        } else {
            board[tr + s - 1][tc + s - 1] = t;
            chessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
        }
        //右上角
        if (dr < tr + s && dc >= tc + s) {
            chessBoard(tr, tc + s, dr, dc, s);
        } else {
            board[tr + s - 1][tc + s] = t;
            chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
        }
        //左下角
        if (dr >= tr + s && dc < tc + s) {
            chessBoard(tr + s, tc, dr, dc, s);
        } else {
            board[tr + s][tc + s - 1] = t;
            chessBoard(tr + s, tc, tr + s, tc + s - 1, s);
        }
        //右下角
        if (dr >= tr + s && dc >= tc + s) {
            chessBoard(tr + s, tc + s, dr, dc, s);
        } else {
            board[tr + s][tc + s] = t;
            chessBoard(tr + s, tc + s, tr + s, tc + s, s);
        }
    }

    public static void main(String[] args) {
//		methodOfMath.Qipanfugai qi = new methodOfMath.Qipanfugai(4);
//		qi.chessBoard(0, 0, 0, 1, 4);

        Qipanfugai qi = new Qipanfugai(8);
        qi.chessBoard(0, 0, 7, 4, 8);
        for (int i = 0; i < qi.board.length; i++) {
            for (int j = 0; j < qi.board[i].length; j++) {
                System.out.print(qi.board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
/*
注：输出0代表特殊方格所在位置
==================================================
测试程序：
qi.chessBoard(0, 0, 0, 1, 4);

输出：
2 0 3 3 
2 2 1 3 
4 1 1 5 
4 4 5 5 
================================================

测试程序：
qi.chessBoard(0, 0, 7, 4, 8);

输出：
3 3 4 4 8 8 9 9 
3 2 2 4 8 7 7 9 
5 2 6 6 10 10 7 11 
5 5 6 1 1 10 11 11 
13 13 14 1 18 18 19 19 
13 12 14 14 18 17 17 19 
15 12 12 16 20 20 17 21 
15 15 16 16 0 20 21 21 
=================================================
 */
