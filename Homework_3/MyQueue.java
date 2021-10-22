/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date: 10/21/2021
    Instructor: Professor Silvergra
    Description: Implement a circular queue
 */
public class MyQueue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public int getSize() {
        return size;
    }
    /*
    * Constructor creates an array of size ____. Front and rear is set to `-1`
    * to show that the array is empty
    * */
    public MyQueue(int size) {
        this.size = size;
        front = -1;
        rear = -1;
        this.queue = new int[size];
    }
    /*
    * Inserts value into array. There are two special cases:
    * 1) If array is empty(Checked using the `isEmpty()`),
    * increase `front` and `rear` by 1 and add the value.
    * 2) If front is at the start of the array and rear is at end of the list, then print error message
    * because array is full(Checked using the `isFull()`)
    * Otherwise: Increase rear by 1 and change the value at index[rear].
    * */
    public void enqueue(int value) {

        if (isEmpty()) {
            front++;
            rear++;
            queue[rear] = value;
        }

        else {
            if (isFull()) {
                System.out.println("It's full, dequeue first!");
            } else {
                if (rear == (getSize() - 1)) {
                   rear = 0;
                }
                else {
                    rear++;
                }
                queue[rear] = value;
            }
        }
    }
    /*
    * Dequeue elements in a list. Basic case: Array is empty, print error statement.
    * Case 2:  Check if front is about to pass rear and print error messagae. Case 3) Else, check if `front` is at end of the list.
    * If it is, reset it to the start of the array
    * by setting `front` to zero.
    * Case 3) increase front by 1;
    * */
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("It's empty, insert first!");
        }
        else {
            if (front + 1 == rear) {
                System.out.println("Add some values before de-queuing");
            }
            else if (front == (getSize() - 1)) {
                front = 0;
            }
            else {
                front++;
            }
        }
        return 1;
    }
// Check if array is empty.
    public boolean isEmpty() {
        if (front == -1) {
            return true;
        }
        return false;
    }
//    It return true for the following cases: 1) `front` is at the start of the array(Index 0) AND rear is at end(Index size - 1)
//    2) `rear` is behind front.
//    Returns false otherwise.
    public boolean isFull() {
        if ((rear+1) % getSize() == front ) {
            return true;
        }
        else {
            return false;
        }
    }

    public void outPut() {
        for (int i = 0; i < queue.length; i++) {
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
        MyQueue intQueue = new MyQueue(4);
        intQueue.dequeue();
        intQueue.enqueue(2);
        intQueue.enqueue(4);
        intQueue.enqueue(5);
        intQueue.enqueue(9);
        intQueue.dequeue();
        intQueue.dequeue();
        intQueue.enqueue(4);
        intQueue.enqueue(3);
        intQueue.enqueue(6);
        intQueue.dequeue();
        intQueue.dequeue();
        intQueue.dequeue();
        intQueue.outPut();
    }
}
