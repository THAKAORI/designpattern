import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

interface DirectoryEntry{
    public void remove();
}

class File implements DirectoryEntry{
    private String name = null;
    public File(String name){
        this.name = name;
    }
    public void remove(){
        System.out.println(name + "を削除しました");
    }
}

class SymbolicLink implements DirectoryEntry{
    private String name = null;
    public SymbolicLink(String name) {
        this.name = name;
    }
    public void remove(){
        System.out.println(name + "を削除しました");
    }
}

class Directory implements DirectoryEntry{
    private List<DirectoryEntry> list = null;
    private String name = null;
    public Directory(String name){
        this.name = name;
        list = new ArrayList<DirectoryEntry>();
    }
    public void add(DirectoryEntry entry){
        list.add(entry);
    }
    public void remove(){
        Iterator<DirectoryEntry> itr = list.iterator();
        while(itr.hasNext()){
            DirectoryEntry entry = itr.next();
            entry.remove();
        }
        System.out.println(name + "を削除しました。");
    }
}

public class Composite {
    public static void main(String args[]){
        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");
        File file4 = new File("file4");
        SymbolicLink link = new SymbolicLink("link1");
        Directory dir1 = new Directory("dir1");
        dir1.add(file1);
        Directory dir2 = new Directory("dir2");
        dir2.add(file2);
        dir2.add(file3);
        dir1.add(dir2);
        dir1.add(file4);
        dir1.add(link);
         
        dir1.remove();
    }
}
/*容器(Directory)と中身(File)を同一視して同じインターフェースから派生させる。再帰的な処理をさせたいとき*/