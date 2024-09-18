import java.io.*;

//to optimise wrtitng we use bufferoutputstream which uses a buffer to store the input char
public class BuffOutpStream {
    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(System.in);
        
        //reading from file
        FileOutputStream fout = new FileOutputStream("textFile.txt",true);

        BufferedOutputStream bout = new BufferedOutputStream(fout,1024);

        System.out.println("Enter text @ to end");

        char ch;

        while ((ch  = (char)dis.read()) != '@') {
            bout.write(ch);
        }

        bout.close();
    }
}
