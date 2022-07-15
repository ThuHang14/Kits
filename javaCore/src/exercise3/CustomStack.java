package exercise3;

import org.w3c.dom.Node;

public class CustomStack {
    public static void main(String[] args) {
        NodeStacks stack = new NodeStacks(2);
        stack.push(2);
        stack.push(2);
        stack.push(2);
        System.out.println(stack.size());

    }
}

class NodeStacks {
    int top;
    int[] A;

    NodeStacks(int size) {
        top = -1;
        A = new int[size];
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

     int size(){
        return A.length;
    }
     boolean isEmpty(){
        return A.length == 0;
    }

    void push(int x) {
        if (top >= A.length - 1) {
            System.out.println("stack full");
            return;
        }
        top += 1;
        A[top] = x;
    }
}