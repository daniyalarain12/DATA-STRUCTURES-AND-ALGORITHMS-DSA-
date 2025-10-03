interface Stack {
    public Object peek();
    public Object pop();
    public void push(Object obj);
    public int size();
}
public class LinkedStack2 implements Stack {
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
    @Override
    public int size() {
        return size;
    }
    public void display() {
        for (Node i = top; i != null; i = i.next) {
            System.out.println(i.data);
        }
    }
    public ArrayStack toArrayStack() {
        Node temp = top;
        Object[] arr = new Object[size];
        for (int i = size-1; i >= 0; i--) {
            arr[i] = temp.data;
            temp = temp.next;
        }
        ArrayStack arrayStack = new ArrayStack(size);
        for (int i = 0; i < size; i++) {
            arrayStack.push(arr[i]);
        }
        return arrayStack;
    }
    public static void main(String[] args) {
        LinkedStack2 fruits = new LinkedStack2();
        fruits.push("MANGO");
        fruits.push(1);
        fruits.push('f');
        fruits.push(4.6);
        fruits.display();

        ArrayStack arrayStack = fruits.toArrayStack();
        arrayStack.display();
    }
}
