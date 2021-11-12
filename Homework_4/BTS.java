/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date:
    Instructor: Professor Silveyra
    Description: Implements a generic binary search tree. Create a menu in which you can insert, delete, and find elements.
    Write a function to find the depth of a given node and the depth of the tree. Write the function SwapTree(). This
    function swaps the left and the right children of every node.
 */
// The following code is the heavily modified version of code provided by
public class BTS<T>{

  public class Node {
    Node right;
    Node left;
    T value;

    public Node(T abc){
      right = null;
      left = null;
      value = abc;
    }
  }

  Node root;

  public BTS(){
    root = null;
  }

  /**
   * A generic function that calls it recursive version called `insertRecursive()`
   * @param  input the a generic value given that determines what to insert(int or double or char)
   * @return void
   */
  public void insert_One(T input){
  root = insertRecursive(root, input);
}
  /**
   * A generic function that inserts primitive of int or double or char depending on type declared. It
   * @param  input the a generic value given that determines what to insert(int or double or char)
   * @param  x the a generic value given that determines what to insert(int or double or char)
   * @return The root of the tree, it has access to every node.
   */
  private Node insertRecursive(Node x, T input){
    int inputNum;
    double intDouble;
    char inputChar;
//    If it's an interger or double
    if (compareTo(input) == 0) {
      inputNum = Integer.parseInt(input.toString());
      if(x == null){
        x = new Node(input);
      }
      else if(Integer.parseInt(x.value.toString()) > inputNum){
        x.left = insertRecursive(x.left,input);
      }
      else if(Integer.parseInt(x.value.toString()) < inputNum){
        x.right = insertRecursive(x.right,input);
      }
      return x;
    }

    else if (compareTo(input) == 2) {
      intDouble = Double.parseDouble(input.toString());
      if(x == null){
        x = new Node(input);
      }
      else if(Double.parseDouble(x.value.toString()) > intDouble){
        x.left = insertRecursive(x.left,input);
      }
      else if(Double.parseDouble(x.value.toString()) < intDouble){
        x.right = insertRecursive(x.right,input);
      }
      return x;
    }
//    If it's a character
    else {
      inputChar = input.toString().charAt(0);

      if(x == null){
        x = new Node(input);
      }
      else if(x.value.toString().charAt(0) > inputChar){
        x.left = insertRecursive(x.left, input);
      }
      else if(x.value.toString().charAt(0) < inputChar){
        x.right = insertRecursive(x.right, input);
      }
      return x;
    }
  }

  /**
   * A generic function that calls it recursive version called `findNode_recur()`
   * @param  input the a generic value given that determines what to find(int or double or char)
   * @return Void
   */
  public void findNode(T input) {
    root = findNode_recur(root, input);
  }
  /**
   * A generic function that finds primitive of int or double or char depending on type declared. It
   * @param  input the a generic value given that determines what to find(int or double or char)
   * @param  x param stores a node that allows function to call it self
   * @return The root of the tree, it has access to every node. It also prints how many, if any, nodes of a requested value found.
   */
  private Node findNode_recur(Node x, T input) {
    int inputNum;
    double intDouble;
    char inputChar;
    if (compareTo(input) == 0) {
      inputNum = Integer.parseInt(input.toString());
      if (x == null) {
        System.out.println("There is NO node value present in the tree.");
        return null;
      }
      if (inputNum < Integer.parseInt(x.value.toString()) ) {
        x.left = findNode_recur(x.left, input);
      } else if (inputNum > Integer.parseInt(x.value.toString())) {
        x.right = findNode_recur(x.right, input);
      } else {
        System.out.println("There is a node value of \"" + x.value + "\" present in the tree.");
      }
      return x;
    }

    else if (compareTo(input) == 2) {
      intDouble = Double.parseDouble(input.toString());
      if (x == null) {
        System.out.println("There is NO node value present in the tree.");
        return null;
      }
      if (intDouble < Double.parseDouble(x.value.toString())) {
        x.left = findNode_recur(x.left, input);
      } else if (intDouble > Double.parseDouble(x.value.toString())) {
        x.right = findNode_recur(x.right, input);
      } else {
        System.out.println("There is a node value of \"" + x.value + "\" present in the tree.");
      }
      return x;
    }

    else {
      inputChar = input.toString().charAt(0);
      if (x == null) {
        System.out.println("There is NO node value present in the tree.");
        return null;
      }
      if (inputChar < x.value.toString().charAt(0)) {
        x.left = findNode_recur(x.left, input);
      } else if (inputChar > x.value.toString().charAt(0)) {
        x.right = findNode_recur(x.right, input);
      } else {
        System.out.println("There is a node value of \"" + x.value + "\" present in the tree.");
      }
      return x;
    }
  }
  /**
   * A generic function that calls it recursive version called `deleteNode_recur()`
   * @param  value A generic value given that determines what to delete (int or double or char).
   * @return Void
   */
  public void delete(T value) {
    root = deleteNode_recur(root, value);
  }
  /**
   * A generic function that deletes primitive of int or double or char depending on type declared. It
   * @param  node param stores a node that allows function to call it self
   * @param  value the a generic value given that determines what to delete(int or double or char)
   * @return The root of the tree, it has access to every node. It also prints how many, if any, nodes of a requested value found.
   */
  private Node deleteNode_recur(Node node, T value) {
    int inputInt;
    double inputDouble;
    char inputChar;
    if (compareTo(value) == 0) {
      inputInt = Integer.parseInt(value.toString());
      if (node == null) {
        System.out.println("There is NO such value in the tree");
        return null;
      }
      if (inputInt < Integer.parseInt(node.value.toString())) {
        node.left = deleteNode_recur(node.left, value);
      } else if (inputInt > Integer.parseInt(node.value.toString())) {
        node.right = deleteNode_recur(node.right, value);
      } else {
        if (node.left == null && node.right == null) {
          System.out.println("It had no child elements");
          node = null;
        } else if (node.left == null) {
          System.out.println("Switched places with right child");
          node = node.right;
        } else if (node.right == null) {
          System.out.println("Switched places with left child");
          node = node.left;
        } else {
          System.out.println("case");
          Node successor = findSuccessor_recur(node.right);
//
          node.value = successor.value;
//
          node.right = deleteNode_recur(node.right, successor.value);

        }
      }
      return node;
    }
    else if (compareTo(value) == 2) {
      inputDouble = Double.parseDouble(value.toString());
      if (node == null) {
        System.out.println("There is NO such value in the tree");
        return null;
      }
      if (inputDouble < Double.parseDouble(node.value.toString())) {
        node.left = deleteNode_recur(node.left, value);
      } else if (inputDouble > Double.parseDouble(node.value.toString())) {
        node.right = deleteNode_recur(node.right, value);
      } else {
        if (node.left == null && node.right == null) {
          node = null;
        } else if (node.left == null) {
          node = node.right;
        } else if (node.right == null) {
          node = node.left;
        } else {
          Node successor = findSuccessor_recur(node.right);
//
          node.value = successor.value;
//
          node.right = deleteNode_recur(node.right, successor.value);
        }
      }
      return node;
    }
    else {
      inputChar = value.toString().charAt(0);
      if (node == null) {
        System.out.println("There is NO such value in the tree");
        return null;
      }
      if (inputChar < value.toString().charAt(0)) {
        node.left = deleteNode_recur(node.left, value);
      } else if (inputChar > value.toString().charAt(0)) {
        node.right = deleteNode_recur(node.right, value);
      } else {
        if (node.left == null && node.right == null) {
          System.out.println("It had no child elements");
          node = null;
        } else if (node.left == null) {
          System.out.println("Switched places with right child");
          node = node.right;
        } else if (node.right == null) {
          System.out.println("Switched places with left child");
          node = node.left;
        } else {
          System.out.println("case");
          Node successor = findSuccessor_recur(node.right);
//
          node.value = successor.value;
//
          node.right = deleteNode_recur(node.right, successor.value);
        }
      }
      return node;
    }
  }

  private Node findSuccessor_recur(Node node) {
    if (node.left == null) {
      return node;
    }
    else {
      return findSuccessor_recur(node.left);
    }
  }

  public void findDepth(T input) {
    root = findDepth_recur(root, input, 0);
  }

  private Node findDepth_recur(Node x, T input, int depth) {
    int inputNum;
    double intDouble;
    char inputChar;
    if (compareTo(input) == 0) {
      inputNum = Integer.parseInt(input.toString());
      if (x == null) {
        System.out.println("There is NO node value present in the tree.");
        return null;
      }
      if (inputNum < Integer.parseInt(x.value.toString()) ) {
        x.left = findDepth_recur(x.left, input, depth + 1);
      } else if (inputNum > Integer.parseInt(x.value.toString())) {
        x.right = findDepth_recur(x.right, input, depth + 1);
      } else {
        System.out.println("This node has a depth of " + depth);
      }
      return x;
    }

    else if (compareTo(input) == 2) {
      intDouble = Double.parseDouble(input.toString());
      if (x == null) {
        System.out.println("There is NO node value present in the tree.");
        return null;
      }
      if (intDouble < Double.parseDouble(x.value.toString())) {
        x.left = findDepth_recur(x.left, input, depth + 1);
      } else if (intDouble > Double.parseDouble(x.value.toString())) {
        x.right = findDepth_recur(x.right, input, depth + 1);
      } else {
        System.out.println("This node has a depth of " + depth);
      }
      return x;
    }

    else {
      inputChar = input.toString().charAt(0);
      if (x == null) {
        System.out.println("There is NO node value present in the tree.");
        return null;
      }
      if (inputChar < x.value.toString().charAt(0) ) {
        x.left = findDepth_recur(x.left, input, depth + 1);
      } else if (inputChar > x.value.toString().charAt(0)) {
        x.right = findDepth_recur(x.right, input, depth + 1);
      } else {
        System.out.println("This node has a depth of " + depth);
      }
      return x;
    }
  }



  public void preorder(){
    preorderRecursive(root);
  }

  public void preorderRecursive(Node x){
    if(x == null){return;}
//    String symbol = String.valueOf(x.value);
    System.out.println(x.value);
    preorderRecursive(x.left);
    preorderRecursive(x.right);
  }

  public void inorder(){
    inorderRecursive(root);
  }

  public void inorderRecursive(Node x){
    if(x == null){return;}
    inorderRecursive(x.left);
    System.out.println(x.value);
    inorderRecursive(x.right);
  }

  public void postorder(){
    postorderRecursive(root);
  }

  public void postorderRecursive(Node x){
    if(x == null){return;}
    postorderRecursive(x.left);
    postorderRecursive(x.right);
    System.out.println(x.value);
  }

  public void printAllOrders() {
    System.out.println("Pre-order:");
    preorder();
    System.out.println("In-order:");
    inorder();
    System.out.println("Post-order:");
    postorder();
  }
  /**
   * Returns an int that can be used in generic methods to identify if a value is a int, double or char.
   *
   * @param  a  a generic that looks for primitive types.
   * @return  An int that 1 or 2 or 3. Return 1 of the input of "a" is an integer. Return 2 of the input of "a" is an double.
   * Return 3 of the input of "a" is an string.
   */
  public int compareTo(T a) {
    String temp1 = a.toString();
//    Return "0" if it's an integer
    if (temp1.matches("-?(0|[1-9][0-9]*)")) {
        return 0;
    }
//    Return "2" if it's a double
    else if (temp1.matches("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")){
      return 2;
    }
    else {
//    Return "1" if it's a string
      return 1;
    }
  }
}
