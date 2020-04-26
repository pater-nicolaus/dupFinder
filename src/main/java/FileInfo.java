import java.nio.file.Path;
import java.util.Arrays;

public class FileInfo {
    private Path path;
    private byte[] hash;
    private long length;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Media{" +
                "hash=" + Arrays.toString(hash) +
                ", path='" + path + '\'' +
                ", v=" + length +
                '}';
    }
}