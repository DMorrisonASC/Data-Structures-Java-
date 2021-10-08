/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date:
    Instructor: Professor Silveyra
    Description:
 */
public class SortedDoubleList<T> {
    private DoubleNode head;
    private DoubleNode tail;
    private int size;

    public SortedDoubleList() {
        head = new DoubleNode(null);
        tail = new DoubleNode(null);

        head.next = tail;
        tail.previous = head;
        size = 0;
    }

    public int size() {
        return this.size;
    }
    public void addSizeByOne() { size++; }

    public boolean empty() {
        if (head.next == tail) {
            return true;
        }
        return false;
    }

    public T front() {
        if (empty()) {
            return null;
        }
        return head.next.node_value;
    }

    public T back() {
        if (empty()) {
            return null;
        }
        return tail.previous.node_value;
    }

    public int count(T obj) {
        DoubleNode traverse = head;
        int counter = 0;

        while (traverse.next != tail) {
            traverse = traverse.next;
//            Check if `obj` equals the `node_value` of current doubleNode
            if (compareTo(traverse.node_value, obj) == 0 ) {
                counter++;
            }
        }
        return counter;
    }

    public void insert(T obj) {
        DoubleNode put_value = new DoubleNode(obj);
        if (empty()) {
            put_value.next = tail;
            put_value.previous = head;

            tail.previous = put_value;
            head.next = put_value;

            addSizeByOne();
        }
        else {
            DoubleNode traverse = tail;
            while (traverse.previous != head) {
                traverse = traverse.previous;
                if (compareTo(obj, traverse.node_value) == 1) {
                    put_value.previous = traverse;
                    put_value.next = traverse.next;

                    traverse.next.previous = put_value;
                    traverse.next = put_value;
                    addSizeByOne();
                    return;
                }
            }

            put_value.previous = head;
            put_value.next = traverse;

            traverse.previous = put_value;
            head.next = put_value;
            addSizeByOne();
        }
    }

    public T pop_front() {
        if (empty()) {
            return null;
        }
        else {
            DoubleNode frontDouble = head.next;

            head.next = frontDouble.next;
            frontDouble.next.previous = head;

            frontDouble.next = null;
            frontDouble.previous = null;

            return frontDouble.node_value;
        }
    }

    public T pop_back() {
        if (empty()) {
            return null;
        } else {
            DoubleNode frontDouble = tail.previous;

            tail.previous = frontDouble.previous;
            frontDouble.previous.next = tail;

            frontDouble.next = null;
            frontDouble.previous = null;

            return frontDouble.node_value;
        }
    }
    public int erase(T obj) {
        int nodesRemoved = 0;
        if (empty()) {
            return nodesRemoved;
        }
        else {
            DoubleNode traverse = tail;
            while (traverse.previous != head) {
                traverse = traverse.previous;
                if (compareTo(obj, traverse.node_value) == 0) {
                    DoubleNode eraseThisNode = traverse;
                    traverse = traverse.next;
                    eraseThisNode.previous.next = eraseThisNode.next;
                    eraseThisNode.next.previous = eraseThisNode.previous;

                    eraseThisNode.next = null;
                    eraseThisNode.previous = null;
                    nodesRemoved++;
                }
            }
            return nodesRemoved;
        }
    }

//    Print all the values of the double nodes
    public void checkLinkedList() {
        DoubleNode traverse = head.next;
        while (traverse.node_value != null) {
            System.out.println(traverse.node_value);
            traverse = traverse.next;
        }
    }

    public class DoubleNode {
        T node_value;
        DoubleNode previous;
        DoubleNode next;

        public DoubleNode(T obj) {
            node_value = obj;
            previous = null;
            next = null;
        }
        public T value() {
            return node_value;
        }
    }

    public static void main(String[] args) {
//        SortedDoubleList <String> temp = new SortedDoubleList <String> ();
        SortedDoubleList<Integer> intLinkedList = new SortedDoubleList<Integer>();

        intLinkedList.insert(55);
        intLinkedList.insert(102);
        intLinkedList.insert(8);
        intLinkedList.insert(2);
        intLinkedList.insert(99);
        intLinkedList.insert(1);
        intLinkedList.insert(1);
        intLinkedList.insert(20);

        System.out.println(intLinkedList.size());
        System.out.println(intLinkedList.empty());
        System.out.println(intLinkedList.count(1));

        System.out.println();
        System.out.println(intLinkedList.erase(1));
//        System.out.println(intLinkedList.pop_front());
//        System.out.println(intLinkedList.pop_front());
//        System.out.println(intLinkedList.pop_back());
//        System.out.println(intLinkedList.pop_back());
        System.out.println();
        intLinkedList.checkLinkedList();
    }

    public int compareTo(T a, T b) {
        String temp1 = a.toString();
        String temp2 = b.toString();

            if (temp1.matches("-?(0|[1-9][0-9]*)")) {
                //It is an integer! Convert the string to integer and compare it by using
                // > and <. Use a similar notation to the one used by compareTo (If first is greater than second
                // return a positive value, if they are the same return 0, else return a negative value)
                int temp1Int = Integer.parseInt(temp1);
                int temp2Int = Integer.parseInt(temp2);

                if (temp1Int == temp2Int) {
                    return 0;
                } else if (temp1Int > temp2Int) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                // It is a String. Compare the string with the compareTo method (look online
                // in case you don't know how it works)
                return temp1.compareTo(temp2);
            }
        }
}


/*
    public void test(T w){
        //Example of how to use the method compareTo
        // Important! This method does NOT do anything right now because the list is empty
        // This is an example of how you could use your method CompareTo if there is at least one node inserted.
        DoubleNode toInsert = new DoubleNode(w);
        DoubleNode traverse = head;
        int answer = compareTo(traverse.value(),toInsert.value());
        //Answer has the numberical value of comparing the 2 nodes
        System.out.println(answer);
    }
*/
