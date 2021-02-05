import java.util.HashMap;
import java.util.Map;

/**
 * ひとつの計算を表すクラス。
 */
class Calc {
    private int temp = 0;
 
    /**
     * 足し算を実行するメソッド
     * @param plus
     */
    public void plus(int plus) {
        temp += plus;
    }
 
    /**
     * 途中経過を Memento として取得するメソッド
     * @return memento
     */
    public Memento createMemento() {
        return new Memento(temp);
    }
 
    /**
     * Memento から計算経過を取得して、temp にセットする
     * @param mement
     */
    public void setMemento(Memento memento) {
        this.temp = memento.result;
    }
 
    /**
     * 計算結果を取得するメソッド
     * @return temp
     */
    public int getTemp() {
        return this.temp;
    }
 
    /**
     * 途中経過を保持する Memento クラス
     */
    public class Memento {
        /** 計算の途中経過を表す */
        private int result = -1;
 
        /**
         * 計算経過を引数に受け取るコンストラクタ
         * @param temp
         */
        Memento(int temp) {
            this.result = temp;
        }
    }
}

public class MementoLearn {
    private static Map<String,Calc.Memento> map = new HashMap<String,Calc.Memento>();
    public static void main(String args[]) {
        Calc calc = new Calc();
        for (int n = 1; n <= 5; n++) {
            calc.plus(n);
        }
        System.out.println(calc.getTemp());
        map.put("5までの足し算", calc.createMemento());
 
        // 数日経過
        // 10までの足し算をしたい。
 
        Calc calc2 = new Calc();
        calc2.setMemento(map.get("5までの足し算"));
        for (int n = 6; n <= 10; n++) {
            calc2.plus(n);
        }
        System.out.println(calc2.getTemp());
        map.put("10までの足し算", calc2.createMemento());
    }
}

/*処理の状態のスナップショットを作成して復元したり利用したりできる*/