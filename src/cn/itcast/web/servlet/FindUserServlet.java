package cn.itcast.web.servlet;

import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import cn.itcast.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cdx on 2019/12/17.
 * desc:
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        System.out.println(username);
        UserService service = new UserServiceImpl();
        List<User> list = service.queryUserByNameAddrEmail(username, null, null);
        System.out.println(list);
        response.setContentType("text/html;charset=utf-8");
        //response.setContentType("application/json;charset=utf-8");
        Map<String, Object> map = new HashMap<>();

        ObjectMapper mapper = new ObjectMapper();

        if (list != null) {
            map.put("userExist", true);
            map.put("msg", "用户名可用");
            mapper.writeValue(response.getWriter(), map);
        } else {
            map.put("userExist", false);
            map.put("msg", "用户名不可用");
            mapper.writeValue(response.getWriter(), map);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
