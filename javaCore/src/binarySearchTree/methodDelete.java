package binarySearchTree;

public class methodDelete {
    int val;
    methodDelete left,right;

    public methodDelete minimumNode(methodDelete node){
        if(node.left == null){
            return node;
        }
        else{
            return minimumNode(node.left);
        }
    }
    public methodDelete deleteNode(methodDelete root, int key) {
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
                methodDelete temp = root;
                methodDelete minNode = minimumNode(temp.right);
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

