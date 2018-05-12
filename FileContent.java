import java.io.IOException;
import java.util.*;
import java.io.File;

public class FileContent implements IterableText{
    private String fileName;
    private String fileText; 

    public FileContent (String fileName){
        this.fileName = fileName;
        importText();
    }

    public Iterator<String> charIterator(){
        return new CharIterator(this);
    }

    public Iterator<String> wordIterator(){
        return new CharIterator(this);
    }

    private void importText(){
        File file = new File(fileName);
        StringBuilder text = new StringBuilder();
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                text.append(scanner.nextLine());
                text.append(" ");    
            }
        } catch (Exception e){
            e.printStackTrace();
            }

        this.fileText = text.toString();    
    }

    public String getFileText(){
        return this.fileText;
    }

    public String getFilename(){
        return this.fileName;
    }
}