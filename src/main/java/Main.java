public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
class Media // класс для хранения данных о файле
{
    public byte[] hash; // хэш
    public String path; // путь
    public long v; //объём

    @Override
    public String toString() {
        return "Media{" +
                "hash=" + Arrays.toString(hash) +
                ", path='" + path + '\'' +
                ", v=" + v +
                '}';
    }
}