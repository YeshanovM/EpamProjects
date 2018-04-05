package utils;

import org.junit.*;

import java.io.*;
import java.nio.file.Files;

import static org.junit.Assert.*;

public class TextReaderTest {

    private static final String FILEPATH = "test.txt";
    private static final String TEXT = "Quick brown fox jumps over the lazy dog.\nABC";

    @Before
    public void setUp() throws IOException {
        FileWriter fw = new FileWriter(FILEPATH);
        fw.write(TEXT);
        fw.close();
    }

    @After
    public void tearDown() throws IOException {
        Files.deleteIfExists(new File(FILEPATH).toPath());
    }

    @Test
    public void getAllTextTest() throws IOException {
        assertTrue(TextReader.getAllText(FILEPATH).equals(TEXT));
    }
}