interface Stack2 {
    public Object peek();
    public Object pop();
    public void push(Object obj);
    public int size();
}
public class LinkedStack1 implements Stack2 {
    private class Node {
        private Object data;
        private Node next;
        public Node(Object data,Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private int size;
    private Node top;
    @Override
    public void push(Object obj) {
        top = new Node(obj,top);
        size++;
    }
    @Override
    public Object peek() {
        if (size==0) throw new IllegalStateException("Stack is empty");
        return top.data;
    }
    @Override
    public Object pop() {
        if (size==0) throw new IllegalStateException("Stack is empty");
        Object oldTop = top.data;
        top = top.next;
        size--;
        return oldTop;
    }
    public Object deleteSecondTopElement() {
        if (size<2) throw new IllegalStateException("Size of Stack is less than 2");
        Object temp = top.next.data;
        top.next = top.next.next;
        size--;
        return temp;
    }
    public Object deleteBottomElement() {
        if (size==0) throw new IllegalStateException("Stack is empty");
        if (size==1) {
            Object temp = top.data;
            top = null;
            size--;
            return temp;
        }
        Node dummy = top;
        Object temp;
        while (dummy.next.next!=null) {
            dummy = dummy.next;
        }
        temp = dummy.next.data;
        dummy.next = null;
        size--;
        return temp;
    }
    @Override
    public int size() {
        return size;
    }
    public void display() {
        for (Node i = top; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
    public boolean search(Object target) {
        for (Node i = top; i != null; i = i.next) {
            if (i.data.equals(target)) {
                return true;
            }
        }
        return false;
    }
    public boolean compareTwoStacks(LinkedStack stack1,LinkedStack stack2) {
        if (stack1.size!=stack2.size) {
            return false;
        }
        Node temp1 = stack1.top, temp2 = stack2.top;
        for (int i = 0; i < size; i++) {
            if (!(temp1.data.equals(temp2.data))) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return true;
    }
    public static void main(String[] args) {
        LinkedStack1 fruits = new LinkedStack1();
        System.out.println("SIZE : " + fruits.size());
        fruits.push("ORANGE");
        fruits.push(1);
        fruits.push(2.3);
        fruits.push('d');
        fruits.display();
        System.out.println("SIZE : " + fruits.size());
        System.out.println("PEEK ELEMENT : " + fruits.peek());

//        System.out.println("DELETED ELEMENT : " + fruits.pop());
//        fruits.display();
//        System.out.println("SIZE : " + fruits.size());
//        System.out.println("PEAK ELEMENT : " + fruits.peek());

//        System.out.println("DELETED ELEMENT : " + fruits.deleteSecondTopElement());
//        fruits.display();
//        System.out.println("SIZE : " + fruits.size());
//        System.out.println("PEEK ELEMENT : " + fruits.peek());

//        System.out.println("DELETED ELEMENT : " + fruits.deleteBottomElement());
//        fruits.display();
//        System.out.println("SIZE : " + fruits.size());
//        System.out.println("PEAK ELEMENT : " + fruits.peek());

//        System.out.println("TARGET IS PRESENT IN THE STACK : " + fruits.search('d'));

        LinkedStack1 fruits1 = new LinkedStack1();
        fruits1.push("MANGO");
        fruits1.push(1);
        fruits1.push('f');
        fruits1.push(4.6);
        fruits1.display();

        LinkedStack1 fruits2 = new LinkedStack1();
        fruits2.push("MANGO");
        fruits2.push(1);
        fruits2.push('f');
        fruits2.push(4.6);
        fruits2.display();
        System.out.println("BOTH STACKS ARE EQUAL : " + fruits1.compareTwoStacks(fruits1,fruits2));
    }
}
