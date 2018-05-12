import java.util.Iterator;
import java.lang.Math;
import java.util.Set;
import java.lang.System;
import java.io.IOException;

import com.sun.glass.ui.View;


public class Application{
    private FileContent fileContent;
    private Iterator<String> charIterator;
    private Iterator<String> wordIterator;
    private StatisticalAnalysis charAnalysis;
    private StatisticalAnalysis wordAnalysis;
    private static ViewAndSave view = new ViewAndSave();
    
    
    public static void main(String[] args)throws IOException{
        for (String fileName : args){
            Application application = new Application();
            application.countingOperations(fileName);
        }  
        view.saveToFile();
    }

    private void countingOperations(String fileName)throws IOException{
        long startTime = System.nanoTime();
        long finishTime;
        double operationTime;
        fileContent = new FileContent(fileName);
        charIterator = new CharIterator(fileContent);
        wordIterator = new WordIterator(fileContent);
        charAnalysis = new StatisticalAnalysis(charIterator);
        wordAnalysis = new StatisticalAnalysis(wordIterator);

        fileNameReading(fileName);
        characterCounting();
        wordCounting();
        dictSizeCounting();
        mostUsedWordsCounting();
        specifiedWordCounting("love");
        specifiedWordCounting("hate");
        specifiedWordCounting("music");
        vovelsPercentageCounting();
        aeRatioCounting();
        allLettersPercentageCounting();

        finishTime = System.nanoTime();
        operationTime = (finishTime - startTime)/1000000000.0;
        view.appendToStringBuilder("OPERATION TIME: " + operationTime + " seconds\n\n");
        view.printInTerminal();
        // view.saveToFile();
    
    }

    private void fileNameReading(String fileName){
        view.appendToStringBuilder("FILENAME: " + fileName + "\n");
    }

    private void characterCounting(){
        int allCharactersNumber = charAnalysis.size();
        view.appendToStringBuilder("CHARACTERS COUNT: " + allCharactersNumber + "\n");
    }

    private void wordCounting(){
        int allWordsNumber = wordAnalysis.size();
        view.appendToStringBuilder("WORD COUNT: " + allWordsNumber + "\n");
    }

    private void dictSizeCounting(){
        int dictSize = wordAnalysis.dictionarySize();
        view.appendToStringBuilder("DICTIONARY SIZE: " + dictSize + "\n");
    }

    private void mostUsedWordsCounting(){
        int onePercentOccurency = Math.round(wordAnalysis.size()/100);
        Set<String> wordsOccMoreThan = wordAnalysis.occurMoreThan(onePercentOccurency);
        view.appendToStringBuilder("MOST USED WORDS (>1%): ");

        for (String word : wordsOccMoreThan){
            view.appendToStringBuilder(word + " ");
        }

        view.appendToStringBuilder("\n");
    }

    private void specifiedWordCounting(String specifiedWord){
        int specifiedWordOccurency = wordAnalysis.countOf(specifiedWord);
        view.appendToStringBuilder(specifiedWord + " count: " + specifiedWordOccurency + "\n");

    }

    private void vovelsPercentageCounting(){
        int vovelsNumber = charAnalysis.countOf("a","e","i","o","u","y");
        int allCharacters = charAnalysis.size();
        float percentage = charAnalysis.countPercentageOf(allCharacters, vovelsNumber);
        view.appendToStringBuilder("VOVELS %: " + (double)Math.round(percentage * 100d) / 100d + "\n");
    }

    private void aeRatioCounting(){
        float aeRatio = (float)charAnalysis.countOf("e")/charAnalysis.countOf("a");
        view.appendToStringBuilder("A:E RATIO: " + (double)Math.round(aeRatio * 100d) / 100d+ "\n");
    }

    private void allLettersPercentageCounting(){
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k",
            "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int allLetters = charAnalysis.size();

        view.appendToStringBuilder("LETTERS PERCENTAGE: \n");
        for (String letter : alphabet){
            
            int letterOccurency = charAnalysis.countOf(letter);
            float percentage = charAnalysis.countPercentageOf(allLetters, letterOccurency);
            double roundedPercentage = (double)Math.round(percentage * 100d) / 100d;
            view.appendToStringBuilder(letter + "---->" + roundedPercentage + "\n"); 
        }
    }


}