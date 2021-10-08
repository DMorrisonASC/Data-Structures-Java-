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
//    Constructor for SortedDoubleList class
    public SortedDoubleList() {
        head = new DoubleNode(null);
        tail = new DoubleNode(null);

        head.next = tail;
        tail.previous = head;
        size = 0;
    }
//      "Getter" function for size
    public int size() {
        return this.size;
    }
//        Increases size by 1
    public void addSizeByOne() { size++; }
//        Decreases size by 1
    public void subtractSizeByOne() { size--; }
//        Checks if list is empty. Its empty when head and tail are pointing to each other.
    public boolean empty() {
        if (head.next == tail) {
            return true;
        }
        return false;
    }
//        Retrieves the object stored in the node pointed to by the head pointer. This function returns null if the list is empty. (O(1))
    public T front() {
        if (empty()) {
            return null;
        }
        return head.next.node_value;
    }
//        Retrieves the object stored in the node pointed to by the tail pointer. This function returns null if the list is empty. (O(1))
    public T back() {
        if (empty()) {
            return null;
        }
        return tail.previous.node_value;
    }
//        Returns the number of nodes in the linked list storing a value equal to the argument. (O(n))
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
/*
Creates a new DoubleNode<Type> storing the argument,
placing it into the correct location in the linked list such
that the element in the previous node (if any) is less than or
equal to the element stored in the current node, and that element
is less than or equal to the element stored in the next node.
The head and tail pointers may have to be updated if
the new node is placed at the head or tail of the linked list. (O(n))
 */
    public void insert(T obj) {
//        Create a node that has a value of `obj`
        DoubleNode put_value = new DoubleNode(obj);
//         IF list is empty, put a value between head and tail.
        if (empty()) {
            put_value.next = tail;
            put_value.previous = head;

            tail.previous = put_value;
            head.next = put_value;

            addSizeByOne();
        }
/*
        ELSE Creates a new DoubleNode<Type> storing the argument, placing it into the correct
        location in the linked list such that the element in the previous node
        is less than or equal to the element stored in the current node,
        and that element is less than or equal to the element stored in the next node;
        Sort the nodes in the list from least to greatest(left to right).
*/
        else {
//            Start at the tail
            DoubleNode traverse = tail;
//            Keep moving through the list from right to left, until it finds a node value that is less than obj
//            then end function by returning
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
//            If there is none, the node(`obj`) is placed at the end because it's the smallest value. Also, increase
//            size by one.
            put_value.previous = head;
            put_value.next = traverse;

            traverse.previous = put_value;
            head.next = put_value;
            addSizeByOne();
        }
    }
/*
* Delete the node at the front of the linked list and,
* as necessary, update the head and tail pointers and the previous pointer of any other node within the list. Return the
* object stored in the node being popped. Return null if the list is empty. (O(1))
* */
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
            subtractSizeByOne();
            return frontDouble.node_value;
        }
    }
/*
* Similar to pop_front, delete the last node in the list. This function returns null if the list is empty. (O(1))
* */
    public T pop_back() {
        if (empty()) {
            return null;
        } else {
            DoubleNode frontDouble = tail.previous;

            tail.previous = frontDouble.previous;
            frontDouble.previous.next = tail;

            frontDouble.next = null;
            frontDouble.previous = null;
            subtractSizeByOne();
            return frontDouble.node_value;
        }
    }
/*
* Delete the all nodes in the linked list that contains the object equal to the argument.
* As necessary, update the head and tail pointers and the previous and next pointers of any other node within the list.
* Return the number of nodes that were deleted. (O(n))
* */
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
                    subtractSizeByOne();
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
/*
* Also, implement the inner class DoubleNode.
A doubly linked node contains three member variables: a value and two pointers, each of which points to another
*  doubly linked node.
* */
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
/*
* Compares generic values. Compare assumes that if `temp1Int` is a int or string, `temp2` is the same type. Example,
* it compares int vs int & string vs string, and not int vs string.
* */
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
