package exercise4;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DataInputOutTest {
    public static void main(String[] args) throws IOException {
        String str = "1 20 30 6 12 45";
        Write(str, "test.txt");

//        doc test.txt
        try (FileInputStream fin = new FileInputStream("test.txt")) {
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);

            String[] intStr = new String[50];
            intStr = formatByte(bytes).split(" ");
            sort(intStr);


            Write(str, "Numbers.dat");

        } catch (IOException ignored) {
        }


//ghi Numbers.dat
//        FileOutputStream file = null;
//        DataOutputStream data = null;
//        byte [] fileInt = {1,2,6,8,12,6,0,2,3,7};
//        try {
//            file = new FileOutputStream("Numbers.dat");
//            data = new DataOutputStream(file);
//            data.write(fileInt);
//            data.flush();
//        } catch (IOException ignored) {
//        } finally {
//            assert data != null;
//            data.close();
//        }

//doc Numbers.dat
        try {
            FileInputStream input = new FileInputStream("Numbers.dat");
            byte[] arr = new byte[input.available()];
            input.read(arr);

            String[] intStr = formatByte(arr).split(" ");

            int[] arrInt = new int[intStr.length];

            for (int i = 0; i < arrInt.length; i++) {
                arrInt[i] = Integer.parseInt(intStr[i]);
            }
            findMaxLenghtEven(arrInt);

        } catch (IOException ignored) {
        }

    }

    public static String formatByte(byte[] data) {

        StringBuilder sb = new StringBuilder();
        for (byte willBeChar : data) {
            sb.append((char) willBeChar);
        }
        return sb.toString();
    }

    public static void Write(String name, String file) {
        try {
            FileWriter fw = new FileWriter(file);
            fw.write(name);
            fw.close();
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    public static void findMaxLenghtEven(int[] arr) {
        int count = 0;
        int index = 0;
        int maxLenght = 0;
        int firtIndex = 0;

        String arrEventStr = "";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                count++;
            } else if (arr[i] % 2 != 0) {
                if (maxLenght < count) {
                    maxLenght = count;
                    index = i;
                    firtIndex = index - maxLenght;
                }
                count = 0;
            }
        }
        if (count > maxLenght) {
            maxLenght = count;
            index = arr.length;
            firtIndex = index - maxLenght;
        }
        System.out.println("max : " + maxLenght);
        System.out.println("firtIndex : " + firtIndex);
        System.out.println("index : " + index);

        if (maxLenght == 1) {
            System.out.println(arr[firtIndex]);
            return;
        } else {
            for (int i = firtIndex; i < index; i++) {
                arrEventStr += arr[i] + " ";
            }

            System.out.println(arrEventStr);
        }
    }

    public static int[] sort(String str[]) {
        int[] a = new int[str.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }

        int n = a.length;
        for (int i = a.length; i <= 0; i--) {
            for (int j = i + 1; j <= 0; j--) {
                if (a[j] > a[i]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        System.out.println("sort : " + Arrays.toString(a));
        return a;
    }
}
