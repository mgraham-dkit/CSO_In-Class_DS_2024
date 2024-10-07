package utils;

public class LinkedList {
    private int count;
    private Node head;
    private Node tail;

    public LinkedList(){
        this.head = null;
        this.tail = null;
        count = 0;
    }

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        count++;
    }

    public boolean insert(int value, int pos){
        if(pos < 0 || pos > count){
            throw new IndexOutOfBoundsException("Illegal position supplied - position must be within bounds of list");
        }

        if(pos == count){
            add(value);
            return true;
        }

        if(pos == 0){
            addToStart(value);
            return true;
        }

        Node newNode = new Node(value);

        Node current = head;
        Node prev = null;
        for (int i = 0; i < pos; i++) {
            prev = current;
            current = current.next;
        }
        newNode.next = current;
        prev.next = newNode;

        count++;

        return true;
    }

    public void addToStart(int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }
}
