package FunctionLayer;

public class Request {

        int id;
        int roofid;
        int shedid;
        int width;
        int length;
        int shedWidth;
        int shedLength;
        int angle;
        String note;
        String email;

    public Request(int roofid, int shedid, int width, int length, int shedWidth, int shedLength, int angle, String note, String email) {
        this.roofid = roofid;
        this.shedid = shedid;
        this.width = width;
        this.length = length;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.angle = angle;
        this.note = note;
        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoofid() {
        return roofid;
    }

    public void setRoofid(int roofid) {
        this.roofid = roofid;
    }

    public int getShedid() {
        return shedid;
    }

    public void setShedid(int shedid) {
        this.shedid = shedid;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }

    public int getShedLength() {
        return shedLength;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
