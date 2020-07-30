import java.io.File;
import java.util.*;

class Ite{
    public static void main(String[] args){
        String path = "D:\\Code\\Data";
        File dir = new File(path);
        List<File> list = new ArrayList<>();
        for ( File file : dir.listFiles() ){
            if ( file.isFile() )
                list.add(file);
        }
        ArrayList<Object> ListOfFile = new ArrayList<>();
        Iterator iterator =  list.iterator();

        while (iterator.hasNext()){
            Object f = iterator.next();
            ListOfFile.add(f);
        }

        for (Object f: ListOfFile)
        {
            System.out.println(f);
        }
    }
}