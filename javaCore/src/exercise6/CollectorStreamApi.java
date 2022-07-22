package exercise6;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class CollectorStreamApi {
    public static void main(String[] args) throws IOException {
        Map<Integer, MinMax> hm = new HashMap<>();
        try {
            readFromFile("Data.txt");
            // Ghi ra
            Write(hm, "Out.txt");
        } catch (IOException ex) {
            Logger.getLogger(CollectorStreamApi.class.getName()).log(Level.SEVERE, null, ex);
        }

        // read
        BufferedReader bw = new BufferedReader(new FileReader("Out.txt"));
        System.out.println(bw.readLine());

    }

    private static void Write(Map<Integer, MinMax> hm, String file) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            int count = 0;

            for (var s : hm.entrySet()) {
                count++;
                bw.write(s.getKey() + " : " + s.getValue().getMax() + " " + s.getValue().getMin());
                bw.newLine();

            }

            bw.write("size : " + hm.size());
            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }

    }

    static void readFromFile(String fName) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fName));
        Map<Integer, String> el = new HashMap<>();

        String st = br.readLine();
        while (st != null) {
            // xử lý
            st = st.replace(".", "");
            String[] arr = st.split(";"); // id: amount;

            for (int i = 0; i < arr.length; i++) {
                String[] id_amount = arr[i].split(":");
                int key = Integer.parseInt(id_amount[0]);
                String values = id_amount[1];
                if (el.containsKey(key)) {
                    values = el.get(key) + " " + values;
                    el.replace(key, values);

                } else {
                    el.put(key, values);
                }
            }

            st = br.readLine();
        }
//        System.out.println(el);
        for (var s : el.entrySet()
        ) {
            if (s.getValue().length() > 1) {
                List<String> arrStr = List.of(s.getValue().split(" "));
                List<Integer> listOfInteger = convertStringListToIntList(
                        arrStr,
                        Integer::parseInt);
//                System.out.println(listOfInteger);
                Integer min = listOfInteger.stream().min(Integer::compare).get();
                Integer max = listOfInteger.stream().max(Integer::compare).get();
//                System.out.println(min + " " +max);
                String values = min + " " + max;
                s.setValue(values);
            }
        }

        System.out.println(el);
    }

    public static <T, U> List<U>
    convertStringListToIntList(List<T> listOfString,
                               Function<T, U> function) {
        return listOfString.stream()
                .map(function)
                .collect(Collectors.toList());
    }
}

//1 : 8 5
//2 : 19 1
//5 : 1 1
//7 : 8 8
//8 : 4 4