package binarySearchTree;

public class mainTree {
    public static void main(String[] args) {

        BSTree bsTree = new BSTree();
        bsTree.insert(27);
        bsTree.insert(8);
        bsTree.insert(3);
        bsTree.printTree(bsTree.root);

        Node node = new Node();
        int [] A = {5,3,6,2,4,7};
        node.deleteNode(bsTree.root,2);
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

    Node(){};

//    Node(int val) { this.val = val; }

    int val;

    Node minimumNode(Node node){
        if(node.left == null){
            return node;
        }
        else{
            return minimumNode(node.left);
        }
    }
    public Node deleteNode(Node root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left,key);
        }
        else if(key > root.val){
            root.right = deleteNode(root.right,key);
        }
        else{
            if(root.left != null && root.right != null){
                Node temp = root;
                Node minNode = minimumNode(temp.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right,minNode.val);
            }
            else if(root.left != null){
                root = root.left;
            }
            else if(root.right != null){
                root = root.right;
            }
            else{
                root = null;
            }
        }
        return root;
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


    void delete(int x){

    }
}




