interface Stack2 {
    public Object peek();
    public Object pop();
    public void push(Object obj);
    public int size();
}
public class ArrayStack1 implements Stack2 {
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
    public Object deleteSecondTopElement() {
        if (size<2) throw new IllegalStateException("Size of Stack is less than 2");
        Object temp = arr[size-2];
        arr[size-2] = arr[size-1];
        arr[--size] = null;
        return temp;
    }
    public Object deleteBottomElement() {
        if (size==0) throw new IllegalStateException("Stack is empty");
        Object temp = arr[0];
        for (int i = 0; i < size-1; i++) {
            arr[i] = arr[i+1];
        }
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
    public boolean search(Object target) {
        for (int i = 0; i < size; i++) {
            if (arr[i]==target) {
                return true;
            }
        }
        return false;
    }
    public boolean compareTwoStacks(ArrayStack stack1,ArrayStack stack2) {
        if (stack1.size!=stack2.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!(stack1.arr[i].equals(stack2.arr[i]))) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        ArrayStack1 fruits = new ArrayStack1(5);
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

//        ArrayStack1 fruits1 = new ArrayStack1(5);
//        fruits1.push("ORANGE");
//        fruits1.push(1);
//        fruits1.push(2.3);
//        fruits1.push('d');
//        System.out.print("STACK 1 : ");
//        fruits1.display();
//        ArrayStack1 fruits2 = new ArrayStack1(5);
//        fruits2.push("ORANGE");
//        fruits2.push(1);
//        fruits2.push(2.3);
//        fruits2.push('d');
//        System.out.print("STACK 2 : ");
//        fruits2.display();
//        System.out.println("BOTH STACKS ARE EQUAL : " + fruits1.compareTwoStacks(fruits1,fruits2));
    }
}
