import java.io.*;

public class DataInpStream {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(System.in);

        // create file to write input
        FileOutputStream fout  = new FileOutputStream("textFile.txt", true);
        

        System.out.println("Enter text @ to end");

        char ch;

        while ((ch = (char) dis.read()) != '@') {
            fout.write(ch);
        }

        fout.close();

    }
}
