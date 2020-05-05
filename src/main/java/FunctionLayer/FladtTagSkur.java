package FunctionLayer;

public class FladtTagSkur {
    int FladtTagSkurID;
    String name;
    int pris;

    public FladtTagSkur(int fladtTagSkurID, String name, int pris) {
        FladtTagSkurID = fladtTagSkurID;
        this.name = name;
        this.pris = pris;
    }

    public int getFladtTagSkurID() {
        return FladtTagSkurID;
    }

    public void setFladtTagSkurID(int fladtTagSkurID) {
        FladtTagSkurID = fladtTagSkurID;
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

