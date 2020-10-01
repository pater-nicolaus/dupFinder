package dupfinder;

import java.nio.file.Path;

abstract public class FileProcessor {
    private Path path;
    private byte[] buffer;

    public FileProcessor(Path path, int bufferSize) {
        this.path = path;
        this.buffer = new byte[bufferSize];
    }

    public void processFile() {

    }

    abstract void processFilePart(byte[] data, int size);
}
