package dupfinder;

import org.mockito.Mockito;
import org.springframework.util.FileSystemUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static org.testng.Assert.fail;

public class FileProcessorTest {
    Path tempDir;

    static class FileProcessorFake extends FileProcessor {

        public FileProcessorFake(Path path, int bufferSize) {
            super(path, bufferSize);
        }

        @Override
        public void processFilePart(byte[] data, int size) {
        }
    }

    FileProcessorFake fileProcessor;

    @BeforeClass
    public void setup() throws IOException {
        tempDir = Files.createTempDirectory("test");
    }

    @AfterClass
    public void tearDown() throws IOException {
        FileSystemUtils.deleteRecursively(tempDir);
    }

    @Test
    public void testSingleBlock() {
        try {
            TestFile testFile = new TestFile(tempDir, "file1", 100);
            fileProcessor = Mockito.spy(new FileProcessorFake(testFile.getPath(), 100));
            fileProcessor.processFile();
            Mockito.verify(fileProcessor).processFilePart(testFile.getData(), testFile.getLength());
            testFile.delete();
        } catch (IOException e) {
            fail("Unexpected exception", e);
        }
    }

    @Test
    public void testMultipleBlocks() {
        try {
            TestFile testFile = new TestFile(tempDir, "file2", 100);
            fileProcessor = Mockito.spy(new FileProcessorFake(testFile.getPath(), 50));
            fileProcessor.processFile();
            byte[] part1 = Arrays.copyOfRange(testFile.getData(), 0, 50);
            byte[] part2 = Arrays.copyOfRange(testFile.getData(), 50, 100);
            Mockito.verify(fileProcessor).processFilePart(part1, 50);
            Mockito.verify(fileProcessor).processFilePart(part2, 50);
            testFile.delete();
        } catch (IOException e) {
            fail("Unexpected exception", e);
        }
    }
}