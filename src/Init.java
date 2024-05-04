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
    private Integer Parent;
    private Integer Kode;
    private String Simpul;
    private static Integer jumlahNode = 0;

    public NodeGraf(Integer Parent, String Isinya){
        this.Parent = Parent; this.Simpul = Isinya;
        this.Kode = ++jumlahNode;
    }
    public Integer getParent(){
        return this.Parent;
    }
    public Integer getKode(){
        return this.Kode;
    }
    public String getSimpul(){
        return this.Simpul;
    }
}