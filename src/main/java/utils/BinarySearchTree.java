package utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void removeMax(){
        // if tree is empty, stop process
        if(root == null){
            return;
        }

        // Remove the largest value in the tree, starting at the top
        root = removeMax(root);
    }

    private Node<E> removeMax(Node<E> root){
        // If there is nothing to right of this node,
        // this is the maximum node
        if(root.right == null){
            return null;
        }

        // Otherwise, remove the biggest value from our right
        // and update our right value accordingly
        root.right = removeMax(root.right);
        // Return our updated node
        return root;
    }

    public void removeMin(){
        // if tree is empty, stop process
        if(root == null){
            return;
        }

        // Remove the smallest value in the tree, starting at the top
        root = removeMin(root);
    }

    private Node<E> removeMin(Node<E> root){
        // If there is nothing to left of this node,
        // this is the minimum node
        if(root.left == null){
            return null;
        }

        // Otherwise, remove the smallest value from our left
        // and update our left value accordingly
        root.left = removeMin(root.left);
        // Return our updated node
        return root;
    }

    public E getMin(){
        if(root == null){
            return null;
        }
        return getMin(root);
    }

    private E getMin(Node<E> root){
        if(root.left == null){
            return root.data;
        }
        return getMin(root.left);
    }

    public E getMax(){
        if(root == null){
            return null;
        }
        return getMax(root);
    }

    private E getMax(Node<E> root){
        if(root.right == null){
            return root.data;
        }
        return getMax(root.right);
    }

    private static <E extends Comparable<E>> void validateElement(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot search for nulls");
        }
    }

    public boolean contains(E element) {
        validateElement(element);
        return contains(root, element);
    }

    private boolean contains(Node<E> root, E element) {
        if (root == null) {
            return false;
        }

        if (root.data.equals(element)) {
            return true;
        }

        // If current node is greater than element:
        if (root.data.compareTo(element) > 0) {
            return contains(root.left, element);
        } else {
            return contains(root.right, element);
        }
    }

    public void insert(E element) {
        validateElement(element);

        root = insert(root, element);
        size++;
    }

    private Node<E> insert(Node<E> root, E element) {
        if (root == null) {
            return new Node<>(element);
        }

        if (root.data.compareTo(element) >= 0) {
            root.left = insert(root.left, element);
        } else {
            root.right = insert(root.right, element);
        }
        return root;
    }

    public void delete(E element){
        validateElement(element);

        if(root == null){
            return;
        }
        root = delete(root, element);
    }

    private Node<E> delete(Node<E> root, E element){
        if(root == null){
            return null;
        }

        if(element.compareTo(root.data) < 0){
            root.left = delete(root.left, element);
        }else if(element.compareTo(root.data) > 0){
            root.right = delete(root.right, element);
        }else {
            // Where the node to be deleted is a leaf
            if (root.left == null && root.right == null) {
                return null;
            }

            // Where the node to be deleted has one child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Where the node to be deleted has two children
            // Get the smallest value on its right-hand side
            E successorValue = getMin(root.right);
            // Swap this into the node we're deleting from
            root.data = successorValue;
            // We will only delete from the middle of the tree once,
            // so we can decrease size here as it will only happen once
            size--;
            root.right = delete(root.right, successorValue);
        }
        return root;
    }

    public E remove(E element){
        validateElement(element);

        // If the tree is empty, return null immediately
        if(root == null){
            return null;
        }

        DeletedNode<E> deleted = remove(root, element);

        // If we found something to delete, decrease our overall count
        // Do this here as this will only run once
        if(deleted.element != null){
            size--;
        }
        root = deleted.node;

        return deleted.element;
    }

    private DeletedNode<E> remove(Node<E> root, E element){
        if(root == null){
            return new DeletedNode<>(null, null);
        }

        if(element.compareTo(root.data) < 0){
            // Move to delete from left side
            DeletedNode<E> deletedLeft = remove(root.left, element);
            root.left = deletedLeft.node;
            return new DeletedNode<>(root, deletedLeft.element);
        }else if(element.compareTo(root.data) > 0){
            // Move to delete from right side
            DeletedNode<E> deletedRight = remove(root.right, element);
            root.right = deletedRight.node;
            return new DeletedNode<>(root, deletedRight.element);
        }

        // Found a match - update the tree accordingly
        E deletedValue = root.data;
        // If the node to be deleted is a leaf
        if(root.left == null && root.right == null){
            return new DeletedNode<>(null, deletedValue);
        }

        // If the node has only one child
        if(root.left == null){
            return new DeletedNode<>(root.right, deletedValue);
        }
        if(root.right == null){
            return new DeletedNode<>(root.left, deletedValue);
        }

        // If the node has two children, find the smallest value on the right side
        E successorValue = getMin(root.right);
        // Swap it into this node's position
        root.data = successorValue;
        // Delete the original copy
        DeletedNode<E> deletedRight = remove(root.right, successorValue);
        root.right = deletedRight.node;
        return new DeletedNode<>(root, deletedValue);

    }

    public void inOrderDisplay() {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
        } else {
            inOrderDisplay(root);
        }
    }

    private void inOrderDisplay(Node<E> root) {
        if (root != null) {
            inOrderDisplay(root.left);
            System.out.print(root.data + " ");
            inOrderDisplay(root.right);
        }
    }

    public Iterator<E> inOrderIterator() {
        return new InOrderIterator<>(root);
    }

    protected static class Node<E extends Comparable<E>> {
        E data;
        Node<E> left;
        Node<E> right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
    }


    static class InOrderIterator<E extends Comparable<E>> implements Iterator<E> {
        private final Stack<Node<E>> traversal;

        public InOrderIterator(Node<E> root) {
            traversal = new Stack<>();
            fillLeft(root);
        }

        public boolean hasNext() {
            return !traversal.isEmpty();
        }

        private void fillLeft(Node<E> current) {
            // While we're not at the base of the tree,
            // fill in all left nodes from this node down
            while (current != null) {
                // Add current node to the stack
                traversal.push(current);
                // Move to the left and go again
                current = current.left;
            }
        }

        public E next() {
            // Validation: If it's empty, throw an exception
            if (!hasNext()) {
                throw new NoSuchElementException("No elements remaining in iterator");
            }

            // Get the next element in the stack
            Node<E> current = traversal.pop();
            // If there are things to the right of this node
            if (current.right != null) {
                // Add all their left nodes to the iterator
                // (The right nodes will be added as next() encounters them)
                fillLeft(current.right);
            }
            return current.data;
        }
    }

    private static class DeletedNode<E extends Comparable<E>>{
        E element;
        Node<E> node;

        public DeletedNode(Node<E> node, E deletedValue){
            this.node = node;
            this.element = deletedValue;
        }
    }
}
