package streamApi;

import exercise4.Student;

interface MyFunctionalInerface{
     
     Student getStudent( 
        String name,
        int age,
        String quequan,
        int namsinh,
        float diemTB);
}
public class ContructerReferrntWithOneArgument {
    public static void main(String[] args) {
        MyFunctionalInerface mf = Student :: new;

        System.out.println(mf.getStudent("name", 20, "quequan", 2002, 9));

        // BiFunction<String,Integer,Student> f1 = Student :: new;
            // BiFunction<String,
    }
}

