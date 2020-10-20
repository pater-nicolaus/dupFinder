import java.io.File;
import java.util.stream.Stream;

public class PathGive {
    private String walkDirectory(String path) {
        // we should refactor this
        File filePath = new File(path);
        Stream.of(filePath.listFiles()).forEach(file -> {
            if (file.isDirectory()) {
                walkDirectory(file.toString());
            } else {
                if (file.length() > 0 && file.length() < 1000000000) {
                    String absolutePath = new String() ;
                    absolutePath =  file.getAbsolutePath().toString();
                    //return absolutePath;
                }

            }
        });
        return null;
    }
}