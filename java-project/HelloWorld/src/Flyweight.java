import java.util.HashMap;
import java.util.Map;

class HumanLetter{
    private String letter;
    public HumanLetter(String letter){
        this.letter = letter;
    }
    public String getLetter(){
        return letter;
    }
}

class HumanLetterFactory {
    /**
     * 人文字のマップ
     */
    Map<String,HumanLetter> map = new HashMap<String,HumanLetter>();
 
    /**
     * Singleton の生成
     */
    private static HumanLetterFactory singleton = new HumanLetterFactory();
 
    /**
     * Singleton パターン
     */
    private HumanLetterFactory() {}
 
    /**
     * インスタンスを取得するメソッド
     * 唯一のインスタンスが返される。
     * @return singleton
     */
    public static HumanLetterFactory getInstance() {
        return singleton;
    }
 
    /**
     * 人文字を取得するメソッド。
     * すでに持っているものであれば、map から返す。
     * map に持っていないものは生成して map への登録を行った後に返り値として返す。
     *
     * @param letter
     * @return humanLetter
     */
    public synchronized HumanLetter getHumanLetter(String letter) {
        HumanLetter humanLetter = map.get(letter);
        if (humanLetter == null) {
            humanLetter = new HumanLetter(letter);
            map.put(letter, humanLetter);
        }
        return humanLetter;
    }
 
}

public class Flyweight {
    public static void main(String args[]) {
        HumanLetterFactory factory = HumanLetterFactory.getInstance();
        takeAPhoto(factory.getHumanLetter("あ"));
        takeAPhoto(factory.getHumanLetter("い"));
        takeAPhoto(factory.getHumanLetter("は"));
        takeAPhoto(factory.getHumanLetter("あ"));
        takeAPhoto(factory.getHumanLetter("い"));
        takeAPhoto(factory.getHumanLetter("よ"));
        takeAPhoto(factory.getHumanLetter("り"));
        takeAPhoto(factory.getHumanLetter("も"));
        takeAPhoto(factory.getHumanLetter("あ"));
        takeAPhoto(factory.getHumanLetter("お"));
        takeAPhoto(factory.getHumanLetter("い"));
    }
 
    /**
     * 写真を撮るメソッド
     * @param letter
     */
    private static void takeAPhoto(HumanLetter letter) {
        System.out.println(letter.getLetter());
    }
}
