import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

class Init{
    public static HashSet<String> Dictionary;

    public static void initialize(){
        Init.Dictionary = new HashSet<>();
        try {
            File objFile = new File("dict.txt");
            Scanner reader = new Scanner(objFile);
            while (reader.hasNextLine()) {
                Init.Dictionary.add(reader.nextLine());
            } reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void filter(int lengthword){
        HashSet<String> tempvar = new HashSet<>();
        for (String dictionary : Init.Dictionary) {
            if (dictionary.length() == lengthword) tempvar.add(dictionary);
        } Init.Dictionary = tempvar;
    }
}

class NodeGraf{
    private String Parent;
    private String Simpul;
    private List<String> Childrens;

    public NodeGraf(String Parent, String Isinya){
        this.Parent = Parent; this.Simpul = Isinya;
    }
    public void AddChildren(List<String> Childrens){
        this.Childrens = Childrens;
    }
    public String getParent(){
        return this.Parent;
    }
    public String getSimpul(){
        return this.Simpul;
    }
}