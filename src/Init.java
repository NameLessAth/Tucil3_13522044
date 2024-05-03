package src;
import java.util.ArrayList;
import java.util.List;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

class Init{
    List<String> Dictionary;

    public Init(){
        this.Dictionary = new ArrayList<>();
        try {
            File objFile = new File("dict.txt");
            Scanner reader = new Scanner(objFile);
            while (reader.hasNextLine()) {
                this.Dictionary.add(reader.nextLine());
            } reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void solve(String startWord, String destWord){}
}
