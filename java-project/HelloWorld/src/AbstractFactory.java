import java.util.*;

class Soup{}

class ChickenBonesSoup extends Soup{}

class Ingredients{}

class Protein extends Ingredients{}

class Chicken extends Protein{}

class Beef extends Protein{}

class Tofu extends Protein{}

class Vegetable extends Ingredients{}

class ChineseCabbage extends Vegetable{}

class Leek extends Vegetable {}

class Chrysanthemum extends Vegetable{}

class Pot{}

class HotPot{
    private Pot pot;
    private Soup soup;
    private Protein protein;
    private List vegetables;
    private List otherIngredients;
    public HotPot(Pot pot){
        this.pot = pot;
    }
    public void addSoup(Soup soup){
        this.soup = soup;
    }
    public void addMain(Protein protein){
        this.protein = protein;
    }
    public void addVegetables(List<Vegetable> vegetables){
        this.vegetables = vegetables;
    }
    public void addOtherIngredients(List<Ingredients> otherIngredients){
        this.otherIngredients = otherIngredients;
    }
}

abstract class Factory{
    public abstract Soup getSoup();
    public abstract Protein getMain();
    public abstract List getVegetables();
    public abstract List getOtherIngredients();
}

class MizutakiFactory extends Factory{
    public Soup getSoup(){
        return new ChickenBonesSoup();
    }
    public Protein getMain(){
        return new Chicken();
    }
    public List<Vegetable> getVegetables(){
        List<Vegetable> vegetables = new ArrayList<Vegetable>();
        vegetables.add(new ChineseCabbage());
        vegetables.add(new Leek());
        vegetables.add(new Chrysanthemum());
        return vegetables;
    }
    public List<Ingredients> getOtherIngredients(){
        List<Ingredients> otherIngredients = new ArrayList<Ingredients>();
        otherIngredients.add(new Tofu());
        return otherIngredients;
    }
}

public class AbstractFactory {
    public static void main(String args[]){
        HotPot hotPot = new HotPot(new Pot());
        Factory factory = new MizutakiFactory();
        hotPot.addSoup(factory.getSoup());
        hotPot.addMain(factory.getMain());
        hotPot.addVegetables(factory.getVegetables());
        hotPot.addOtherIngredients(factory.getOtherIngredients());
    }
    private static Factory createFactory(String str){
        // if("キムチ鍋".equals(str)){
        //     return new KimuchiFactory();
        // }else if("すき焼き".equals(str)){
        //     return new SukiyakiFactory();
        // }else{
        //     return new MizutakiFactory();
        // }
        return new MizutakiFactory();
    }
}
/*工場のような一連の作業を抽象化して、商品ごとに具体的な作業内容を決めるというもの*/