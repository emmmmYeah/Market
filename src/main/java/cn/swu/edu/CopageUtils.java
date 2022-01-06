package cn.swu.edu;

public class CopageUtils {
    public static String getHeader() {
        String head ="<!DOCTYPE html>\n" +
                "<html lang=\"zxx\">\n" +
                "<head>\n" +
                "    <title>Sunday Film</title>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"description\" content=\"Real estate HTML Template\">\n" +
                "    <meta name=\"keywords\" content=\"real estate, html\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "\n" +
                "    <!-- Stylesheets -->\n" +
                "    <link rel=\"stylesheet\" href=\"mainstatic/css/bootstrap.min.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"mainstatic/css/font-awesome.min.css\">\n" +
                "    <link rel=\"stylesheet\" href=\"mainstatic/css/slicknav.min.css\">\n" +
                "\n" +
                "    <!-- Main Stylesheets -->\n" +
                "    <link rel=\"stylesheet\" href=\"mainstatic/css/style.css\">\n" +
                "\n" +
                "    <script src=\"https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js\"></script>\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<!-- Page Preloder -->\n" +
                "<div id=\"preloder\">\n" +
                "    <div class=\"loader\"></div>\n" +
                "</div>\n" +
                "\n" +
                "<!-- Header Section -->\n" +
                "<header class=\"header-section\">\n" +
                "    <!--<a href=\"\" class=\"site-logo\">\n" +
                "        <img src=\"mainstatic/picture/logo.png\" alt=\"\">\n" +
                "    </a>-->\n" +
                "    <nav class=\"header-nav\">\n" +
                "        <ul class=\"main-menu\">\n" +
                "            <li><a href=\"./login.html\" >首页</a></li>\n" +
                "            <li><a href=\"\"class=\"active\">社区</a></li>\n" +
                "            <li><a href=\"./index.html\">退出</a></li>\n" +
                "            <li><a href=\"./Single\">个人</a></li>\n" +
                "            <li><a href=\"./Create.html\">创作</a></li>\n" +
                "        </ul>\n" +
                "        <!--<div class=\"header-right\">\n" +
                "            <div class=\"user-panel\">\n" +
                "                <a href=\"#\" class=\"login\">Sign in</a>\n" +
                "                <a href=\"#\" class=\"register\">Join us</a>\n" +
                "            </div>\n" +
                "        </div>-->\n" +
                "    </nav>\n" +
                "</header>\n" +
                "<!-- Header Section end -->\n" +
                "<!-- Hero Section end -->\n" +
                "<section class=\"hero-section set-bg\" data-setbg=\"mainstatic/picture/in.jpg\">\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"hero-warp\">\n" +
                "            <form class=\"main-search-form\" method=\"POST\" action=\"./searchServlet\">\n" +
                "                <div class=\"search-type\">\n" +
                "                    <div class=\"st-item\">\n" +
                "                        <input type=\"radio\" value=\"film\"name=\"st\" id=\"buy\" >\n" +
                "                        <label for=\"buy\">film name</label>\n" +
                "                    </div>\n" +
                "                    <div class=\"st-item\">\n" +
                "                        <input type=\"radio\" value=\"editor\" name=\"st\" id=\"rent\">\n" +
                "                        <label for=\"rent\">Editor</label>\n" +
                "                    </div>\n" +
                "                    <div class=\"st-item\">\n" +
                "                        <input type=\"radio\" value=\"actor\" name=\"st\" id=\"sell\">\n" +
                "                        <label for=\"sell\">Actor</label>\n" +
                "                    </div>\n" +
                "                    <div class=\"st-item\">\n" +
                "                        <input type=\"radio\" value=\"type\" name=\"st\" id=\"property\">\n" +
                "                        <label for=\"property\">Type</label>\n" +
                "                    </div>\n" +
                "                    <div class=\"st-item\">\n" +
                "                        <input type=\"radio\" value=\"time\" name=\"st\" id=\"agents\">\n" +
                "                        <label for=\"agents\">Time</label>\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"search-input\">\n" +
                "                    <input type=\"text\" id=\"searchInput\" placeholder=\"Search by state, postcode or suburb\" name=\"name\">\n" +
                "                    <button  class=\"site-btn\" id=\"searchButton\">Search</button>\n" +
                "                </div>\n" +
                "                <!--<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Quis ipsum suspendisse ultrices gravida. </p>\n" +
                "                --></form>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</section>\n" +
                "<!-- Hero Section end -->\n";


        return head;
    }



    public static String getEnd() {
        String End="<!--====== Javascripts & Jquery ======-->\n" +
                "<script src=\"mainstatic/js/jquery-3.2.1.min.js\"></script>\n" +
                "<script src=\"mainstatic/js/bootstrap.min.js\"></script>\n" +
                "<script src=\"mainstatic/js/jquery.slicknav.min.js\"></script>\n" +
                "<script src=\"mainstatic/js/jquery.magnific-popup.min.js\"></script>\n" +
                "<script src=\"mainstatic/js/main.js\"></script>\n" +
                "\n" +
                "<script>\n" +
                "\n" +
                "\t\t/*function initSearchButton() {\n" +
                "\t\t\t$(\"#searchButton\").click(function(){\n" +
                "\t\t\t\tvar key = $(\"#searchInput\").val();\n" +
                "\t\t\t\tconsole.log(key);\n" +
                "\n" +
                "\t\t\t\twindow.open(\"./searchServlet?key=\" + key, \"new-window\");//这里这个跳转页面\n" +
                "\t\t\t});\n" +
                "\t\t}\n" +
                "\n" +
                "\t\tinitSearchButton();*/SS\n" +
                "\n" +
                "\n" +
                "\t</script>\n" +
                "</body>\n" +
                "</html>";
        return End;
    }
}
