import java.util.ArrayList;
import java.util.List;

public class javaBasic1 {
    public static void main(String[] args) {
//        int [] a =new int[3];
//        a = new int[]{1, 2};
//        int [] b = new int[a.length];
//        b = a;
//        a[0] = 100;
//        System.out.println(b[0]);

//        BAI 2
//        int x=10, y=100;
//        swap(x,y);//
//        System.out.println(x+";"+ y);
//        int [] A={10,100};
//        swapFirstTwoInArray(A);
//        System.out.println(A[0]+";"+ A[1]);

//        BAI 3
//        char [] [] Student ={
//                {'A','B','C','D','E','A','B','C','D','E'},
//                {'A','A','C','D','E','A','B','C','D','E'},
//                {'A','C','C','D','E','A','B','C','D','E'},
//                {'A','D','C','D','E','A','B','C','D','E'},
//                {'A','E','C','D','E','A','B','C','D','E'},
//        };
//        char[] key={'A','B','C','D','E','A','B','C','D','E'};
//        List<Integer> score = new ArrayList<Integer>();
//
//        for ( char [] c : Student
//             ) {
//           int num = ex3(c,key);
////            System.out.println("diem : " + num);
//            score.add(num);
//        }
//        System.out.println(score);


//        TEST
//        byte test = (byte) 999;
//        System.out.println(test);

//        BAI 4
//        String s = "Hoang Nguyen Tuan Anh";
//
////        C1
//        StringTokenizer tokenizer = new StringTokenizer(s);
//        String [] arr = new String[tokenizer.countTokens()];
//        int length = tokenizer.countTokens()-1;
//        while (tokenizer.hasMoreTokens()) {
//
//            arr[length--] = tokenizer.nextToken();
//        }
//        System.out.println(Arrays.toString(arr));
//
//
////        C2
//        String[] newArr = s.split(" ");
//        StringBuilder newStr = new StringBuilder();
//        for (int i = newArr.length-1; i >=0 ; i--) {
//            newStr.append(newArr[i]).append(" ");
//        }
//        System.out.println(newStr);
//
////        C3
//        int i = s.trim().lastIndexOf(" ");
//        System.out.println(s.substring(i+1) + " " + s.substring(0,i));
//
////        C4

        //        System.out.println(Calendar.getInstance());

//
//BAI 5

//        int n=1273;
//        if(isPrimeNumber(n)){
//            System.out.println("n la so nguyen to");
//        }else {
//            System.out.println("n khong la so nguyen to");
//        }

//        BAI 6
//        dãy tăng dần
////        C1
//        int [] A={5, 7, 9, 10,16};
//        int a = 1;
//        for (int i = 0; i < A.length-1; i++) {
//            if (A[i] >= A[i+1]){
//                System.out.println("A khong la day tang dan");
//                return;
//            }else {
//                a++;
//            }
//        }
//
//        if(a == A.length){
//            System.out.println("A la day tang dan");
//        }


//         dãy đan dấu
        int B[] = {5, -1, 9, -10, 16};
        int count = 0;
        int num = 0;
        if (B[0] < 0) num = -1;

        for (int b : B
        ) {
            if (b > 0) {
                count++;
            } else {
                count--;
            }
        }


//        C đều là số nguyên tố hay ko?
        int[] C = {5, 1, 9, 10, 16};


//        Bai 5
        int[] A = {5, 7, 1, 9, 10, 16, 4, 6, 8, 13, 17, 20, 22, 23, 24};

        int checkMax = 1;
        int countArr = 1;
        int index = 0;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                countArr++;
            } else {
                if (countArr > checkMax) {
                    index = i;
                    checkMax = countArr;
                    countArr = 1;
                }
            }
        }
//        System.out.println(index);
//        System.out.println(index + 1 - checkMax);
        List<Integer> list = new ArrayList<>();
        for (int i = index + 1 - checkMax; i <= index; i++) {
            list.add(A[i]);
        }
        System.out.println("độ dài của dãy con tăng dần dài nhất : " + checkMax);
        System.out.println("dãy con tăng dần dài nhất : " + list);

    }


    public static boolean equals(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int ex3(char[] student, char[] key) {
        int result = 0;
        for (int i = 0; i < key.length; i++) {
            if (student[i] == key[i]) {
                result += 1;
            }
        }
        return result;
    }

    public static void swapFirstTwoInArray(int[] array) {
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

    public static void swap(int n1, int n2) {//
        int temp = n1;
        n1 = n2;
        n2 = temp;
    }


}