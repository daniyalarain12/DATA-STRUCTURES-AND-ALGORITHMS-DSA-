public class Node {
    private int data;
    private Node next;
    public Node(int data) {
        this.data = data;
    }
    public static void main(String[] args) {
//1st way to create a LinkList     
      
//        Node start = new Node(5);   
//        start.next = new Node(10);
//        start.next.next = new Node(15);
//        start.next.next.next = new Node(20);

//2nd way to create a LinkList
      
//        Node start = new Node(5);
//        Node currentNode = start;
//        currentNode.next = new Node(10);
//        currentNode = currentNode.next;
//        currentNode.next = new Node(15);
//        currentNode = currentNode.next;
//        currentNode.next = new Node(20);

//3rd way to create a LinkList     
      
       Node start = new Node(5);
       Node currentNode = start;
       for (int i = 2; i <=4 ; i++) {
           currentNode.next = new Node(i*5);
           currentNode = currentNode.next;
       }

//1st way to print a LinkedList
      
//        System.out.println(start.data);
//        System.out.println(start.next.data);
//        System.out.println(start.next.next.data);
//        System.out.println(start.next.next.next.data);

//2nd way to print a LinkedList
      
       for (Node i = start; i!= null; i = i.next) {
           System.out.println(i.data);
       }
    }
}
