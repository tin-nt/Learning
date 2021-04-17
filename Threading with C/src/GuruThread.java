import java.util.concurrent.CountDownLatch;

class GuruThread implements Runnable {
    Thread thread;
    private int row, col;
    private double a[][];
    private String threadName;
    private double result[];
    CountDownLatch countDownLatch;

    GuruThread(String threadName, CountDownLatch countDownLatch, double[][] a, int row, int col) {
        this.threadName = threadName;
        this.a = a;
        this.row = row;
        this.col = col;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        result = new double[row];
//        System.out.println("Running Thread: " + threadName);
        for (int i = 0; i < row; i++) {
//            System.out.println(threadName + "[" + j + ", " + (col-1) + "]: " + average(a, j, col));
//            System.out.print(average(a, i, col) + "\t");
            result[i] = average(a, i, col);
        }
        countDownLatch.countDown();
    }

    public void start() {
//        System.out.println("Starting Thread: " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }

    }

    public double [] getValue(){
        return result;
    }

    public double average(double[][] a, int row, int col) {
        double sum = 0;
        // xet thread o vi tri 0
        if (col == 0) {
            // vi tri can tim: a[0][0]
            if (row == 0) {
                // a[0][1]
                sum += a[row][col + 1];
                // a[1][0]
                sum += a[row + 1][col];
                // a[1][1]
                sum += a[row + 1][col + 1];
                sum /= 3;
            }
            // vi tri can tim: a[this.row-1][0]
            else if (row == this.row - 1) {
                // a[row-2][0]
                sum += a[this.row - 2][col];
                // a[row-2][1]
                sum += a[this.row - 2][col + 1];
                // a[row-1][1]
                sum += a[this.row - 1][col + 1];
                sum /= 3;
            }
            // vi tri can tim: a[row][col]
            else {
                sum += a[row - 1][col];
                sum += a[row - 1][col + 1];
                sum += a[row][col + 1];
                sum += a[row + 1][col + 1];
                sum += a[row + 1][col];
                sum /= 5;
            }
        }
        // xet thread o vi tri cuoi
        else if (col == this.col) {
            // vi tri can tim: a[0][this.col-1]
            if (row == 0) {
                // a[0][this.col-1]
                sum += a[row][this.col - 1];
                // a[1][this.col-2]
                sum += a[row + 1][this.col - 1];
                // a[1][this.col-1]
                sum += a[row + 1][this.col];
                sum /= 3;
            }
            // vi tri can tim: a[this.row-1][this.col-1]
            else if (row == this.row-1) {
                sum += a[this.row - 1][this.col - 1];
                sum += a[this.row - 2][this.col - 1];
                sum += a[this.row - 2][this.col];
                sum /= 3;
            } else {
                sum += a[row - 1][col];
                sum += a[row - 1][col - 1];
                sum += a[row][col - 1];
                sum += a[row + 1][col - 1];
                sum += a[row + 1][col];
                sum /= 5;
            }
        }
        //xet thread o vi tri col
        else {
            // vi tri can tim: a[0][row]
            if (row == 0) {
                sum += a[row][col - 1];
                sum += a[row + 1][col - 1];
                sum += a[row + 1][col];
                sum += a[row + 1][col + 1];
                sum += a[row][col + 1];
                sum /= 5;
            }
            // vi tri can tim: a[this.row-1][col]
            else if (row == this.row - 1) {
                sum += a[row][col - 1];
                sum += a[row - 1][col - 1];
                sum += a[row - 1][col];
                sum += a[row - 1][col + 1];
                sum += a[row][col + 1];
                sum /= 5;
            } else {
                sum += a[row - 1][col];
                sum += a[row - 1][col + 1];
                sum += a[row][col + 1];
                sum += a[row + 1][col + 1];
                sum += a[row + 1][col];
                sum += a[row + 1][col - 1];
                sum += a[row][col - 1];
                sum += a[row - 1][col - 1];
                sum /= 8;
            }
        }
        return sum;
    }
}
