class Human{
 
    public String name;
    public int height = -1;
    public int weight = -1;
    public int age = -1;
 
    public Human(String name,int height,int weight,int age){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }
}

interface Comparator{
    public int compare(Human h1,Human h2);
}

class AgeComparator implements Comparator{
    public int compare(Human h1 , Human h2){
        if(h1.age > h2.age){
            return 1;
        }else if(h1.age == h2.age){
            return 0;
        }else{
            return -1;
        }
    }
}

class HeightComparator implements Comparator{
    public int compare(Human h1,Human h2){
        if(h1.height > h2.height){
            return 1;
        }else if(h1.height == h2.height){
            return 0;
        }else{
            return -1;
        }
    }
}

class MyClass{
    private Comparator comparator = null;
    public MyClass(Comparator comparator){
        this.comparator = comparator;
    }
    public int compare(Human h1,Human h2){
        return comparator.compare(h1,h2);
    }
}

public class Strategy {
    public static void main(String[] args) throws Exception {
        Comparator comparator = new HeightComparator();
        Human human1 = new Human("taro",170,60,19);
        Human human2 = new Human("hanako",160,40,25);
        MyClass myclass = new MyClass(comparator);
        System.out.println(myclass.compare(human1, human2));
    }
}
/*if文で分岐させるメソッドではなく、アルゴリズムのメソッド中身の変更を柔軟にする*/
