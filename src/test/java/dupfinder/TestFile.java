package dupfinder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

import static org.testng.Assert.assertTrue;

public class TestFile {
    private Path path;
    private File file;
    private byte[] data;

    public TestFile(Path tempDir, String fileName, int size) throws IOException {
        path = tempDir.resolve("./" + fileName);
        file = path.toFile();
        assertTrue(file.createNewFile());
        FileOutputStream fos = new FileOutputStream(file);
        data = new byte[size];
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) i;
        }
        fos.write(data);
        fos.close();
    }

    public Path getPath() {
        return path;
    }

    public boolean delete() {
        return file.delete();
    }

    public byte[] getData() {
        return data;
    }

    public int getLength() {
        return data.length;
    }
}
