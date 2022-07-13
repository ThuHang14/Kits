package exercise2;

import java.util.Arrays;

public class mainEx2 {
    public static void main(String[] args) {
        Ex2 ex2 = new Ex2();
        int [] A = {1,5,6,9,11,20,25};
//        System.out.println(Arrays.toString(ex2.sort2(A, 10)));
//        System.out.println(Arrays.toString(ex2.sort2(A, 30)));
//        System.out.println(Arrays.toString(ex2.sort2(A, 0)));

        int arr[] = { 2, 4, 9, 10, 11, 22, 24, 31, 48, 56, 76, 86 };
        int result = ex2.binarySearch(arr, 0, arr.length-1, 99);
//        if (result == -1)
//            System.out.println("Phần tử không tồn tại.");
//        else
//            System.out.println("Phần tử được tìm thấy tại vị trí: " + result);


        int[] B = {1,6,89,22,5,65,48,9};
//        System.out.println(Arrays.toString(ex2.sortC3(B)));

//Cho mảng int [] A={5, 1, 9, 10, 16, 4,6, 8, 3}.  Hãy xác định và in dãy con có các số chẵn liên tiếp dài nhất
        int [] C={101, 161, 41,6, 1, 2,5, 1, 9, 101, 161, 41,6, 81, 2,2};
//        ex2.findMaxLenghtEven(C);

//        Cho mảng int [] A={5, 1, 9, 10,16, 4,6, 8, 3}. Hãy xác định và in dãy con tăng dần dài nhất có tổng các phần tử lớn hơn 20 nho hon 100
        int [] D={1, 9, 10,160,5, 4,6, 8, 3};
        ex2.ascendingMaxAndIndex(D);
    }

}
