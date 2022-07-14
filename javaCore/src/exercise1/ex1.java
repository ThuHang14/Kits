package exercise1;

public class ex1 {
    public static void main(String[] args) {
        int [] A={5, 7, -19, 10,16};
        int [] B={5, -1, 9, -10,16,-1};
        int [] C={5, 1, 9, 10, 16};

        methodEx1 methodEx1 = new methodEx1();

//        1.1
//        if(methodEx1.ascending(A)){
//            System.out.println("day tang dan");
//        }else {
//            System.out.println("khong la day tang dan");
//        }

//        1.2
//        if(methodEx1.checkNum(B)){
//            System.out.println("day doi so");
//        }else {
//            System.out.println("khong la day doi so");
//        }
//    1.3
//        for (int c : C
//             ) {
//            if(!methodEx1.isPrimeNumber(c)){
//                System.out.println("day khong phai la so nguyen to");
//                return;
//            }
//        }

//         Cho mảng int [] D={5, 1, 9, 10, 16, 4, 6, 8, 3}.  Hãy xác định và in dãy con tăng dần dài nhất
//        int [] D={5, 1, 9, 10, 16, 4, 6, 8, 13,23};
//        System.out.println(methodEx1.ascendingMax(D));

//         int [] A={5, 3, 7, 8, 4, 6, 8, 3}.  Hãy xác định và in tất cả các dãy con tăng dần dài nhất cùng các vị trí bắt đầu xuất hiện của nó
             int [] E={5, 1, 9, 10, 16,20,22, 4, 6, 8, 3,1, 9, 10, 16};
        int [] E2={5, 1, 9, 10, 16,20,220, 4, 6, 8, 3,1, 9, 10, 16};

//        methodEx1.ascendingMaxAndIndex(E);
        methodEx1.ascendingMaxAndIndex(E2);
    }

}
