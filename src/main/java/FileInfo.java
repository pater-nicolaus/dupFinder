public class FileInfo  {
    private byte[] hash;

    {
        public byte[] getHash () {
        return hash;
    }
        public void setHash ( byte[] hash){
        this.hash = hash;
    }
    }
    private Path path;
    private long length;

    @Override
    private String toString() {
        return "Media{" +
                "hash=" + Arrays.toString(hash) +
                ", path='" + path + '\'' +
                ", v=" + length +
                '}';
    }
}