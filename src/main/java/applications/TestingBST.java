package applications;

import utils.BinarySearchTree;

import java.util.Iterator;

public class TestingBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(15);
        bst.inOrderDisplay();
        System.out.println();

        Iterator<Integer> iterator = bst.inOrderIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
    }
}
