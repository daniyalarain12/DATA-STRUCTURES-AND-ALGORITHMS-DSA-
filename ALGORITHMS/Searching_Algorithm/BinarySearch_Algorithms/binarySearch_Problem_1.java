class Student {
    private String name, rollNo;
    private int batch;
    public Student() {

    }
    public Student(String name,String rollNo,int batch) {
        this.name = name;
        this.rollNo = rollNo;
        this.batch = batch;
    }
    public Student[] sortByName(Student[] arr) {
        Student temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j].name.compareTo(arr[j+1].name)>0) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public Student[] sortByRollNo(Student[] arr) {
        Student temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j].rollNo.compareTo(arr[j+1].rollNo)>0) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    public int binarySearchByName(Student[] arr,String n) {
        int start = 0, end = arr.length-1;
        while (start<=end) {
            int mid = (start+end)/2;
            if (arr[mid].name==n) {
                return mid;
            } if (arr[mid].name.compareTo(n)<0) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
    public int binarySearchByRollNo(Student[] arr,String r) {
        int start = 0, end = arr.length-1;
        while (start<=end) {
            int mid = (start+end)/2;
            if (arr[mid].rollNo==r) {
                return mid;
            } if (arr[mid].rollNo.compareTo(r)<0) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;
    }
    public void display(Student[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("RECORD OF STUDENT " + (i+1) + " : ");
            System.out.println("NAME : " + arr[i].name + " , ROLL NO : " + arr[i].rollNo + " AND BATCH : " + arr[i].batch);
        }
    }
}
public class binarySearch_Problem_1 {
    public static void main(String[] args) {
        Student[] arr = new Student[5];
        arr[0] = new Student("DANIYAL","24SW039",2024);
        arr[1] = new Student("IBRAR","24SW024",2024);
        arr[2] = new Student("PRITHVI","24SW030",2024);
        arr[3] = new Student("FATIMA","24SW021",2024);
        arr[4] = new Student("SOOFIA","24SW145",2024);
        Student s = new Student();
        arr = s.sortByName(arr);
        //arr = s.sortByRollNo(arr);
        s.display(arr);
        String name = "IBRAR", rollNo = "24SW021";
        System.out.println("TARGET IS AT INDEX : " + s.binarySearchByName(arr,name));
        //System.out.println("TARGET IS AT INDEX : " + s.binarySearchByRollNo(arr,rollNo));
    }
}
