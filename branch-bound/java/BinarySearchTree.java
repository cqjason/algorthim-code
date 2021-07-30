import javafx.scene.shape.DrawMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree {
    private  Node root;
    public  class Node{
        private Node parent;
        private Node leftChild;
        private Node rightChild;
        private int value;

        public Node(Node parent, Node leftChild, Node rightChild, int value) {
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.value = value;
        }
    }

    public void insert(Node node){
        if(root == null){
            root = node;
            return;
        }

        Node p = null;
        Node x = root;
        // loop search insert place(null)
        while(x != null){
            p = x;
            if(node.value < x.value) {
                x = x.leftChild;
            }else if(node.value > x.value){
                x = x.rightChild;
            }else {
                // node is exist at tree
                return;
            }
        }

        if(node.value < p.value){
            p.leftChild = node;
        }else {
            p.rightChild = node;
        }

        node.parent = p;
    }

    public Node search(int targetValue){
        Node x = root;
        while (x != null && x.value != targetValue){
            if(targetValue < x.value){
                x = x.leftChild;
            }else {
                x = x.rightChild;
            }
        }
        return x;
    }

    public Node min(Node node){
        Node x = node;
        while ( x.leftChild != null){
            x = x.leftChild;
        }
        return x;
    }

    public Node max(Node node){
        Node x = node;
        while (x.rightChild != null){
            x = x.rightChild;
        }
        return x;
    }

    //defalut: inorder
    public Node successor(Node node){
        if(node.rightChild != null){
            return min(node.rightChild);
        }else if(node.parent != null ){
            Node parent = node.parent;
            Node child = node;
            while ( parent != null && parent.rightChild == child){
                child = parent;
                parent = parent.parent;
            }
            return parent;
        }
        return null;
    }

    //defalut: inorder
    public Node predecessor(Node node){
        if(node.leftChild != null){
            return max(node.leftChild);
        }else if(node.parent != null){
            Node parent = node.parent;
            Node child = node;
            while (parent != null && parent.leftChild == child){
                child = parent;
                parent = parent.parent;
            }
            return parent;
        }
        return null;
    }

    public void remove(Node node){

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] source = new int[]{5, 1, 7, 3, 9, 4, 6};
        for (int value : source){
            bst.insert(bst.new Node(null,null,null,value));
        }
        System.out.println("after sorted:" + Arrays.toString(InsertSort.sort(source)));
        System.out.printf("BST's root is: %d \n",bst.root.value);

        //verify successor
        Node first = bst.search(1);
        List<Integer> forwardTravelValues = new ArrayList<>();
        forwardTravelValues.add(first.value);
        while (bst.successor(first) != null){
            first = bst.successor(first);
            forwardTravelValues.add(first.value);
        }
        System.out.println("forwardTravelValues is:" + forwardTravelValues.toString());

        //verify predecessor
        Node last = bst.search(9);
        List<Integer> backwardTravelValues = new ArrayList<>();
        backwardTravelValues.add(last.value);
        while (bst.predecessor(last) != null){
            last = bst.predecessor(last);
            backwardTravelValues.add(last.value);
        }
        System.out.println("backwardTravelValues is:" + backwardTravelValues.toString());

    }
}
