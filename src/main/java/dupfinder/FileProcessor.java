package dupfinder;

import sun.nio.ch.DirectBuffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
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
            //KLUDGE: here we can read only files less than 2GB. If we need to read bigger files we should move the mapping window.
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
            try {
                while (mappedByteBuffer.hasRemaining()) {
                    int bytesToRead = Math.min(buffer.length, mappedByteBuffer.remaining());
                    mappedByteBuffer.get(buffer, 0, bytesToRead);
                    processFilePart(buffer, bytesToRead);
                }
            } finally {
                ((DirectBuffer) mappedByteBuffer).cleaner().clean();
            }
        }
    }

    abstract void processFilePart(byte[] data, int size);
}
