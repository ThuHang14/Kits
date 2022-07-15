package exercise4;

import java.io.*;

public class DataInputOutTest {
    public static void main(String[] args) throws IOException {
        Reader reader = new BufferedReader(new FileReader("C:\\Users\\MULTICAMPUSPC\\Desktop\\Kits\\javaCore\\src\\exercise4\\test.txt"));

        char[] theChars = new char[128];

        int charsRead = reader.read(theChars, 0, theChars.length);
        while(charsRead != -1) {
            System.out.println(new String(theChars, 0, charsRead));
            charsRead = reader.read(theChars, 0, theChars.length);
        }

        System.out.println(theChars);
    }
}
