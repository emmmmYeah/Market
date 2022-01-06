package cn.swu.edu;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.List;

public class CommunityServlet extends HttpServlet {
    private static final long serialVersionUID = 1198763442711986380L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String sql = "SELECT * FROM films ORDER BY id DESC;";

        List<Film> films = null;
        try {
            films = DBUtils.getFilms(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        Writer writer = response.getWriter();
        StringBuilder sb = new StringBuilder();//写网页主体
        sb.append(CopageUtils.getHeader());
        sb.append(toHtmlTable(films));
        sb.append(CopageUtils.getEnd());
        writer.write(sb.toString());
    }

    private String toHtmlTable(List<Film> films) {
        StringBuilder sb = new StringBuilder();
        sb.append("<section class=\"blog-section spad\">\n" +
                "    <div class=\"container\">" );

        for (int i=0; i< films.size(); i++) {
            Film film = films.get(i);
            if(i%4==1)
            {   sb.append("<div class=\"row\">");
                sb.append("<div class=\"col-lg-4 col-md-6\">");
                sb.append("<div class=\"blog-item\">");
                sb.append("<img width=340px height=370px src='./upload/").append(film.getPics().replaceAll(",", "")).append("' alt=\"\">");
                sb.append("<div class=\"blog-text\">");
                sb.append("<div class=\"blog-date\">").append(film.getTime()).append("</div>");
                sb.append("<h4>").append(film.getFilm()).append("</h4>");
                sb.append("<p>").append(film.getActor()).append("</p>");
                sb.append("<a href=\"./So?id=").append(film.getId()).append("\" class=\"readmore-btn\">Read More</a>");
                sb.append("  </div>\n" +
                        "                </div>\n" +
                        "            </div>");
            }
            else if(i%4==2)
            {
                sb.append("<div class=\"col-lg-4 col-md-6\">");
                sb.append("<div class=\"blog-item\">");
                sb.append("<img width=340px height=370px src='./upload/").append(film.getPics().replaceAll(",", "")).append("' alt=\"\">");
                //sb.append("<td><img width='100px' src='./upload/").append(film.getPics().replaceAll(",", "")).append("'></img></td>");
                sb.append("<div class=\"blog-text\">");
                sb.append("<div class=\"blog-date\">").append(film.getTime()).append("</div>");
                sb.append("<h4>").append(film.getFilm()).append("</h4>");
                sb.append("<p>").append(film.getActor()).append("</p>");
                sb.append("<a href=\"./So?id=").append(film.getId()).append("\" class=\"readmore-btn\">Read More</a>");
                sb.append("  </div>\n" +
                        "                </div>\n" +
                        "            </div>");
            }
            else if(i%4==3)
            {
                sb.append("<div class=\"col-lg-4 col-md-6\">");
                sb.append("<div class=\"blog-item\">");
                sb.append("<img width=340px height=370px src='./upload/").append(film.getPics().replaceAll(",", "")).append("' alt=\"\">");
                //sb.append("<td><img width='100px' src='./upload/").append(film.getPics().replaceAll(",", "")).append("'></img></td>");
                sb.append("<div class=\"blog-text\">");
                sb.append("<div class=\"blog-date\">").append(film.getTime()).append("</div>");
                sb.append("<h4>").append(film.getFilm()).append("</h4>");
                sb.append("<p>").append(film.getActor()).append("</p>");
                sb.append("<a href=\"./So?id=").append(film.getId()).append("\" class=\"readmore-btn\">Read More</a>");
                sb.append("</div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>");
            }
            else if(i%4==0)
            {
                sb.append("<div class=\"blog-item feature-blog\">");
                sb.append("<div class=\"row\">");
                sb.append("<div class=\"col-lg-6\">");

                sb.append("<img width=500px height=600px src='./upload/").append(film.getPics().replaceAll(",", "")).append("' alt=\"\">  </div>");
                //sb.append("<td><img width='100px' src='./upload/").append(film.getPics().replaceAll(",", "")).append("'></img></td>");
                sb.append("<div class=\"col-lg-6\">");
                sb.append("<div class=\"blog-date\">").append(film.getTime()).append("</div>");
                sb.append("<h4>").append(film.getFilm()).append("</h4>");
                sb.append("<p>").append(film.getEditor()).append("</p>");
                sb.append("<p>").append(film.getActor()).append("</p>");
                sb.append("<a href=\"./So?id=").append(film.getId()).append("\" class=\"readmore-btn\">Read More</a>");
                sb.append("</div>\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>");
            }




        }
        sb.append(" </div>\n" +
                "</section>");

        return sb.toString();
    }


}
