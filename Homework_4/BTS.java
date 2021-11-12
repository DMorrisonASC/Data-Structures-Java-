/*
    Author: Daeshaun Morrison, Muhlenberg College class of 2024(daeshaunkmorrison@gmail.com)
    Date:
    Instructor: Professor Silveyra
    Description: Implements a generic binary search tree. Create a menu in which you can insert, delete, and find elements.
    Write a function to find the depth of a given node and the depth of the tree. Write the function SwapTree(). This
    function swaps the left and the right children of every node.
 */

import java.util.Random;

// The following code is the modified version of code provided by
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

//  public void insert_One(int input){
//    root = insertRecursive(root, input);
//  }
//
//  private Node insertRecursive(Node x, int input){
//    if(x == null){
//      x = new Node(input);
//    }
//    else if(x.value > input){
//      x.left = insertRecursive(x.left,input);
//    }
//    else if(x.value < input){
//      x.right = insertRecursive(x.right,input);
//    }
//
//    return x;
//  }
  public void insert_One(T input){
  root = insertRecursive(root, input);
}

  private Node insertRecursive(Node x, T input){
    int inputNum;
    double intDouble;
    char inputChar;
//    If it's an interger or double
    if (compareTo(input) == 0) {
      inputNum = Integer.parseInt(input.toString());
//      double currentNum = Integer.parseInt(x.value.toString());
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


  public void findNode(T input) {
    root = findNode_recur(root, input);
  }

  private Node findNode_recur(Node x, T input) {
    int inputNum;
    double intDouble;
    char inputChar;
    if (compareTo(input) == 0) {
      inputNum = Integer.parseInt(input.toString());
      if (x == null) {
        System.out.println("There is NO node value of \"" + x.value + "\" present in the tree.");
        return null;
      }
      if (Integer.parseInt(x.value.toString()) < inputNum) {
        x.left = findNode_recur(x.left, input);
      } else if (Integer.parseInt(x.value.toString()) > inputNum) {
        x.right = findNode_recur(x.right, input);
      } else {
        System.out.println("There is a node value of \"" + x.value + "\" present in the tree.");
      }
      return x;
    }

    else if (compareTo(input) == 2) {
      intDouble = Double.parseDouble(input.toString());
      if (x == null) {
        System.out.println("There is NO node value of \"" + x.value + "\" present in the tree.");
        return null;
      }
      if (Double.parseDouble(x.value.toString()) < intDouble) {
        x.left = findNode_recur(x.left, input);
      } else if (Double.parseDouble(x.value.toString()) > intDouble) {
        x.right = findNode_recur(x.right, input);
      } else {
        System.out.println("There is a node value of \"" + x.value + "\" present in the tree.");
      }
      return x;
    }

    else {
      inputChar = input.toString().charAt(0);
      if (x == null) {
        return null;
      }
      if (Integer.parseInt(x.value.toString()) < inputChar) {
        x.left = findNode_recur(x.left, input);
      } else if (Integer.parseInt(x.value.toString()) > inputChar) {
        x.right = findNode_recur(x.right, input);
      } else {
        System.out.println("There is a node value of \"" + x.value + "\" present in the tree.");
      }
      return x;
    }
  }

//  public void delete(int value) {
//    root = deleteNode_recur(root, value);
//  }

//  private Node deleteNode_recur(Node node, int value) {
//    if (node == null) {
//      return null;
//    }
//    if (value < node.value) {
//      node.left = deleteNode_recur(node.left, value);
//    }
//    else if (value > node.value) {
//      node.right = deleteNode_recur(node.right, value);
//    }
//    else {
//      if (node.left == null && node.right == null) {
//        System.out.println("case");
//        node = null;
//      }
//      else if (node.left == null) {
//        System.out.println("case");
//        node = node.right;
//      }
//      else if (node.right == null) {
//        System.out.println("case");
//        node = node.left;
//      }
//
//      else {
//        System.out.println("case");
//        Node successor = findSuccessor_recur(node.right);
////
//        node.value = successor.value;
////
//        node.right = deleteNode_recur(node.right, successor.value);
//
//      }
//
//    }
//    return node;
//  }

  private Node findSuccessor_recur(Node node) {
    if (node.left == null) {
      return node;
    }
    else {
      return findSuccessor_recur(node.left);
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

  public int compareTo(T a) {
    String temp1 = a.toString();

    if (temp1.matches("-?(0|[1-9][0-9]*)")) {
        return 0;
    }
    else if (temp1.matches("[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?")){
      return 2;
    }
    else {
//    Return "1" if it's a string
      return 1;
    }
  }
}
