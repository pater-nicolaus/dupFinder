public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    class data_of_file // класс для хранения данных о файле
    {
        public byte[] hash; // hash
        public Path path; // path
        public long length; //length

        @Override
        public String toString() {
            return "Media{" +
                    "hash=" + Arrays.toString(hash) +
                    ", path='" + path + '\'' +
                    ", v=" + length +
                    '}';
        }
    }
}