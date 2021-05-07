import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class IOUtils {
    private int row, col;
    private double a[][];

    public IOUtils() {
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public double[][] getA() {
        return a;
    }

    public void setA(double[][] a) {
        this.a = a;
    }

    public void input() throws FileNotFoundException {
        // count rows, cols
        Scanner scanner = new Scanner(new File("input.txt"));
        row = 0;
        col = 0;
        while (scanner.hasNextLine()) {
            row++;
            scanner.nextLine();
        }
        scanner.close();
        a = new double[row][];
        scanner = new Scanner(new File("input.txt"));
        for (int i = 0; i < row; i++) {
            String string = scanner.nextLine();
            String[] token = string.split(" ");
            col = token.length;
            a[i] = new double[token.length];
            for (int j = 0; j < token.length; j++) {
                a[i][j] = Integer.parseInt(token[j]);
            }
        }
    }

    public void output() throws IOException {
        NumberFormat numberFormat = new DecimalFormat("#0.00");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                a[i][j] = Double.parseDouble(numberFormat.format(a[i][j]));
                bufferedWriter.write(a[i][j] + ((j == a[i].length-1)?"":" "));
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
