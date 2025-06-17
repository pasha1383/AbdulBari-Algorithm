package binaryTree;

class Node {
    int data;

    Node leftChild;
    Node rightChild;


    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
