package dupfinder;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.mockito.Mockito;
import org.springframework.util.FileSystemUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class FileProcessorTest {
    Path tempDir;

    static class FileProcessorFake extends FileProcessor {
        List<Pair<byte[], Integer>> parts = new ArrayList<>();

        public FileProcessorFake(Path path, int bufferSize) {
            super(path, bufferSize);
        }

        @Override
        public void processFilePart(byte[] data, int size) {
            parts.add(new ImmutablePair<>(data.clone(), size));
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
            try {
                fileProcessor = Mockito.spy(new FileProcessorFake(testFile.getPath(), 100));
                fileProcessor.processFile();
                Mockito.verify(fileProcessor).processFilePart(testFile.getData(), testFile.getLength());
            } finally {
                testFile.delete();
            }
        } catch (IOException e) {
            fail("Unexpected exception", e);
        }
    }

    @Test
    public void testMultipleBlocks() {
        try {
            TestFile testFile = new TestFile(tempDir, "file2", 100);
            try {
                fileProcessor = Mockito.spy(new FileProcessorFake(testFile.getPath(), 50));
                fileProcessor.processFile();
                byte[] part1 = Arrays.copyOfRange(testFile.getData(), 0, 50);
                byte[] part2 = Arrays.copyOfRange(testFile.getData(), 50, 100);
                assertEquals(fileProcessor.parts.size(), 2);
                assertArrayEquals(part1, fileProcessor.parts.get(0).getLeft(), fileProcessor.parts.get(0).getRight());
                assertArrayEquals(part2, fileProcessor.parts.get(1).getLeft(), fileProcessor.parts.get(1).getRight());
            } finally {
                testFile.delete();
            }
        } catch (IOException e) {
            fail("Unexpected exception", e);
        }
    }

    private void assertArrayEquals(byte[] part1, byte[] left, Integer right) {
        for (int i = 0; i < right; i++) {
            assertEquals(part1[i], left[i]);
        }
    }
}