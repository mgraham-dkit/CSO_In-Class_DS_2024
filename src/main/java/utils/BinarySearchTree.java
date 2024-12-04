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

    public boolean contains(E element) {
        validateElement(element);
        return contains(root, element);
    }

    private static <E extends Comparable<E>> void validateElement(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Cannot search for nulls");
        }
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
        return new InOrderIterator<E>(root);
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
}
