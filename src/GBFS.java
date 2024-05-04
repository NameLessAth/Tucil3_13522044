import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

class GBFS {
    public static List<NodeGraf> addPriorQueue(List<NodeGraf> arg1, NodeGraf arg2, String destinasi){
        List<NodeGraf> tempSet = new ArrayList<>(arg1);
        boolean found = false; int itr = 0, distCurr = Init.getDistance(arg2.getSimpul(), destinasi);
        while (!found && itr < tempSet.size()){
            if (distCurr < Init.getDistance(tempSet.get(itr).getSimpul(), destinasi)) found = true;
            else itr++;
        } tempSet.add(itr, arg2);
        return tempSet;
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
        System.out.println("Jumlah steps : " + ++steps);
        System.out.println(Answer);
    }
    
    public static void solve(String startWord, String destWord){
        Integer visited = 0; 

        NodeGraf leluhur = new NodeGraf(0, startWord);

        List<NodeGraf> tempvar = new ArrayList<>(); tempvar.add(leluhur);
        List<NodeGraf> queue = new ArrayList<>(); queue.add(leluhur);
        Set<String> visitedDict = new HashSet<>(); visitedDict.add(leluhur.getSimpul());

        while (!queue.isEmpty()){
            visited++;
            NodeGraf temp = queue.get(0); queue.remove(0);
            
            for (int i = 0; i < temp.getSimpul().length(); i++){
                for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()){
                    String tempstr = temp.getSimpul().substring(0, i) + c + temp.getSimpul().substring(i+1);
                    if (Init.Dictionary.contains(tempstr) && !visitedDict.contains(tempstr)){ // berarti simpul bertetangga (cuma beda 1 huruf)
                        visitedDict.add(tempstr);
                        NodeGraf cucu = new NodeGraf(temp.getKode(), tempstr);
                        tempvar.add(cucu);
                        if (tempstr.equals(destWord)){
                            System.out.println("Visited jml : " + visited);
                            GBFS.solveHelper(tempvar); return;
                        } else queue = GBFS.addPriorQueue(queue, cucu, destWord);            
                    }
                } 
            } 
        } System.out.println("Tidak ditemukan jalan menuju Destinasi.");
    }
}
