package FunctionLayer;

public class Request {

        int id;
        int roofid;
        int tiltedroofid;
        int shedid;
        int width;
        int length;
        int shedWidth;
        int shedLength;
        int angle;
        String note;
        String email;
        String SCname;
        int SCprice;
        String RCname;
        int RCprice;
        String TRCname;
        int TRCprice;



    public Request(int id, int width, int length, int shedWidth, int shedLength, int angle, String note, String email, String SCname, String RCname, String TRCname) {
        this.id = id;
        this.width = width;
        this.length = length;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.angle = angle;
        this.note = note;
        this.email = email;
        this.SCname = SCname;
        this.RCname = RCname;
        this.TRCname = TRCname;
    }

    public Request(int roofid, int tiltedroofid, int shedid, int width, int length, int shedWidth, int shedLength, int angle, String note, String email) {
        this.roofid = roofid;
        this.tiltedroofid = tiltedroofid;
        this.shedid = shedid;
        this.width = width;
        this.length = length;
        this.shedWidth = shedWidth;
        this.shedLength = shedLength;
        this.angle = angle;
        this.note = note;
        this.email = email;

    }

    public String getSCname() {
        return SCname;
    }

    public void setSCname(String SCname) {
        this.SCname = SCname;
    }

    public int getSCprice() {
        return SCprice;
    }

    public void setSCprice(int SCprice) {
        this.SCprice = SCprice;
    }

    public String getRCname() {
        return RCname;
    }

    public void setRCname(String RCname) {
        this.RCname = RCname;
    }

    public int getRCprice() {
        return RCprice;
    }

    public void setRCprice(int RCprice) {
        this.RCprice = RCprice;
    }

    public String getTRCname() {
        return TRCname;
    }

    public void setTRCname(String TRCname) {
        this.TRCname = TRCname;
    }

    public int getTRCprice() {
        return TRCprice;
    }

    public void setTRCprice(int TRCprice) {
        this.TRCprice = TRCprice;
    }

    public int getTiltedroofid() {
        return tiltedroofid;
    }


    public void setTiltedroofid(int tiltedroofid) {
        this.tiltedroofid = tiltedroofid;
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
