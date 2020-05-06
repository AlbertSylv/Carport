package PresentationLayer;

import DBAccess.RequestMapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteRequest extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        RequestMapper.deleteRequest(email);
        return "customerpage";
    }
}
