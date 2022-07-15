package exercise3;

import java.util.*;

public class ex3Main {
    public static void main(String[] args) {
c3_2();
    }
    public static void c3_2(){
        int [] A={5, 1, 9, 10,160, -13,-2,-1,0};
        int [] arrLength = new int[A.length];
        String [] arrItem = new String[A.length];
        int [] sum = new int[A.length];
        sum[0] = A[0];
        String item = " "+A[0];

        int count = 0;
        int maxItem = 1;

        for (int j=0, i = 1; i < A.length; i++,j++) {
            if(A[j] > A[i]){
                arrItem[count] = item;
                arrLength[count++] = maxItem;
                item = " "+A[i];
                sum[count] += A[i];
                maxItem = 1;
            }else {
                if(sum[count]+A[i] <=100){
                item += " " + A[i];
                sum[count] += A[i];
                maxItem++; }
            }
        }


        if(A[A.length-2] > A[A.length-1]){
            arrItem[count] = String.valueOf(A[A.length-1]);
            sum[count] = A[A.length-1];
            arrLength[count++] = 1;
        }else {
            sum[count] += A[A.length-1];
            arrItem[count] = item;
            arrLength[count++] = maxItem;
        }

        System.out.println("arrLength : " + Arrays.toString(arrLength));
        System.out.println("arrItem : " + Arrays.toString(arrItem));
        System.out.println("sum : " + Arrays.toString(sum));

        while (true){
            int[] max = max(arrLength);
            if(sum[max[0]] >=20){
                System.out.println("sum : " + sum[max[0]]);
                System.out.println("arr : " + arrItem[max[0]]);
                return;
            }else {
                arrLength[max[0]] = -1;
            }

        }

    }

    public static int[] max(int [] max){
        int arr [] = new int[2];
        int maxNum = max[0];
        for (int i = 0; i <max.length ; i++) {
            if(maxNum < max[i]){
                maxNum = max[i];
                arr[0] = i;
                arr[1] = max[i];
            }
        }
        return arr;
    }
}


