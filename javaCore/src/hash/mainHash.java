package hash;

import java.util.Arrays;

public class mainHash {
    public static void main(String[] args) {
        methodHash methodHash = new methodHash();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        arr = methodHash.push(arr, 10);
        arr = methodHash.push(arr, 11);
        arr = methodHash.pop(arr);
//        System.out.println(Arrays.toString(arr));

        Stack Stack = new Stack(5);
        Stack.push(1);
        Stack.push(1);
        Stack.push(1);
        Stack.push(1);
        Stack.push(1);
//        Stack.push(1);
//        System.out.println(Stack.pop());

//        System.out.println( methodHash.binarySearch(arr,8,0, arr.length-1));

        int[] a = {1,6,89,22,5,65,48,9};
        System.out.println(Arrays.toString(methodHash.sortC2(a)));
        System.out.println(Arrays.toString(methodHash.sortC1(a)));
    }
}

class Stack {
    int top;
    int[] A;

    Stack(int size) {
        top = -1;
        A = new int[size];
    }

    void push(int x) {
        if (top >= A.length - 1) {
            System.out.println("stack full");
            return;
        }
        top += 1;
        A[top] = x;
    }

    int pop() {
        if (top < 0) {
            System.out.println("empty");
        }
        top = -1;
        return A[top + 1];
    }

    int peek() {
        if (top >= 0) {
            return A[top];
        }
        return -1;
    }
}

