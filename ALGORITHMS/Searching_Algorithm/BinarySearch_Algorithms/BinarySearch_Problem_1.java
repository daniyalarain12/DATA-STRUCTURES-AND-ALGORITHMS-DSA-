/* Write a Java program to implement Binary Search on an array of Student objects,
   allowing search by name or roll number after sorting*/
class Student {
    private String name, rollNo;
    private int batch;
    public Student(String name,String rollNo,int batch) {
        this.name = name;
        this.rollNo = rollNo;
        this.batch = batch;
    }
    public static int binarySearchByName(Student[] arr,String name) {
        int start = 0, end = arr.length-1;
        while (start<=end) {
            int mid = (start+end) / 2;
            if (arr[mid].name.equals(name)) {
                return mid;
            } else if (arr[mid].name.compareTo(name) < 0) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
    public static int binarySearchByRollNo(Student[] arr,String rollNo) {
        int start = 0, end = arr.length-1;
        while (start<=end) {
            int mid = (start+end) / 2;
            if (arr[mid].rollNo.equals(rollNo)) {
                return mid;
            } else if (arr[mid].rollNo.compareTo(rollNo) < 0) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
    public static void sortByName(Student[] arr) {
        Student temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j].name.compareTo(arr[j+1].name) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void sortByRollNo(Student[] arr) {
        Student temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j].rollNo.compareTo(arr[j+1].rollNo) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void display(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("RECORD OF STUDENT " + (i+1) + " : ");
            System.out.println("NAME : " + arr[i].name + ", ROLL NO : " + arr[i].rollNo + " AND BATCH : " + arr[i].batch);
        }
    }
}
public class BinarySearch_Problem_1 {
    public static void main(String[] args) {
        Student[] arr = new Student[5];
        arr[0] = new Student("DANIYAL","24SW039",2024);
        arr[1] = new Student("IBRAR","24SW024",2024);
        arr[2] = new Student("PRITHVI","24SW030",2024);
        arr[3] = new Student("FATIMA","24SW021",2024);
        arr[4] = new Student("SOOFIA","24SW145",2024);
        Student.display(arr);
        //Student.sortByName(arr);
        Student.sortByRollNo(arr);
        //System.out.println("STUDENT FOUND AT INDEX : " + Student.binarySearchByName(arr,"FATIMA"));
        System.out.println("STUDENT FOUND AT INDEX : " + Student.binarySearchByRollNo(arr,"24SW145"));
    }
}
