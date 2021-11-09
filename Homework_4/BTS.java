/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date:
    Instructor: Professor Silveyra
    Description: Implements a generic binary search tree. Create a menu in which you can insert, delete, and find elements.
    Write a function to find the depth of a given node and the depth of the tree. Write the function SwapTree(). This
    function swaps the left and the right children of every node.
 */

// The following code is the modified version of code provided by
public class BTS{

  public class Node {
    Node right;
    Node left;
    int value;

    public Node(int abc){
      right = null;
      left = null;
      value = abc;
    }
  }

  Node root;

  public BTS(){
    root = null;
  }

  public void insert(int input){
    root = insertRecursive(root,input);
  }

  private Node insertRecursive(Node x, int input){
    if(x == null){
      x = new Node(input);
    }
    else if(x.value > input){
      x.left = insertRecursive(x.left,input);
    }
    else if(x.value < input){
      x.right = insertRecursive(x.right,input);
    }

    return x;
  }

  public void findNode() {


  }

  public void delete(int value) {
    root = deleteNode_recur(root, value);
  }

  public Node deleteNode_recur(Node node, int value) {
    if (node == null) {
      return null;
    }
    if (value < node.value) {
      node.left = deleteNode_recur(node.left, value);
    }
    else if (value > node.value) {
      node.right = deleteNode_recur(node.right, value);
    }
    else {
      if (node.left == null && node.right == null) {
        System.out.println("case");
        node = null;
      }
      else if (node.left == null) {
        System.out.println("case");
        node = node.right;
      }
      else if (node.right == null) {
        System.out.println("case");
        node = node.left;
      }

      else {
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

  private Node findSuccessor_recur(Node node) {
    if (node.left == null) {
      return node;
    }
    else {
      return findSuccessor_recur(node.left);
    }
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


}
