package utils;

import java.util.*;

public class ConsoleReader {

    private Scanner sc;

    public ConsoleReader() {
        sc = new Scanner(System.in);
    }

    public String readFilename() {
        return sc.nextLine();
    }

    public int readWordLength() throws InputMismatchException {
        return sc.nextInt();
    }
}