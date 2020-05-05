package FunctionLayer;

public class FladtTag {
    int flatTagID;
    String name;
    int pris;

    public FladtTag(int flatTagID, String name, int pris) {
        this.flatTagID = flatTagID;
        this.name = name;
        this.pris = pris;
    }

    public int getFlatTagID() {
        return flatTagID;
    }

    public void setFlatTagID(int flatTagID) {
        this.flatTagID = flatTagID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }
}
