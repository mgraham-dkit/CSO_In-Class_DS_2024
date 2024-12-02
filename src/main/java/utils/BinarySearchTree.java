package utils;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;
    private int size;

    public BinarySearchTree(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contains(E element){
        validateElement(element);
        return contains(root, element);
    }

    private static <E extends Comparable<E>> void validateElement(E element) {
        if(element == null) {
            throw new IllegalArgumentException("Cannot search for nulls");
        }
    }

    private boolean contains(Node<E> root, E element){
        if(root == null){
            return false;
        }

        if(root.data.equals(element)){
            return true;
        }

        // If current node is greater than element:
        if(root.data.compareTo(element) > 0){
            return contains(root.left, element);
        }else{
            return contains(root.right, element);
        }
    }

    public void insert(E element){
        validateElement(element);

        root = insert(root, element);
        size++;
    }

    private Node<E> insert(Node<E> root, E element){
        if(root == null){
            return new Node<>(element);
        }

        if(root.data.compareTo(element) >= 0){
            root.left = insert(root.left, element);
        }else{
            root.right = insert(root.right, element);
        }
        return root;
    }

    public void inOrderDisplay(){
        if(isEmpty()){
            System.out.println("Tree is empty!");
        }else{
            inOrderDisplay(root);
        }
    }

    private void inOrderDisplay(Node<E> root){
        if(root != null){
            inOrderDisplay(root.left);
            System.out.print(root.data + " ");
            inOrderDisplay(root.right);
        }
    }

    protected static class Node<E extends Comparable<E>>{
        E data;
        Node<E> left;
        Node<E> right;

        public Node(E data){
            this.data = data;
            left = null;
            right = null;
        }
    }
}
