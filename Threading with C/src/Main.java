import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        int a[][] = {{1, 3, 4}, {2, 4, 3}, {3, 4, 5}, {1, 2, 3}};
        int row = 4, col = 3;
        double[] ret = new double[row];
        final CountDownLatch countDownLatch = new CountDownLatch(col);
        double[][] result = new double[row][col];
        int countDownIndex=col;
        GuruThread guruThread[] = new GuruThread[col];
        for (int i = 0; i < col; i++) {
            guruThread[i] = new GuruThread("guru" + (i + 1), countDownLatch, a, row, i, countDownIndex-1);
            guruThread[i].start();
//            ret = guruThread.getValue();
//            for (int j = 0; j < row; j++) {
////                result[j][i] = ret[j];
//                System.out.println(ret);
//            }
        }
        countDownLatch.await();

//        GuruThread guruThread = new GuruThread("guru0", countDownLatch, a, row, 0, countDownIndex-1);
//        GuruThread guruThread1 = new GuruThread("guru1", countDownLatch, a, row, 1, countDownIndex-1);
//        GuruThread guruThread2 = new GuruThread("guru2", countDownLatch, a, row, 2, countDownIndex-1);
//        guruThread.start();
//        guruThread1.start();
//        guruThread2.start();
        ret = guruThread[0].getValue();
        for (int i = 0; i < row; i++){
            System.out.println(ret[i]);
        }
        ret = guruThread[1].getValue();
        for (int i = 0; i < row; i++){
            System.out.println(ret[i]);
        } ret = guruThread[2].getValue();
        for (int i = 0; i < row; i++){
            System.out.println(ret[i]);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%.2f\t", result[i][j]);
                ;
            }
            System.out.println();
        }
        System.out.println();
    }
}