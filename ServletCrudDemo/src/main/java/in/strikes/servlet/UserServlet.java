package in.strikes.servlet;

import in.strikes.model.User;
import in.strikes.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if(idParam == null || name == null || email == null || mobile == null) {
            response.setStatus(400);
            response.setContentType("application/json");
            response.getWriter().write("{\n" +
                    "    \"message\": \"Some fields are missing.\"\n" +
                    "}");
            return;
        }

        Integer id = Integer.parseInt(idParam);

        User user = new User(id, name, email, mobile);

        User createdUser = userService.createUser(user);

        response.setContentType("application/json");
        response.setStatus(201);
        response.getWriter().write("{\n" +
                "    \"message\": \"User Added Successfully.\"\n" +
                "}");
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        if(idParam == null) {

            List<User> users = userService.getAllUsers();

            response.setContentType("application/json");
            response.setStatus(200);
            response.getWriter().write(usersToJosn(users));
            return;
        }

        Integer id = Integer.parseInt(idParam);

        User userRes = userService.getUserById(id);

        if(userRes == null) {
            response.setStatus(404);
            response.setContentType("application/json");
            response.getWriter().write("{\n" +
                    "    \"message\": \"User Not Found.\"\n" +
                    "}");
            return;
        }

        response.setContentType("application/json");
        response.setStatus(200);
        response.getWriter().write(UserToJson(userRes));
    }

    @Override
    public void doPut(HttpServletRequest request,
                      HttpServletResponse response){

    }

    @Override
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response){

    }

    private String UserToJson(User user){
        return "{\n" +
                "    \"id\": " + user.getId() + ",\n" +
                "    \"name\": \"" + user.getName() + "\",\n" +
                "    \"email\": \"" + user.getEmail() + "\",\n" +
                "    \"mobile\": \"" + user.getMobile() + "\"\n" +
                "}";
    }

    private String usersToJosn(List<User> users){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for(int i = 0; i < users.size(); i++){
            stringBuilder.append(UserToJson(users.get(i)));

            if(i < users.size()-1){
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
