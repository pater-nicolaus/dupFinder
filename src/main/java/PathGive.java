import java.io.File;
import java.util.stream.Stream;

public class PathGive {
    private File walkDirectory(String path) {
        File filePath = new File(path);
        Stream.of(filePath.listFiles()).forEach(file -> {
            if (file.isDirectory()) {
                walkDirectory(file.toString());
            } else {
                if (file.length() > 0 && file.length() < 1000000000) {
                    return filePath = file.getAbsolutePath();
                }
                ;
            }
        });
    }
}