package model;

import model.entity.*;
import java.io.*;
import java.util.*;

public class Model {

    public Model() {
    }

    public String[] getWords(String filePath, int wordLength) {
        ArrayList<Sentence<SentenceUnit>> questions = getInterrogativeSentences(filePath);
        TreeSet<Word> wordsTreeSet = new TreeSet<>();
        for(Sentence<SentenceUnit> question : questions) {
            for(SentenceUnit unit : question.getUnits()) {
                if(unit instanceof Word && ((Word) unit).getLength() == wordLength)
                    wordsTreeSet.add((Word) unit);
            }
        }
        String[] result = new String[wordsTreeSet.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = wordsTreeSet.pollFirst().getValue();
        }
        return result;
    }

    private ArrayList<Sentence<SentenceUnit>> getInterrogativeSentences(String filePath) {
        ArrayList<Sentence<SentenceUnit>> result = new ArrayList<>();
        try {
            FileReader fr = new FileReader(filePath);
            int symbol;
            StringBuffer buffer = new StringBuffer();
            do {
                symbol = fr.read();
                buffer.append((char)symbol);
                if(symbol == '.' || symbol == '?' || symbol == '!') {
                    if(symbol == '?')
                        result.add(new Sentence<>(buffer.toString()));
                    buffer = new StringBuffer();
                }
            } while(symbol != -1);
            fr.close();
        }
        catch (IOException e) {
            return null;
        }
        return result;
    }
}
