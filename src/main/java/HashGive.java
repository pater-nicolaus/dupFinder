import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGive {
    private byte[] Hash(File file) throws IOException, NoSuchAlgorithmException {
    byte[] buffer = new byte[1000000000];
    InputStream is = new FileInputStream(file);
    int len = is.read(buffer);
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    digest.update(buffer, 0, len);
    byte[] hash = digest.digest();
    return hash;
    }
}
