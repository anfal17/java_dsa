import java.io.*;

public class FileIO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input filename: ");
        String fname = br.readLine();

        FileInputStream fin = null;
        BufferedInputStream binp = null;
        BufferedOutputStream bout = null;

        try {
            // Open the input file
            fin = new FileInputStream(fname);
            binp = new BufferedInputStream(fin);

            // Print the contents of the input file to the console
            System.out.println("File Contents:");
            int ch;
            while ((ch = binp.read()) != -1) {
                System.out.print((char) ch);
            }

            // Reset the input stream so we can read it again
            binp.close();
            fin = new FileInputStream(fname);  // Reopen the input stream
            binp = new BufferedInputStream(fin);

            // Get the output file name
            System.out.println("\nOutput filename: ");
            String fname2 = br.readLine();
            
            // Open the output file in append mode
            FileOutputStream fout = new FileOutputStream(fname2, true);
            bout = new BufferedOutputStream(fout);

            // Write the contents of the input file to the output file
            while ((ch = binp.read()) != -1) {
                bout.write(ch);
            }

            System.out.println("File contents copied successfully to " + fname2);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } finally {
            // Close all resources to avoid resource leaks
            if (binp != null) binp.close();
            if (fin != null) fin.close();
            if (bout != null) bout.close();
        }
    }
}
