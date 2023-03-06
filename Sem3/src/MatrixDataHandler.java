
import java.io.*;


public class MatrixDataHandler {
    private int[][] matrix;
    private int height;
    private int width;

    /**
     * Constructorul care initializeaza matricea pe baza valorilor primite pentru dimensiuni
     * Matricea initializata este scrisa in fisierul fileName
     * @param height
     * @param width
     * @param fileName
     */
    private String fileName;
    public MatrixDataHandler(int height, int width, String fileName) {
        this.height = height;
        this.width = width;
        this.fileName = fileName;
        matrix = new int[height][];
        for (int i = 0; i < height; i++) {
            matrix[i] = new int[width];
        }
        if(!this.writeMatrixToFile())
            System.out.println("Ceva nu a fost ok la scrierea fisierului!");
    }

    /**
     * Metoda scrie matricea in fisierul denumit <this.fileName>
     * @return true daca scrierea s-a facut cu succes; false in caz contrar
     */
    public boolean writeMatrixToFile(){
        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write(height + " " + width + "\n");
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    fw.write(matrix[i][j] + " ");
                }
                fw.write("\n");
            }
            fw.close();
            return true;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            //System.exit(-1);
            return false;
        }
    }

    /**
     * Returneaza valoarea de pe o anumita pozitie in matrice.
     * Inainte de a returna, se va actualiza matricea cu datele din fisier
     * @param posHeight Linia de pe care se citeste
     * @param posWidth Coloana de pe care se citeste
     * @return Valoarea de pe pozitia transmisa
     */
    public int getValueFromPosition(int posHeight, int posWidth) {
        if(!this.readMatrixFromFile())
            System.out.println("Citirea din fisier a esuat! Datele returnate sunt cele existente in <matrix> local");
        return this.matrix[posHeight][posWidth];
    }

    /**
     * Citeste din fisier datelee pentru o matrice, conform clasei curente
     * @return true daca s-a citit cu succes; false in caz contrar
     */
    public boolean readMatrixFromFile(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.fileName));
            String line = br.readLine();
            height = Integer.parseInt(line.split(" ")[0]);
            width = Integer.parseInt(line.split(" ")[1]);

            for (int i = 0; i < height; i++) {
                line = br.readLine();
                for (int j = 0; j < width; j++) {
                    matrix[i][j] = Integer.parseInt(line.split(" ")[j]);
                }
            }
            br.close();
            return true;
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    /**
     * Se citesc valorile din fisier, se modifica valoarea dorita si apoi se rescriu datele din fisier
     * @param posHeight Linia pe care se scrie
     * @param posWidth Coloana pe care se scrie
     * @param val Noua Valoare
     */
    public void modifyValueAndUpdateFile(int posHeight, int posWidth, int val) {
       this.readMatrixFromFile();
       this.matrix[posHeight][posWidth] = val;
       this.writeMatrixToFile();
    }
}