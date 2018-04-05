package utils;

import java.io.*;
import java.util.Arrays;

public class TextReader {
    public static String getAllText(String filepath) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        FileReader fr = new FileReader(filepath);
        char[] buffer = new char[32];
        int status;
        while((status = fr.read(buffer)) != -1) {
            stringBuilder.append(Arrays.copyOf(buffer, status));
        }
        fr.close();
        return stringBuilder.toString();
    }
}
