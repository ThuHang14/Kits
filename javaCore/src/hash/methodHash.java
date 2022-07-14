package hash;

public class methodHash {
    public int[] sortC1(int [] a){
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

    public int[] sortC2(int [] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1 ; j <a.length ; j++) {
                if(a[j] < a[i]){
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
        return a;
    }

    public int [] push(int [] arr,int push){
       int [] newArr = new int[arr.length+1];
        for (int i = 0; i <arr.length ; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = push;
        return newArr;
    }
    public int [] pop(int [] arr){
        if(arr.length == 1){
            int [] a = new int[0];
            return a;
        }else {
       int newArr [] = new int[arr.length-1];
        for (int i = 0; i <arr.length-1 ; i++) {
            newArr[i] = arr[i];
        }
        return newArr; }
    }

    public int binarySearch(int [] arr,int search,int start,int end){
        int length = start+end/2;
        if(arr[length] > search){
            if(arr[length] == search) return length;
            if(arr[end] == search) return end;
            else {
               return binarySearch(arr,search,0,length-1);
            }
        }else {
            if(arr[length] == search) return length;
            if(arr[start] == search) return start;
            else {
               return binarySearch(arr,search,length+1,arr.length-1);
            }
        }
    }


}
