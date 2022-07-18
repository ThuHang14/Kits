package exercise4;

import java.io.*;

public class DataInputOutTest {
    public static void main(String[] args) throws IOException {
        Reader reader = new BufferedReader(new FileReader("C:\\Users\\MULTICAMPUSPC\\Desktop\\Kits\\javaCore\\src\\exercise4\\test.txt"));

        char[] chars = new char[128];

        int charsRead = reader.read(chars, 0, chars.length);
        while(charsRead != -1) {
            System.out.println(new String(chars, 0, charsRead));
            charsRead = reader.read(chars, 0, chars.length);
        }

    }
}
