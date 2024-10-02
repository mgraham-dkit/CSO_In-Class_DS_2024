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

    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }
}
