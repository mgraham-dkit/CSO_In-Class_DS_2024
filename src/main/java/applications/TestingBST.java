package applications;

import utils.BinarySearchTree;

import java.util.Iterator;

public class TestingBST {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        bst.insert(5);
        bst.insert(3);
        bst.insert(15);
        bst.insert(-100);
        bst.insert(9);
        bst.insert(22);
        bst.insert(50);
        bst.inOrderDisplay();
        System.out.println();

        Iterator<Integer> iterator = bst.inOrderIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
        System.out.println("Min: " + bst.getMin());
        System.out.println("Max: " + bst.getMax());

        bst.removeMin();
        bst.inOrderDisplay();
        System.out.println();

        bst.removeMax();
        bst.inOrderDisplay();
        System.out.println();
//        System.out.println("Size before removing: " + bst.size());
//        System.out.println(bst.remove(22));
//        System.out.println("Size after removing: " + bst.size());
//        System.out.println(bst.remove(0));
//        System.out.println("Size after removing: " + bst.size() + " (no match so no change)");
//        bst.inOrderDisplay();
//        System.out.println();
//        System.out.println("--------------");
//        bst.delete(15);
//        System.out.println("Size after removing: " + bst.size());
//        bst.inOrderDisplay();
//        System.out.println();
//        System.out.println("---------------------");
//        bst.delete(5);
//        System.out.println("Size after removing: " + bst.size());
//        bst.inOrderDisplay();
//        System.out.println("");
//        System.out.println("---------------------");
    }
}
