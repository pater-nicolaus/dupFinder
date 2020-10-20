package dupfinder;

import java.io.*;
import java.nio.file.Path;


abstract public class FileProcessor {
    private Path path;
    private byte[] buffer;

    public FileProcessor(Path path, int bufferSize) {
        this.path = path;
        this.buffer = new byte[bufferSize];


    }

    public void processFile() throws IOException {
        File file = path.toFile();
        FileInputStream inputStream = new FileInputStream(new BufferedReader((Reader) path).readLine());
        int bufSize = buffer.length;

        while (inputStream.available() > 0) {
            if (inputStream.available() < bufSize) bufSize = inputStream.available();
            buffer = inputStream.readNBytes(bufSize);
            processFilePart(buffer, buffer.length);
    }

//        for(int i=0;i<file.length();i+=buffer.length){
//            for (int j = 0+i;j< buffer.length;j++){
//                inputStream.read(buffer,j,j+1);
//            }
//        }
    }



    abstract void processFilePart(byte[] data, int size);
}
