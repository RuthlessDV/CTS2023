
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        MatrixDataHandler mH = new MatrixDataHandler(5, 7, "matrix.txt");
        mH.modifyValueAndUpdateFile(3, 4, 345);
    }
}