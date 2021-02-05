import java.util.List;
import java.util.ArrayList;

abstract class Teacher{
    List students = null;
    public abstract void visit(Home studentHome);
    //public abstract void visit(TanakaHome studentHome);
    public abstract void visit(SuzukiHome studentHome);
    public List getStudentList(){
        return students;
    }
 
}

class RookieTeacher extends Teacher{
    List students = null;
    public RookieTeacher(List students){
        this.students = students;
    }
    public void visit(Home studentHome){
        System.out.println("こんにちは");
    }
    // public void visit(TanakaHome studentHome){
    //     studentHome.praisedChild();
    // }
    public void visit(SuzukiHome studentHome){
        studentHome.reprovedChild();
    }
}

abstract class Home{
    public abstract Object praisedChild();
    public abstract Object reprovedChild();
}

interface TeacherAcceptor{
    public void accept(Teacher teacher);
}

class Tea{}

class SuzukiHome extends Home implements TeacherAcceptor{
    public Object praisedChild(){
        System.out.println("あら、先生ったらご冗談を");
        return new Tea();
    }
    public Object reprovedChild(){
        System.out.println("うちの子に限ってそんなことは・・・。");
 
        return null;
    }
    /**
     * 訪問者を受け入れるメソッド
     */
    public void accept(Teacher teacher){
        teacher.visit(this);
    }
}


public class VisitorLearn {
    public static void main(String args[]){
        SuzukiHome home = new SuzukiHome();
        home.praisedChild();
        home.reprovedChild();
        List<String> list = new ArrayList<>();
        list.add("Suzuki");
        Teacher teacher = new RookieTeacher(list);
        home.accept(teacher);
    }
}
/*受け入れ側に処理を追加することなく、処理の追加ができる。Acceptorにaccept関数を作っておいて、外部のクラスの処理をさせる。*/