import java.io.File;
import java.util.*;

class Ite{
    public void Main(String[] args){
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Object> ListOfFile = new ArrayList<>();
        Iterator iterator =  list.iterator();

        while (iterator.hasNext()){
            Object f = iterator.next();
            ListOfFile.add(f);
        }

    }
}