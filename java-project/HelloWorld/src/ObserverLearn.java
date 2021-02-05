import java.util.List;
import java.util.ArrayList;


interface Observer{
    void update();
}

class NewTeacher implements Observer{
    public void update(){

    }
}

abstract class Observee{
    protected List<Observer> observerList = new ArrayList<>();
    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    protected void notifyObservers(){};
    abstract protected void run(int count);
}

class RunStudent extends Observee{
    public void notifyObservers(int count){
        
    }
    public void run(int count){

    }
}

public class ObserverLearn {
    public static void main(String[] args) {
        Observee student = new RunStudent();
        Observer teacher = new NewTeacher();
        student.addObserver(teacher);
    }   
}
