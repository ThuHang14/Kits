package exercise1;

import java.util.ArrayList;
import java.util.List;

public class methodEx1 {
    public boolean ascending(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] >= arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkNum(int[] B) {
        for (int i = 0; i < B.length - 1; i++) {
            if (B[i] > 0 && B[i + 1] > 0 || B[i] < 0 && B[i + 1] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public String ascendingMax(int[] D) {
        String arrMax = "";
        int count = 1;
        int index = 0;
        int max = 1;

        for (int i = 0, k = 1; k <= D.length-1; i++,k++) {
            if (D[i] < D[k]) {
                count++;
            }
           else  if (D[i] > D[k] && max < count ) {
                max = count;
                index = i;
                count = 1;
            }
        }
        if ( max < count ) {
            max = count;
            index = D.length-1;
        }
//        System.out.println(max);
//        System.out.println(index);

        for (int i = index - max +1; i <=index ; i++) {
            arrMax += D[i] + " ";
        }
        return arrMax;
    }
}
