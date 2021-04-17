import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        IOUtils ioUtils = new IOUtils();
        ioUtils.input();
        double a[][] = ioUtils.getA();
        int row = ioUtils.getRow(), col = ioUtils.getCol();
        double[] ret;
        final CountDownLatch countDownLatch = new CountDownLatch(col);
        double[][] result = new double[row][col];
        GuruThread guruThread[] = new GuruThread[col];
        for (int i = 0; i < col; i++) {
            guruThread[i] = new GuruThread("guru" + (i + 1),
                    countDownLatch, a
                    , row, i);
            guruThread[i].start();
        }
        countDownLatch.await();

        for(int i=0; i<col; i++){
            ret=guruThread[i].getValue();
            for(int j=0; j<row; j++){
                result[j][i] = ret[j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%.2f\t", result[i][j]);
                ;
            }
            System.out.println();
        }
        System.out.println("Writing to file output.txt...");
        ioUtils.setA(result);
        ioUtils.output();
    }
}