package dupfinder;

import java.io.*;
import java.nio.file.Path;


abstract public class FileProcessor {
    private Path path;
    private byte[] buffer;

    public FileProcessor(Path path, int bufferSize) {
        this.path = path;
        this.buffer = new byte[bufferSize];


    }

    public void processFile() throws IOException {
        int bytesRead;

        try (FileInputStream f = new FileInputStream(path.toString())) {
            do {
                bytesRead = f.read(buffer, 0, buffer.length);
                if (bytesRead != -1)
                    processFilePart(buffer, bytesRead);
            } while (bytesRead != -1);
        }
    }


    abstract void processFilePart(byte[] data, int size);
}
