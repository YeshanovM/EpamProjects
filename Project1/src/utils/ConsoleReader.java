package utils;

import java.util.*;

public class ConsoleReader {

    private Scanner scanner;

    public ConsoleReader() {
        scanner = new Scanner(System.in);
    }

    public String[] readCmd() {
        return scanner.nextLine().trim().split("[ \\t]+");
    }
}
