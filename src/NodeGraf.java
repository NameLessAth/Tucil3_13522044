class NodeGraf{
    private Integer Kode;
    private Integer Parent;
    private Integer Depth;
    private Integer Heuristic;
    private String Simpul;
    private static Integer jumlahNode = 0;

    public NodeGraf(Integer Parent, Integer Depth, String Isinya, String Destinasi){
        this.Parent = Parent; this.Simpul = Isinya; this.Depth = Depth; this.Heuristic = Init.getDistanceToFinish(Isinya, Destinasi);
        this.Kode = ++jumlahNode;
    }
    public Integer getParent(){
        return this.Parent;
    }
    public Integer getKode(){
        return this.Kode;
    }
    public Integer getDepth(){
        return this.Depth;
    }
    public Integer getHeuristic(){
        return this.Heuristic;
    }
    public String getSimpul(){
        return this.Simpul;
    }
}