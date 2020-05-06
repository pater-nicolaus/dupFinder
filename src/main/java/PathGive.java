public class PathGive {
    private  void walkDirectory(String path) {
        File filePath = new File(path);
        Stream.of(filePath.listFiles()).forEach(file -> {
            if (file.isDirectory()) {
                walkDirectory(file.toString(),of);
            } else {
                if (file.length() > 0 && file.length() < 1000000000){
                    return filePath;
                });
    }
}
