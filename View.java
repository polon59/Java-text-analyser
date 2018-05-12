import java.lang.StringBuilder;

public class View{
    StringBuilder stringBuilder;


    public View(){
        stringBuilder = new StringBuilder();
    }

    public void appendToStringBuilder(String text){
        stringBuilder.append(text);
    }

    public void printInfo(){
        System.out.println(stringBuilder.toString());
    }


}