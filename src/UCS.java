import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

class UCS {
    public static List<NodeGraf> addPriorQueue(List<NodeGraf> arg1, NodeGraf arg2, String start){
        List<NodeGraf> tempSet = new ArrayList<>(arg1);
        boolean found = false; int itr = 0, distCurr = Init.getDistToParent(tempSet, arg2);
        while (!found && itr < tempSet.size()){
            if (distCurr < Init.getDistToParent(tempSet, arg1.get(itr))) found = true;
            else itr++;
        } tempSet.add(itr, arg2);
        return tempSet;
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
                            Init.solveHelper(tempvar); return;
                        } else queue.add(cucu);            
                    }
                } 
            } 
        } System.out.println("Tidak ditemukan jalan menuju Destinasi.");
    }
}
