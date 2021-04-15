public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {{1, 3, 4}, {2, 4, 3}, {3, 4, 5}, {1, 2, 3}};
        int row = 4, col = 3;
        for (int i = 0; i < col; i++) {
            GuruThread guruThread = new GuruThread("guru" + (i+1), a, row, col);
            guruThread.start();
        }
    }
}