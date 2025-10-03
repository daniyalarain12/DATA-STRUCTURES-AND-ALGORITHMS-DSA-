interface Stack {
    public Object peek();
    public Object pop();
    public void push(Object obj);
    public int size();
}
public class ArrayStack2 implements Stack {
    private int size;
    private Object[] arr;
    public ArrayStack(int capacity) {
        arr = new Object[capacity];
    }
    @Override
    public Object peek() {
        if (size==0) throw new IllegalStateException("Stack is empty");
        return arr[size-1];
    }
    @Override
    public Object pop() {
        if (size==0) throw new IllegalStateException("Stack is empty");
        Object temp = arr[size-1];
        arr[--size] = null;
        return temp;
    }
    private void resize() {
        Object[] temp = arr;
        arr = new Object[size*2];
        System.arraycopy(temp,0,arr,0,size);
    }
    @Override
    public void push(Object obj) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = obj;
    }
    @Override
    public int size() {
        return size;
    }
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public LinkedStack toLinkedStack() {
        LinkedStack linkedStack = new LinkedStack();
        for (int i = 0; i < size; i++) {
            linkedStack.push(arr[i]);
        }
        return linkedStack;
    }
    public static void main(String[] args) {
        ArrayStack2 fruits = new ArrayStack2(5);
        fruits.push("ORANGE");
        fruits.push(1);
        fruits.push(2.3);
        fruits.push('d');
        fruits.display();

        LinkedStack linkedStack = fruits.toLinkedStack();
        linkedStack.display();
    }
}
