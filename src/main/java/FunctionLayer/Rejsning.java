package FunctionLayer;

public class Rejsning {
    int rejsningID;
    String name;
    int pris;

    public Rejsning(int rejsningID, String name, int pris) {
        this.rejsningID = rejsningID;
        this.name = name;
        this.pris = pris;


    }

    public int getRejsningID() {
        return rejsningID;
    }

    public void setRejsningID(int rejsningID) {
        this.rejsningID = rejsningID;
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

