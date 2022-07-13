package exercise2;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Ex2 {
    public int[] sort2 (int[] arr,int newNumber){
        int [] newArr = new int[arr.length+1];

        if(newNumber > arr[arr.length-1]){
            newArr = arr.clone();
            newArr[newArr.length-1] = newNumber;
        } else if (newNumber < arr[0]) {
            newArr[0] = newNumber;
            for (int i = 0,j=1; i <arr.length ; i++,j++) {
                newArr[j] = arr[i];
            }

        } else  {
            for (int j = 0,i=0; j <arr.length ; j++) {
                if(newNumber < arr[j]){
                    newArr[i++] = newNumber;
                    newArr[i++] = arr[j];
                    newNumber = arr[arr.length-1]+10;
                }else {
                    newArr[i++] = arr[j];
                }
            }
        }

        return newArr;
    }

    public int[] sortC3(int [] a){
        for (int i = a.length; i <=0 ; i--) {
            for (int j = i+1; j <=0 ; j--) {
                if(a[j] > a[i]){
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        return a;
    }

   public int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            return binarySearch(arr, mid + 1, r, x);
        }

        return -1;
    }

   public void findMaxLenghtEven(int[] arr){
        int count = 0;
        int index = 0;
        int maxLenght = 0;
        int firtIndex = 0;

        String arrEventStr = "";
       for (int i = 0; i < arr.length; i++) {
           if(arr[i] % 2 == 0 ){
               count++;
           } else if (arr[i] % 2 != 0) {
               if(maxLenght < count) {
                   maxLenght = count;
                   index = i;
                   firtIndex = index - maxLenght;
               }
               count = 0;
           }
       }
       if(count > maxLenght){
           maxLenght = count;
           index = arr.length;
           firtIndex = index - maxLenght;
       }
       System.out.println("max : " + maxLenght);
       System.out.println("firtIndex : " + firtIndex);
       System.out.println("index : " + index);

       if(maxLenght == 1){
           System.out.println(arr[firtIndex]);
           return;
       }else{
       for (int i = firtIndex; i <index ; i++) {
           arrEventStr += arr[i] + " ";
       }

       System.out.println(arrEventStr); }
   }

    public void ascendingMaxAndIndex(int[] D) {
        int key = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < D.length-1; i++) {
            if(D[i] > D[i++]){
//                tao key moi roi add vao
                key ++;
                map.put(key,map.getOrDefault(key, 0));
            }else {
                map.put(key,D[i]);
            }
        }

        System.out.println(map);
    }

}
