package controller;

import model.Model;
import model.entity.enums.SentenceType;
import utils.*;
import view.ConsoleView;

import java.io.*;
import java.util.*;

public class Controller {

    private Model model;
    private ConsoleView view;
    private ConsoleReader reader;

    public Controller(Model model, ConsoleView view) {
        this.model = model;
        this.view = view;
        reader = new ConsoleReader();
    }

    public void run() {
        File file = getExistingFile();
        int wordLength = getWordLength();
        try {
            String text = TextReader.getAllText(file.getAbsolutePath());
            model.getAllSentences(text);
            String[] words = model.getWordsByLength(
                    model.getSentencesByType(SentenceType.INTERROGATIVE),
                    wordLength
            );
            if(words != null && words.length != 0)
                view.showWords(words);
            else
                view.showMessage(ConsoleView.NO_WORDS_FOUND_MESSAGE);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File getExistingFile() {
        view.showMessage(ConsoleView.INPUT_FILENAME_MESSAGE);
        File file = new File(reader.readFilename());
        while(!file.exists() || !file.isFile()) {
            view.showError(ConsoleView.FILE_NOT_FOUND_ERROR);
            view.showMessage(ConsoleView.INPUT_FILENAME_MESSAGE);
            file = new File(reader.readFilename());
        }
        return file;
    }

    private int getWordLength() {
        view.showMessage(ConsoleView.INPUT_WORD_LENGTH_MESSAGE);
        int wordLength = -1;
        boolean isCorrect = false;
        while(!isCorrect) {
            try {
                wordLength = reader.readWordLength();
                isCorrect = true;
            }
            catch (InputMismatchException e) {
                view.showError(ConsoleView.INVALID_NUMBER_ERROR);
                view.showMessage(ConsoleView.INPUT_WORD_LENGTH_MESSAGE);
            }
        }
        return wordLength;
    }
}
