abstract class Teacher{
    protected StudentList studentList;
 
    public abstract void createStudentList();
    public abstract void callStudents();
}

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

class MyStudentList extends StudentList{

}

class MyTeacher extends Teacher {
    public void createStudentList(){
        studentList = new StudentList(5);
        studentList.add(new Student("赤井亮太",1));
        studentList.add(new Student("赤羽里美",2));
        studentList.add(new Student("岡田美央",2));
        studentList.add(new Student("西森俊介",1));
        studentList.add(new Student("中ノ森玲菜",2));
    }

    public void callStudents(){
        int size = studentList.getLastNum();
        for(int n=0;n<size;n++){
            System.out.println(studentList.getStudentAt(n).getName());
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Teacher you = new MyTeacher();
        you.createStudentList();
        you.callStudents();
    }
}
