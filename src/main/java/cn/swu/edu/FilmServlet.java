package cn.swu.edu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

public class FilmServlet  extends HttpServlet {
    private static final long serialVersionUID = 1193333442711986380L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //System.out.println("ok");
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String page = request.getParameter("page");

        int offset = (Integer.valueOf(page).intValue() - 1) * 4;

        String sql = "SELECT * FROM films ORDER BY id DESC LIMIT 4 OFFSET " + offset+";";

        System.out.println(sql);

        try {
            List<Film> Films = DBUtils.getFilms(sql);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            System.out.println("json:"+this.toJson(Films));
            try(Writer writer = response.getWriter()) {
                writer.write(this.toJson(Films));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String toJson(List<Film> Films) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("\"films\": [");

        for(int i=0; i<Films.size(); i++) {
            Film Film = Films.get(i);
            if (i > 0) sb.append(",");
            sb.append(String.format(
                    "{\"id\": %s, \"film\": \"%s\",\"editor\": \"%s\",\"actor\": \"%s\",\"type\": \"%s\",\"time\": \"%s\",\"pics\": \"%s\",\"review\": \"%s\"}",
                    Film.getId(), Film.getFilm(), Film.getEditor(),Film.getActor(), Film.getType(), Film.getTime(),Film.getPics(),Film.getReview()
            ));
        }
System.out.println(Films.size());
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }
    }

