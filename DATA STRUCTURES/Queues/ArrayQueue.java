interface Queue2 {
    public void add(Object obj);
    public Object first();
    public Object remove();
    public int size();
}
public class ArrayQueue implements Queue2 {
    private int size;
    private Object[] arr;
    public ArrayQueue(int capacity) {
        arr = new Object[capacity];
    }
    private void resize() {
        Object[] temp = arr;
        arr = new Object[size*2];
        System.arraycopy(temp,0,arr,0,size);
    }
    @Override
    public void add(Object obj) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = obj;
    }
    @Override
    public Object first() {
        if (size==0) throw new IllegalStateException("Queue is empty");
        return arr[0];
    }
    @Override
    public Object remove() {
        if (size==0) throw new IllegalStateException("Queue is empty");
        Object temp = arr[0];
        for (int i = 0; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
        arr[--size] = null;
        return temp;
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
    public static void main(String[] args) {
        ArrayQueue1 queue = new ArrayQueue1(5);
        queue.add("DANIYAL");
        queue.add(2);
        queue.add('s');
        queue.add(3.4);
        queue.display();
        System.out.println("FIRST ELEMENT : " + queue.first());
        System.out.println("SIZE : " + queue.size());

        System.out.println("DELETED ELEMENT : " + queue.remove());
        queue.display();
        System.out.println("FIRST ELEMENT : " + queue.first());
        System.out.println("SIZE : " + queue.size());
    }
}
