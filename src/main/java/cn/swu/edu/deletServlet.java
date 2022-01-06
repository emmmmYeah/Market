package cn.swu.edu;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deletServlet extends HttpServlet {

    private static final long serialVersionUID = 1198763442666686380L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String sql = "DELETE FROM films WHERE id=" + id;

        try {
            DBUtils.delete(sql);
            response.sendRedirect("./Single");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
