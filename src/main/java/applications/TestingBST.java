package applications;

import utils.BinarySearchTree;

public class TestingBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(15);
        bst.inOrderDisplay();
    }
}
