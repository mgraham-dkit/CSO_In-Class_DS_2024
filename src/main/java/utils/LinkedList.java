package utils;

public class LinkedList {
    private int count;
    private Node head;

    public LinkedList(){
        this.head = null;
        count = 0;
    }

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            this.head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
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
