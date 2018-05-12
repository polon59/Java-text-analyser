import java.util.Iterator;

public class CharIterator implements Iterator<String>{
    private int index;
    private String[] letters;

    public CharIterator(FileContent fileContent){
        this.letters = fileContent.getFileText().split("");
        this.index = 0;
    }

    public boolean hasNext(){
        return index < this.letters.length;
    }

    public String next(){
        index ++;
        if (hasNext()){
            while (letters[index-1].equals(" ") || letters[index-1].equals("\n") || letters[index-1].equals("")){
                index ++;
            }
        }
        return letters[index-1].toLowerCase();
        }

    @Override
    public void remove(){
        this.index = 0;
    }
}

