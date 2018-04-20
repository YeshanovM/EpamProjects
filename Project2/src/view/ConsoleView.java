package view;

public class ConsoleView {

    public static final String INPUT_WORD_LENGTH_MESSAGE = "Please, input word length:";
    public static final String INPUT_FILENAME_MESSAGE = "Please, input filepath:";
    public static final String NO_WORDS_FOUND_MESSAGE = "No words from interrogative questions in"
            + "specified file with specified lengths found";
    public static final String FILE_NOT_FOUND_ERROR = "Error! No such file found!";
    public static final String INVALID_NUMBER_ERROR = "Error! Invalid number format!";

    private static final String RESULT_MESSAGE = "All words from interrogative questions in"
            + "specified file with specified lengths:";
    private static final String RESULT_WORDS_SEPARATOR = ", ";

    public ConsoleView() {
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showError(String error) {
        System.err.println(error);
    }

    public void showWords(String[] words) {
        System.out.println(RESULT_MESSAGE);
        for(int i = 0; i < words.length; i++) {
            if(i != 0)
                System.out.print(RESULT_WORDS_SEPARATOR);
            System.out.print(words[i]);
        }
    }
}
