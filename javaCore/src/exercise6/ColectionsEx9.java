package exercise6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


class Element {

    int id, amount;

    Element(String id, String amount) {
        this.id = Integer.parseInt(id.trim());
        this.amount = Integer.parseInt(amount.trim());
    }
}

class MinMax {
    private int min;
    private int max;

    MinMax(int m) {
        min = max = m;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}

public class ColectionsEx9 {

    public static void main(String[] args) throws IOException{
        Map<Integer, MinMax> hm = new HashMap<>();
        try {
            readFromFile("Data.txt", hm);
            // Ghi ra file
            Write(hm, "Out.txt");
        } catch (IOException ex) {
            Logger.getLogger(ColectionsEx9.class.getName()).log(Level.SEVERE, null, ex);
        }

        // read
        BufferedReader bw = new BufferedReader(new FileReader("Out.txt"));
        System.out.println(bw.readLine());

    }

    private static void Write(Map<Integer, MinMax> hm, String file) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            int count = 0;

            for (var  s   : hm.entrySet()) {
                count++;
                bw.write(s.getKey() + " : " + s.getValue().getMax() + " " + s.getValue().getMin() );
                bw.newLine();

            }

            bw.write("size : " + hm.size());
            bw.close();

        } catch (Exception e) {
            System.out.println("error");
        }

    }

    static void readFromFile(String fName, Map<Integer, MinMax> hm) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(fName));
        String st = br.readLine();
        while (st != null) {
            // xử lý
            st = st.replace(".", "");
            String[] arr = st.split(";"); // id: amount;
            for (int i = 0; i < arr.length; i++) {
                String[] id_amount = arr[i].split(":");
                Element el = new Element(id_amount[0], id_amount[1]);
                MinMax mm = hm.get(el.id);
                if (mm == null)
                    hm.put(el.id, new MinMax(el.amount));
                else {
                    if (el.amount < mm.getMin())
                        mm.setMin(el.amount);
                    if (el.amount > mm.getMax())
                        mm.setMax(el.amount);
                }
            }
            st = br.readLine();
        }
    }

}
