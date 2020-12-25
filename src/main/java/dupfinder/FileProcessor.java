package dupfinder;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;


abstract public class FileProcessor {
    private Path path;
    private byte[] buffer;

    public FileProcessor(Path path, int bufferSize) {
        this.path = path;
        this.buffer = new byte[bufferSize];
    }

    public void processFile() throws IOException {
        try (RandomAccessFile file = new RandomAccessFile(path.toFile(), "r")) {
            FileChannel fileChannel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
            do {
                int bytesRead = fileChannel.read(byteBuffer);
                if (bytesRead == 0 || bytesRead == -1)
                    break;
                processFilePart(buffer, bytesRead);
                byteBuffer.rewind();
            } while (true);
        }
    }

    abstract void processFilePart(byte[] data, int size);
}
