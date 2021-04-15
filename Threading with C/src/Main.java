import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        int a[][] = {{1, 3, 4}, {2, 4, 3}, {3, 4, 5}, {1, 2, 3}};
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        int row = 4, col = 3;
        double ret[];
//        for (int i = 0; i < col; i++) {
//            GuruThread guruThread = new GuruThread("guru" + (i+1), countDownLatch, a, row, i);
//            guruThread.start();
//            countDownLatch.await();
//            ret = guruThread.getValue();
//            System.out.println(ret);
//        }

        GuruThread guruThread = new GuruThread("guru", countDownLatch, a, 4, 0);
        guruThread.start();
        countDownLatch.await();
        ret = guruThread.getValue();
        System.out.println(ret);
    }
}