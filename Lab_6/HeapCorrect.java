import java.lang.Math;
public class HeapCorrect{
    Node[] heap;
    int top;
    int size;

    public class Node{
        public String name;
        public int weight;

        public Node(String n, int w){
            name = n;
            weight = w;
        }
    }

    public HeapCorrect(int s){
        heap = new Node[s];
        top = 0;
        size =s;
    }

    public void insert(String n, int w){
        Node toInsert = new Node(n,w);
        top++;
        if(top == size){
            top--;
            System.out.println("Heap is full!");
        }
        else{
            heap[top] = toInsert;
            int counter = top;
            while( counter/2 > 0){ //Integer division
                if(heap[counter].weight < heap[counter/2].weight){
                    Node temp = heap[counter/2];
                    heap[counter/2] = heap[counter];
                    heap[counter] = temp;
                    counter = counter/2;
                }
                else break;
            }
        }
    }

    public Node remove(){
        if(top>0){
            Node toReturn = heap[1];
            heap[1] = heap[top];
            heap[top] = null;
            top--;
            int counter = 1;
            while(counter * 2 <= top){
                if(heap[counter].weight > heap[counter*2].weight ){
                    if(counter*2+1 <= top && heap[counter].weight > heap[counter*2+1].weight){
                        if(heap[counter*2].weight < heap[counter*2+1].weight){
                            //Swap with left
                            int leftChild_Weight = heap[counter*2].weight;
                            heap[counter*2].weight = heap[counter].weight;
                            heap[counter].weight = leftChild_Weight;
                            counter = counter*2;
                        }
                        else{
                            //Swap with right
                            int rightChild_Weight = heap[counter*2+1].weight;
                            heap[counter*2+1].weight = heap[counter].weight;
                            heap[counter].weight = rightChild_Weight;
                            counter = counter*2+1;
                        }
                    }
                    else{
                        //Swap with left
                        int leftChild_Weight = heap[counter*2].weight;
                        heap[counter*2].weight = heap[counter].weight;
                        heap[counter].weight = leftChild_Weight;
                        counter = counter*2;
                    }
                }
            }
            return toReturn;
        }

        else{
            System.out.println("Heap is empty!");
            return null;
        }
    }

    public void displayHeap() {
        if (top > 0) {
            for (int i = 1; i <= top; i++) {
                System.out.print(heap[i].weight + " |");
            }
        }
        else {
            System.out.println("Heap is empty!");
        }
    }

    public static void main(String[] args) {
        HeapCorrect testHeap = new HeapCorrect(12);

        testHeap.insert("Bird", 9);
        testHeap.insert("Bird", 10);
        testHeap.insert("Bird", 2);
        testHeap.insert("Bird", 5);
        testHeap.insert("Bird", 4);
        testHeap.insert("Bird", 12);
        System.out.println(testHeap.remove());

        testHeap.displayHeap();
    }

}
