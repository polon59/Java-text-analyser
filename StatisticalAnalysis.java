import java.util.*;

public class StatisticalAnalysis{
    private Iterator<String> textIterator;
    private Set<String> uniqueElements = new HashSet<String>();


    public StatisticalAnalysis(Iterator<String> textIterator){
        this.textIterator = textIterator;
        
    }
    public int countOf(String ... elements){
        int counter = 0;
        textIterator.remove();
        for (String element : elements){
            textIterator.remove();
            while (textIterator.hasNext()){
                
                if (textIterator.next().equals(element.toLowerCase())){
                    counter ++;
                }
            }
        }
        return counter;
    }

    public int dictionarySize(){
        textIterator.remove();
        
        while (textIterator.hasNext()){
            String word = textIterator.next();
            if (!(word.isEmpty())){
                this.uniqueElements.add(word);
            }
        }
        return this.uniqueElements.size();
        

    }

    public int size(){
        textIterator.remove();
        int size = 0;

        while (textIterator.hasNext()){
            textIterator.next();
            size++;  
            }
    
        return size;
    }

    public Set<String> occurMoreThan(Integer value){
        dictionarySize();
        Set<String> itemsThatOccurMoreThanValue = new HashSet<String>(); 

        for (String element : uniqueElements){
            if (countOf(element) > value){
                itemsThatOccurMoreThanValue.add(element);
            }
        }
        
        return itemsThatOccurMoreThanValue;
    }

    public float countPercentageOf(int allElementsNumber, int partNumber){
        
        return (float)(partNumber)*100/allElementsNumber;
    }

}