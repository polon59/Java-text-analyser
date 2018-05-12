import java.util.Iterator;

public class WordIterator implements Iterator<String>{
    private int index;
    private String[] words;

    public WordIterator(FileContent fileContent){
        this.words = fileContent.getFileText().split(" ");
        this.index = 0;
    }

    @Override
    public boolean hasNext(){
        return index < this.words.length;
    }

    @Override
    public String next(){
        index ++;
        while (words[index -1].isEmpty() && hasNext()){
            index ++;
        }

        return words[index -1].toLowerCase();
    }

    @Override
    public void remove(){
        this.index = 0;
    }
}