package cn.swu.edu;
//这个是可以添加但是无法显示，，现在需要取写listfilm
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class AddFilmServlet extends HttpServlet {
    private static final long serialVersionUID = 1139723442711986380L;

    private static final String INSERT_TEMPLATE =
            "INSERT INTO films (`film`, `editor`, `actor`, `type`, `time`,`review`,`pics`) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%s','%s','%s');";

    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    // 上传文件存储目录
    private static final String UPLOAD_DIRECTORY = "upload";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String film     = request.getParameter("film");
        String editor   = request.getParameter("editor");
        String actor    = request.getParameter("actor");
        String type     = request.getParameter("type");
        String time     = request.getParameter("time");
        String review     = request.getParameter("review");
        response.setCharacterEncoding("UTF-8");
        // 检测是否为多媒体上传

        if (!ServletFileUpload.isMultipartContent(request)) {

            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        
        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);
        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        // 如果目录不存在则创建,往upload目录里添加图片
        System.out.println(uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }


        String pics = "";
        try {
            // 解析请求的内容提取文件数据
            List<FileItem> formItems = upload.parseRequest(request);
            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        // 在控制台输出文件的上传路径
                        System.out.println(filePath);
                        // 保存文件到硬盘
                        item.write(storeFile);
                        pics += fileName + "";
                    } else {
                        if (item.getFieldName().equals("film")) {
                            film = item.getString();
                        }
                        if (item.getFieldName().equals("editor")) {
                            editor = item.getString();
                        }
                        if (item.getFieldName().equals("actor")) {
                            actor = item.getString();
                        }
                        if (item.getFieldName().equals("type")) {
                            type = item.getString();
                        }
                        if (item.getFieldName().equals("time")) {
                            time = item.getString();
                        }
                        if (item.getFieldName().equals("review")) {
                            review = item.getString();
                        }
                    }
                }
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

        String sql = String.format(INSERT_TEMPLATE, film, editor, actor, type,time, review, pics);
        System.out.println(sql);

        try {
            DBUtils.insert(sql);
            response.sendRedirect("./Create.html");//list
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
