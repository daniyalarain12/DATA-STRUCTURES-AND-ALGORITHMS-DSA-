interface Queue {
    public void add(Object obj);
    public Object first();
    public Object remove();
    public int size();
}
public class LinkedQueue implements Queue {
    private class Node {
        private Object data;
        private Node prev = this, next = this;
        public Node(Object data) {
            this.data = data;
        }
        public Node(Object data,Node prev,Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    private int size;
    private Node head = new Node(null);
    @Override
    public void add(Object obj) {
        head.prev.next = new Node(obj,head.prev,head);
        head.prev = head.prev.next;
        size++;
    }
    @Override
    public Object first() {
        if (size==0) throw new IllegalStateException("Queue is empty");
        return head.next.data;
    }
    @Override
    public Object remove() {
        if (size==0) throw new IllegalStateException("Queue is empty");
        Object temp = head.next.data;
        head.next = head.next.next;
        head.next.prev = head;
        size--;
        return temp;
    }
    public Object removeNthElement(int pos) {
        if (pos>size || pos<=0) throw new IllegalStateException("Your given position does not exists");
        Node currentNode = head.next;
        for (int i = 1; i < pos; i++) {
            currentNode = currentNode.next;
        }
        Object temp = currentNode.data;
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
        size--;
        return temp;
    }
    @Override
    public int size() {
        return size;
    }
    public void display() {
        Node currentNode = head.next;
        while (currentNode != head) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    public String toString() {
        if (size==0) {
            return " ";
        }
        Node currentNode = head.next;
        StringBuilder sb = new StringBuilder();
        while (currentNode != head) {
            sb.append(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        return sb.toString();
    }
    public LinkedQueue copy() {
        LinkedQueue queue = new LinkedQueue();
        Node currentNode = head.next;
        while (currentNode != head) {
            queue.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return queue;
    }
    public ArrayQueue toArrayQueue() {
        ArrayQueue arrayQueue = new ArrayQueue(size);
        Node currentNode = head.next;
        while (currentNode != head) {
            arrayQueue.add(currentNode.data);
            currentNode = currentNode.next;
        }
        return arrayQueue;
    }
    public boolean compareTwoQueues(LinkedQueue queue1,LinkedQueue queue2) {
        if (queue1.size() != queue2.size()) {
            return false;
        }
        Node currentNode1 = queue1.head.next;
        Node currentNode2 = queue2.head.next;
        while (currentNode1!=queue1.head && currentNode2!=queue2.head) {
            if ( !(currentNode1.data.equals(currentNode2.data)) ) {
                return false;
            }
            currentNode1 = currentNode1.next;
            currentNode2 = currentNode2.next;
        }
        return true;
    }
    public Object output1() {
        return head.next.next.next.next.next.data;
    }
    public Object output2() {
        return head.prev.prev.prev.prev.prev.prev.data;
    }
    public static void main(String[] args) {
//        LinkedQueue queue = new LinkedQueue();
//        queue.add("DANIYAL");
//        queue.add(2);
//        queue.add('d');
//        queue.add(3.4);
//        queue.display();
//        System.out.println("FIRST ELEMENT : " + queue.first());
//        System.out.println("SIZE : " + queue.size());
//
//        System.out.println("DELETED ELEMENT : " + queue.remove());
//        System.out.println("DELETED ELEMENT : " + queue.removeNthElement(3));
//        queue.display();
//        System.out.println("FIRST ELEMENT : " + queue.first());
//        System.out.println("SIZE : " + queue.size());
//
//        System.out.println(queue.toString());

//        LinkedQueue queue1 = new LinkedQueue();
//        queue1.add(1); queue1.add(2); queue1.add(3);
//        LinkedQueue queue2 = queue1.copy();
//        queue1.display();
//        queue2.display();

//        LinkedQueue queue = new LinkedQueue();
//        queue.add(1); queue.add(2); queue.add(3);
//        ArrayQueue arrayQueue = queue.toArrayQueue();
//        arrayQueue.display();

//        LinkedQueue queue1 = new LinkedQueue();
//        queue1.add("DANIYAL"); queue1.add(2); queue1.add('D');
//        LinkedQueue queue2 = new LinkedQueue();
//        queue2.add("DANIYAL"); queue2.add(2); queue2.add('D');
//        System.out.println("BOTH QUEUES ARE EQUAL : " + queue1.compareTwoQueues(queue1,queue2));

//        LinkedQueue queue = new LinkedQueue();
//        queue.add(1); queue.add(2); queue.add(3); queue.add(4); queue.add(5);
//        queue.add(6); queue.add(7); queue.add(8); queue.add(9); queue.add(10);
//        System.out.println("5TH ELEMENT OF A QUEUE : " + queue.output1());
//        System.out.println("5TH ELEMENT OF A QUEUE : " + queue.output2());
    }
}
