package binarySearchTree;

public class mainTree {
    public static void main(String[] args) {

        BSTree bsTree = new BSTree();
        bsTree.insert(27);
        bsTree.insert(8);
        bsTree.insert(3);
        bsTree.printTree(bsTree.root);
    }
}

class Node {
    int key;
    Node left, right;

    Node(int x) {
        this.key = x;
        left = right = null;
    }
}

class BSTree {
    Node root;

    public BSTree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }

        Node findNode= root,parent = null;
        while(findNode != null){
            if(findNode.key == x){
                System.out.println("da co");
                return;
            }
            parent = findNode;

            if(findNode.key > x){
                findNode = findNode.left;
            }
            else {
                findNode = findNode.right;
            }
        }
        if(parent.key > x){
            parent.left = new Node(x);
        }else {
            parent.right = new Node(x);
        }
    }

    void printTree(Node node) {
        if (node == null) return;
        printTree(node.left);
        System.out.println(node.key);
        printTree(node.right);
    }
}