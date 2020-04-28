public class Hash {
    byte[] myProc(File file) throws IOException, NoSuchAlgorithmException {
    //String name = new String("");
    byte[] buffer = new byte[1000000000];
    InputStream is = new FileInputStream(file);
    int len = is.read(buffer);
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    digest.update(buffer, 0, len);
    byte[] hash = digest.digest();
    return hash;
}
}
