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
            while (reader.hasNextLine()) Init.Dictionary.add(reader.nextLine());
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static boolean hasNeighbour(String arg){
        String tempstr;
        for (int i = 0; i < arg.length(); i++){
            for (char charFit : "abcdefghijklmnopqrstuvwxyz".toCharArray()){
                tempstr = arg.substring(0, i) + charFit + arg.substring(i+1);
                if (Init.Dictionary.contains(tempstr) && !tempstr.equals(arg)) return true;
            }
        } return false;
    }
    public static Integer getDistanceToFinish(String arg1, String arg2){
        if (arg1.length() != arg2.length()) return 9999;
        else{
            int dist = arg1.length();
            for (int i = 0; i < arg1.length(); i++) if (arg1.substring(i, i+1).equals(arg2.substring(i, i+1))) dist--;
            return dist;
        }
    }
    public static void solveHelper(List<NodeGraf> tempvar){
        NodeGraf jawabannya = tempvar.get(tempvar.size()-1);
        String Answer = ""; boolean found; Integer itr, steps = 0; 
        while(jawabannya.getParent() != 0){
            steps++;
            Answer = "->" + jawabannya.getSimpul() + Answer;
            found = false; itr = 0;
            while (!found && itr < tempvar.size()){
                if (tempvar.get(itr).getKode() == jawabannya.getParent()){
                    jawabannya = tempvar.get(itr); found = true;
                } else itr++;
            }
        } Answer = jawabannya.getSimpul() + Answer; 
        System.out.println("Jumlah steps : " + steps);
        System.out.println(Answer);
    }
}

