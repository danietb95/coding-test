package coding;

import java.io.*;
import java.util.ArrayList;

public class FileManagement {

    /**
     * Read in a file
     *
     * @param fileRoot file root where the file will be read
     */
    public static ArrayList<String> readFile(String fileRoot) throws FileNotFoundException, IOException {
        ArrayList<String> ar = new ArrayList<String>();
        String string;
        FileReader f = new FileReader(fileRoot);
        BufferedReader b = new BufferedReader(f);
        while ((string = b.readLine()) != null) {
            ar.add(string);
        }
        b.close();
        return ar;
    }

    /**
     * Write in a file
     *
     * @param rootFile file root where the inputs will be written
     * @param writeInputs inputs to write
     */
    public static void writeFile(String rootFile, ArrayList<String> writeInputs) throws IOException {
        File file = new File(rootFile);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(file));
        for (String input : writeInputs) {
            if (!String.valueOf(input).equals("")) {
                bw.write(String.valueOf(input));
                bw.newLine();
            }
        }
        bw.close();
    }
}
