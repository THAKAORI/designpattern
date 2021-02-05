interface TeacherProx {
    public void question1();
    public void question2();
    public void question3();
}

class Yamada implements TeacherProx {
 
    public void question1() {
        System.out.print("～～解答1～～");
    }
 
    public void question2() {
        System.out.print("～～解答2～～");
    }
 
    public void question3() {
        System.out.print("～～解答3～～");
    }
 
}

class Fujiwara implements TeacherProx {
    private TeacherProx yamada = new Yamada();
 
    public void question1() {
        System.out.println("それは「～～解答1～～」です。");
    }
 
    public void question2() {
        System.out.println("それは「～～解答2～～」です。");
    }
 
    public void question3() {
        System.out.print("答えは「");
        //藤原先生には答えられないので、山田先生に聞く
         yamada.question3();
        System.out.println("」となります。");
    }
 
}

public class Proxy {
    public static void main(String[] args) {
        TeacherProx fujiwara = new Fujiwara();
         
        //質問1
        fujiwara.question1();
        //質問2
        fujiwara.question2();
        //質問3
        fujiwara.question3();
         
    }
}
