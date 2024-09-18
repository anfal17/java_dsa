import java.io.*;

public class FileReadWrite {
    public static void main(String[] args) throws IOException {
        filewr();
        filerd();
    }    


public static void filerd() throws IOException {
    int ch;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    FileReader fr = null;

    System.out.println("Enter the filename");
    String fname = br.readLine();

    try {
        fr = new FileReader(fname);
    } catch (Exception e) {
        System.out.println("File not found");
        return;
    }

    System.out.println("Fileread from textFile ");
    while ((ch = fr.read()) != -1) {
        System.out.print((char)ch);
    }
    fr.close();
} 

public static void filewr()throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter string ");

        String str = br.readLine();

        FileWriter fw = new FileWriter("textFile.txt");

        for (int i = 0; i < str.length(); i++) {
            fw.write(str.charAt(i));
        }

        fw.close();
}

}