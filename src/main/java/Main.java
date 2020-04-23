public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
class FileInfo   {
        public byte[] hash;
        public Path path;
        public long length;

        @Override
        public String toString() {
            return "Media{" +
                    "hash=" + Arrays.toString(hash) +
                    ", path='" + path + '\'' +
                    ", v=" + length +
                    '}';
        }
    }

