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