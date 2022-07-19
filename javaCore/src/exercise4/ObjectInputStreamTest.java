package exercise4;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectInputStreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String studentTxt = "Tran Van B;22;Hai Duong;2002;7.8\n" +
                "Tran Van C;23;Hai Phong;2001;5\n" +
                "Tran Van D;24;Ha Noi;2003;6.8\n" +
                "Tran Van E;25;Ha Nam;2004;7\n" +
                "Tran Van F;26;Ha Tinh;2005;8";

        Write(studentTxt, "student.txt");

        List<Student> list = new ArrayList<Student>();
        ObjectOutputStream objectOutput = null;
        try {
            FileReader FR = new FileReader("student.txt");
            BufferedReader BR = new BufferedReader(FR);
            String line = "";
            while (true) {
                line = BR.readLine();
                if (line == null) break;
                String[] txt = line.split(";");
                String name = txt[0];
                int age = Integer.parseInt(txt[1]);
                String quequan = txt[2];
                int namsinh = Integer.parseInt(txt[3]);
                float diemTB = Float.parseFloat(txt[4]);

                list.add(new Student(name, age, quequan, namsinh, diemTB));

            }
        } catch (Exception e) {
            System.out.println("error");
        }

        String fileName = "FileStudents.dat";

        int[] namSinh = new int[list.size()];
        int count = 0;
        try {
            objectOutput = new ObjectOutputStream(new FileOutputStream(fileName));

            for (Student s : list
            ) {
                namSinh[count++] = s.getNamsinh();
                //        ghi FileStudents.dat
                objectOutput.writeObject(s);
//            System.out.println(s);
            }

        } catch (IOException e) {
            System.out.println("error");
        }
        sort(namSinh);
        System.out.println("sort year : " + Arrays.toString(namSinh));


//      doc FileStudents.dat
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(fileName));

        try {
            while (true) {
                Student student = (Student) objectInput.readObject();
                System.out.println(student.toString());
            }
        } catch (Exception e) {
            System.out.println("error");
        }

    }

    public static void sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
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
}


