abstract class Responsible{
    private Responsible next = null;
    public String responsiblePerson = null;
    public Responsible(String responsiblePerson){
        this.responsiblePerson = responsiblePerson;
    }
    public Responsible setNext(Responsible next){
        this.next = next;
        return next;
    }
    public final void putQuestion(Question question){
        if(beAbleToJudge(question)){
            judge(question);
        }else if(next != null){
            next.putQuestion(question);
        }else{
            System.out.println("誰にも判断できませんでした。やってみなさい。");
        }
    }
    protected abstract boolean beAbleToJudge(Question question);
    protected abstract void judge(Question question);
}

class Level{
    private int level;
    public Level(int level){
        this.level = level;
    }
    public boolean lessThan(Level responsibleLevel){
        //System.out.println("比較元"+this.level);
        //System.out.println("比較先"+responsibleLevel.level);
        if(this.level <= responsibleLevel.level){
            return true;
        }
        return false;
    }
}

class Question{
    public Level level;
    public String text;
    public Question(String text, Level level){
        this.text = text;
        this.level = level;
    }
}

class Student extends Responsible{
    private Level responsibleLevel = new Level(1);
    public Student(String responsiblePerson){
        super(responsiblePerson);
    }   
    protected boolean beAbleToJudge(Question question){
        if(question.level.lessThan(responsibleLevel)){
            return true;
        }
        return false;
    }
    protected void judge(Question question){
        System.out.println("生徒が判断");
    }
}

class ClassTeacher extends Responsible{
    private Level responsibleLevel = new Level(2);
    public ClassTeacher(String responsiblePerson){
        super(responsiblePerson);
    }   
    protected boolean beAbleToJudge(Question question){
        if(question.level.lessThan(responsibleLevel)){
            return true;
        }
        return false;
    }
    protected void judge(Question question){
        System.out.println("先生が判断");
    }
}

class ChiefTeacher extends Responsible{
    private Level responsibleLevel = new Level(3);
    public ChiefTeacher(String responsiblePerson){
        super(responsiblePerson);
    }   
    protected boolean beAbleToJudge(Question question){
        if(question.level.lessThan(responsibleLevel)){
            return true;
        }
        return false;
    }
    protected void judge(Question question){
        System.out.println("教頭が判断");
    }
}

class StaffMeeting extends Responsible{
    private Level responsibleLevel = new Level(4);
    public StaffMeeting(String responsiblePerson){
        super(responsiblePerson);
    }   
    protected boolean beAbleToJudge(Question question){
        if(question.level.lessThan(responsibleLevel)){
            return true;
        }
        return false;
    }
    protected void judge(Question question){
        System.out.println("職員会議が判断");
    }
}

public class ChainofResponsibility {
    public static void main(String args[]){
        Responsible nakagawa = new Student("中川雄介");
        Responsible rookie = new ClassTeacher("新人先生");
        Responsible veteran = new ChiefTeacher("ベテラン先生");
        Responsible staffMeeting = new StaffMeeting("職員会議");
        nakagawa.setNext(rookie).setNext(veteran).setNext(staffMeeting);
        nakagawa.putQuestion(new Question("おやつはいくらまで？",new Level(1)));
        nakagawa.putQuestion(new Question("携帯電話持って行ってよい？",new Level(4)));
    }
}
/*レベル別などで順番に処理を渡していき、適合するレベルで処理できる*/