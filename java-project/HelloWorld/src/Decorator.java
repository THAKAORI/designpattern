interface Icecream{
    public String getName();
    public String howSweet();
}

class VanillaIcecream implements Icecream{
    public String getName(){
        return "バニラアイスクリーム";
    }
    public String howSweet(){
        return "バニラ味";
    }
}

class GreenTeaIcecream implements Icecream{
    public String getName(){
        return "抹茶アイスクリーム";
    }
    public String howSweet(){
        return "抹茶味";
    }
}

class CashewNutsToppingIcecream implements Icecream{
    private Icecream ice = null;
    public CashewNutsToppingIcecream(Icecream ice){
        this.ice = ice;
    }
    public String getName(){
        String name = "カシューナッツ";
        name += ice.getName();
        return name;
    }
    public String howSweet(){
        return ice.howSweet();
    }
}

class SliceAlmondToppingIcecream implements Icecream{
    private Icecream ice = null;
    public SliceAlmondToppingIcecream(Icecream ice){
        this.ice = ice;
    }
    public String getName(){
        String name = "スライスアーモンド";
        name += ice.getName();
        return name;
    }
    public String howSweet(){
        return ice.howSweet();
    }
}

public class Decorator {
    public static void main(String args[]){
        Icecream ice1 = new CashewNutsToppingIcecream(new VanillaIcecream());
        System.out.println(ice1.getName());
        Icecream ice2 = new CashewNutsToppingIcecream(new GreenTeaIcecream());
        System.out.println(ice2.getName());
        Icecream ice3 = new SliceAlmondToppingIcecream(new CashewNutsToppingIcecream(new VanillaIcecream()));
        System.out.println(ice3.getName());
    }
}
/*中身と装飾を同一視することで包む形で追加実装を柔軟に行うことができる*/