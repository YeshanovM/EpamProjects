package model;

import model.entity.*;
import model.entity.enums.SentenceType;

import java.io.*;
import java.util.*;

public class Model {

    private Sentence[] sentences;

    public Model() {
    }

    public String[] getWordsByLength(Sentence[] sentences, int wordLength) {
        TreeSet<Word> wordsTreeSet = new TreeSet<>();
        for(Sentence question : sentences) {
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

    public String[] getWordsByLength(int wordLength) {
        return getWordsByLength(sentences, wordLength);
    }

    public void getAllSentences(String text) {
        ArrayList<Sentence> result = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            buffer.append(symbol);
            if(symbol == '.' || symbol == '?' || symbol == '!') {
                result.add(new Sentence(buffer.toString()));
                buffer = new StringBuffer();
            }
        }
        sentences = new Sentence[result.size()];
        for(int i = 0; i < result.size(); i++) {
            sentences[i] = result.get(i);
        }
    }

    public Sentence[] getSentencesByType(Sentence[] sentences, SentenceType type) {
        ArrayList<Sentence> result = new ArrayList<>();
        for(Sentence sentence : sentences) {
            if(sentence.getType() == type)
                result.add(sentence);
        }
        Sentence[] resultArray = new Sentence[result.size()];
        int i = 0;
        for(Sentence sentence : result) {
            resultArray[i] = sentence;
            i++;
        }
        return resultArray;
    }

    public Sentence[] getSentencesByType(SentenceType type) {
        return getSentencesByType(sentences, type);
    }
}
