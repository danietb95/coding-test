package main.java.coding;

import java.io.*;
import java.util.ArrayList;

public class FileManagement {

    public static ArrayList<String> readFile(String fileRoot) throws FileNotFoundException, IOException {
        ArrayList<String> ar = new ArrayList<String>();
        String cadena;
        FileReader f = new FileReader(fileRoot);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            ar.add(cadena);
        }
        b.close();
        return ar;
    }

    public static void writeFile(String rootFile, ArrayList<String> palindromes) throws IOException {
        File archivo = new File(rootFile);
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(archivo));
        for (String palindrome : palindromes) {
            bw.write(String.valueOf(palindrome));
            bw.newLine();
        }
        bw.close();
    }
}
