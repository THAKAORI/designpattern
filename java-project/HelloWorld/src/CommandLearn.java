import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

class Beaker {
    private double water = 0; //水
    private double salt = 0; //食塩
    private boolean melted = true; //食塩がすべて溶けたときtrue、溶け残ったときfalse
   
    //コンストラクタ
    public Beaker(double water, double salt) {
        this.water = water;
        this.salt = salt;
        this.mix();//かき混ぜる
    }
    //ビーカーに食塩を入れるメソッド
    public void addSalt(double salt) {
        this.salt += salt;
    }
    //ビーカーに水を入れるメソッド
    public void addWater(double water) {
        this.water += water;
    }
    //かき混ぜるメソッド
    public void mix() {
        //溶液をかき混ぜる
        //溶けたか溶け残ったかをセットする
        //常温での飽和食塩水の濃度は約26.4%
        if((this.salt / (this.salt+this.water))*100 < 26.4){
            melted = true;
        }else{
            melted = false;
        }
    }
    //食塩の量を返すメソッド
    public double getSalt() {
        return salt;
    }
    //水の量を返すメソッド
    public double getWater() {
        return water;
    }
    //溶けたか溶け残ったか調べるメソッド
    public boolean isMelted() {
        return melted;
    }
    //実験結果をノートに記録する
    public void note() {
        System.out.println("水：" + water + "g");
        System.out.println("食塩：" + salt + "g");
        System.out.println("濃度：" + (salt / (water + salt))*100 + "%");
    }
}

abstract class Command {
    //ビーカー
    protected Beaker beaker;
    //ビーカーをセットするメソッド
    public void setBeaker(Beaker beaker) {
         this.beaker = beaker;
    }
    //要求内容を実行する抽象メソッド
    public abstract void execute();
}

class AddSaltCommand extends Command {
 
    public void execute() {
        //食塩を1gずつ加えて飽和食塩水を作る実験をする場合
        //完全に溶けている間は食塩を加える
        while (beaker.isMelted()) {
           beaker.addSalt(1); //食塩を1g入れる
            beaker.mix(); //かき混ぜる
        }
        //実験結果をノートに記述する
        System.out.println("食塩を1gずつ加える実験");
       beaker.note();
    }
}

class AddWaterCommand extends Command {
    public void execute() {
        //水を10gずつ加えて飽和食塩水を作る実験をする場合
        //溶け残っている間は水を加える
        while (!beaker.isMelted()) {
            beaker.addWater(10); //水を10g入れる
            beaker.mix(); //かき混ぜる
        }
        //実験結果をノートに記述する
        System.out.println("水を10gずつ加える実験");
        beaker.note();
    }
}

class MakeSaltWaterCommand extends Command {
    public void execute() {
        //食塩水を作る実験
        beaker.mix();
        //濃度をはかり、ノートに記述する
        System.out.println("食塩水を作る実験");
        beaker.note();
    }
}

class MakeSaltWaterAddSaltCommand extends Command {
    //実験リスト
    private List<Command> commands = new LinkedList<Command>();
    //実験を実行するメソッド
    public void execute() {
        Iterator<Command> iterator = commands.iterator();
        //実験リストの実行
        Command command = null;
        while(iterator.hasNext()){
            command = iterator.next();
            command.execute();
        }
        //実験結果をノートに記述する
        System.out.println("食塩水を作り、それに食塩を1gずつ加えて飽和食塩水を作る実験");
        beaker.note();
    }
    //実験リストに追加するメソッド
    public void addCommand(Command command){
        commands.add(command);
    }
}

public class CommandLearn {
    public static void main(String[] args) {
         //実験内容(コマンドオブジェクト)を用意する
         Command makeSaltWater = new MakeSaltWaterCommand();
        Command addSalt = new AddSaltCommand();
        MakeSaltWaterAddSaltCommand makeSaltWaterAddSalt
                                  = new MakeSaltWaterAddSaltCommand();
        //実験セットを実験内容にセットする
         Beaker beaker = new Beaker(90,10);
        makeSaltWater.setBeaker(beaker);
        addSalt.setBeaker(beaker);
        makeSaltWaterAddSalt.setBeaker(beaker);
        //実験リストをセットする
         makeSaltWaterAddSalt.addCommand(makeSaltWater);
        makeSaltWaterAddSalt.addCommand(addSalt);
        //実験を行う
         makeSaltWaterAddSalt.execute();
    }
}
