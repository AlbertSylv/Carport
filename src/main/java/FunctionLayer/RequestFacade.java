package FunctionLayer;

import DBAccess.RequestMapper;

import java.util.ArrayList;

public class RequestFacade {
    public static void createRequest(int roofID,int tiltedroofID, int shedID, int width, int length, int shedWidth, int shedLength, int angle, String note, String email) throws LoginSampleException {

        RequestMapper.createRequest(roofID, tiltedroofID, shedID, width, length, shedWidth, shedLength, angle, note, email);

    }

    public static Request getRequest(String email) throws LoginSampleException {

        return RequestMapper.getRequest(email);

    }
    public static ArrayList<Request> getRequests() {
        ArrayList<Request> bestillinger=new ArrayList<Request>();
        bestillinger=RequestMapper.getRequests();
        return bestillinger;
    }
    public static Request getRequest4Styklist(int id) throws LoginSampleException {
        return RequestMapper.getRequest4Styklist(id);
    }
}
