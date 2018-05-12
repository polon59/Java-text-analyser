import java.io.IOException;
import java.lang.StringBuilder;
import java.io.PrintWriter;

public class ViewAndSave{
    StringBuilder stringBuilder;


    public ViewAndSave(){
        stringBuilder = new StringBuilder();
    }

    public void appendToStringBuilder(String text){
        stringBuilder.append(text);
    }

    public void printInTerminal(){
        System.out.println(stringBuilder.toString());
    }

    public void saveToFile()throws IOException{
       
        PrintWriter pw = new PrintWriter("report.txt");
        pw.println(stringBuilder.toString());
        pw.close();
        
    }


}