import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
class GBFS {
    public static void solve(String startWord, String destWord){
        Integer visited = 0;
        NodeGraf leluhur = new NodeGraf(0, startWord);
        List<NodeGraf> tempvar = new ArrayList<>(); tempvar.add(leluhur);

        List<NodeGraf> queue = new ArrayList<>(); queue.add(leluhur);
        
        boolean found = false;
        while (!queue.isEmpty() && !found){

            NodeGraf temp = queue.get(0); queue.remove(0);
            // Init.Dictionary.remove(temp.getSimpul());

            for (int i = 0; i < temp.getSimpul().length(); i++){
                String tempstr = temp.getSimpul().substring(0, i) + temp.getSimpul().substring(i+1);

                HashSet<String> setTemp = new HashSet<>(Init.Dictionary);
                for (String dictionary : Init.Dictionary){
                    
                    String tempstr2 = dictionary.substring(0, i) + dictionary.substring(i+1);

                    if (tempstr.equals(tempstr2) && !dictionary.equals(temp.getSimpul())){ // berarti simpul bertetangga (cuma beda 1 huruf)
                        visited++;
                        setTemp.remove(dictionary);
                        NodeGraf cucu = new NodeGraf(temp.getKode(), dictionary);
                        tempvar.add(cucu);
                        if (dictionary.equals(destWord)){
                            System.out.println("Visited jml : " + visited);
                            GBFS.solveHelper(tempvar); return;
                        } else queue.add(cucu);            
                    }
                } Init.Dictionary = setTemp;
            } 
        }
    }

    public static void solveHelper(List<NodeGraf> tempvar){
        NodeGraf jawabannya = tempvar.get(tempvar.size()-1);
        String Answer = ""; boolean found; Integer itr;
        while(jawabannya.getParent() != 0){
            Answer = "->" + jawabannya.getSimpul() + Answer;
            found = false; itr = 0;
            while (!found && itr < tempvar.size()){
                if (tempvar.get(itr).getKode() == jawabannya.getParent()){
                    jawabannya = tempvar.get(itr); found = true;
                } else itr++;
            }
        } Answer = jawabannya.getSimpul() + Answer; 
        System.out.println(Answer);
    }
}
