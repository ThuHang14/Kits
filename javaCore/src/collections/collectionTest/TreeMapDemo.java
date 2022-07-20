///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package collections.collectionTest;
//
//
//
//import exercise4.Student;
//
//import java.util.Comparator;
//import java.util.Map;
//import java.util.TreeMap;
//
///**
// *
// * @author MULTICAMPUSPC
// */
//public class TreeMapDemo {
//     static class compareEmployee implements Comparator<Employee2> {
//
//        public int compare(Employee2 a, Employee2 b) {
//            return a.getFirstName().compareTo(b.getFirstName());
//        }
//    }
//
//    public static void main(String[] args) {
//        Map<Employee2, Double> emp = new TreeMap<>();
//
//        emp.put(new Employee2("Tuan", "Hoang", dateFormat.parse("2007-12-03"));
//        emp.put(new Employee2("Do", "Ngo", dateFormat.parse("2005-06-20"));
//
//
////        Employee2 employee1 = new Employee2("Tuan", "Hoang", dateFormat.parse("2007-12-03"));
////        Employee2 employee2 = new Employee2("Do", "Ngo", dateFormat.parse("2005-06-20"));
////        Employee2 employee3 = new Employee2("Hang", "Nguyen", dateFormat.parse("2009-01-31"));
////        Employee2 employee4 = new Employee2("Nguyen", "Luu", dateFormat.parse("2005-05-12"));
//        // System.out.println("Sorted by code" + stu);
//
//        Student st_key1 = new Student("A06338", "AA"); // code, name, score
//        boolean kt = stu.containsKey(st_key1);//
//        if (kt) {
//            System.out.println("Found key");
//        } else {
//            System.out.println("Not Found keye");
//        }
//        // Tìm kiếm điểm TB theo mã sinh sinh
//        Student st_ = new Student("A06338", "");
//        Double dtb = stu.get(st_);
//        if (dtb != null) {
//            System.out.println(dtb);
//        }
//
//        // Thay doi cach so sanh
//        SortedMap<Student, Double> sortByScore; // sap xep lai theo score
//        sortByScore = new TreeMap<Student, Double>(
//                new Comparator<Student>() {
//            public int compare(Student a, Student b) {
//                return a.getName().compareTo(b.getName());
//            }
//        });
//        sortByScore.putAll(stu);
//
//        //  System.out.println("Sorted by score:" + sortByScore);
//        System.out.println("====================");
//        // Bo sung contains theo score
//        kt = sortByScore.containsKey(st_key1);// tim kiem tren cay
//        if (kt) {
//            System.out.println("Found key");
//        } else {
//            System.out.println("Not Found key");
//        }
//
//        st_ = new Student("", "AA");
//        dtb = sortByScore.get(st_);
//        if (dtb != null) {
//            System.out.println(dtb);
//        }
//        sortByScore.put(new Student("A05726-123", "AA"), 8.9);
//
//        for (Student st : sortByScore.keySet()) {
//            Double dtb1 = sortByScore.get(st);
//            System.out.println(st.toString() + ", " + dtb1);
//        }
//
//    }
//
//}
