abstract class CutPrint{
 
    protected abstract void draw( Cuttable hanzai );
    protected abstract void cut( Cuttable hanzai );
    protected abstract void print( Cuttable hanzai );
    protected Cuttable createCuttable(){
        return new Wood();
    }
    public void createCutPrint(){
        Cuttable hanzai = createCuttable();
        draw( hanzai );
        cut( hanzai );
        print( hanzai );
    }
}

class Potato implements Cuttable{

}

class ImagawasCutPrint extends CutPrint{
    protected void draw(Cuttable hanzai){
         System.out.println("マンガの絵を描く");
    }
    protected void cut(Cuttable hanzai){
         System.out.println("彫刻刀を利用して器用に彫る");
    }
    protected void  print(Cuttable hanzai){
         System.out.println("インクとして、自分の血を使いプリントする");
    }
    protected Cuttable createCuttable(){
        return new Potato();
    }
}

public class FactoryMethod {
    public static void main(String[] args) throws Exception {
        CutPrint cutprint = new ImagawasCutPrint();
        cutprint.createCutPrint();
    }
}
/*操作するインスタンスの種類をコンストラクタを工夫することで変更可能にする*/