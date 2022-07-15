
package serialJavaBean.serialJavaBean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String outputFile = "C:\\Users\\MULTICAMPUSPC\\Desktop\\Kits\\javaCore\\src\\serialJavaBean\\serialJavaBean\\serialJavaBean.rar";
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
        ObjectOutputStream objectOutput = null;
        try {
            objectOutput = new ObjectOutputStream(new FileOutputStream(outputFile));

            Student st1 = new Student("Hoten", dateFormat.parse("10-10-1977"), false, 23, 80.5f);
            Student st2 = new Student("Hoten", dateFormat.parse("10-10-1977"), false, 23, 80.5f);


            objectOutput.writeObject(st1);

            List<Student> listStudent = new ArrayList<Student>();
            listStudent.add(new Student("Alice", dateFormat.parse("02-15-1993"), false, 23, 80.5f));
            listStudent.add(new Student("Brian", dateFormat.parse("10-03-1994"), true, 22, 95.0f));
            listStudent.add(new Student("Carol", dateFormat.parse("08-22-1995"), false, 21, 79.8f));

            for (Student student : listStudent) {
                objectOutput.writeObject(student);
            }

        } catch (IOException e) {
        } catch (ParseException ex) {
            ex.printStackTrace();
        } finally {
            objectOutput.close();
        }
    }
}

