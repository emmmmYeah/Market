package cn.swu.edu;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 119876388866686380L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");

        String sql = "SELECT * FROM films WHERE id=" + id;
        try {
            List<Film> Films = DBUtils.getFilms(sql);
            if (Films.size() == 0) {
                response.sendRedirect("./Single");
                return;
            }

            Film Film = Films.get(0);

            StringBuilder sb = new StringBuilder();
            sb.append(PageUtils.getHeader());
            sb.append(buildFilmForm(Film));
            sb.append(PageUtils.getEnd());

            response.setCharacterEncoding("UTF-8");
            try (Writer writer = response.getWriter()) {
                writer.write(sb.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String buildFilmForm(Film film) {
        String html = String.format("<center>\n" +
                        "<div class=\"container\">\n" +
                        "    <div class=\"hero-warp\" style=\"text-align:center;\">\n" +
                        "        <div class=\"container\"><h1>Create your blog</h1></div>\n" +
                        "<div class=\"login-01\" class=\"bk\">\n" +
                        "<input type='hidden' name='id' value=\"%s\" >"+
                        "    <form action=\"./Single\" method=\"post\" enctype=multipart/form-data>\n" +
                        "        <ul>\n" +
                        "            <li class=\"first\">\n" +
                        "                <a href=\"#\" class=\" icon user\"></a><input type=\"text\" class=\"text\" value=\"%s\" name=\"film\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Film';}\" >\n" +
                        "                <div class=\"clear\"></div>\n" +
                        "            </li>\n" +
                        "            <li class=\"first\">\n" +
                        "                <a href=\"#\" class=\" icon email\"></a><input type=\"text\" class=\"text\" value=\"%s\" name=\"editor\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'Editor';}\" >\n" +
                        "                <div class=\"clear\"></div>\n" +
                        "            </li>\n" +
                        "            <li class=\"first\">\n" +
                        "                <a href=\"#\" class=\" icon phone\"></a><input type=\"text\" class=\"text\" value=\"%s\" name=\"actor\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = '';}\" >\n" +
                        "                <div class=\"clear\"></div>\n" +
                        "            </li>\n" +
                        "            <li class=\"first\">\n" +
                        "                <a href=\"#\" class=\" icon phone\"></a><input type=\"text\" class=\"text\" value=\"%s\" name=\"time\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'time';}\" >\n" +
                        "                <div class=\"clear\"></div>\n" +
                        "            </li>\n" +
                        "            <li class=\"second\">\n" +
                        "                <a href=\"#\" class=\" icon msg\"></a><textarea value=\"%s\" name=\"review\" onfocus=\"this.value = '';\" onblur=\"if (this.value == '') {this.value = 'review';}\">Review</textarea>\n" +
                        "                <div class=\"clear\"></div>\n" +
                        "            </li>\n" +
                        "        </ul>\n" +
                        "        <input type=\"submit\" onclick=\"myFunction()\" value=\"Submit\" >\n" +
                        "        <div class=\"clear\"></div>\n" +
                        "    </form>\n" +
                        "</div>\n" +
                        "    </div>\n" +
                        "</div>\n" +
                        "<!--start-copyright-->\n" +
                        "</center>",
               film.getId(), film.getFilm(),film.getEditor(), film.getActor(), film.getTime(),film.getReview()
        );

        html = html.replace("'" + film.getType() + "'", "'" + film.getType() + "' selected" );

        return html;
    }
}

