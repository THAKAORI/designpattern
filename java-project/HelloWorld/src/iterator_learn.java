class Student{
    private String name;
    private int sex; //男の子:1  女の子:2
 
    public Student(String name,int sex){
        this.name = name;
        this.sex = sex;
    }
    public String getName(){
        return name;
    }
    public int getSex(){
        return sex;
    }
}

class StudentList{
    protected Student[] students;
    private int last = 0;
 
    public StudentList(){}
    public StudentList(int studentCount){
        this.students = new Student[studentCount];
    }
  
    public void add(Student student){
        students[last] = student;
        last++;
    }
    public Student getStudentAt(int index){
        return students[index];
    }
    public int getLastNum(){
        return last;
    }
}

interface Iterator{
    public boolean hasNext();
    public Object next();
}

interface Aggregate{
    public Iterator iterator();
}

class MyStudentList extends StudentList implements Aggregate{
    public MyStudentList(){
        super();
    }
    public MyStudentList(int studentCount){
        super(studentCount);
    }
 
    public Iterator iterator(){
        return new MyStudentListIterator(this);
    }
}

class MyStudentListIterator implements Iterator{
    private MyStudentList myStudentList;
    private int index;
    public MyStudentListIterator(MyStudentList list){
        this.myStudentList = list;
        this.index = 0;
    }
    public boolean hasNext(){
        if(myStudentList.getLastNum() > index){
            return true;
        }else{
            return false;
        }
    }
    public Student next(){
        Student s =  myStudentList.getStudentAt(index);
        index++;
        return s;
    }
}

abstract class Teacher{
    protected StudentList studentList;
 
    public abstract void createStudentList();
    public abstract void callStudents();
}

class VeteranTeacher extends Teacher{
    private MyStudentList list;
    public void createStudentList(){
        list = new MyStudentList(3);
        list.add(new Student("中川雄介",1));
        list.add(new Student("板東恵美",2));
        list.add(new Student("水島太郎",1));
    }
    public void callStudents(){
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(((Student)itr.next()).getName());
        }
    }      
}

public class iterator_learn {
    public static void main(String[] args) throws Exception {
        Teacher teacher = new VeteranTeacher();
        teacher.createStudentList();
        teacher.callStudents();
    }
}
/*これはvectorなどの集約体の種類による走査方法の制約を受けずに前から1つつずつ操作したい場合に用いる*/