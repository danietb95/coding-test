package coding;

import java.io.*;
import java.util.ArrayList;

public class FileManagement {

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

    public static void writeFile(String rootFile, ArrayList<String> palindromes) throws IOException {
        File file = new File(rootFile);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(file));
        for (String palindrome : palindromes) {
            if (!String.valueOf(palindrome).equals("")) {
                bw.write(String.valueOf(palindrome));
                bw.newLine();
            }
        }
        bw.close();
    }
}
