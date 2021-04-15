public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a[][] = {{1, 3, 4}, {2, 4, 3}, {3, 4, 5}, {1, 2, 3}};
        int row = 4, col = 3;
        double ret[];
//        for (int i = 0; i < col; i++) {
//            GuruThread guruThread = new GuruThread("guru" + (i+1), a, row, i);
//            guruThread.start();
//            ret = guruThread.getValue();
//            System.out.println(ret);
//        }

        GuruThread guruThread = new GuruThread("guru", a, 4, 0);
        guruThread.start();
        ret = guruThread.getValue();
        System.out.println(ret);
    }
}