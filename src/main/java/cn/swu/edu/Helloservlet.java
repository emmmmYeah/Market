package cn.swu.edu;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Helloservlet extends HttpServlet {
    private String message;

    private static final long serialVersionUID = 1198763442711986380L;

    /*public void init() {
        message = "Hello, my dear!";

    }*/

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        out.println("<center>");
        out.println("<h1>"+message+"</h1>");
        String film= request.getParameter("film");
        String editor= request.getParameter("editor");
        String actor= request.getParameter("actor");
        out.println("<h1>"+film+"</h1>");
        out.println("<h1>"+editor+"</h1>");
        out.println("<h1>"+actor+"</h1>");
        out.println("</center>");
    }
}
