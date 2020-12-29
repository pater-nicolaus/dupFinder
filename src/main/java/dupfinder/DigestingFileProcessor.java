package dupfinder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestingFileProcessor extends FileProcessor{

    public DigestingFileProcessor(Path path, int bufferSize) throws NoSuchAlgorithmException, IOException {
        super(path, bufferSize);
        byte[] buffer = new byte[1000000000];//
        InputStream is = new FileInputStream(path.toFile());
        is.read(buffer);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(buffer, 0, bufferSize);
        byte[] hash = digest.digest();

    }

    void processFilePart(byte[] data, int size) {

    }
}
