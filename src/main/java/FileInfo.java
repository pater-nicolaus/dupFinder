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

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }
    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
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