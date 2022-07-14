package test;

import java.util.*;
import java.util.stream.Collectors;

public class test<entry> {
    public  int mathNum(int n ){
        return n % 10;
    }
    public int mathNum2(int n ){
        return n / 10;
    }

    public void isHappy (int n ) {
        System.out.println(n);
        int sum = 0;
        while (n > 0){
            sum += n%10;
            n /= 10;
            System.out.println("sum : " +sum + " - n : " + n);
        }
    }

    public int mathNum3(int n) {
        int result = 0;

        while (n > 0) {
            result += (n % 10) * (n % 10);
            n /= 10;
        }

        return result;
    }

    public void frequencySort(int[] nums){
        int[] arr =new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int s : nums
             ) {
            map.put(s,map.getOrDefault(s,0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (a,b) -> a.getValue() == b.getValue() ? a.getKey() - b.getKey() : a.getValue() - b.getValue());

       int count = 0;
        for (var s : list
             ) {
            while (s.getValue() != 0){
                arr[count++] = s.getKey();
                s.setValue(s.getValue()-1);
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public String largestNumber(int[] nums) {
        String sum = "";
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        System.out.println(Arrays.toString(str));
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        System.out.println(Arrays.toString(str));

        for (int i = 0; i < str.length ; i++) {
            sum+= str[i];
        }
        if(str[0].equals("0")){
            return "0";
        }
        System.out.println(sum);
        return sum;
    }

    public boolean arrTang(int [] A){
        if(A[A.length-1] > A[A.length-2]) {
            System.out.println("khong phai day tang dan");
            return false; }
        else {
        for (int i = 0; i < A.length-1; i++) {
            if(A[i] >= A[i++]) {
                System.out.println("khong phai day tang dan");
                return false;
            }
        } }
        System.out.println("la day tang dan");
        return true;
    }
}
