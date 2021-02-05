class Taro{
    public void enjoyWithAllClassmate(){
        System.out.println("みんなで楽しむ");
    }
}

interface Chairperson{
    public void organizeClass();
}

class NewTaro extends Taro implements Chairperson{
    public void organizeClass(){
        enjoyWithAllClassmate();
    }
}

public class adapter {
    public static void main(String[] args) throws Exception {
        Chairperson chairperson = new NewTaro();
        chairperson.organizeClass();
    }
}
/*あらかじめメソッドを考えておき、それを実現するメソッドを新しく変更できる。organizeClassの中身を変えることでインターフェースの変更を吸収できる*/