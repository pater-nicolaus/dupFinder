package dupfinder;

import java.io.IOException;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestingFileProcessor extends FileProcessor {
    private MessageDigest digest = MessageDigest.getInstance("SHA-256");

    public DigestingFileProcessor(Path path, int bufferSize) throws NoSuchAlgorithmException, IOException {
        super(path, bufferSize);
    }

    @Override
    protected void processFilePart(byte[] data, int size) {
        digest.update(data, 0, size);
    }

    public byte[] getDigest() {
        return digest.digest();
    }
}
