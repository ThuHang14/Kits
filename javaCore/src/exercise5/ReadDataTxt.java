package exercise5;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadDataTxt {
    public static void main(String[] args) {
//        1 2 5 7 8
        String dataTxt = "2:19;5:1." +
                "1:5;2:1." +
                "5:1;7:8." +
                "1:8;8:4." +
                "2:1";

        Write(dataTxt,"Data.txt");
       List<String> data =  readFile("Data.txt");
//        System.out.println(data);
countData(data);

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

    public static List<String> readFile(String dataTxt){
        List<String> stringList = new ArrayList<>();

        FileInputStream fin = null;
        try {
            fin = new FileInputStream(dataTxt);
            int data = fin.read();
            StringBuilder line = new StringBuilder();
            while (data != -1) {
                if (((char) data == '.') || ((char) data == ';') || ((char) data == ':')) {
//                    System.out.println(line.toString());
                    stringList.add(line.toString());
                    line.delete(0, line.length());
                    data = fin.read();
                    continue;
                }
                line.append((char) data);
                data = fin.read();
            }
            System.out.println( line.toString());
            stringList.add(line.toString());
//            System.out.println(stringList);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null)
                    fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringList;
    }

    public static void countData(List<String> list){
        Map<String, String> map = new HashMap<>();
        try {
            for (int i = 0,j=i+1; j <list.size() ; i++,j++) {
//                System.out.println(list.get(i) + " : " + list.get(j));
                map.put(list.get(i),map.getOrDefault(list.get(i),list.get(j))+" "+list.get(j));
                i++;
            }
        } catch (Exception ignored) {

        }
        System.out.println(map);
    }
}
