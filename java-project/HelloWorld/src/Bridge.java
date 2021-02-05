class Sorter{
    private SortImple sortImple;
    public Sorter(SortImple sortImple){
        this.sortImple = sortImple;
    }
    public void sort(Object obj[]){
        sortImple.sort(obj);
    }
}
abstract class SortImple{
    public abstract void sort(Object obj[]);
}


class QuickSortImple extends SortImple {
    public void sort(Object obj[]){
        // クイックソートで obj[] をソートする
        System.out.println("Quick sort");
    }
}

class BubbleSortImple extends SortImple{
    public void sort(Object obj[]){
        // バブルソートで obj[] をソートする
        System.out.println("Bubble sort");
    }
}

class TimerSorter extends Sorter{
    public TimerSorter(SortImple sortImple){
        super(sortImple);
    }
    public void timerSort(Object obj[]){
        long start = System.currentTimeMillis();
        sort(obj);
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end - start));
    }
}

public class Bridge {
    public static void main(String[] args) throws Exception {
        SortImple sortImple = new QuickSortImple();
        Sorter sorter = new TimerSorter(sortImple);
        sorter.timerSort();
    }
}
/*継承して新しいメソッドを追加するときに、継承元から継承されてオーバーライドされた関数を読みたいとき、機能と実装の分離*/