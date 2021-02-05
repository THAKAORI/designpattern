interface State {
    /**
     * 朝のあいさつを返すメソッドを定義する
     */
    public String morningGreet();
 
    /**
     * 寒いときの対策を返すメソッドを定義する
     */
    public String getProtectionForCold();
}

class StatePatternYumichan {
 
    /** 由実ちゃんの状態を表すプロパティ */
    private State state = null;
 
    /**
     * 由実ちゃんの状態を変更するメソッド
     * @param state
     */
    public void changeState(State state) {
        this.state = state;
    }

    public void getStatement(){
        System.out.println(morningGreet()+getProtectionForCold());
    }
 
    /**
     * 朝のあいさつを返すメソッド
     * @return
     */
    public String morningGreet() {
        return this.state.morningGreet();
    }
 
    /**
     * 寒いときの対策を取得するメソッド
     * @return
     */
    public String getProtectionForCold() {
        return this.state.getProtectionForCold();
    }
}

class BadMoodState implements State {
    /**
     * 朝のあいさつです。機嫌の悪いときは、ぶっきらぼうに応えます。
     */
    public String morningGreet() {
        return "おお";
    }
 
    /**
     * 冬の防寒方法です。機嫌の悪いときはももひきをはきます。
     */
    public String getProtectionForCold() {
        return "ももひき";
    }
}

class OrdinaryState implements State {
    /**
     * 朝のあいさつです。通常は、男らしく応えます。
     */
    public String morningGreet() {
        return "おっす！";
    }
 
    /**
     * 冬の防寒方法です。走るようです。
     */
    public String getProtectionForCold() {
        return "走る";
    }
}

public class StateLearn {
    public static void main(String[] args) {
        StatePatternYumichan yumichan = new StatePatternYumichan();
        State bad = new BadMoodState();
        State ordinal = new OrdinaryState();
        yumichan.changeState(bad);
        yumichan.getStatement();
        yumichan.changeState(ordinal);
        yumichan.getStatement();
    }  
}
