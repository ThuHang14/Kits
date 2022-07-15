package exercise3;

public class CustomQueue {
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        q.peek();
        q.dequeue();
        q.peek();


        System.out.println("size : " + q.size());

        q.dequeue();
        q.dequeue();

        if (q.isEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }
    }
}
class Queue
{
    private int[] arr;
    private int firt;
    private int child;
    private int lengthQueue;
    private int count;

    Queue(int size)
    {
        arr = new int[size];
        lengthQueue = size;
        firt = 0;
        child = -1;
        count = 0;
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            System.out.println("isEmpty");
            System.exit(-1);
        }

        int x = arr[firt];

        System.out.println("Removing " + x);

        firt = (firt + 1) % lengthQueue;
        count--;

        return x;
    }

    public void enqueue(int item)
    {

        if (isFull())
        {
            System.out.println("is Full");
            System.exit(-1);
        }
        System.out.println("enqueue : " + item);
        child = (child + 1) % lengthQueue;
        arr[child] = item;
        count++;
    }

    public void peek()
    {
        if (isEmpty())
        {
            System.out.println("is Empty");
            System.exit(-1);
        }
        System.out.println("peek : " + arr[firt]);
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return (size() == lengthQueue);
    }
}
