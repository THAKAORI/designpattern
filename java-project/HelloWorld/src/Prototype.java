import java.util.*;

class TeacherProto{
    public Paper[] createManyCrystals(){
        Paper prototype = new Paper("雪の結晶");
        drawCrystal(prototype);
        cutAccordanceWithLine(prototype);
         
        Paper[] papers = new Paper[100];
 
        for(int n=0; n<papers.length ; n++){
            papers[n] = (Paper)prototype.createClone();
        }
        return papers;
    }
    private void drawCrystal(Paper paper){
        // 描いたり消したりしながら、きれいに描くため時間がかかる
    }
    private void cutAccordanceWithLine(Paper paper){
        // 描かれた線に沿ってきれいに切るには時間がかかる
    }
}

interface Cloneable{
    public Cloneable createClone();
}

class Paper implements Cloneable{
    private String name;
    public Paper(){}
    public Paper(String name){
        this.name = name;
    }
    public String getname(){
        return name;
    }
    public Cloneable createClone(){
        Paper newPaper = new Paper();
        newPaper.name = this.name;
        // newPaper と this を重ねて、this の形に切り抜く
        return newPaper;
    }
}

class PrototypeKeeper{
    private Map<String,Cloneable> map;
    public PrototypeKeeper(){
        this.map = new HashMap<String,Cloneable> ();
    }
    public void addCloneable(String key,Cloneable prototype){
        map.put( key , prototype );
    }
    public Cloneable getClone(String key){
        Cloneable prototype = map.get(key);
        return prototype.createClone();
    }
}

public class Prototype {
    public static void main(String[] args) throws Exception {
        TeacherProto teacher = new TeacherProto();
        Paper[] paper = teacher.createManyCrystals();
        System.out.println(paper[0].getname());
    }
}

/*複雑な操作がなされたインスタンスをコピーすることができる*/
