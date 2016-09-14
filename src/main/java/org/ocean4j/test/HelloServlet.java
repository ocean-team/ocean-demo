package org.ocean4j.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by richey on 16-9-13.
 * demo:接收GET类型的请求/hello转发到/WEB-INF/jsp/hello.jsp页面,在hello.jsp页面显示当前系统时间
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String currentTime = dataFormat.format(new Date());
        req.setAttribute("currentTime",currentTime);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
    }
}
